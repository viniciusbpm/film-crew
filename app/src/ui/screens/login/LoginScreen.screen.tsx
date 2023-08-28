import './index.css';
import logo from '../../../assets/img/logo.png';
import { useState } from 'react';
import { AxiosError } from 'axios';
import toast from 'react-hot-toast';
import Title from '../../components/title/Title.component';
import useAuthFunctions from '../../../api/hooks/useAuthFunctions.hooks';
import FormInput from '../../components/form-input/FormInput.component';
import Button from '../../components/button/Button.component';

const LoginScreen = () => {
  const { login } = useAuthFunctions();
  const [loginInput, setLoginInput] = useState({
    username: { value: '' },
    password: { value: '' },
  });

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.currentTarget;
    setLoginInput((oldFormInput) => ({
      ...oldFormInput,
      [name]: { value: value },
    }));
  };

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    try {
      const user = await login(
        loginInput.username.value,
        loginInput.password.value
      );
    } catch (error) {
      if (error instanceof AxiosError) {
        toast.error(error.response?.data.message);
      }
    }
  };

  return (
    <div className="login-box">
      <div className="login-box-left-side">
        <img src={logo} alt="Film Crew logo" className="logo" />
      </div>
      <div className="login-box-right-side">
        <Title type="h2" size="medium">
          Login
        </Title>
        <form className="login-form" onSubmit={handleSubmit}>
          <FormInput
            label="Username:"
            type="text"
            onChange={handleChange}
            name="username"
            id="username"
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
          <a href="/register" className="register-link">
            Register here
          </a>
        </p>
      </div>
    </div>
  );
};

export default LoginScreen;
