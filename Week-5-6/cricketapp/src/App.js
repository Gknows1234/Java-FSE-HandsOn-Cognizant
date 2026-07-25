import React from 'react';
import { ListofPlayers } from './ListofPlayers';
import { IndianPlayers } from './IndianPlayers';

function App() {
  const flag = true; // Set to false to see IndianPlayers

  if (flag) {
    return (
      <div>
        <h1>Cricket App</h1>
        <ListofPlayers />
      </div>
    );
  } else {
    return (
      <div>
        <h1>Cricket App</h1>
        <IndianPlayers />
      </div>
    );
  }
}

export default App;
