
function submitForm() {
    const dateInput = document.getElementById("lastVaccineDate").value;
    const dateTimeString = dateInput + 'T00:00:00';

    const dogData = {
    name: document.getElementById("name").value,
    imgURL: document.getElementById("imgURL").value,
    species: document.getElementById("species").value,
    medicalHistory: document.getElementById("medicalHistory").value,
    intro: document.getElementById("intro").value,
    gender: document.getElementById("gender").value,
    lastVaccineDate: dateTimeString,
    age: document.getElementById("age").value

};

    // Make an AJAX POST request to send JSON data
    fetch('/dogpage/save', {
    method: 'POST',
    headers: {
    'Content-Type': 'application/json',
},
    body: JSON.stringify(dogData),
})
    .then(response => {
    if (response.ok) {
    alert('Dog added successfully!');
} else {
    alert('Failed to add the dog.');
}
});
}
