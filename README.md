# Comprehensive-Doctor-Management
The "HealthConnect" API serves as a robust Doctor Management system, enabling users to effortlessly establish, oversee, and locate physicians according to diverse parameters. This project aims to assess your proficiency in programming and logical thinking. Each task is accompanied by a pre-defined description and illustrative examples to support your progress.

## Project Description
The "HealthConnect" API is a comprehensive Doctor Management system that allows users to create, manage, and search for doctors based on various criteria. It provides endpoints for creating, updating, and deleting doctors, as well as managing doctor's appointments, availability. The API ensures unique email validation and prevents appointment clashes. It also allows patients to book appointments for doctors and for doctors to submit notes referencing patient after each appointment.This project provides an opportunity to enhance skills in data modeling, database querying, error handling, and API design.

## Task 1: Seamless Doctor Profile Creation API Implementation
Perform the following tasks before API development:

Download the MySQL database by clicking on the provided link. HealthConnect.sql
Access your database information by clicking on the "Database Info" tab.
Set up the downloaded database in the provided database environment and code.
This task revolves around developing a streamlined system for creating and exploring doctors' profiles within a medical application. The core objective is to implement a POST endpoint, "/doctors/create" which empowers users to establish new doctor profiles. This endpoint is designed to guarantee the uniqueness of both doctor email addresses and IDs, while also facilitating the customization of the doctor's weekly schedule encompassing workdays and available time slots.

The input JSON structure for doctor profile creation comprises essential particulars such as the doctor's name, email, specialization, and weekly availability. The weekly availability is structured as an array of objects, each encapsulating the day of the week, commencement time, and conclusion time during which the doctor remains available.

The input JSON should include the following details:

    {     
        "name": "Dr. Jane Smith",     
        "email": "jane.smith@example.com",      
        "specialization": "Pediatrician",     
        "weeklySchedule": [         
            {             
                "dayOfWeek": "Monday",             
                "startTime": "10:00",             
                "endTime": "17:00"         
            },         
            {             
                "dayOfWeek": "Tuesday",             
                "startTime": "09:00",             
                "endTime": "16:00"         
            },         
            {             
                "dayOfWeek": "Wednesday",             
                "startTime": "10:00",             
                "endTime": "17:00"         
            },         
            {             
                "dayOfWeek": "Thursday",             
                "startTime": "09:00",             
                "endTime": "16:00"         
            },         
            {             
                "dayOfWeek": "Friday",             
                "startTime": "10:00",             
                "endTime": "17:00"         
            }     
        ] 
    }

Upon the successful addition of a doctor's profile to the "doctors" table within the application's database, the response will furnish the user with a JSON representation of the newly created doctor. This includes the doctor's ID, name, email, specialization, and an organized rendition of the weekly schedule as per the user's input.

The success response will include  as follows:

    {              
        "id": 1,         
        "name": "Dr. Jane Smith",         
        "email": "jane.smith@example.com",         
        "specialization": "Pediatrician",         
        "weeklySchedule": [             
            {                 
                "dayOfWeek": "Monday",                  
                "startTime": "10:00:00",                 
                "endTime": "17:00:00"             
            },             
            {                 
                "dayOfWeek": "Tuesday",                 
                "startTime": "09:00:00",                 
                "endTime": "16:00:00"             
            },             
            {                 
                "dayOfWeek": "Wednesday",                 
                "startTime": "10:00:00",                 
                "endTime": "17:00:00"             
            },             
            {                 
                "dayOfWeek": "Thursday",                 
                "startTime": "09:00:00",                 
                "endTime": "16:00:00"             
            },             
            {                 
                "dayOfWeek": "Friday",                 
                "startTime": "10:00:00",                 
                "endTime": "17:00:00"             
            }         
        ]        
    }

This implementation caters to potential failures as well where distinct error scenarios are also handled:

1)"Either of the details in the input is empty or null":Either name or email or specialization cannot be empty or null.

2)"Email already registered with another doctor": This error arises if the provided email for the new doctor is already linked with another doctor in the system. This safeguard ensures the exclusivity of email addresses among doctors.

