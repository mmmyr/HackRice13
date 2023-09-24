const controller = document.querySelector('input[type=range]');
const radialProgress = document.querySelector('.MentalProgress');
const progressValue = document.querySelector('.progress-value');

var value = 0;
const setProgress = (progress) => {
    value = `${progress}%`;
    let angleDegree = value + "deg";
    progressValue.textContent = `${progress}%`
    radialProgress.style.background = `conic-gradient(#7d2ae8 ${progress*3.6}deg, #ededed 0deg) `
    //radialProgress.innerHTML = value
    radialProgress.setAttribute('aria-valuenow', value)
}

setProgress(controller.value)
controller.oninput = () => {
    setProgress(controller.value)
}

document.getElementById('saveMentalBtn').addEventListener('click', function () {
    console.log("sent request!");
    console.log(value);
    let intValue = parseInt(value.slice(0, -1));
    console.log(intValue);
    fetch('/user/saveMoodData', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: intValue
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to save data');
            }
            // Once data is saved successfully, redirect to MoodPage

        })
        .catch(error => {
            console.error("Error:", error);
        });

    console.log("finish store data");
});