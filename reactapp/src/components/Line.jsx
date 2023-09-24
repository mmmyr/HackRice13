import React from 'react';
import ReactEcharts from 'echarts-for-react';
import './index.css'

export default class Line extends React.Component {
    getOption = () => {
        let option = {
            xAxis: {
                type: 'category',
                data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    data: [13, 230, 224, 218, 135, 147, 260],
                    type: 'line'
                }
            ]
        };
        return option
    }

    render() {
        return (
            <div className='wrapper'>
                <ReactEcharts option={this.getOption()} style={{ height: '400px' }} />
            </div>
        )
    }
}