3)"Weekly schedule is required and should contain valid schedule entries.": This error activates when the input JSON lacks or is devoid of weekly schedule information. This emphasizes the necessity of providing a valid weekly schedule for the doctor.

By implementing this you will gain RESTful API proficiency, handling data validation intricacies and JSON manipulation, while honing error handling and best practices in API design for doctors' profiles creation.

## Task 2: Comprehensive Doctor Profile Management API Enhancement
Building upon the previous task, this enhancement involves implementing a GET endpoint to retrieve a comprehensive list of all registered doctors within the application. The GET endpoint, "/doctors," is introduced to facilitate this functionality. The response to this endpoint will be presented in JSON format, containing vital details of all doctors registered in the "doctors" table.

The GET endpoint "/doctors" empowers users to retrieve a comprehensive list of all doctors. The response is formatted in JSON and includes essential doctor details, such as their ID, name, email, and specialization. An example response would be:

    [     
        {         
            "id": 1,         
            "name": "Dr. Jane Smith",         
            "email": "jane.smith@example.com",         
            "specialization": "Pediatrician"     
        } 
    ]

If no doctors details are found in the table then response would be:

    {    
        "success":false    
        "message":"Doctor not found for hospital." 
    }

By implementing this you will gain insights into understanding how APIs evolve to meet user needs. You will learn efficient data transformation using DTOs for enhanced presentation while maintaining internal structure security. The refinement of error handling highlights the significance of clear error messages and proper status codes, advancing skills in API design, data transformation, and user-centered error management.

## Task 3: Efficient Doctor Specialization Search API Implementation
This task introduces a powerful feature to the doctor profile management system - the ability to search for doctors based on their specialization. It entails implementing a GET endpoint, "/doctors/search," which empowers users to find doctors specializing in a specific area. If no specialization matches the criteria or if no doctors are found, a suitable response is generated.

The GET endpoint "/doctors/search" enables users to search for doctors by specifying their specialization in the URL query parameter. The response is returned in JSON format and includes pertinent doctor details, such as ID, name, email, and specialization.

Input: URL: /doctors/search?specialization={specialization}

An example of the response is:

    [     
        {         
            "id": 1,         
            "name": "Dr. Jane Smith",         
            "email": "jane.smith@example.com",         
            "specialization": "Pediatrician"     
        } 
    ]

If no doctor related to given {specialization} are found then response would be:

    {    
        "success":false    
        "message":"No Doctors found  matching the specialization {specialization} " 
    }

By implementing this you will gain expertise in creating dynamic database queries driven by user input for specific search criteria. You will learn to customize responses for diverse scenarios, offering informative messages based on search outcomes, and effectively extract and utilize query parameters from URL requests. This feature's implementation enhances developers' skills in dynamic querying, response personalization, and query parameter handling, contributing to effective API design.

## Task 4: Comprehensive Doctor Information Retrieval API Implementation
This task enhances the doctor profile management system with a GET endpoint, "/doctors/{id}," that provides detailed information about a specific doctor based on their unique ID, including their weekly schedule. The endpoint ensures the validity of the provided {id} against the data stored in the "doctors" table.

The GET endpoint "/doctors/{id}" enables users to retrieve comprehensive information about a specific doctor using their unique ID. The response is presented in JSON format and encompasses crucial doctor details, including ID, name, email, specialization, and their detailed weekly schedule.

The response will include the doctor details as follows:

    {              
        "id": 1,         
        "name": "Dr. Jane Smith",         
        "email": "jane.smith@example.com",         
        "specialization": "Pediatrician",         
        "weeklySchedule": [             
            {                 
                "dayOfWeek": "Monday",                 
                "startTime": "10:00:00",                 
                "endTime": "17:00:00"             
            },             
            {                 
                "dayOfWeek": "Tuesday",                 
                "startTime": "09:00:00",                 
                "endTime": "16:00:00"             
            },             
            {                 
                "dayOfWeek": "Wednesday",                 
                "startTime": "10:00:00",                 
                "endTime": "17:00:00"             
            },             
            {                 
                "dayOfWeek": "Thursday",                 
                "startTime": "09:00:00",                 
                "endTime": "16:00:00"             
            },             
            {                 
                "dayOfWeek": "Friday",                 
                "startTime": "10:00:00",                 
                "endTime": "17:00:00"             
            }         
        ]        
    }

