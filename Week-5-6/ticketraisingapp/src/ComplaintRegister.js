import React, { useState } from 'react';

const ComplaintRegister = () => {
  const [empName, setEmpName] = useState('');
  const [complaint, setComplaint] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    const refNumber = Math.floor(Math.random() * 100000);
    alert(`Complaint Registered Successfully!\nEmployee: ${empName}\nReference Number: ${refNumber}`);
    setEmpName('');
    setComplaint('');
  };

  return (
    <div style={{ padding: '20px', maxWidth: '400px' }}>
      <h2>Register Complaint</h2>
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label style={{ display: 'block' }}>Employee Name:</label>
          <input
            type="text"
            value={empName}
            onChange={(e) => setEmpName(e.target.value)}
            required
            style={{ width: '100%' }}
          />
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label style={{ display: 'block' }}>Complaint:</label>
          <textarea
            value={complaint}
            onChange={(e) => setComplaint(e.target.value)}
            required
            rows="5"
            style={{ width: '100%' }}
          ></textarea>
        </div>
        <button type="submit">Submit Complaint</button>
      </form>
    </div>
  );
};

export default ComplaintRegister;
