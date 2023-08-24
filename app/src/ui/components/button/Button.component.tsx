import './index.css';

interface ButtonProps {
  content: string;
  type?: 'auth' | 'main' | 'secondary';
  onClick?: () => void;
}

const Button = ({ content, type = 'auth', onClick }: ButtonProps) => {
  return (
    <button className={`button-${type}`} onClick={onClick}>
      {content}
    </button>
  );
};

export default Button;
