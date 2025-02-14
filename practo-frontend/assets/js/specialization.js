document.addEventListener("DOMContentLoaded", async function () {
    const specializationSelect = document.getElementById("specialization-select");
    const doctorList = document.getElementById("doctors");

    // Load specializations into dropdown
    const specializations = await fetchSpecializations();
    specializations.forEach(spec => {
        let option = document.createElement("option");
        option.value = spec.id;
        option.textContent = spec.name;
        specializationSelect.appendChild(option);
    });

    // Event listener for specialization selection
    specializationSelect.addEventListener("change", async function () {
        doctorList.innerHTML = ""; // Clear previous results
        if (this.value) {
            const doctors = await fetchDoctorsBySpecialization(this.value);
            doctors.forEach(doctor => {
                let li = document.createElement("li");
                li.textContent = `${doctor.name} - ${doctor.practice}`;
                doctorList.appendChild(li);
            });
        }
    });
});
