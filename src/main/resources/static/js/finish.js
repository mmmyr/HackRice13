document.getElementById('generateInsight').addEventListener('click', function () {
    const insights = [
        "Over the last month, your emotional well-being scores have been consistently higher on Fridays. Do you have a favorite activity or routine that day?",
        "Your average sleep score this month (85) is higher than last month's (72). Well done on improving your sleep routine!",
        "On days when your sleep score is above 90, your physical wellness rating tends to be 15 points higher on average. Quality sleep seems to have a significant impact on how you feel physically.",
        "There's a noticeable uptick in your mood scores on weekends. Reflect on activities or routines that make weekends special and consider incorporating them into weekdays.",
        "Your sleep scores tend to drop during the start of the month. Could it be related to monthly work commitments or routines?",
        "Seeing a dip in sleep scores over the past week? Establishing a consistent bedtime routine might help. Would you like some tips?",
        "You've rated your emotional well-being above 80 for five consecutive days. Keep up the positive vibes!",
        "Congratulations! You've logged your sleep score for 100 days in a row. Consistency is key to understanding patterns."
        // ... (Add more insights as you wish)
    ];

    // Randomly select an insight
    const randomInsight = insights[Math.floor(Math.random() * insights.length)];

    document.getElementById('insightText').textContent = randomInsight;
});
