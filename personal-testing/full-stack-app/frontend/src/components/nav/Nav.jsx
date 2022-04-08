import { Link } from "react-router-dom";

import "./nav.css";

function Nav() {
  return (
    <nav className="nav">
      <Link to="/" className="logo">
        Full-Stack
      </Link>
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
  );
}

export default Nav;
