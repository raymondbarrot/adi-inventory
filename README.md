Steps on running the applications:

1. Create new MySQL schema adi_db
2. Make sure that it is running on localhost:3306
   Or change the spring.datasource.url in application.properties
3. Set the mysql username and password in application.properties
4. Make sure kafka is running on localhost:9092
   Or change the kafka.bootstrap.server in application.properties
5. Trigger inventory or bidding

   EndPoint(POST)
   http://localhost:8081/inventory/add

   Sample Payload:
   {
       "code": "IT01",
       "name": "New Item 01",
       "availableResources": 100,
       "amount": 20.0
   }
   EndPoint(PUT)
   http://localhost:8081/inventory/update

   Sample Payload:
   {
       "code": "IT01",
       "name": "Updated Item 01",
       "availableResources": 120,
       "amount": 25.0
   }

   EndPoint(POST)
   http://localhost:8083/bidding/add

   Sample Payload:
   {
       "bidId": "BID01",
       "amount": 30.0,
       "numberOfResources": 10,
       "status": "NEW",
       "itemCode": "IT01"
   }

   EndPoint(PUT)
   http://localhost:8083/bidding/update

   Sample Payload:
   {
       "bidId": "BID01",
       "amount": 30.0,
       "numberOfResources": 10,
       "status": "ACCEPTED",
       "itemCode": "IT01"
   }

6. Setup other services the same way.