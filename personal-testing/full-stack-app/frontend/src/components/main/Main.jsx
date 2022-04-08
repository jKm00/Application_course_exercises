import { useState, useEffect } from "react";
import { Link } from "react-router-dom";

import ProductCard from "../productCard/ProductCard";

import "./main.css";

function Main() {
  const PRODUCTS_URL = "http://localhost:8080/api/products";

  const [loading, setLoading] = useState(true);
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch(PRODUCTS_URL)
      .then((response) => response.json())
      .then((products) => {
        setProducts(products);
        setLoading(false);
      });
  }, []);

  return (
    <main className="main">
      <h2 className="main__title">Our products</h2>
      {loading ? (
        <p>Loading...</p>
      ) : (
        products.map((product) => (
          <ProductCard
            key={product.id}
            id={product.id}
            title={product.name}
            desc={product.description}
            price={product.price}
          />
        ))
      )}
    </main>
  );
}

export default Main;
