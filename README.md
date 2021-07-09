# A00445618_MCDA5550_REST
Author WAN, Taixuan
For REST assignment

The code is in folder HotelReservationAPI. Rest folders are used for storing downloaded files

Introduce:
This project aims to build a spring project with RESTful API functions. 
API functions:
1. list hotels:
This api returns the list of all hotels in database. The return data is in JSON format. The usage of this api is as following:

URL: http://HotelReservationAPI-tx.us-east-1.elasticbeanstalk.com/getListOfHotels
Parameter: N/A
Method: Get
Input Structure&explanation: No input
Return Structure&explanation: 
{
    "hotels_list": [
        {
            "hotelId": <long> hotel id in table,
            "hotelName": <String> hotel's name,
            "price": <float> hotel's price,
            "availability": <boolean> if hotel is available
        },
        {
            …（more hotel record if there is any）
        }
    ]
}
Exception: None

Example: 
return:
{
    "hotels_list": [
        {
            "hotelId": 9,
            "hotelName": "Four Season",
            "price": 120.0,
            "availability": true
        },
        {
            "hotelId": 15,
            "hotelName": "Hilton",
            "price": 210.0,
            "availability": false
        }
    ]
}

2. Reservation Confirmation:
This api allows user to store reservation details in database. Input all user information in request body. The input data is in JSON format. It resturns the reservation confirmation number. The return data is in String format. The usage of this api is as following:

