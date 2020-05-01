# GitHub timeline

## Author
- Dragosh Sergey - [j-04](https://github.com/j-04)  
dragoshs.j@yahoo.com


---
## Built with
* Java 12
* Spring Core
* Spring Boot 2
* JUnit
* Freemarker
* OkHttp
* Lombok
* FasterXml-Jackson

---
## TODO list

* Write entities:
    * [x] User entity
    * [x] Repository entity
    * [x] Commit entity

* Write http client for make calls to github api:
    * [x] Get user
    * [x] Get repositories
    * [x] Get commits of a repository
    
* Write services:
    * [x] TimeLine service (Main service of the server that will interact with all other services).
    * [x] ModelFactory service. It will insert dynamic information in web pages.
    * [x] GitHubHttpClient service. It will prepare all data for normal use.

* Write exception handler:
    * [x] ExceptionController class
    * [x] ObjectNotFoundException class. 404
    * [x] BadRequestException class. 400
    * [x] ServerErrorException class. 500
    
* Write web pages:
    * [x] Index page index.ftl
    * [x] User page user.ftl
    * [x] Repositories page repos.ftl
    * [x] Commits page commits.ftl
    * [x] Exception page timeline_error.ftl
    
* Write a controller:
    * [ ] TimeLineController class