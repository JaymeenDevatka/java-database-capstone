## Architecture Summary

This Spring Boot application follows a three-tier architecture comprising the presentation, application, and data layers.

- The **Presentation Layer** uses Thymeleaf templates for Admin and Doctor dashboards, and REST APIs for patient-related modules such as appointments and records.
- The **Application Layer** contains Spring Boot controllers (both MVC and REST), services for business logic, and repositories for data access.
- The **Data Layer** integrates two databases:
  - **MySQL** for structured, relational data like patients, doctors, appointments, and admin users.
  - **MongoDB** for flexible, document-based storage like prescriptions.
  
The service layer ensures all business logic is centralized and interacts with either JPA repositories (for MySQL) or MongoDB repositories based on the data source. This structure provides modularity, scalability, and ease of maintenance.

## Numbered Flow of Data and Control

1. **User Interface Layer**  
   Users interact with the system either via Thymeleaf-based dashboards (e.g., AdminDashboard, DoctorDashboard) or through REST API clients like mobile apps or web modules (e.g., PatientDashboard).

2. **Controller Layer**  
   User actions are routed to:
   - MVC Controllers for rendering HTML views using Thymeleaf
   - REST Controllers for handling JSON requests/responses

3. **Service Layer**  
   Controllers delegate processing to service classes that:
   - Apply business logic and validations
   - Coordinate workflows like appointment booking or record fetching

4. **Repository Layer**  
   The service layer interacts with repositories:
   - JPA Repositories (for MySQL) for structured data like patients and appointments
   - MongoDB Repositories (for document data like prescriptions)

5. **Database Access**  
   - MySQL stores normalized relational data
   - MongoDB stores nested, schema-flexible documents

6. **Model Binding**  
   Retrieved data is converted into Java classes:
   - `@Entity` for JPA models (MySQL)
   - `@Document` for MongoDB models

7. **Response to Client**  
   - For MVC: Models are passed to Thymeleaf templates → rendered HTML sent to browser
   - For REST: Models or DTOs are serialized into JSON and returned to clients
