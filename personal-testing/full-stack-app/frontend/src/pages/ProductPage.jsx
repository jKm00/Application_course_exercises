import { useParams } from "react-router-dom";

function ProductPage() {
  const { id } = useParams();

  return (
    <section className="product-page">
      <h1>Product page {id}</h1>
    </section>
  );
}

export default ProductPage;
