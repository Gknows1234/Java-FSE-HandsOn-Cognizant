import React from 'react';

class Welcome extends React.Component {
  sayWelcome(message) {
    alert(message);
  }

  render() {
    return (
      <div>
        <button onClick={() => this.sayWelcome('Welcome')}>Say Welcome</button>
      </div>
    );
  }
}

export default Welcome;
