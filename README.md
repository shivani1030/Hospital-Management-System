# 🏥 Hospital Management System (HMS)

The **Hospital Management System (HMS)** is a Java-based desktop application that automates hospital workflows such as **patient registration, doctor management, appointment booking, room allocation, and discharge handling**.  

The project uses **Java Swing & AWT** for GUI, **MySQL** for database management, and **JDBC** for database connectivity. External libraries like **DbUtils** and **ResultSet2xml.jar** are used for database-to-table mapping and report generation. An **AI-powered chatbot** is also integrated to answer natural language queries like *“Check available rooms”* or *“Book an appointment”*.  

---

## ✨ Features
- 🔐 Secure login for hospital staff  
- 🧑‍🤝‍🧑 Patient registration & record management (`ALL_Patient_Info.java`)  
- 👨‍⚕️ Doctor information & scheduling  
- 📅 Appointment booking with conflict prevention  
- 🏨 Room search & allocation (`SearchRoom.java`)  
- 📤 Patient discharge & room release   
- 🖥️ User-friendly GUI (Java Swing & AWT)  

---

## 🛠️ Technology Stack
- **Language:** Java (Swing, AWT, JDBC)  
- **Database:** MySQL  
- **Libraries:**  
  - `mysql-connector.jar` (DB connectivity)  
  - `DbUtils.jar` (ResultSet → TableModel)  
  - `ResultSet2xml.jar` (XML export)  
- **IDE:** IntelliJ IDEA Community Edition 2022  

---

## 📂 Project Structure
- `Login.java` → User login & authentication  
- `NEW_PATIENT.java` → Register new patients  
- `NEW_APPOINTMENT.java` → Schedule appointments  
- `Doctor_info.java` → Manage doctor details  
- `SearchRoom.java` → Search & allocate rooms  
- `patient_discharge.java` → Discharge process & room release  
- `ALL_Patient_Info.java` → View all patient records  
- `conn.java` → Database connection class  
