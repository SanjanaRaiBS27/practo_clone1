async function performSearch() {
    const query = document.getElementById("search-bar").value.trim();
    if (!query) return;

    let url = `http://localhost:8080/doctors/doctor-name/${query}`;
    let type = "doctor";

    if (query.toLowerCase().includes("clinic") || query.toLowerCase().includes("hospital")) {
        url = `http://localhost:8080/practices/practice-name/${query}`;
        type = "practice";
    } else if (query.toLowerCase().includes("specialization")) {
        url = `http://localhost:8080/specializations?name=${query}`;
        type = "specialization";
    }

    try {
        console.log("Fetching from:", url);
        const response = await fetch(url);
        if (!response.ok) throw new Error("Network response was not ok");

        const data = await response.json();
        console.log("API Response:", data);
        displayResults(data, type);
    } catch (error) {
        console.error("Error fetching data:", error);
    }
}

function displayResults(results, type) {
    const resultsContainer = document.getElementById("search-results");
    resultsContainer.innerHTML = "";

    if (!results || results.length === 0) {
        resultsContainer.innerHTML = "<p>No results found.</p>";
        return;
    }

    results.forEach(result => {
        const div = document.createElement("div");
        div.classList.add("result-item");

        if (type === "practice") {
            // Clicking a practice fetches its doctors
            div.innerHTML = `<p><strong style="cursor: pointer; color: blue; text-decoration: underline;">${result.name}</strong></p>`;
            div.addEventListener("click", () => fetchDoctorsByPracticeId(result.name));
        } else {
            // Show details for doctors and other types
            div.innerHTML = `<p><strong>${result.name}</strong></p>`;
        }

        resultsContainer.appendChild(div);
    });
}

async function fetchDoctorsByPracticeId(practiceName) {
    const url = `http://localhost:8080/practices/all-doctors/practice-id/${encodeURIComponent(practiceName)}`;

    try {
        console.log("Fetching doctors from:", url);
        const response = await fetch(url);
        if (!response.ok) throw new Error("Network response was not ok");

        const doctors = await response.json();
        console.log("Doctors Response:", doctors);
        displayDoctors(doctors, practiceName);
    } catch (error) {
        console.error("Error fetching doctors:", error);
    }
}

function displayDoctors(doctors, practiceName) {
    const resultsContainer = document.getElementById("search-results");

    // Append doctors list under the selected practice
    const doctorsDiv = document.createElement("div");
    doctorsDiv.innerHTML = `<h3>Doctors at ${practiceName}</h3>`;

    if (!doctors || doctors.length === 0) {
        doctorsDiv.innerHTML += "<p>No doctors found.</p>";
    } else {
        doctors.forEach(doctor => {
            const doctorCard = document.createElement("div");
            doctorCard.classList.add("doctor-card");

            doctorCard.innerHTML = `
                <h4>${doctor.name}</h4>
                <p><strong>Qualifications:</strong> ${doctor.qualifications}</p>
                <p><strong>Experience:</strong> ${doctor.experienceYears} years</p>
                <p><strong>Bio:</strong> ${doctor.bio}</p>
                <hr>
            `;

            doctorsDiv.appendChild(doctorCard);
        });
    }

    resultsContainer.appendChild(doctorsDiv);
}

// Attach event listeners after DOM loads
document.addEventListener("DOMContentLoaded", () => {
    document.getElementById("search-button").addEventListener("click", performSearch);
    document.getElementById("search-bar").addEventListener("keypress", function(event) {
        if (event.key === "Enter") {
            performSearch();
        }
    });
});
