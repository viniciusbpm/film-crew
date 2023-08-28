import './index.css';

interface ComponentProps {
  children: string;
  type: 'h1' | 'h2' | 'h3' | 'h4' | 'h5' | 'h6';
  size?: 'small' | 'medium' | 'large';
  className?: string;
}

const Title = ({
  children,
  type,
  size = 'medium',
  className,
}: ComponentProps) => {
  switch (type) {
    case 'h1':
      return <h1 className={`title-${size} ${className}`}>{children}</h1>;
    case 'h2':
      return <h2 className={`title-${size} ${className}`}>{children}</h2>;
    case 'h3':
      return <h3 className={`title-${size} ${className}`}>{children}</h3>;
    case 'h4':
      return <h4 className={`title-${size} ${className}`}>{children}</h4>;
    case 'h5':
      return <h5 className={`title-${size} ${className}`}>{children}</h5>;
    case 'h6':
      return <h6 className={`title-${size} ${className}`}>{children}</h6>;
    default:
      return <h1 className="title">{children}</h1>;
  }
};

export default Title;
