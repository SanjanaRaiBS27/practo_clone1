const urlParams = new URLSearchParams(window.location.search);
const doctorId = urlParams.get("id");

async function fetchDoctor() {
    const response = await fetch(`http://localhost:8080/doctors/${doctorId}`);
    const doctor = await response.json();
    document.getElementById("doctor-list").innerHTML = `
        <h3>${doctor.name}</h3>
        <p>Experience: ${doctor.experienceYears} years</p>
        <p>Qualifications: ${doctor.qualifications}</p>
    `;
}
fetchDoctor();
