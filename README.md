# Formula 1 Betting Backend

This is a backend application for placing and managing bets on Formula 1 events using third-party APIs. It is developed as part of a backend engineering home assignment.

## 🏁 Overview

This RESTful service allows users to:
- List Formula 1 events (with filtering)
- Place a bet on a driver for a specific event (TBD)
- Simulate event outcomes and update bet results (TBD)

> Events and driver data are retrieved from the open-source API: [https://openf1.org](https://openf1.org)

---
## 🚀 Getting Started

### Prerequisites

- [Java 21 JDK](https://adoptium.net/en-GB/temurin/releases/)
- [Maven](https://maven.apache.org/download.cgi)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/genezeiniss/formula-one-betting.git
   cd formula-one-betting
   ```
2. **Build the application**
```bash
   mvn clean install
```
3. **Run the application**
```bash
   mvn spring-boot:run
```

---
## 🔌 API Endpoints
1. List F1 Events

```bash
    GET /api/formula-one/events
```

**Query Parameters**:

* year 
* country (optional)
* sessionType (optional)

**Response**: List of sessions and associated driver odds.

---
## 👤 User Info
* Each user starts with a balance of €100
* No deposit or withdrawal functionality
* A userId must be passed in bet-related operations
* User **signup, authentication, and authorization** are not implemented as they are out of scope for this project

---
## ⚙️ Design Considerations
* The service uses a modular architecture for easy integration with future F1 data providers.
* Randomized odds (2, 3, or 4) are assigned to drivers per event.