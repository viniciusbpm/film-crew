import './index.css';
import logo from '../../../assets/img/logo.png';
import Title from '../../components/title/Title.component';
import FormInput from '../../components/form-input/FormInput.component';
import Button from '../../components/button/Button.component';
import { useState } from 'react';
import useAuthFunctions from '../../../api/hooks/useAuthFunctions.hooks';
import { toast } from 'react-hot-toast';
import { AxiosError } from 'axios';

const RegisterScreen = () => {
  const { register } = useAuthFunctions();
  const [loginInput, setLoginInput] = useState({
    username: { value: '' },
    email: { value: '' },
    password: { value: '' },
    profilePicture: { value: '' },
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
      const user = await register(
        loginInput.username.value,
        loginInput.email.value,
        loginInput.password.value,
        loginInput.profilePicture.value
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
          Register
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
          <FormInput
            label="Profile picture:"
            type="text"
            onChange={handleChange}
            name="text"
            id="text"
            required
          />
          <Button content="Register" />
        </form>
        <p>
          Already have an account?{' '}
          <a href="/" className="register-link">
            Login here
          </a>
        </p>
      </div>
    </div>
  );
};

export default RegisterScreen;
