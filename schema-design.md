## MySQL Database Design

### Table: Patients
- patient_id: INT (Primary Key, AUTO_INCREMENT)
- name: VARCHAR(100) NOT NULL
- dob: DATE
- email: VARCHAR(100) UNIQUE
- phone: VARCHAR(15)

### Table: Doctors
- doctor_id: INT (Primary Key, AUTO_INCREMENT)
- name: VARCHAR(100) NOT NULL
- specialization: VARCHAR(100)
- email: VARCHAR(100) UNIQUE

### Table: Appointments
- appointment_id: INT (Primary Key, AUTO_INCREMENT)
- patient_id: INT (Foreign Key to Patients.patient_id)
- doctor_id: INT (Foreign Key to Doctors.doctor_id)
- date: DATE
- time: TIME
- status: VARCHAR(20) CHECK (status IN ('Scheduled', 'Completed', 'Cancelled'))

### Table: Admin
- admin_id: INT (Primary Key, AUTO_INCREMENT)
- username: VARCHAR(50) UNIQUE
- password: VARCHAR(255) NOT NULL

## MongoDB Collection Design

### Collection: Prescriptions

Example Document:
```json
{
  "prescription_id": "RX123456",
  "patient_id": 1,
  "doctor_id": 101,
  "date": "2025-07-18",
  "medications": [
    {
      "name": "Amoxicillin",
      "dosage": "500mg",
      "instructions": "Take twice daily after food"
    },
    {
      "name": "Paracetamol",
      "dosage": "650mg",
      "instructions": "Take when needed for fever"
    }
  ],
  "notes": "Patient should rest for 3 days"
}
