import { Link } from "react-router-dom";

export default function SignupPage() {
  return (
    <div className="signup">
      <form action="" className="form form--two-column">
        <h2 className="form__title">Sign up</h2>
        <fieldset className="form--wrapper">
          <div className="form__input--wrapper">
            <input id="username" type="text" className="form__input" required />
            <label htmlFor="username" className="form__label">
              Username
            </label>
          </div>
          <div className="form__input--wrapper">
            <input id="email" type="text" className="form__input" required />
            <label htmlFor="email" className="form__label">
              Email
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
          <div className="form__input--wrapper">
            <input
              id="password-confirm"
              type="password"
              className="form__input"
              required
            />
            <label htmlFor="password-confirm" className="form__label">
              Confirm password
            </label>
          </div>
        </fieldset>
        <fieldset className="form--wrapper">
          <div className="form__input--wrapper">
            <input
              id="first-name"
              type="text"
              className="form__input"
              required
            />
            <label htmlFor="first-name" className="form__label">
              First name
            </label>
          </div>
          <div className="form__input--wrapper">
            <input
              id="last-name"
              type="text"
              className="form__input"
              required
            />
            <label htmlFor="last-name" className="form__label">
              Last name
            </label>
          </div>
          <div className="form__input--wrapper">
            <input
              id="phone-number"
              type="tel"
              className="form__input"
              required
            />
            <label htmlFor="phone-number" className="form__label">
              Phone number
            </label>
          </div>
          <div className="form__input--wrapper form__input--wrapper--centered">
            <input id="terms-of-service" type="checkbox" />
            <label htmlFor="terms-of-service" className="form__label--checkbox">
              I have read and accept the{" "}
              <a href="#" className="form__input__label__link">
                terms of service
              </a>
            </label>
          </div>
        </fieldset>
        <button type="submit" className="btn form__btn">
          Create account
        </button>
        <p className="form__register">
          Already have an account?{" "}
          <Link to="/login" className="form__register__link">
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
