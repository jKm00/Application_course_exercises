import { Routes, Route } from "react-router-dom";

import "./styles/global.css";

import Nav from "./components/nav/Nav";
import HomePage from "./pages/HomePage";
import ProductPage from "./pages/productPage/ProductPage";
import LoginPage from "./pages/LoginPage";
import SignupPage from "./pages/SignupPage";

import "./styles/queries.css";

function App() {
  return (
    <>
      <Nav />
      <Routes>
        <Route exact path="/" element={<HomePage />} />
        <Route path="/products/:id" element={<ProductPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/signup" element={<SignupPage />} />
      </Routes>
    </>
  );
}

export default App;
