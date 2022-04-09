import { useNavigate, Link } from "react-router-dom";

import "./nav.css";

function Nav() {
  let history = useNavigate();

  function scrollToTop(event) {
    history("/");
    window.scrollTo(0, 0);
  }

  return (
    <>
      <div className="nav--wrapper"></div>
      <nav className="nav">
        <div className="nav__list--wrapper">
          <p className="logo" onClick={scrollToTop}>
            Full-Stack
          </p>
          <ul className="nav__list">
            <li className="nav__item">
              <a href="#products" className="nav__link">
                Products
              </a>
            </li>
            <li className="nav__item">
              <a href="#about" className="nav__link">
                About
              </a>
            </li>
            <li className="nav__item">
              <a href="#contact" className="nav__link">
                Contact
              </a>
            </li>
          </ul>
        </div>
        <ul className="nav__list">
          <li className="nav__item">
            <Link to="/login" className="nav__link">
              Login
            </Link>
          </li>
          <li className="nav__item">
            <Link to="/signup" className="nav__link">
              Signup
            </Link>
          </li>
        </ul>
      </nav>
    </>
  );
}

export default Nav;
