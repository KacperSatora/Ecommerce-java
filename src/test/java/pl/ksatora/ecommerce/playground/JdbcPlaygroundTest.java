package pl.ksatora.ecommerce.playground;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.ksatora.ecommerce.catalog.Product;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class JdbcPlaygroundTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    void itSetupDB() {
        var dropTableIfExists = "DROP TABLE `product_catalog__products` IF EXISTS";
        jdbcTemplate.execute(dropTableIfExists);

        var createTableSql = "CREATE TABLE `product_catalog__products` (" +
                "`id` varchar(255) NOT NULL, " +
                "`name` varchar(255) NOT NULL, " +
                "`price` decimal(12,2), " +
                "PRIMARY KEY (id)" +
                ");";

        jdbcTemplate.execute(createTableSql);
    }

    @Test
    void selectMyNameViaDB() {
        var name = jdbcTemplate.queryForObject("SELECT 'Kacper Satora' AS hello_column", String.class);
    }

    @Test
    void selectDateNow() {
        var currentDate = jdbcTemplate.queryForObject("select now() my_date", String.class);
        assert currentDate.contains("2024");
    }

    @Test
    void itCreatesTable() {
        var dropTableIfExists = "DROP TABLE `product_catalog__products` IF EXISTS";
        jdbcTemplate.execute(dropTableIfExists);
        var createTableSql = "CREATE TABLE `product_catalog__products` (" +
                "`id` varchar(255) NOT NULL, " +
                "`name` varchar(255) NOT NULL, " +
                "`price` decimal(12,2), " +
                "PRIMARY KEY (id)" +
                ");";

        jdbcTemplate.execute(createTableSql);
    }

    @Test
    void itCountsProductsWhenNoProducts() {
        var countSql = "SELECT COUNT(*) FROM `product_catalog__products`";
        int productsCount = jdbcTemplate.queryForObject(countSql, Integer.class);

        assertThat(productsCount).isEqualTo(0);
    }

    @Test
    void itAllowsToInsertElements() {
        var insert = "INSERT INTO `product_catalog__products` (id, name, price) " +
                "VALUES " +
                "('product_1', 'my product 1', 20.25), " +
                "('product_2', 'my product 2', 30.25)";
        jdbcTemplate.execute(insert);
        var countSql = "SELECT COUNT(*) FROM `product_catalog__products`";
        int productsCount = jdbcTemplate.queryForObject(countSql, Integer.class);

        assertThat(productsCount).isEqualTo(2);
    }

    @Test
    void itAllowsToInsertDynamicElements() {
        var insert = "INSERT INTO `product_catalog__products` (id, name, price) " +
                "VALUES " +
                "(?, ?, ?)";

        var product = new Product(UUID.randomUUID(), "my product", "nice one");
        product.changePrice(BigDecimal.TEN);

        jdbcTemplate.update(insert, product.getId(), product.getName(), product.getPrice());

        var countSql = "SELECT COUNT(*) FROM `product_catalog__products`";
        int productsCount = jdbcTemplate.queryForObject(countSql, Integer.class);

        assertThat(productsCount).isEqualTo(1);
    }

    @Test
    void selectForProducts() {
        var insert = "INSERT INTO `product_catalog__products` (id, name, price) " +
                "VALUES " +
                "('product_1', 'my product 1', 20.25), " +
                "('product_2', 'my product 2', 30.25);";
        jdbcTemplate.execute(insert);

        var selectSQL = "SELECT * FROM `product_catalog__products` WHERE id = ?";

        Product myProduct = jdbcTemplate.queryForObject(
                selectSQL,
                new Object[]{"product_1"},
                (rs, i) -> {
                    var myResult = new Product(
                            UUID.randomUUID(),
                            rs.getString("name"),
                            rs.getString("name")
                    );
                    myResult.changePrice(BigDecimal.valueOf(rs.getDouble("price")));
                    return myResult;
                });
        assertThat(myProduct.getName()).isEqualTo("my product 1");
    }

}