If doctor with {id} not found in the "doctors" table , then response would be:

    {    "success":false    "message": "Doctor not found with ID:{id} " }


By implementing this you will acquire insights into retrieving targeted database data using unique identifiers, mapping entity attributes to organized JSON responses, and enhancing error handling for user-friendly feedback. This task advances understanding in data retrieval, response structuring, and user-centric error management in API design.

## Task 5: Empowering Doctor Details Update API Functionality
This task introduces a pivotal functionality to the doctor profile management system through the implementation of a POST endpoint, "/doctors/update/{id}," enabling users to modify the details of a specific doctor based on their unique ID. The endpoint ensures email uniqueness validation and permits updates to the doctor's name, email, specialization, and weekly schedule.

The POST endpoint "/doctors/update/{id}" empowers users to update specific doctor details. Users can modify the doctor's name, email, specialization, and weekly schedule through the input JSON.

The input JSON should include the following details:

    {     
        "name": "Dr. Jane Smith",     
        "email": "jane.smit1h@example.com",     
        "specialization": "Pediatrician",     
        "weeklySchedule": [         
            {             
                "dayOfWeek": "Monday",             
                "startTime": "10:00",             
                "endTime": "17:00"         
            },         
            {             
                "dayOfWeek": "Wednesday",             
                "startTime": "10:00",             
                "endTime": "17:00"         
            },         
            {             
                "dayOfWeek": "Friday",             
                "startTime": "10:00",             
                "endTime": "17:00"         
            }     
        ] 
    }



This implementation caters to potential failures as well where distinct error scenarios are also handled:

1)"Doctor not found with ID:{id} ": If doctor with {id} not found in the "doctors" table 2)"Either of the details in the input is empty or null":Either name or email or specialization cannot be empty or null. 3)"Email already used by another doctor.": This error arises if the provided email for the new doctor is already linked with another doctor in the system. This safeguard ensures the exclusivity of email addresses among doctors. 4)Also to keep in note that if weeklSchedule in the input is null or empty then the weekly schedule in the updated data will be quivaled to the existing weeklySchedule. 5) "No changes found. Doctor details remain the same.":If all the details in the input is same as existing one then display that no changes found.

Upon successfull validation , the success Response would be:

    {     
        "name": "Dr. Jane Smith",     
        "email": "jane.smit1h@example.com",     
        "specialization": "Pediatrician",     
        "weeklySchedule": [         
            {             
                "dayOfWeek": "Monday",             
                "startTime": "10:00",             
                "endTime": "17:00"         
            },         
            {             
                "dayOfWeek": "Wednesday",             
                "startTime": "10:00",             
                "endTime": "17:00"         
            },         
            {             
                "dayOfWeek": "Friday",             
                "startTime": "10:00",             
                "endTime": "17:00"         
            }     
        ] 
    }

By implementing this you will gain expertise in updating database data effectively, managing conflicts like email uniqueness, and offering suitable responses to ensure data integrity. You will learn to validate incoming data, construct structured JSON responses, and enhance their proficiency in data updates, validation, conflict resolution, and creating informative API responses.

## Task 6: Seamless Doctor Deletion and Appointment Management API Integration	
This task introduces a critical functionality, implementing a POST endpoint, "/doctors/delete/{id}," enabling to delete a specific doctor based on their unique ID.

The POST endpoint "/doctors/delete/{id}" empowers users to delete a doctor's profile. Deletion is contingent upon the doctor not having any upcoming appointments. If upcoming appointments exist, the doctor cannot be deleted, thus preserving the integrity of appointment-related data.

The endpoint checks the doctor's existence and potential upcoming appointments. If no upcoming appointments are found, the doctor, their past appointments, and associated data are deleted. The code then provides a suitable response to indicate successful deletion or the reasons for failure.

The success response include:

    { "success":true }

