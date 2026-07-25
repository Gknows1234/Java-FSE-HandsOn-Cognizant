import React from 'react';
import '../Stylesheets/mystyle.css';

const CalculateScore = ({ Name, School, Total, Goal }) => {
  return (
    <div className="student-score">
      <h1>Student Details:</h1>
      <div className="Name">
        <b>Name:</b> {Name}
      </div>
      <div className="School">
        <b>School:</b> {School}
      </div>
      <div className="Total">
        <b>Total:</b> {Total}
      </div>
      <div className="Goal">
        <b>Goal:</b> {Goal}
      </div>
      <div className="Score">
        <b>Score:</b> {Math.round((Total / Goal) * 100) / 100}
      </div>
    </div>
  );
};

export default CalculateScore;
