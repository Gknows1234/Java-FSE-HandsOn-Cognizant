import React, { useState } from 'react';
import EmployeesList from './EmployeesList';
import ThemeContext from './ThemeContext';

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme(theme === 'light' ? 'dark' : 'light');
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div style={{ background: theme === 'dark' ? '#333' : '#fff', color: theme === 'dark' ? '#fff' : '#000', padding: '20px', minHeight: '100vh' }}>
        <h1>Employee Management</h1>
        <button onClick={toggleTheme}>Toggle Theme</button>
        <EmployeesList />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;
