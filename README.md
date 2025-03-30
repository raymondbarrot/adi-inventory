<b>Steps on running the applications:</b>

1. Create new MySQL schema adi_db
2. Make sure that it is running on localhost:3306
   Or change the spring.datasource.url in application.properties
3. Set the mysql username and password in application.properties
4. Make sure kafka is running on localhost:9092
   Or change the kafka.bootstrap.server in application.properties
5. Trigger inventory or bidding

   - EndPoint(POST)
   http://localhost:8081/inventory/add

   - Sample Payload:
   {
       "code": "IT01",
       "name": "New Item 01",
       "availableResources": 100,
       "amount": 20.0
   }


   - EndPoint(PUT)
   http://localhost:8081/inventory/update

   - Sample Payload:
   {
       "code": "IT01",
       "name": "Updated Item 01",
       "availableResources": 120,
       "amount": 25.0
   }


   - EndPoint(POST)
   http://localhost:8083/bidding/add

   - Sample Payload:
   {
       "bidId": "BID01",
       "amount": 30.0,
       "numberOfResources": 10,
       "status": "NEW",
       "itemCode": "IT01"
   }


   - EndPoint(PUT)
   http://localhost:8083/bidding/update

   - Sample Payload:
   {
       "bidId": "BID01",
       "amount": 30.0,
       "numberOfResources": 10,
       "status": "ACCEPTED",
       "itemCode": "IT01"
   }

6. Setup other services the same way.

<br/><br/>
<b>ARCHITECTURE</b>

- REST API
- microservices
- event-driven

<br/><br/>
<b>FUNCTIONALITY</b>

Inventory Service<br/>
Endpoints:
- /add
- /update

<br/>
Kafka
- Publishes to recommendation service
- Listens to bidding service

Bidding Service<br/>
Endpoints:
- /add
- /update

<br/>
Kafka:
- Publishes to inventory service
- Listens to recommendation service

Recommendation Service<br/>
Kafka:
- Publishes to bidding service
- Listens to inventory service

Used Kafka as it is more scalable and can provide more real time functionality.
Kafka can handle large amount of messages at a time in real time