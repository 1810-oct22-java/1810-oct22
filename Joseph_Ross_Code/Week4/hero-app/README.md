Project 1 Notes:

Project Overview:

//Front End
* Angular 7 Server
    - Communicate with Java for database opperations
    - Provides the full application user interface

//API
* Java 1.8 Server
    - Provides API for all database opperations

//DataBase
* Oracle 12g Server
    - Hosts the database


Project Functionality

//Front End
* Angular 7
        
    - Pages
        -> (All pages)
            * If a session exists (the user is logged in) a user cannot go back to loggin page wihout logging out. A redirect will make this happen
            * 
        -> Loggin
            * Angular will send creds to API in plain text over HTTPS
            * If the user entered valid credentials send them to the manager/employee page
            * If the user entered invalid credentials jquery valildator will tell them so



