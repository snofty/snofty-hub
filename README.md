					It an MoneyManagement API to track the spendings.
					
<p align="center">
  <img src="/src/main/resources/images/homeImage.jpg"/>
</p>
Simple java + rest + mongodb + maven application.

Using below technologies/frameworks:
<table>
<tr><td><a href="http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html">java-1.8.0_121</a></td></tr>
<tr><td><a href="https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/">MongoDB-3.4.2</a></td></tr>
<tr><td><a href="https://jersey.java.net/">Rest with Jersey-2.17</a></td></tr>
<tr><td><a href="https://en.wikipedia.org/wiki/Gson">gson-2.8.0</a></td></tr>
<tr><td><a href="https://maven.apache.org/download.cgi">maven-3.3.9</a></td></tr>
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
