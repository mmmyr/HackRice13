import React from 'react';
import './index.css';


function FetchButton3(props) {
    async function handleClick() {
        try {

            console.log("sent Request!"); // Handle the received data as needed

            /*
            const response2 = await fetch('http://localhost:8080/user/getWeeklyWellData', {method: 'GET'});
    
            if (!response2.ok) {
                throw new Error(`HTTP error! Status: ${response2.status}`);
            }
    
            const data2 = await response2.json();
            
            const response1 = await fetch('http://localhost:8080/user/getMonthlyWellData', {method: 'GET'});
    
            if (!response1.ok) {
                throw new Error(`HTTP error! Status: ${response1.status}`);
            }
    
            const data1 = await response1.json(); */
            

            const data2 = [2, 3, 4, 5,6,7,1];
            const data1 = [2, 3, 4, 5, 6, 7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,10];
            props.setData(data1,data2);
            console.log("data1"); // Handle the received data as needed
            console.log(data1); // Handle the received data as needed
            console.log("data2"); // Handle the received data as needed
            console.log(data2); // Handle the received data as needed
        } catch (error) {
            console.error("There was a problem with the fetch operation:", error.message);
        }
    }

    return (
        <button className = "fetch-button3" onClick={handleClick}>
            Show Wellness Data
        </button>
    );
}

export default FetchButton3;
