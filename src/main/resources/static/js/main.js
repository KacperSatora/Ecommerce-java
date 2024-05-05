getProducts = () => {
    return fetch("/api/products")
        .then(response => response.json());
}

createProductHtmlEl = (productData) => {
    const template = `
        <div>
            <img src="https://www.pastelowelove.pl/userdata/public/gfx/5582/kotek-mruczek--naklejka.-naklejka-dla-dzieci.-dekoracje-pokoju.jpg" width="200" height="200">
            <h4>${productData.name}</h4>
            <span>${productData.description}</span>
            <span>${productData.price}</span>
            <button data-id ="${productData.id}"> Add to cart</button>
        </div>
    `;
    const newEl = document.createElement("li");
    newEl.innerHTML = template.trim();
    return newEl;
}

document.addEventListener("DOMContentLoaded", () => {
    console.log("it works");
    const productsList = document.querySelector("#productsList");
    getProducts()
        .then(products => products.map(createProductHtmlEl))
        .then(productsHtmls => {
            productsHtmls.forEach(htmlEl => productsList.appendChild(htmlEl))
        });
})