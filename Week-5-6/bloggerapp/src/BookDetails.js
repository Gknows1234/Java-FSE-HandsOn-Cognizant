import React from 'react';

const BookDetails = ({ show }) => {
  if (!show) {
    return null;
  }
  return <div><h3>Book Details</h3><p>React Programming Guide</p></div>;
};

export default BookDetails;
