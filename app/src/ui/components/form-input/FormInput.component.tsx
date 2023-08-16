import './index.css';

interface ComponentProps {
  label: string;
  type: string;
  name?: string;
  id?: string;
  onChange: (event: React.ChangeEvent<HTMLInputElement>) => void;
  required?: boolean;
}

const FormInput = ({
  label,
  type,
  onChange,
  required = false,
  name = label,
  id = label,
}: ComponentProps) => {
  return (
    <div className="input-box">
      <label htmlFor="email">{label}</label>
      <input
        type={type}
        name={name}
        id={id}
        onChange={onChange}
        required={required}
      />
    </div>
  );
};

export default FormInput;
