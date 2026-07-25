import React from 'react';

export const IndianPlayers = () => {
  const T20Players = ['First Player', 'Second Player', 'Third Player'];
  const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
  const indianPlayers = [...T20Players, ...RanjiTrophyPlayers];

  // Destructuring
  const [first, second, third, fourth, fifth, sixth] = indianPlayers;

  return (
    <div>
      <h2>Indian Players</h2>
      <p>Odd Team Players: {first}, {third}, {fifth}</p>
      <p>Even Team Players: {second}, {fourth}, {sixth}</p>
      <h2>Merged Team</h2>
      <ul>
        {indianPlayers.map((p, i) => <li key={i}>{p}</li>)}
      </ul>
    </div>
  );
};