URL: http://HotelReservationAPI-tx.us-east-1.elasticbeanstalk.com/reservationConfirmation
Parameter: N/A
Method: POST
Input Structure&explanation: 
{ 
    "hotel_name": <String> hotel's name,
    "checkin": <Date> check in date, in "YYYY-MM-DD" format,
    "checkout": <Date> check out date, in "YYYY-MM-DD" format,
    "guests_list": [
           { "guest_firstname" : <String> guest's first name,
             "guest_lastname" : <String> guest's last name,
             "gender":  <Enum Gender> Only accepted values: "Male"/"Female"/"NONIDENTIFIED",
             "age" : <Integer> guest's age
           },
           { 
	...(other guests' information if there is any, same format as above)
            }
       ]
}
Return Structure&explanation: 
confirmation_number : <Integer> reservation Id in database.
Exception: 
     if no hotel name matches, return 404 Not Found with detailed explaination
     if check in date is later than check out date, return 400 Bad Request with detailed explaination
     if hotel is not available, return 400 Bad Request with detailed explaination

Example:
Input:
{ 
    "hotel_name": "Mercure",
    "checkin": "2021-06-01",
    "checkout": "2021-06-02",
    "guests_list": [
           { "guest_firstname" : "Tom",
             "guest_lastname" : "Cat",
             "gender":  "Male",
             "age" : 25
           },
           { "guest_firstname" : "Jerry",
             "guest_lastname" : "Mouse",
             "gender": "Male",
             "age" : 24
            }
       ]
}
Return:
confirmation_number :18

3. Get hotel by id
This api returns the result of inquirying hotel by its ID. It returns the detailed information of hotel. The return data is in String format. The usage of this api is as following:
URL: http://HotelReservationAPI-tx.us-east-1.elasticbeanstalk.com/getHotel/{id}
Parameter: id: hotel's id
Method: Get
Input Structure&explanation: No input
Return Structure&explanation: 
{
     "hotelId": <long> hotel id in table,
     "hotelName": <String> hotel's name,
     "price": <float> hotel's price,
     "availability": <boolean> if hotel is available
}
Exception: 
     if no records matches, return 404 Not Found with detailed explaination

Example:
URL: http://HotelReservationAPI-tx.us-east-1.elasticbeanstalk.com/getHotel/9
return:
{
    "hotelId": 9,
    "hotelName": "Four Season",
    "price": 120.0,
    "availability": true
}

4. Update hotel by id
This api allows to modify hotel's price and availability in database. The input data must include hotel's price and availability. The input data is in JSON format.  It returns what database updates. The return data is in JSON format. The usage of this api is as following:
URL: http://HotelReservationAPI-tx.us-east-1.elasticbeanstalk.com/updateHotel/{id}
Parameter: id: hotel's id
Method: PUT
Input Structure&explanation: 
{
    "price":<float> hotel's price,
    "availability":<boolean> if hotel is available
}
Return Structure&explanation: 
{
     "hotelId": <long> hotel id in table,
     "hotelName": <String> hotel's name,
     "price": <float> hotel's price,
     "availability": <boolean> if hotel is available
}
Exception: 
     if no records matches, return 404 Not Found with detailed explaination

Example:
URL: http://HotelReservationAPI-tx.us-east-1.elasticbeanstalk.com/updateHotel/15
input:
{
    "price":210,
    "availability":false
}
return:
{
    "hotelId": 15,
    "hotelName": "Hilton",
    "price": 210.0,
    "availability": false
}

5. Delete hotel by id
This api allows to delete hotel with its id in database.   It returns the delete result. The return data is in JSON format. The usage of this api is as following:
URL: http://HotelReservationAPI-tx.us-east-1.elasticbeanstalk.com/deleteHotel/{id}
Parameter: id: hotel's id
Method: DELETE
Input Structure&explanation:  N/A
Return Structure&explanation: 
{
    "delete": true
}
Exception: 
     if no records matches, return 404 Not Found with detailed explaination

6. Create Hotel Record
This api allows to insert hotel record in database. The input data includes the detailed information of hotel. The input data is in JSON format.  It returns what database updates. The return data is in JSON format. The usage of this api is as following:
URL: http://HotelReservationAPI-tx.us-east-1.elasticbeanstalk.com/createHotel
Parameter: N/A
Method: POST
Input Structure&explanation: 
{
    "hotelName":<String> hotel's name,
    "price":<float> hotel's price,
    "availability":<boolean> if hotel is available
}
Return Structure&explanation: 
{
     "hotelId": <long> hotel id in table,
     "hotelName": <String> hotel's name,
     "price": <float> hotel's price,
     "availability": <boolean> if hotel is available
}
Exception: 
    N/A

Example:
input:
{
    "hotelName":"Mercure",
    "price":180,
    "availability":true
}
return:
{
    "hotelId": 17,
    "hotelName": "Mercure",
    "price": 180.0,
    "availability": true
}


7. Get Guest List
This api returns the guest list and guest's reservation information in database. The return data is in JSON format. The usage of this api is as following:
URL: http://HotelReservationAPI-tx.us-east-1.elasticbeanstalk.com/getListOfGuests
Parameter: N/A
Method: GET
Input Structure&explanation:  N/A
Return Structure&explanation: 
{
    "all_Guests": [
        {
            "check_out_date": <Date> check out date, in "YYYY-MM-DD" format,
            "gender": "MALE"/"FEMALE"/"NONIDENTIFIED",
            "last_name": <String> guest's first name,
            "first_name": <String> guest's last name,
            "age": guest's age,
            "check_in_date": <Date> check in date, in "YYYY-MM-DD" format,
            "hotel_name": <String> hotel's name
        },
        {
            ...(other guests' information if there is any, same format as above)
        }
    ]
}
Exception: 
    N/A

Example:
input:
{
    "all_Guests": [
        {
            "check_out_date": "2021-05-02",
            "gender": "MALE",
            "last_name": "Sleepy",
            "first_name": "Ted",
            "check_in_date": "2021-05-01",
            "age": 20,
            "hotel_name": "Four Season"
        },
        {
            "check_out_date": "2021-05-02",
            "gender": "MALE",
            "last_name": "Grumpy",
            "first_name": "Jack",
            "age": 22,
            "check_in_date": "2021-05-01",
            "hotel_name": "Four Season"
        },
        {
            "check_out_date": "2021-06-02",
            "gender": "MALE",
            "last_name": "Cat",
            "first_name": "Tom",
            "check_in_date": "2021-06-01",
            "age": 25,
            "hotel_name": "Mercure"
        },
        {
            "check_out_date": "2021-06-02",
            "gender": "MALE",
            "last_name": "Mouse",
            "first_name": "Jerry",
            "check_in_date": "2021-06-01",
            "age": 24,
            "hotel_name": "Mercure"
        }
    ]
}

7. Get Guest List with reservation Id
This api returns the guest list and guest's reservation information with a particular ID in database. The return data is in JSON format. The usage of this api is as following:
URL: http://HotelReservationAPI-tx.us-east-1.elasticbeanstalk.com/getGuestsByReservationId/{id}
Parameter: id: reservation's id
Method: GET
Input Structure&explanation:  N/A
Return Structure&explanation: 
{
    "Guests": [
        {
            "check_out_date": <Date> check out date, in "YYYY-MM-DD" format,
            "gender": "MALE"/"FEMALE"/"NONIDENTIFIED",
            "last_name": <String> guest's first name,
            "first_name": <String> guest's last name,
            "age": guest's age,
            "check_in_date": <Date> check in date, in "YYYY-MM-DD" format,
            "hotel_name": <String> hotel's name
        },
        {
            ...(other guests' information if there is any, same format as above)
        }
    ]
}
Exception: 
    if no records matches, return 404 Not Found with detailed explaination

Example:
Return:
{
    "Guests": [
        {
            "gender": 0,
            "hotel_name": "Four Season",
            "last_name": "Sleepy",
            "age": 20,
            "first_name": "Ted"
        },
        {
            "last_name": "Grumpy",
            "first_name": "Jack",
            "gender": 0,
            "hotel_name": "Four Season",
            "age": 22
        }
    ]
}