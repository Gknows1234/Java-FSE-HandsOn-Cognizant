import React, { useState } from 'react';

const Register = () => {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (name.length < 5) {
      setError('Name should have at least 5 characters');
      return;
    }
    if (!email.includes('@') || !email.includes('.')) {
      setError('Email should have @ and .');
      return;
    }
    if (password.length < 8) {
      setError('Password should have at least 8 characters');
      return;
    }
    setError('');
    alert('Registration Successful');
  };

  return (
    <div style={{ padding: '20px' }}>
      <h2>Register</h2>
      {error && <p style={{ color: 'red' }}>{error}</p>}
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '10px' }}>
          <label style={{ display: 'inline-block', width: '80px' }}>Name: </label>
          <input type="text" value={name} onChange={e => setName(e.target.value)} />
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label style={{ display: 'inline-block', width: '80px' }}>Email: </label>
          <input type="text" value={email} onChange={e => setEmail(e.target.value)} />
        </div>
        <div style={{ marginBottom: '10px' }}>
          <label style={{ display: 'inline-block', width: '80px' }}>Password: </label>
          <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
        </div>
        <button type="submit">Register</button>
      </form>
    </div>
  );
};

export default Register;
