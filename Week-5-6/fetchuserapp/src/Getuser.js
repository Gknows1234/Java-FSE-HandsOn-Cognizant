import React, { Component } from 'react';

class Getuser extends Component {
  constructor(props) {
    super(props);
    this.state = {
      user: null,
      loading: true
    };
  }

  async componentDidMount() {
    try {
      const response = await fetch('https://api.randomuser.me/');
      const data = await response.json();
      this.setState({ user: data.results[0], loading: false });
    } catch (error) {
      console.error(error);
      this.setState({ loading: false });
    }
  }

  render() {
    const { user, loading } = this.state;
    if (loading) {
      return <div>Loading user details...</div>;
    }

    if (!user) {
      return <div>No user data available.</div>;
    }

    return (
      <div style={{ padding: '20px', border: '1px solid #ccc', maxWidth: '300px' }}>
        <h2>User Details</h2>
        <img src={user.picture.large} alt="User" style={{ borderRadius: '50%' }} />
        <p><strong>Title:</strong> {user.name.title}</p>
        <p><strong>First Name:</strong> {user.name.first}</p>
        <p><strong>Last Name:</strong> {user.name.last}</p>
      </div>
    );
  }
}

export default Getuser;
