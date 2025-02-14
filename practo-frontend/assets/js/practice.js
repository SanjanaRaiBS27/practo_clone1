document.addEventListener("DOMContentLoaded", async () => {
    const urlParams = new URLSearchParams(window.location.search);
    const practiceId = urlParams.get("id");

    if (practiceId) {
        await loadPracticeDetails(practiceId);
        await loadSpecializations(practiceId);
        await loadDoctors(practiceId); // Load all doctors initially
    }
});

// Load Practice Details
async function loadPracticeDetails(practiceId) {
    try {
        const response = await fetch(`http://localhost:8080/api/practices/${practiceId}`);
        if (!response.ok) throw new Error("Failed to fetch practice details");

        const practice = await response.json();
        document.getElementById("practice-name").textContent = practice.name;
        document.getElementById("practice-address").textContent = `${practice.address || "Unknown"}, ${practice.city || "Unknown"}`;
    } catch (error) {
        console.error("Error fetching practice details:", error);
    }
}

// Load Specializations for this Practice
async function loadSpecializations(practiceId) {
    try {
        const response = await fetch(`http://localhost:8080/api/practices/${practiceId}/specializations`);
        if (!response.ok) throw new Error("Failed to fetch specializations");

        const specializations = await response.json();
        const specializationDropdown = document.getElementById("specialization-select");
        specializationDropdown.innerHTML = `<option value="">All Specializations</option>`;

        specializations.forEach(spec => {
            const option = document.createElement("option");
            option.value = spec.id;
            option.textContent = spec.name;
            specializationDropdown.appendChild(option);
        });
    } catch (error) {
        console.error("Error fetching specializations:", error);
    }
}

// Load All Doctors in the Practice
async function loadDoctors(practiceId) {
    try {
        const response = await fetch(`http://localhost:8080/api/practices/${practiceId}/doctors`);
        if (!response.ok) throw new Error("Failed to fetch doctors");

        const doctors = await response.json();
        displayDoctors(doctors);
    } catch (error) {
        console.error("Error fetching doctors:", error);
    }
}

// Fetch Doctors when Specialization is Selected
document.getElementById("specialization-select").addEventListener("change", async function () {
    const specializationId = this.value;
    const urlParams = new URLSearchParams(window.location.search);
    const practiceId = urlParams.get("id");

    if (specializationId) {
        await loadDoctorsBySpecialization(practiceId, specializationId);
    } else {
        await loadDoctors(practiceId); // Load all doctors if no specialization is selected
    }
});

// Load Doctors by Selected Specialization
async function loadDoctorsBySpecialization(practiceId, specializationId) {
    try {
        const response = await fetch(`http://localhost:8080/api/doctors?practiceId=${practiceId}&specializationId=${specializationId}`);
        if (!response.ok) throw new Error("Failed to fetch doctors");

        const doctors = await response.json();
        displayDoctors(doctors);
    } catch (error) {
        console.error("Error fetching doctors:", error);
    }
}

// Display Doctors in the UI
function displayDoctors(doctors) {
    const doctorList = document.getElementById("doctor-list");
    doctorList.innerHTML = "";

    if (doctors.length === 0) {
        doctorList.innerHTML = "<p>No doctors found.</p>";
        return;
    }

    doctors.forEach(doc => {
        const div = document.createElement("div");
        div.classList.add("doctor-item");
        div.innerHTML = `
            <p><strong>${doc.name}</strong></p>
            <p>${doc.qualifications || "N/A"} | ${doc.experienceYears || 0} years experience</p>
            <button onclick="viewDoctor(${doc.id})">View Details</button>
        `;
        doctorList.appendChild(div);
    });
}

// Redirect to Doctor Details Page
function viewDoctor(doctorId) {
    window.location.href = `doctor-detail.html?id=${doctorId}`;
}
