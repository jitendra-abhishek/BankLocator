#Bank Locator - Spring Boot Microservice

This project is a simple Spring Boot application that accepts a user's zipcode and returns a list of banks within a 10-mile radius using the *Google Maps API*.

---

#Features

- Accepts a ZIP code and returns nearby banks
- Integrates with Google Maps API (Geocoding + Places API)
- Built using *Spring Boot*
- Modular architecture (easy to extend with microservices)


#Project Structure

bank-locator/ │ ├── pom.xml │ └── src/ │ └── main/ │ └── java/ │ └── com/ │ └── example/ │ └── bankfinder/ │ ├── BankFinderApplication.java │ ├── controller/ │ │ └── BankController.java │ └── service/ │ └── BankService.java

#How to Run

##Prerequisites

- Java 17 or later
- Maven
- A Google Maps API key (Geocoding + Places API enabled)
- IDE like Visual Studio Code or Eclipse

---

###Steps to Run

1. Clone the project or download the folder
2. Open the project in your IDE (like VS Code or Eclipse)
3. Replace the placeholder API key in BankService.java:
      private final String GOOGLE_API_KEY = "YOUR_API_KEY";