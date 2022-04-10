export default function AdminPage() {
  const ADD_PRODUCT_URL = "http://localhost:8080/api/products";

  function tryAddProduct(event) {
    event.preventDefault();
    const name = event.target.productName.value;
  }

  return (
    <section className="admin">
      <form action="" className="form" onSubmit={tryAddProduct}>
        <fieldset className="form--wrapper">
          <legend className="form__title">Product</legend>
          <div className="form__input--wrapper">
            <input
              id="product-name"
              type="text"
              name="productName"
              className="form__input"
              required
            />
            <label htmlFor="product-name" className="form__label">
              Product name
            </label>
          </div>
          <div className="form__input--wrapper">
            <input
              id="product-desc"
              type="text"
              name="productDesc"
              className="form__input"
              required
            />
            <label htmlFor="product-desc" className="form__label">
              Product description
            </label>
          </div>
          <div className="form__input--wrapper">
            <input
              id="product-sex"
              type="text"
              name="productSex"
              className="form__input"
              required
            />
            <label htmlFor="product-sex" className="form__label">
              Sex
            </label>
          </div>
          <div className="form__input--wrapper">
            <input
              id="product-featured"
              type="text"
              name="productFeatured"
              className="form__input"
              required
            />
            <label htmlFor="product-featured" className="form__label">
              Featured? (0 = no, 1 = yes)
            </label>
          </div>
          <div className="form__input--wrapper">
            <input
              id="product-price"
              type="text"
              name="productPrice"
              className="form__input"
              required
            />
            <label htmlFor="product-price" className="form__label">
              Price
            </label>
          </div>
        </fieldset>
        <fieldset className="form--wrapper">
          <legend className="form__title form__title--small">
            Product colors
          </legend>
          <div className="form__input--wrapper">
            <input
              id="product-colors"
              type="text"
              name="productColors"
              className="form__input"
              required
            />
            <label htmlFor="product-colors" className="form__label">
              Colors (separate with commas)
            </label>
          </div>
        </fieldset>
        <fieldset className="form--wrapper">
          <legend className="form__title form__title--small">
            Product sizes
          </legend>
          <div className="form__input--wrapper">
            <input
              id="product-sizes"
              type="text"
              name="productSizes"
              className="form__input"
              required
            />
            <label htmlFor="product-sizes" className="form__label">
              Sizes (separate with commas)
            </label>
          </div>
        </fieldset>
        <button type="submit" className="btn form__btn">
          Add product
        </button>
      </form>
    </section>
  );
}
