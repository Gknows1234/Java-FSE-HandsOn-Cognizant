import React from 'react';

const CourseDetails = ({ status }) => {
  let content;
  if (status === 'available') {
    content = <p>React Masterclass is available.</p>;
  } else {
    content = <p>Course not found.</p>;
  }

  return (
    <div>
      <h3>Course Details</h3>
      {content}
    </div>
  );
};

export default CourseDetails;
