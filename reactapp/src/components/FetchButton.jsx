import React from 'react';
import './index.css'

async function handleClick() {
    try {

        console.log("sent Request!"); // Handle the received data as needed
        const response = await fetch('http://localhost:8080/user/getWeeklySleepData',
            {method: 'GET'});

        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const data = await response.json();
        console.log("data"); // Handle the received data as needed
        console.log(data); // Handle the received data as needed

        if (this.props.onFetch) {
            this.props.onFetch(data);
        }

    } catch (error) {
        console.error("There was a problem with the fetch operation:", error.message);
    }
}

function FetchButton(props) {
    return (
        <button className="fetch-button" onClick={handleClick}>
            Fetch Data
        </button>
    );
}

export default FetchButton;
