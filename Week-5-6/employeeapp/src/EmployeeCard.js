import React, { useContext } from 'react';
import ThemeContext from './ThemeContext';

const EmployeeCard = ({ employee }) => {
  const theme = useContext(ThemeContext);

  const buttonStyle = {
    backgroundColor: theme === 'dark' ? '#555' : '#ccc',
    color: theme === 'dark' ? '#fff' : '#000',
    padding: '5px 10px',
    border: 'none',
    cursor: 'pointer'
  };

  return (
    <div style={{ border: '1px solid', borderColor: theme === 'dark' ? '#fff' : '#000', padding: '10px', borderRadius: '5px' }}>
      <h3>{employee.name}</h3>
      <p>{employee.designation}</p>
      <button style={buttonStyle}>View Profile</button>
    </div>
  );
};

export default EmployeeCard;
