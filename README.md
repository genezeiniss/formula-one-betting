# Formula 1 Betting Backend

This is a backend application for placing and managing bets on Formula 1 events using third-party APIs. It is developed as part of a backend engineering home assignment.

## 🏁 Overview

This RESTful service allows users to:
- List Formula 1 events (with filtering)
- Place a bet on a driver for a specific event
- Simulate event outcomes and update bet results

> Events and driver data are retrieved from the open-source API: [https://openf1.org](https://openf1.org)

---
## 🚀 Getting Started

### Prerequisites

- [Java 21 JDK](https://adoptium.net/en-GB/temurin/releases/)
- [Maven](https://maven.apache.org/download.cgi)
- [Podman](https://podman.io/) or [Docker](https://www.docker.com/)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/genezeiniss/formula-one-betting.git
   cd formula-one-betting
   ```
2. Make the script executable

```bash
   chmod +x start-dev.sh
```

3. Run the development environment
```bash
   ./start-dev.sh
```

This will:

* Start a PostgreSQL container
* Run database migrations (Liquibase)
* Generate jOOQ classes
* Launch the Spring Boot application at http://localhost:8080

---
## 🔌 API Endpoints
1. List F1 Events

```bash
    GET /api/formula1/events
```

**Query Parameters (optional)**:

* year 
* country 
* sessionType

**Response**: List of sessions and associated driver odds.

2. Place a Bet

```bash
    POST /api/formula1/bet
```

**Request Body":
```
{
    "userId": "user-123",
    "eventId": "event-456",
    "driverId": "driver-789",
    "amount": 20.0
}
```

**Response**: Details of the placed bet and updated balance.

3. Simulate Event Outcome
```bash
    POST /api/formula1/events/{eventId}/outcome
```
**Response**: Bet outcomes and updated user balances.

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