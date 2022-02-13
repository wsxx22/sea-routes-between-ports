# Sea routes between ports of Bremerhaven and Hamburg

Application use spring-boot on deafult port 8080.
Application has one endpoint and a few value of params to sort data.

Name of param: typeSearch

Available value of params:
- minimum-trip-duration
- maximum-amount-readings
- maximum-speed

Example use of parameters:

localhost:8080/historical-routes/search-by?typeSearch=maximum-speed

We can also define name of file (csv) from which data would be load, we can do it in application.yaml
