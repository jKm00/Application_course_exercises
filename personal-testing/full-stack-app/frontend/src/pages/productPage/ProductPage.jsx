import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";

import ProductShowcase from "../../components/productShowcase/ProductShowcase";

import "./productPage.css";

function ProductPage() {
  const { id } = useParams();

  const [loading, setLoading] = useState(true);
  const [product, setProduct] = useState();

  const PRODUCT_URL = "http://localhost:8080/api/products/" + id;

  useEffect(() => {
    fetch(PRODUCT_URL)
      .then((response) => response.json())
      .then((result) => {
        setProduct(result);
        console.log(product);
        setLoading(false);
      });
  }, []);

  return (
    <div className="product-page">
      {loading ? (
        <p>Loading...</p>
      ) : (
        <ProductShowcase
          id={product.id}
          title={product.name}
          desc={product.description}
          price={product.price}
        />
      )}
    </div>
  );
}

export default ProductPage;
