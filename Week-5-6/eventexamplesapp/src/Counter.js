import React from 'react';

class Counter extends React.Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
    this.handleIncrement = this.handleIncrement.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.handleDecrement = this.handleDecrement.bind(this);
  }

  handleIncrement() {
    this.setState({ count: this.state.count + 1 });
  }

  sayHello() {
    alert('Hello! Static message.');
  }

  handleIncreaseClick = () => {
    this.handleIncrement();
    this.sayHello();
  }

  handleDecrement() {
    this.setState({ count: this.state.count - 1 });
  }

  render() {
    return (
      <div>
        <h2>Counter: {this.state.count}</h2>
        <button onClick={this.handleIncreaseClick}>Increment</button>
        <button onClick={this.handleDecrement}>Decrement</button>
      </div>
    );
  }
}

export default Counter;
