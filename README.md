# 🔗 UTXO-Based Cryptocurrency Wallet with ECDSA

## 📌 Overview
This project is a basic implementation of a blockchain-based cryptocurrency system built in Java. It demonstrates how digital wallets, transactions, and blocks interact using cryptographic principles and the UTXO (Unspent Transaction Output) model.

---

## 🚀 Features
- 🔐 Wallet generation using **ECDSA (Elliptic Curve Digital Signature Algorithm)**
- ✍️ Secure transaction signing and verification
- 🔄 UTXO-based transaction model for ownership tracking
- ⛓️ Blockchain with Proof-of-Work (mining using SHA-256)
- 💾 Transaction persistence using **H2 Database**
- ✅ Full transaction validation and double-spending prevention

---

## 🧠 Key Concepts Implemented
- **Digital Signatures:** Ensures only the owner of funds can authorize transactions  
- **Hashing (SHA-256):** Maintains data integrity and links blocks securely  
- **UTXO Model:** Tracks ownership using unspent transaction outputs  
- **Proof of Work:** Secures the blockchain by mining blocks  

---

## ⚙️ Tech Stack
- **Language:** Java  
- **Cryptography:** BouncyCastle (ECDSA)  
- **Database:** H2  
- **Build Tool:** Maven  

---

## 📂 Project Structure
- `Wallet` → Handles key generation and fund transfers  
- `Transaction` → Defines transaction logic and validation  
- `TransactionInput/Output` → Manages UTXO references  
- `Block` → Stores transactions and handles mining  
- `NoobChain` → Main blockchain logic  

---

## 🔄 How It Works
1. A wallet generates a public-private key pair  
2. Transactions are created and signed using the private key  
3. Inputs reference previous UTXOs to prove ownership  
4. New outputs are generated and stored as UTXOs  
5. Blocks are mined and added to the blockchain  

---

## 📊 Sample Output
```
WalletA's balance is: 100.0
WalletA is Attempting to send funds (40) to WalletB...
Transaction Successfully added to Block

WalletA's balance is: 60.0
WalletB's balance is: 40.0
```

---

## 🎯 Learning Outcome
This project helped in understanding:
- Blockchain fundamentals and transaction flow  
- Cryptographic security using digital signatures  
- How distributed ledgers prevent tampering and double spending  

---

## 📎 Future Improvements
- Peer-to-peer networking (multiple nodes)  
- REST API integration  
- Frontend dashboard for transaction visualization  

---

## 🙌 Acknowledgment
Inspired by a blockchain development tutorial and extended with additional features and debugging.
