import React from 'react';
import { useParams, Link } from 'react-router-dom';
import { TrainersMock } from './TrainersMock';

const TrainerDetails = () => {
  const { id } = useParams();
  const trainer = TrainersMock.find((t) => t.TrainerId === parseInt(id));

  if (!trainer) {
    return <div>Trainer not found</div>;
  }

  return (
    <div>
      <h2>Trainer Details</h2>
      <p><strong>ID:</strong> {trainer.TrainerId}</p>
      <p><strong>Name:</strong> {trainer.Name}</p>
      <p><strong>Email:</strong> {trainer.Email}</p>
      <p><strong>Phone:</strong> {trainer.Phone}</p>
      <p><strong>Technology:</strong> {trainer.Technology}</p>
      <p><strong>Skills:</strong> {trainer.Skills}</p>
      <Link to="/trainers">Back to List</Link>
    </div>
  );
};

export default TrainerDetails;
