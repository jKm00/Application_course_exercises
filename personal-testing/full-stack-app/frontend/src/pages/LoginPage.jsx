import { Link } from "react-router-dom";

import "../styles/userForm.css";

export default function LoginPage() {
  return (
    <div className="login">
      <form action="" className="form">
        <fieldset className="form--wrapper">
          <legend className="form__title">Login</legend>
          <div className="form__input--wrapper">
            <input id="username" type="text" className="form__input" required />
            <label htmlFor="username" className="form__label">
              Username / Email
            </label>
          </div>
          <div className="form__input--wrapper">
            <input
              id="password"
              type="password"
              className="form__input"
              required
            />
            <label htmlFor="password" className="form__label">
              Password
            </label>
          </div>
          <button type="submit" className="btn form__btn">
            Login
          </button>
        </fieldset>
        <p className="form__register">
          Don't have an account?{" "}
          <Link to="/signup" className="form__register__link">
            Register here
          </Link>
        </p>
      </form>
      <p className="login__footer">
        Copyright &copy; Joakim Edvardsen 2022. All rights reserved
      </p>
    </div>
  );
}
