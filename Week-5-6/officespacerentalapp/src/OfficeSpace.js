import React from 'react';

const officeSpaces = [
  { Name: 'DBS', Rent: 50000, Address: 'Chennai' },
  { Name: 'Ozone', Rent: 70000, Address: 'Bangalore' },
  { Name: 'DLF', Rent: 40000, Address: 'Hyderabad' }
];

export const OfficeSpace = () => {
  return (
    <div style={{ padding: '20px' }}>
      <h1>Office Space Rental App</h1>
      <img src="https://via.placeholder.com/300x150?text=Office+Space" alt="Office Space" style={{ marginBottom: '20px' }} />
      <h2>Available Spaces:</h2>
      <ul style={{ listStyleType: 'none', padding: 0 }}>
        {officeSpaces.map((office, index) => {
          const rentStyle = { color: office.Rent <= 60000 ? 'red' : 'green' };
          return (
            <li key={index} style={{ marginBottom: '10px', border: '1px solid #ccc', padding: '10px', width: '300px' }}>
              <strong>Name:</strong> {office.Name} <br />
              <strong style={rentStyle}>Rent: Rs. {office.Rent}</strong> <br />
              <strong>Address:</strong> {office.Address}
            </li>
          );
        })}
      </ul>
    </div>
  );
}

export default OfficeSpace;
