import { Routes, Route } from "react-router-dom";

import Nav from "./components/nav/Nav";
import HomePage from "./pages/HomePage";
import ProductPage from "./pages/ProductPage";
import Footer from "./components/footer/Footer";

import "./styles/global.css";
import "./styles/queries.css";

function App() {
  return (
    <>
      <Nav />
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route path="/products/:id" element={<ProductPage />} />
      </Routes>
      <Footer />
    </>
  );
}

export default App;
