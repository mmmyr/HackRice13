const controller = document.querySelector('input[type=range]');
const radialProgress = document.querySelector('.RadialProgress');
const progressValue = document.querySelector('.progress-value');

const setProgress = (progress) => {
    const value = `${progress}%`;
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