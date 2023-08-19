import './index.css';
import logo from '../../assets/img/logo.png';
import { useState } from 'react';
import FormInput from '../components/form-input/FormInput.component';
import Button from '../components/button/Button.component';

const LoginScreen = () => {
  const [loginInput, setLoginInput] = useState({
    email: { value: '' },
    password: { value: '' },
  });

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.currentTarget;
    setLoginInput((oldFormInput) => ({
      ...oldFormInput,
      [name]: { value: value },
    }));
  };

  return (
    <div className="login-box">
      <div className="login-box-left-side">
        <img src={logo} alt="Film Crew logo" className="logo" />
      </div>
      <div className="login-box-right-side">
        <h2>Login</h2>
        <form className="login-form">
          <FormInput
            label="Email:"
            type="email"
            onChange={handleChange}
            name="email"
            id="email"
            required
          />
          <FormInput
            label="Password:"
            type="password"
            onChange={handleChange}
            name="password"
            id="password"
            required
          />
          <Button content="Login" />
        </form>
        <p>
          Doesn't have an account yet?{' '}
          <a href="/" className="register-link">
            Register here
          </a>
        </p>
      </div>
    </div>
  );
};

export default LoginScreen;