Failure Response include  1)"Doctor not found with ID: {id}" :If no doctor in the "doctors" table with the {id} are found. 2)"Cannot delete the doctor. The doctor has upcoming appointments.".:This prevents the deletion of doctor if the doctor has any upcoming appointments.

By implementing this you will gain insights into conditional data deletion, preserving integrity by checking for upcoming appointments. You will learn to craft informative error responses for deletion failure reasons and manage associated data cleanup, like past appointments and reviews. Through this task, you will enhance skills in conditional deletion, error response crafting, and comprehensive data management, refining their proficiency in API design.

## Task 7: Efficient Doctor Leave Management
This task,  implements endpoints for efficient Doctor Leave Management in our Doctor Management API. These endpoints will allow doctors to add and update their leave schedules, providing an intuitive way for doctors to manage their availability effectively.


This task creates a POST endpoint "/doctors/{id}/leave" to enable doctors to apply for leave. The endpoint takes the doctor's unique ID as a path parameter and receives leave details, such as leave date, start time(if applicable), and end time(if applicable), as input in the request body. If the leave is for the whole day, the start and end times can be omitted.Also if only start time is entered along with date then it means that doctor is on leave on the date from startTime.Also user can enter both startTime and endTime that shows the leave time range.

Input:

    {
        "leaveDate": "2023-08-15",
        "startTime": "09:00",
        "endTime": "12:00"
    }

The entered data in '/doctors/{id}/leave' will undergo thorough validation to ensure accuracy and completeness. Special attention will be given to the:

1) "Doctor not found with ID: {id}":If no doctor in the "doctors" table with the {id} are found.

2)"Leave date cannot be in the past.": If the leave date is in past from current date

3)"Doctor is not scheduled to work on the specified leave date.":If suppose the doctor is not working on saturday and the leave date if coming on saturday then no need to apply for leave.

4)"You have entered only endTime , please enter start time also":If  entered the endTime without startTime.

5)"End time cannot be before start time.":If the endTime in the input be before the start time .

6)Checks for existing leave entry for the specified leave date:If the leave date already exists for the doctor with {id} then the system updates the leave entry with the input details, rather than creating another separate record avoiding duplicate data.


Upon successful validation, the system either updates an existing leave entry or creates a new one. It responds with a JSON message indicating the success of the process.

    {
        "Doctor Id": 1,
         "LeaveId": 1,
         "LeaveDate": "2023-08-15",
         "StartTime": "09:00",
         "EndTime": "12:00"
    }

Note: For output if start time or endtime is not there , then display "Not specified" instead of null.

Example:

    {
        "Doctor Id": 1,
        "LeaveId": 1,
        "LeaveDate": "2023-08-15",
        "StartTime": "09:00",
        "EndTime": "Not specified"
    }

This task provides hands-on experience in handling leave management logic, ensuring schedule consistency, and responding effectively to user requests. It further enriches your backend development skills by implementing user-oriented functionalities.

## Task 8: Efficient Leave Removal for Doctors	
This task provides the POST endpoint "/doctors/{id}/deleteLeave" empowers doctors to remove their leave entries based on the provided leave date. This functionality enriches the Doctor Leave Management system, allowing doctors to efficiently update their availability as needed.

Endpoint: POST /doctors/{id}/deleteLeave?leaveDate={leaveDate}

Input: Doctor ID (id): The unique ID of the doctor whose leave entry needs to be deleted. It is provided in the path variable. Leave Date (leaveDate): The specific date for which the doctor wants to remove the leave entry. It is provided in the path variable using the ISO date format (e.g., 2023-08-10).

Example Input:/doctors/1/deleteLeave?leaveDate=2023-08-10

The entered data in '/doctors/{id}/deleteLeave' will undergo thorough validation to ensure accuracy and completeness: 1)"Doctor not found with ID: {id} ":The system verifies the doctor's existence using the provided ID. 2)"Doctor leave not found for the specified date.":If on the specified date the doctor is not on leave. 3)"Cannot delete the leaveDate as it is in the past": If the leave has already happened then leave cannot be delete.

