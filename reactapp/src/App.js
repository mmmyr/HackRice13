import React, { Component } from 'react';
import Line from './components/Line';
import FetchButton from './components/FetchButton';
import ReactDom from 'react-dom';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    }
  }
  componentDidMount() {
    const url = "https://jsonplaceholder.typicode.com/posts";
    fetch(url)
      .then(response => response.json())
      .then(json => this.setState({ posts: json }))
  }
  render() {
    return (
      <div>
        <FetchButton />
        <Line />
      </div>
      
    );
  }
}
export default App;