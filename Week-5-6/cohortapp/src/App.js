import React from 'react';
import './App.css';
import CohortDetails from './CohortDetails';

function App() {
  const cohorts = [
    { id: 1, name: 'Java Full Stack', status: 'ongoing', startDate: '2023-01-10', endDate: '2023-06-30' },
    { id: 2, name: 'Data Engineering', status: 'completed', startDate: '2022-05-01', endDate: '2022-11-30' },
    { id: 3, name: 'Cloud Computing', status: 'ongoing', startDate: '2023-02-15', endDate: '2023-07-31' }
  ];

  return (
    <div className="App" style={{ padding: '20px' }}>
      <h1>Cohorts Dashboard</h1>
      <div style={{ display: 'flex', flexWrap: 'wrap', justifyContent: 'center' }}>
        {cohorts.map(cohort => (
          <CohortDetails key={cohort.id} cohort={cohort} />
        ))}
      </div>
    </div>
  );
}

export default App;
