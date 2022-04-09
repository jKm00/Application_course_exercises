import { Link } from "react-router-dom";

import "../styles/userForm.css";

export default function LoginPage() {
  return (
    <div className="login">
      <form action="" className="user-form">
        <fieldset className="user-form--wrapper">
          <legend className="user-form__title">Login</legend>
          <div className="user-form__input--wrapper">
            <input
              id="username"
              type="text"
              className="user-form__input"
              required
            />
            <label htmlFor="username" className="user-form__label">
              Username / Email
            </label>
          </div>
          <div className="user-form__input--wrapper">
            <input
              id="password"
              type="password"
              className="user-form__input"
              required
            />
            <label htmlFor="password" className="user-form__label">
              Password
            </label>
          </div>
          <button type="submit" className="btn user-form__btn">
            Login
          </button>
        </fieldset>
        <p className="user-form__register">
          Don't have an account?{" "}
          <Link to="/signup" className="user-form__register__link">
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
