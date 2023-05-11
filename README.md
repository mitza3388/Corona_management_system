# Corona_management_system
Corona database management system for a HMO. The system stores the personal details of the members of the HMO, as well as key information regarding the corona epidemic for each member of the HMO. 
You can retrieve details about existing patients in the system or insert new patient or his corona details the API interface.

## Technologies used
* java
* MySql
* spring Framework
* spring boot
* spring data JPA
* hibernate
* postman

## Installation
* Before running the API server, you should update the database config inside the application.properties file.
* Update the port number, username and password as per your local database config.
server.port=8080
    spring.datasource.url=jdbc:mysql://localhost:3306/coronamanagment;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=my_password
    
## Example  API Requuests
### Api's for corona info table
* GET: http://localhost:8080/coronaInfo/getAll get all patients corona info
* GET: http://localhost:8080/coronaInfo/get/{id} get patient's corona info by id
* POST: http://localhost:8080/coronaInfo/addPatInfo add new patient's corona info

### Api's for patients table
* GET: http://localhost:8080/patients/getAll  Get All patients
* POST: http://localhost:8080/patients/addPatient Add new patient

![image](https://github.com/mitza3388/Corona_management_system/assets/133001623/2f9ee4b8-7031-4806-975b-e3d530e019c3)

 
* GET: http://localhost:8080/patients/get/{id} Get patient by id

![image](https://github.com/mitza3388/Corona_management_system/assets/133001623/c89f1af3-1794-4498-8cdd-e993b83a6bec)






    




