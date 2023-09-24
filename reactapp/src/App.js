import React, { Component } from 'react';
import Line from './components/Line';
import FetchButton from './components/FetchButton';
import './App.css';

var fetchedWeekData; 
var fetchedMonthData;

function handleFetchedData(data) {
  console.log("Data in Parent Component:", data);
  fetchedWeekData = data; 
  // You can now set this data to state or use it as required
}

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
        <FetchButton onFetch={handleFetchedData} />
        <h2 className="weekly-headline">Monthly Data</h2>
        <Line
          xData={['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']}
          yData={fetchedWeekData}
        />
        <h2 className="monthly-headline">Monthly Data</h2>
        <Line
          xData={['Jan', 'Feb', 'Mar', 'Apr', 'May']}
          yData={[100, 200, 150, 175, 225]}
        />
      </div>
      
    );
  }
}
export default App;