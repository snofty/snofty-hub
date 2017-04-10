					It an MoneyManagement API to track the spendings.
					
Simple java + rest + mongodb + maven application.

Using below technologies/frameworks:

java-1.8.0_121
MongoDB-3.4.2
Rest with Jersey-2.17
gson-2.8.0
maven-3.3.9

Implemented with custom logger API

API available are:
URI (POST) : http://localhost:8080/myfirstApp/snofty/MM/createTransaction/
Input (JSON): 
{
	"type": "cash",
	"mode": "offline",
	"bank": "HDFC",
	"category": "Provisions",
	"amount": "112.21"
}

Output (JSON):
{
  "type": "cash",
  "amount": 112.21,
  "mode": "offline",
  "timestamp": 0,
  "bank": "HDFC",
  "category": "Provisions"
}

URI (GET): http://localhost:8080/myfirstApp/snofty/MM/getTransactions
Output (JSON) :
[
  {
    "type": "cash",
    "amount": 112.21,
    "mode": "offline",
    "timestamp": 0,
    "bank": "HDFC",
    "category": "Provisions"
  },
  {
    "type": "cash",
    "amount": 112.21,
    "mode": "offline",
    "timestamp": 0,
    "bank": "HDFC",
    "category": "Provisions"
  }
]
