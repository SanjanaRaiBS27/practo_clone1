const API_BASE_URL = "http://localhost:8080/api"; // Update with your backend URL

// Function to fetch doctors based on search
async function fetchDoctors(searchQuery) {
    const response = await fetch(`${API_BASE_URL}/doctors?query=${searchQuery}`);
    return response.json();
}

// Function to fetch specializations
async function fetchSpecializations() {
    const response = await fetch(`${API_BASE_URL}/specializations`);
    return response.json();
}

// Function to fetch doctors by specialization
async function fetchDoctorsBySpecialization(specialization) {
    const response = await fetch(`${API_BASE_URL}/doctors/specialization/${specialization}`);
    return response.json();
}
