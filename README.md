# Moody calculator

En applikation i två delar, frontend och backend. Frontend är en reactjs web-applikation med ett gui för en miniräknare. 
Frontend innehåller ingen "miniräknar-logik" utan skickar frågor till backend. Backend är en Java Open Liberty web-server
med en REST-tjänst som tar emot "miniräknar-frågor" och svarar med ett resultat-objekt.

## Installation
### Backend 
### `mvn liberty:dev`
Kör backend i dev mode [http://localhost:9080](http://localhost:9080) \
OpenAPI UI: [http://localhost:9080/openapi/ui](http://localhost:9080/openapi/ui)
### Frontend
### `npm start`
Kör frontend i dev mode [http://localhost:3000](http://localhost:3000).
