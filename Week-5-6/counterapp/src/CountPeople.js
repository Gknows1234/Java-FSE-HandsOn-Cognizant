import React, { Component } from 'react';

class CountPeople extends Component {
  constructor(props) {
    super(props);
    this.state = {
      entrycount: 0,
      exitcount: 0
    };
  }

  UpdateEntry = () => {
    this.setState((prevState) => ({
      entrycount: prevState.entrycount + 1
    }));
  };

  UpdateExit = () => {
    this.setState((prevState) => ({
      exitcount: prevState.exitcount + 1
    }));
  };

  render() {
    return (
      <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
        <button onClick={this.UpdateEntry} style={{ padding: '5px 15px', marginRight: '10px' }}>Login</button>
        <span>{this.state.entrycount} People Entered!!</span>
        
        <br /><br />
        
        <button onClick={this.UpdateExit} style={{ padding: '5px 15px', marginRight: '10px' }}>Exit</button>
        <span>{this.state.exitcount} People Left!!</span>
      </div>
    );
  }
}

export default CountPeople;
