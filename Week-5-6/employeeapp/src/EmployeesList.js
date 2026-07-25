import React from 'react';
import EmployeeCard from './EmployeeCard';

const EmployeesList = () => {
  const employees = [
    { id: 1, name: 'John Doe', designation: 'Developer' },
    { id: 2, name: 'Jane Smith', designation: 'Designer' },
    { id: 3, name: 'Bob Johnson', designation: 'Manager' }
  ];

  return (
    <div>
      <h2>Employee List</h2>
      <div style={{ display: 'flex', gap: '20px' }}>
        {employees.map(emp => (
          <EmployeeCard key={emp.id} employee={emp} />
        ))}
      </div>
    </div>
  );
};

export default EmployeesList;
