import { Link } from "react-router-dom";

import "./productCard.css";

function ProductCard({ id, title, desc, price }) {
  return (
    <Link to={"/products/" + id} className="product-card--link">
      <div className="product-card">
        <img
          src={"https://picsum.photos/300/250?random=" + id}
          alt={title}
          className="product-card__img"
        />
        <div className="product-card__body">
          <h3 className="product-card__body__title">{title}</h3>
          <p className="product-card__body__desc">{desc}</p>
          <p className="product-card__body__price">{price},-</p>
          <p className="btn product-card__body__btn">View product</p>
        </div>
      </div>
    </Link>
  );
}

export default ProductCard;
