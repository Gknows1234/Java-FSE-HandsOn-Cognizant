import React from 'react';

const BlogDetails = ({ isActive }) => {
  return (
    <div>
      {isActive && <h3>Blog Details</h3>}
      {isActive ? <p>Welcome to my React Blog!</p> : <p>Blog is currently inactive.</p>}
    </div>
  );
};

export default BlogDetails;
