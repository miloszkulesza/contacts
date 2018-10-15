ide: intellij idea ultimate 2018.1.4
mysql server: xampp
server address: localhost
tomcat port: 8080
mysql port: 3306

Before start application, create in MySQL server database named contacts
To send data to database I used Postman addon for Google Chrome

example bodies to send:

localhost:8080/person
{
        "pesel": "94073000222",
        "gender": "MALE",
        "birth": [1994,7,30],
        "first_name": "Adam",
        "last_name": "Nowak"
}

localhost:8080/contact/email
{
    "personid": 1,
    "email": "aaa@gmail.com"
}

localhost:8080/contact/address
{
    "personid": 1,
    "city": "lublin",
    "street": "wesola",
    "bulidingNumber": 5,
    "localNumber": 20
}

localhost:8080/contact/phone
{
    "personid": 1,
    "phone_number": "555222444"
}

To get all contacts for personid 1:
localhost:8080/contact/1

used: java8, maven, spring boot, lombok, rest, jpa, mysql
