const controller = document.querySelector('input[type=range]');
const radialProgress = document.querySelector('.PhysicalProgress');
const progressValue = document.querySelector('.progress-value');

var value = 0;
const setProgress = (progress) => {
    value = `${progress}%`;
    let angleDegree = value + "deg";
    progressValue.textContent = `${progress}%`
    radialProgress.style.background = `conic-gradient(#e67e22 ${progress*3.6}deg, #ededed 0deg) `
    //radialProgress.innerHTML = value
    radialProgress.setAttribute('aria-valuenow', value)
}

setProgress(controller.value)
controller.oninput = () => {
    setProgress(controller.value)
}

document.getElementById('savePhysicalBtn').addEventListener('click', function () {
    console.log("sent request!");
    console.log(value);
    let intValue = parseInt(value.slice(0, -1));
    console.log(intValue);
    fetch('/user/saveWellnessData', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: intValue
    }).then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        return response.json();
    })
        .then(data => console.log(data))
        .catch(error => console.log('Fetch error: ' + error.message));
});