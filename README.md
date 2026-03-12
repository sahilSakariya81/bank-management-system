# Bank Management System - Spring Boot

## Project Overview

Bank Management System is a **Spring Boot REST API application** designed to simulate basic banking operations.  
Users can create accounts, deposit and withdraw money, and transfer funds between accounts. The system maintains all transactions in a separate table and ensures **ACID compliance** using the `@Transactional` annotation.

Each account is automatically assigned a **10-digit unique account number** as the primary key, and the account creation date is recorded automatically.  
The system also tracks all transaction history for deposits, withdrawals, and transfers.

---

## Key Features

### Account Management

* Users can create new accounts
* Account number is **auto-generated (10 digits)** and unique
* Stores:
  * Account Number (`ac_no`)
  * Account Holder Name
  * Balance
  * Creation Date

### Transaction Management

* Users can perform:
  * Deposit
  * Withdrawal
  * Transfer between accounts
* Each transaction is recorded in the transaction table
* Stores:
  * Account Number (`ac_no`)
  * Transaction Amount
  * Transaction Date
  * Transaction Type (Deposit, Withdrawal, Transfer)

### ACID Compliance

* Ensures **atomicity, consistency, isolation, and durability** using Spring Boot `@Transactional` annotation
* Prevents partial updates during failures (e.g., during fund transfer)

---

## Technologies Used

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* REST APIs
* `@Transactional` for ACID compliance

---

## Project Architecture

The application follows a **layered architecture**:

Controller → Service → Repository → Database

* **Controller Layer** – Handles REST API requests
* **Service Layer** – Contains business logic such as deposits, withdrawals, and transfers
* **Repository Layer** – Handles database operations using Spring Data JPA
* **Database Layer** – MySQL database

---

## Database Design

### Account Table

Stores account information.

Fields:

* ac_no
* name
* balance
* created_at

### Transaction Table

Stores transaction history.

Fields:

* id
* ac_no
* amount
* transaction_date
* transaction_type

---

## API Endpoints

### Create Account

POST /accounts

* Auto-generates a **10-digit account number**
* Returns account details including balance and creation date

---

### Deposit

POST /accounts/deposit

* Add funds to an account
* Records transaction

---

### Withdraw

POST /accounts/withdraw

* Withdraw funds from an account
* Checks sufficient balance
* Records transaction

---

### Transfer

POST /accounts/transfer

* Transfer funds from one account to another
* Ensures **ACID compliance** with `@Transactional`
* Records transaction for both accounts

---

### View Transactions

GET /transactions/{ac_no}

* Returns all transaction history for a specific account

---

## How to Run the Project

1. Clone the repository:

```bash
git clone https://github.com/yourusername/bank-management-system.git
