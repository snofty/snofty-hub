					It an MoneyManagement API to track the spendings.
					
Simple java + rest + mongodb + maven application.

Using below technologies/frameworks:
<table>
<tr><td>java-1.8.0_121</td></tr>
<tr><td>MongoDB-3.4.2</td></tr>
<tr><td>Rest with Jersey-2.17</td></tr>
<tr><td>gson-2.8.0</td></tr>
<tr><td>maven-3.3.9</td></tr>
</table>

Implemented with custom logger API
<pre>
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
</pre>
