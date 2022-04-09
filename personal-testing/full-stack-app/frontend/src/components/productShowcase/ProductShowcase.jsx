import "./productShowcase.css";

function ProductShowcase({ id, title, desc, price }) {
  return (
    <section className="product-showcase">
      <img
        src={"https://picsum.photos/500/450?random=" + id}
        alt=""
        className="product-showcase__img"
      />
      <div className="product-showcase__body">
        <div>
          <h2 className="product-showcase__body__title">{title}</h2>
          <p className="product-showcase__body__desc">{desc}</p>
          <p className="product-showcase__body__price">{price},-</p>
        </div>
        {
          // TODO: Update form based on product. Need some backend work
        }
        <form>
          <fieldset className="product-showcase__body__form">
            <legend className="product-showcase__body__form__title">
              Colors:
            </legend>
            {
              // TODO: Make labels for color with right color as background
            }
            <input type="radio" name="color" value="black" />
            <input type="radio" name="color" value="blue" />
            <input type="radio" name="color" value="red" />
          </fieldset>
          <fieldset className="product-showcase__body__form">
            <legend className="product-showcase__body__form__title">
              Sizes:
            </legend>
            <select
              name="sizes"
              className="product-showcase__body__form__select"
            >
              <option value="37">37</option>
              <option value="38">38</option>
              <option value="39">39</option>
              <option value="40">40</option>
              <option value="41">41</option>
              <option value="42">42</option>
              <option value="43">43</option>
              <option value="44">44</option>
              <option value="45">45</option>
              <option value="46">46</option>
              <option value="47">47</option>
            </select>
          </fieldset>
          <button className="product-showcase__body__form__btn btn">
            Add to cart
          </button>
        </form>
      </div>
    </section>
  );
}

export default ProductShowcase;
