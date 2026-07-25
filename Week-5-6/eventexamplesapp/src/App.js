import React from 'react';
import Counter from './Counter';
import Welcome from './Welcome';
import SyntheticEvent from './SyntheticEvent';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  return (
    <div style={{ padding: '20px' }}>
      <h1>Event Examples App</h1>
      <Counter />
      <hr />
      <Welcome />
      <hr />
      <SyntheticEvent />
      <hr />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
