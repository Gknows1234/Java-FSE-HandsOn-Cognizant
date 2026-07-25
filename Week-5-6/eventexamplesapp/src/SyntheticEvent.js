import React from 'react';

class SyntheticEvent extends React.Component {
  handlePress = (e) => {
    alert(`Synthetic Event: ${e.type} - I was clicked`);
  }

  render() {
    return (
      <div>
        <button onClick={this.handlePress}>OnPress</button>
      </div>
    );
  }
}

export default SyntheticEvent;
