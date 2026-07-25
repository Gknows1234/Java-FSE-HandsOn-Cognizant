import React from 'react';

class CurrencyConvertor extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      rupees: 0,
      euros: 0
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(e) {
    this.setState({ rupees: e.target.value });
  }

  handleSubmit(e) {
    e.preventDefault();
    const converted = (this.state.rupees / 90).toFixed(2); // assuming 1 Euro = 90 INR
    this.setState({ euros: converted });
  }

  render() {
    return (
      <div>
        <h2>Currency Convertor</h2>
        <form onSubmit={this.handleSubmit}>
          <label>
            Indian Rupees:
            <input type="number" value={this.state.rupees} onChange={this.handleChange} />
          </label>
          <button type="submit">Convert</button>
        </form>
        <p>Euros: {this.state.euros}</p>
      </div>
    );
  }
}

export default CurrencyConvertor;
