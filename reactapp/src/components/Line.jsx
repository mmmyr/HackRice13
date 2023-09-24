import React from 'react';
import ReactEcharts from 'echarts-for-react';


export default class Line extends React.Component {
    getOption = () => {
        let option = {
            xAxis: {
                type: 'category',
                data: this.props.xData
            },
            yAxis: {
                type: 'value'
            },
            series: [
                {
                    data: this.props.yData,
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
