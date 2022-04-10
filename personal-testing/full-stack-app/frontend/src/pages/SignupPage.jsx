import { Link } from "react-router-dom";

export default function SignupPage() {
  return (
    <div className="signup">
      <form action="" className="user-form user-form--two-column">
        <h2 className="user-form__title">Sign up</h2>
        <fieldset className="user-form--wrapper">
          <div className="user-form__input--wrapper">
            <input
              id="username"
              type="text"
              className="user-form__input"
              required
            />
            <label htmlFor="username" className="user-form__label">
              Username
            </label>
          </div>
          <div className="user-form__input--wrapper">
            <input
              id="email"
              type="text"
              className="user-form__input"
              required
            />
            <label htmlFor="email" className="user-form__label">
              Email
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
          <div className="user-form__input--wrapper">
            <input
              id="password-confirm"
              type="password"
              className="user-form__input"
              required
            />
            <label htmlFor="password-confirm" className="user-form__label">
              Confirm password
            </label>
          </div>
        </fieldset>
        <fieldset className="user-form--wrapper">
          <div className="user-form__input--wrapper">
            <input
              id="first-name"
              type="text"
              className="user-form__input"
              required
            />
            <label htmlFor="first-name" className="user-form__label">
              First name
            </label>
          </div>
          <div className="user-form__input--wrapper">
            <input
              id="last-name"
              type="text"
              className="user-form__input"
              required
            />
            <label htmlFor="last-name" className="user-form__label">
              Last name
            </label>
          </div>
          <div className="user-form__input--wrapper">
            <input
              id="phone-number"
              type="tel"
              className="user-form__input"
              required
            />
            <label htmlFor="phone-number" className="user-form__label">
              Phone number
            </label>
          </div>
          <div className="user-form__input--wrapper user-form__input--wrapper--centered">
            <input id="terms-of-service" type="checkbox" />
            <label
              htmlFor="terms-of-service"
              className="user-form__label--checkbox"
            >
              I have read and accept the{" "}
              <a href="#" className="user-form__input__label__link">
                terms of service
              </a>
            </label>
          </div>
        </fieldset>
        <button type="submit" className="btn user-form__btn">
          Create account
        </button>
        <p className="user-form__register">
          Already have an account?{" "}
          <Link to="/login" className="user-form__register__link">
            Login here
          </Link>
        </p>
      </form>
      <p className="login__footer">
        Copyright &copy; Joakim Edvardsen 2022. All rights reserved
      </p>
    </div>
  );
}
