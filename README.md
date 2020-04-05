Please find the sample jsons for post api's as follows:

1.) http://localhost:8080/postman/register or http://calenderslotbookingservice-env.eba-i9eycy2p.us-east-2.elasticbeanstalk.com/postman/register:

  --  Description: Registration Endpoint
  --  Post Methodv
  --  JSON: {
              "username": "hardik",
              "password": "password"
            }
  -- Expected Behaviour: If already registered won't be allowed to register again or else a new user will be created. 
            
2.) http://localhost:8080/postman/login or http://calenderslotbookingservice-env.eba-i9eycy2p.us-east-2.elasticbeanstalk.com/postman/login:

  --  Description: Login Endpoint
  --  Post Method
  --  JSON: {
              "username": "hardik",
              "password": "password"
            }
  -- Expected Behaviour: If user registered than will be able to login or else error message will be thrown.
  
3.) http://localhost:8080/postman/book-slot or http://calenderslotbookingservice-env.eba-i9eycy2p.us-east-2.elasticbeanstalk.com/postman/book-slot:

  --  Description: Slot Booking Endpoint
  --  Post Method
  --  JSON: {
              "slotDate": "2020-04-04",
              "slotStartTime": "16:00",
              "slotEndTime": "17:00"
            }
  -- Expected Behaviour: Won't allow to book a slot until a user is logged in, slot booking is available after login is successful.
                         On successful slot booking a slot will be "booked" for current user.
                         

4.) http://localhost:8080/postman/check-slot-availability or http://calenderslotbookingservice-env.eba-i9eycy2p.us-east-2.elasticbeanstalk.com/postman/check-slot-availability:

  --  Description: Endpoint to check Slot Availability.
  --  Post Method
  --  JSON: {
              "slotDate": "2020-04-04",
              "slotStartTime": "16:00",
              "slotEndTime": "17:00"
            }
  -- Expected Behaviour: Endpoint accessible only if successfully logged in. 
                         Will give a response saying whether given slot is available is available for booking or not.
                     
                     

5.) http://localhost:8080/postman/mark-slot-available or http://calenderslotbookingservice-env.eba-i9eycy2p.us-east-2.elasticbeanstalk.com/postman/mark-slot-available:
  --  Description: Endpoint to mark a Slot Available for user.
  --  Post Methodv
  --  JSON: {
              "slotDate": "2020-04-04",
              "slotStartTime": "16:00",
              "slotEndTime": "17:00"
            }
  -- Expected Behaviour: Endpoint accessible only if successfully logged in. 
                         User will be able to mark a given slot as "available", by default all slots are in state "unavailable".
                         User can explicitly mark only those slots for which he is available.
                         

6.) http://localhost:8080/postman/mark-all-slot-available or http://calenderslotbookingservice-env.eba-i9eycy2p.us-east-2.elasticbeanstalk.com/postman/mark-all-slot-available:
  --  Description: Endpoint for marking all slots are Available for user.
  --  Post Method
  --  JSON: {
              "slotDate": "2020-04-04",
              "slotStartTime": "16:00",
              "slotEndTime": "17:00"
            }
  -- Expected Behaviour: Endpoint accessible only if successfully logged in. 
                         User will be able to mark all slots as "available" for a given day.
                         Anything "booked" will be cleared and all slots will be made "available" for clean start by user.
                         

7.) http://localhost:8080/postman/get-all-available-slots or http://calenderslotbookingservice-env.eba-i9eycy2p.us-east-2.elasticbeanstalk.com/postman/get-all-available-slots:

  --  Description: Endpoint for getting all the available slots of user for a given date.
  --  Post Method
  --  JSON: {
              "slotDate": "2020-04-04",
              "slotStartTime": "NA",
              "slotEndTime": "NA"
            }
  -- Expected Behaviour: Endpoint accessible only if successfully logged in. 
                         User can know all the available slots for a given date.
                         
8.) http://localhost:8080/postman/get-all-booked-slots or http://calenderslotbookingservice-env.eba-i9eycy2p.us-east-2.elasticbeanstalk.com/postman/get-all-booked-slots:

  --  Description: Endpoint for getting all the booked slots of user for a given date.
  --  Post Method
  --  JSON: {
              "slotDate": "2020-04-04",
              "slotStartTime": "NA",
              "slotEndTime": "NA"
            }
  -- Expected Behaviour: Endpoint accessible only if successfully logged in. 
                         User can know all the booked slots for a given date.                         
                         

9.) http://localhost:8080/postman/logout or http://calenderslotbookingservice-env.eba-i9eycy2p.us-east-2.elasticbeanstalk.com/postman/logout:

  --  Description: Logout Endpoint.
  --  Get Method
  -- Expected Behaviour: User will be logged out.
