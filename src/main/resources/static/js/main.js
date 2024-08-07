const getProducts = () => {
    return fetch("/api/products")
        .then(response => response.json());
}

const getCurrentOffer = () => {
    return fetch("/api/current-offer")
        .then(response => response.json());
}

const addProductToCart = (product) => {
    return fetch(`api/add-to-cart/${product}`, {
        method: "POST",
    });
}


const acceptOffer = (acceptOfferRequest) => {
    return fetch("/api/accept-offer", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(acceptOfferRequest),
    }).then(response => response.json());
}
createProductHtmlEl = (productData) => {
    const template = `
        <div>
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThtvTcTtNhsHpbjUJA5zozfapMee2a9MsxXRP4MPxNgQ&s" width="200" height="200" alt="item-image">
            <h4>${productData.name}</h4>
            <span>${productData.description}</span>
            <span>${productData.price} PLN</span>
            <button data-id ="${productData.id} PLN">Add to cart</button>
        </div>
    `;
    const newEl = document.createElement("li");
    newEl.innerHTML = template.trim();
    return newEl;
}

const refreshCurrentOffer = () => {
    const totalEl = document.querySelector('#offer__items-total');
    const itemCountEl = document.querySelector('#offer__items-count');

    getCurrentOffer()
        .then(offer => {
            totalEl.textContent = `${offer.total} PLN`;
            itemCountEl.textContent = `${offer.itemsCount} shoppingCartEmoji`
        })
}

const initializeCartHandler = (productHtmlEl) => {
    const addToCartBtn = productHtmlEl.querySelector("button[data-id]")
    addToCartBtn.addEventListener("click", (event) => {
        const productId = event.target.getAttribute("data-id");
        addProductToCart(productId)
            .then(refreshCurrentOffer());
    });
    return productHtmlEl;
}

const checkoutFormEl = document.querySelector('#checkout');
checkoutFormEl.addEventListener("submit", (event) => {
    event.preventDefault();

    const acceptOfferRequest = {
        firstName: checkoutFormEl.querySelector('input[name="first_name"]').value,
        lastName: checkoutFormEl.querySelector('input[name="last_name"]').value,
        email: checkoutFormEl.querySelector('input[name="email"]').value,
    }

    acceptOffer(acceptOfferRequest)
        .then(resDetails => window.location.href = resDetails.paymentUrl);
});

document.addEventListener("DOMContentLoaded", () => {
    console.log("it works");
    const productsList = document.querySelector("#productsList");
    getProducts()
        .then(productAsJson => productAsJson.map(createProductHtmlEl))
        .then(productsHtmls => productsHtmls.map(initializeCartHandler))
        .then(productsHtmls => {
            productsHtmls.forEach(htmlEl => productsList.appendChild(htmlEl))
        });
})
