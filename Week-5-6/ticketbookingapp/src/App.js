import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div style={{ padding: '20px' }}>
      <h1>Ticket Booking App</h1>
      {isLoggedIn ? (
        <div>
          <button onClick={handleLogout}>Logout</button>
          <UserPage />
        </div>
      ) : (
        <div>
          <button onClick={handleLogin}>Login</button>
          <GuestPage />
        </div>
      )}
    </div>
  );
}

export default App;
