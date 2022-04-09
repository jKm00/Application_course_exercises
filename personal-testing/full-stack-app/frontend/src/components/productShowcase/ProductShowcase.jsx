import "./productShowcase.css";

import { useState, useEffect } from "react";

function ProductShowcase({ id, title, desc, price }) {
  const ULR = "http://localhost:8080/api/products/colors/" + id;

  const [colors, setColors] = useState([]);

  useEffect(() => {
    fetch(ULR)
      .then((response) => response.json())
      .then((result) => {
        setColors(result);
      });
  }, []);

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
          <fieldset className="product-showcase__body__form product-showcase__body__form--colors">
            <legend className="product-showcase__body__form__title">
              Colors:
            </legend>
            {colors.length === 0 ? (
              <p>Loading...</p>
            ) : (
              colors.map((color) => (
                <div key={color.id} className="color-input--wrapper">
                  <input
                    id={color.id}
                    type="radio"
                    name="color"
                    value={color.color}
                    className="color-input"
                  />
                  <label
                    htmlFor={color.id}
                    className="color-label"
                    style={{ backgroundColor: color.color }}
                  ></label>
                </div>
              ))
            )}
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
          <button
            type="submit"
            className="product-showcase__body__form__btn btn"
          >
            Add to cart
          </button>
        </form>
      </div>
    </section>
  );
}

export default ProductShowcase;
