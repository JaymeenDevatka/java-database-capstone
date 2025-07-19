## MySQL Database Design

### Table: patients
- id: INT, Primary Key, AUTO_INCREMENT
- name: VARCHAR(100), NOT NULL
- email: VARCHAR(100), UNIQUE
- phone: VARCHAR(15)
- gender: VARCHAR(10)
- date_of_birth: DATE

### Table: doctors
- id: INT, Primary Key, AUTO_INCREMENT
- name: VARCHAR(100), NOT NULL
- specialization: VARCHAR(100)
- email: VARCHAR(100), UNIQUE
- phone: VARCHAR(15)
- available_from: TIME
- available_to: TIME

### Table: appointments
- id: INT, Primary Key, AUTO_INCREMENT
- doctor_id: INT, Foreign Key → doctors(id)
- patient_id: INT, Foreign Key → patients(id)
- appointment_time: DATETIME, NOT NULL
- status: VARCHAR(20) -- ('Scheduled', 'Completed', 'Cancelled')

### Table: admins
- id: INT, Primary Key, AUTO_INCREMENT
- username: VARCHAR(50), UNIQUE
- password: VARCHAR(100), NOT NULL
- full_name: VARCHAR(100)
- email: VARCHAR(100)

> Notes:
> - Patients and doctors are the core entities.
> - Appointments link patients and doctors.
> - Admins manage the system; login credentials are stored here.
> - All emails should be unique.


## MongoDB Collection Design

### Collection: prescriptions
```json
{
  "_id": "ObjectId('64abc123456')",
  "patientId": 12,
  "appointmentId": 34,
  "medications": [
    {
      "name": "Amoxicillin",
      "dosage": "250mg",
      "frequency": "3 times a day"
    },
    {
      "name": "Ibuprofen",
      "dosage": "200mg",
      "frequency": "2 times a day"
    }
  ],
  "doctorNotes": "Patient should avoid dairy with antibiotics.",
  "createdAt": "2025-07-19T10:30:00Z"
}

{
  "_id": "ObjectId('64abc456789')",
  "patientId": 12,
  "doctorId": 4,
  "rating": 4.5,
  "comments": "Very kind and attentive doctor.",
  "submittedAt": "2025-07-18T16:00:00Z"
}
