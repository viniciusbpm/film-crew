import { axiosInstance } from './axiosInstance';

const useAuthFunctions = () => {
  const login = async (username: string, password: string) => {
    const response = await axiosInstance.post('/auth/login', {
      username: username,
      password: password,
    });

    return response.data;
  };

  return { login };
};

export default useAuthFunctions;