Upon successfull validation , the leave entry is found and  is deleted from the "doctor_leave" table,the success response include:

    {  "success": true }

This endpoint enhances the Doctor Leave Management system by enabling doctors to conveniently update their availability by removing specific leave entries. The ability to manage leave entries efficiently contributes to a more effective and organized scheduling system for medical practitioners.

## Task 9: HealthConnect API: Check Doctor Availability
This task focuses on the implementation of a GET endpoint "/doctors/{id}/availability?dateTime={dateTime}" that enables users to check a doctor's availability for a specific date and time. By incorporating this feature, the HealthConnect API aims to provide users with the ability to conveniently determine whether a doctor is accessible for appointments.The availability will be based on the doctor's weekly schedule. Additionally, the endpoint will provide information about the doctor's leave status if the date falls within a leave period.

ENDPOINT: /doctors/{id}/availability?dateTime={dateTime}

Doctor ID (id): The unique ID of the doctor for whom availability is being checked. This is provided in the path variable. Appointment Date and Time (dateTime): The desired appointment date and time for which the doctor's availability is being checked. This is provided in the query parameter and follows the format "yyyy-MM-ddTHH:mm" (e.g., "2023-07-27T15:30").

Process:

1)Retrieve Doctor: The system retrieves the doctor's details based on the provided ID from the repository. If the doctor is not found, a failure response with an appropriate message("Doctor not found.") is returned. 2)Extract Information: The system extracts the day of the week and time from the dateTime parameter. 3)Availability Check: The DoctorAvailabilityChecker class is used to determine the doctor's availability based on their weekly schedule. If the doctor is available, the system proceeds to the next step. 4)Slot Availability Check: The system checks if there is an available time slot (assuming each appointment is for 30 minutes) for the specified appointment time. 5)Leave Status Check: The system checks if the doctor is on leave for the specified date and time. It queries the doctorLeaveRepository to find any leave entries matching the doctor and the specified dateTime. If the doctor is on leave, a failure response indicating unavailability along with leave details is provided. 6)Response Formation: Depending on the availability and leave status checks, the system generates an appropriate success or failure response. If the doctor is available and a time slot is also available, a success response with the availability status is returned. Otherwise, a failure response indicating unavailability is provided.

Success Response: If the doctor is available and an available slot is found, the response will look like this:

    {     "success":true,     "message": "yes doctor is available at given date and time: {dateTime}" }

If doctor is not available , then in response include in the message why doctor is not avaialble.

By completing this task, you will enhance the HealthConnect API to allow users to efficiently check the availability of specific doctors. Additionally, you will learn to handle leave status checks, providing valuable information to users interacting with the HealthConnect API. The task incorporates querying the database based on doctor IDs, processing date and time inputs, and providing appropriate response messages based on the doctor's availability and leave status.

## Task 10: Efficient Appointment Scheduling
In this task, we will implement a powerful endpoint to provide advanced appointment booking functionality with a comprehensive patient management system, specifically designed for individual doctors. This endpoint ensures availability and validation checks, enhancing the Doctor Management API by facilitating seamless appointment scheduling.

This  implement a POST endpoint "/doctors/{id}/bookAppointments" to allow users to create an appointment for a specific doctor. The endpoint takes the doctor's unique ID as a path parameter and the desired appointment date and time, patient's name and contact information as input in the request body. The API performs various validations and checks to ensure a smooth appointment booking process.

Input:

    {
        "name": "John Singh",
        "contact": "7260920237",
        "dateTime": "2023-07-31T15:00:00"
    }

id: The unique ID of the doctor for whom the appointment is to be created.

dateTime: The desired appointment date and time in the format "yyyy-MM-ddTHH:mm:ss" (e.g., "2023-07-27T15:30:00").

The API performs the following validations and checks:

1)Check if the doctor with the provided ID exists in the database. If not, return a failure response.

2)Check that input details are not empty or null.

3)Validate that the appointment date and time are in the future.

4)Use the DoctorAvailabilityChecker class to check if the doctor is available on the specified date. If not available, return a failure response.

