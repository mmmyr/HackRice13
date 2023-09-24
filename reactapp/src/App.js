import React, { Component } from 'react';
import Line from './components/Line';
import FetchButton from './components/FetchButton';
import FetchButton2 from './components/FetchButton2';
import FetchButton3 from './components/FetchButton3';
import './App.css';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
      monthdata: null,
      weekdata: null
    }
  }

  setData = (monthData, weekData) => {
    this.setState({ monthdata: monthData });
    this.setState({weekdata: weekData});
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
        <FetchButton setData={this.setData} />
        <FetchButton2 setData={this.setData} />
        <FetchButton3 setData={this.setData} />
        <h2 className="weekly-headline">Weekly Data</h2>
        <Line
          xData={['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']}
          yData={this.state.weekdata}
        />
        <h2 className="weekly-headline">Monthly Data</h2>
        <Line
          xData={['09/01', '09/02', '09/03', '09/04', '09/05', '09/01', '09/02', '09/03', '09/04', '09/05', '09/01', '09/8', '09/9', '09/10', '09/11',
            '09/01', '09/02', '09/03', '09/12', '09/13', '09/14', '09/15', '09/16', '09/17', '09/18', '09/19', '09/20', '09/21', '09/22', '09/23'
          ]}
          yData={this.state.monthdata}
        />
      </div>
      
    );
  }
}
export default App;