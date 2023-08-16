import './index.css';

interface ButtonProps {
  content: string;
  type?: 'auth' | 'main' | 'secondary';
}

const Button = ({ content, type = 'auth' }: ButtonProps) => {
  return <button className={`button-${type}`}>{content}</button>;
};

export default Button;
