import React from 'react';

export class Cart extends React.Component {
  render() {
    const { Itemname, Price } = this.props;
    return (
      <tr>
        <td>{Itemname}</td>
        <td>{Price}</td>
      </tr>
    );
  }
}