5)Check if the doctor is on leave at the specified date and time. If the doctor is on leave, return a failure response indicating the leave status.

6)Retrieve the doctor's working hours for the specified day from the weekly schedule and check if the appointment time is within those working hours. If not, return a failure response with the available working hours.

7)Check if the doctor has the slot available and is not booked (each appointment scheduled for a 30-minute duration) for the given appointment time. If not available, return a failure response.


Upon successful validation, the appointment is booked, incorporating the enhanced patient management system:


     1)On appointment booking, the API first checks if the provided contact information (phone/email) already exists in the "patients" table.

     2)If the contact information does not exist, a new entry is created in the "patients" table . The patient is considered a new visitor to the hospital.

     3)If the contact information exists but the provided name does not match the existing patient record, a new entry is created with the provided name with the patient's details.

     4)If the contact information and name both match an existing patient, the API uses the existing patient's ID for the appointment. This ensures that patients with similar contact information are handled correctly.

     5)The API now includes enhanced features to prevent double-booking and improve patient record keeping, making it a valuable tool for medical professionals and patients alike.So if patients already has booking on the specified date and time , then display appropriate message preventing booking the appointment. 

The patient management system also keeps track of the doctor who last checked the patient.So that after each appointment, doctors can add notes to the patient's record, including diagnosis, prescriptions, or any other relevant information.

Upon sucessfully making appointment  for the patient , the success response is:

    {
        "AppointmentId": 1,
        "DoctorId": 1,
        "DoctorName": "Dr. Jane Smith",
        "DoctorEmail": "jane.smith@example5.com",
        "DoctorSpecialization": "Pediatrician"
        "PatientId": 1,
        "PatientName": "John Singh",
        "PatientContact": "7260920237"
        "dateTime": "2023-07-31T15:00:00"
    }

By following this detailed validation process, the API ensures that appointments are booked smoothly, considering doctor availability, patient details, and existing appointments. This enhanced patient management and appointment booking system makes it a valuable tool for both medical professionals and patients, streamlining the scheduling process and ensuring accurate record keeping.

## Task 11: Get Upcoming Appointments for Doctor Endpoint: Efficient Appointment Retrieval
This implements a GET endpoint "/doctors/{id}/appointments/upcoming" to retrieve all upcoming appointments for a specific doctor. The endpoint takes the doctor's unique ID as a path parameter. It queries the database for all appointments of the specified doctor that are scheduled after the current date and time. The retrieved appointments are then grouped by date, and the response includes the doctor's ID, name, specialization, and a map of upcoming appointment dates with corresponding time slots.

Endpoint: GET /doctors/{id}/appointments/upcoming

{id}: The unique ID of the doctor for whom upcoming appointments are to be retrieved.

The API begins by verifying whether the doctor with the provided ID exists in the database. If no matching doctor is found, a failure response is generated, indicating that the doctor was not found with the provided ID. Subsequently, the API confirms whether there are any upcoming appointments for the doctor. If no upcoming appointments are found, the API generates a failure response indicating that there are currently no scheduled appointments for the doctor. For each upcoming appointment, the API groups them based on their respective dates. This grouping is accomplished by creating a map where the keys represent the dates of the appointments, and the corresponding values are lists of time slots for those dates. This grouping ensures a clear presentation of appointments on different dates.Within each date, the time slots are sorted in ascending order, ensuring that appointments are presented in a coherent and chronological manner.

The success response include:

    {     
        "doctorId": 1,     
        "doctorName": "Dr. Jane Smith",     
        "specialization": "Pediatrician",     
        "upcomingAppointments": {  "2023-07-27": [  "15:30:00" ]  } }

This task enables healthcare providers and patients to access accurate and organized information about a doctor's upcoming appointments. By incorporating leave checks and efficient data grouping, the endpoint ensures that the presented information is reliable and reflects the doctor's real-time availability. This feature enhances the scheduling experience, improves patient-provider interactions, and contributes to a more streamlined and efficient healthcare ecosystem.


DB DETAILS:
schema : https://drive.google.com/file/d/1Gs9Ej7B-LCW6KKL15Q-C4J_blC6J0M0R/view
