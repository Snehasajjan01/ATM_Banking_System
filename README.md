# ATM Banking System (Java)

A console-based ATM Banking System developed in Java. The program demonstrates basic object-oriented programming concepts and menu-driven banking operations.

## Features

- Account number and ATM PIN validation
- Deposit money
- Withdraw money with an insufficient-balance check
- Change the ATM PIN with confirmation
- View a mini statement of transactions
- Check the current account balance
- Validate deposit and withdrawal amounts as positive multiples of 100
- Simulate processing delays for selected operations

## Technologies Used

- Java
- `Scanner` for console input
- `ArrayList` for storing transaction history

## Project Structure

```text
ATM-Banking-System/
├── README.md
└── java_anudip/
    └── Mainn.java
```

## How to Run

Make sure the Java Development Kit (JDK) is installed.

1. Open a terminal or Command Prompt in the folder containing `ATM-Banking-System`.
2. Compile the Java source file:

   ```bash
   javac java_anudip/Mainn.java
   ```

3. Run the program from the project root:

   ```bash
   java java_anudip.Mainn
   ```

## Demo Credentials

The current source code uses hardcoded demo credentials:

- Account number: `54321`
- Initial ATM PIN: `9876`

Use these credentials to test the program. The PIN can be changed during the session.

## Notes and Limitations

- This is an educational console application, not a production banking system.
- The account number and PIN are hardcoded for demonstration.
- The balance and transaction history are stored in memory, so they reset when the program exits.
- No real bank account, payment, or database is connected.

## Possible Improvements

- Store account and transaction data in a database
- Add stronger input validation and exception handling
- Support multiple accounts
- Persist transaction history between runs
- Avoid hardcoded credentials and implement secure authentication

## License

This project is intended for learning and educational use. Add a license if you want to specify reuse terms.
