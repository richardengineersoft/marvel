# Marvel Service API

This service provides an interface for interacting with Marvel characters and their data. It has been built using Spring Boot and integrates with a PostgreSQL database.

## Pre-requisites

### For Compilation:

- **JAVA JDK 17**
    - You can download it from [Java JDK Official Site](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

### For Operation:

- **Postgres 11.15**
  - Ensure that you have Postgres 11.15 installed. If not, 
  - you can quickly set it up using Docker with the following command:
    ```
    docker run --name postgres-marvel -e POSTGRES_PASSWORD=test -d postgres:11.15-alpine
    ```

## Setup & Execution

1. **File Permissions**:
   - First, you need to make sure that the required scripts have the right permissions:
     ```
     chmod +x assemble.sh avengers.sh
     ```

2. **Database Setup**:
   - Create a new database for the service in PostgreSQL.
   - Execute the schema generation script to structure the database appropriately. 
   - This script will set up the necessary tables and relationships required by the service.

3. **Running the Service**:
   - Start by executing the assembly script:
     ```
     ./assemble.sh
     ```
   - Once that's done, you can run the service with:
     ```
     ./avengers.sh
     ```

---

Enjoy using the Marvel Service API! If you face any issues, 
please refer to the documentation or raise an issue on the repository.

---