import React from 'react';

export const ListofPlayers = () => {
  const players = [
    { name: 'Sachin', score: 100 },
    { name: 'Dhoni', score: 60 },
    { name: 'Virat', score: 80 },
    { name: 'Rohit', score: 45 },
    { name: 'Yuvraj', score: 90 },
    { name: 'Raina', score: 55 },
    { name: 'Dravid', score: 120 },
    { name: 'Sehwag', score: 30 },
    { name: 'Gambhir', score: 75 },
    { name: 'Jadeja', score: 65 },
    { name: 'Ashwin', score: 110 }
  ];

  const playersBelow70 = players.filter(p => p.score <= 70);

  return (
    <div>
      <h2>List of Players</h2>
      <ul>
        {players.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>
      <h2>Players Below 70</h2>
      <ul>
        {playersBelow70.map((p, i) => (
          <li key={i}>{p.name} - {p.score}</li>
        ))}
      </ul>
    </div>
  );
};
