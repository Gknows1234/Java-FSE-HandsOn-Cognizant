import React from 'react';
import { Cart } from './Cart';

class OnlineShopping extends React.Component {
  constructor(props) {
    super(props);
    this.cart = [
      { Itemname: 'Laptop', Price: 50000 },
      { Itemname: 'Mobile', Price: 25000 },
      { Itemname: 'Headphones', Price: 2000 },
      { Itemname: 'Watch', Price: 5000 },
      { Itemname: 'Keyboard', Price: 1000 }
    ];
  }

  render() {
    return (
      <div>
        <h1>Items Ordered :</h1>
        <table border="1" cellPadding="10">
          <thead>
            <tr>
              <th>Item Name</th>
              <th>Price</th>
            </tr>
          </thead>
          <tbody>
            {this.cart.map((item, index) => (
              <Cart key={index} Itemname={item.Itemname} Price={item.Price} />
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;
