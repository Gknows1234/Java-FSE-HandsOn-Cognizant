import React, { useState } from 'react';
import BookDetails from './BookDetails';
import BlogDetails from './BlogDetails';
import CourseDetails from './CourseDetails';

function App() {
  const [view, setView] = useState('book');

  const renderView = () => {
    if (view === 'book') {
      return <BookDetails show={true} />;
    } else if (view === 'blog') {
      return <BlogDetails isActive={true} />;
    } else if (view === 'course') {
      return <CourseDetails status="available" />;
    }
    return null;
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>Blogger App</h1>
      <button onClick={() => setView('book')}>Books</button>
      <button onClick={() => setView('blog')}>Blogs</button>
      <button onClick={() => setView('course')}>Courses</button>
      <hr />
      {renderView()}
    </div>
  );
}

export default App;
