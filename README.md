# Sea routes between ports of Bremerhaven and Hamburg

Application use spring-boot on deafult port 8080 and spock for tests. Application has one endpoint and a few value of params to sort data.

Name of param: typeSearch
Available value of params:
- minimum-trip-duration
- maximum-amount-readings
- maximum-speed

Example:
localhost:8080/historical-routes/search-by?typeSearch=maximum-speed

We could use Either object instead of throw Exceptions, use DTO objects to display data but it's simple app

