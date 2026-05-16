# FinanceManager (Java Console Application)
A menu-driven Finance Management System developed in Java using Object-Oriented Programming principles.

This project allows users to:
- Create multiple users
- Create savings/current accounts
- Add income and expense transactions
- Track account balances
- View transaction history
- Handle invalid input safely

---

## Features

- Multiple user support
- Multiple account support
- Income & Expense Tracking
- Transaction Validation
- Exception Handling
- Console-based menu navigation
- Input validation
- Reusable helper methods

---

## OOP Concepts Used

### Encapsulation 
- Private fields with controlled access methods

### Abstraction
- Abstract classes:
  - `Account`
  - `Transaction`

### Inheritance
- `SavingsAccount` and `CurrentAccount` inherit from `Account`
- `Income` and `Expense` inherit from `Transaction`

### Polymorphism
- Overridden `apply()` method for different transaction behaviours

---

## Technologies Used 
- Java 
- IntelliJ IDEA
- Git & GitHub

---

## Future Enhancements
- Persistent data storage using files or databases
- GUI version using JavaFX or Swing
- Monthly financial reports and analytics
- Budget planning and saving goals
- AI-powered spending pattern analysis and financial insights
- AI-chatbot assistance for finance-related queries
- Authentication and secure suer login system
- Transaction search and filtering functionality
- Export transaction history as PDF or CSV
- Cloud synchronization and mobile app integration

---

## How to Run

1. Clone repository
2. Open project in any Java-supported IDE (IntelliJ Idea, VS Code, etc.)
3. Ensure JDK 21 is installed
4. Run `Main.java`
