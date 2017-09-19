# SpringBootApp

SpringBootApp is a basic REST API which provides an interface to check for the health of a service.

To run on your particular machine it requires JDK 1.8 or higher and Maven 3.0 and higher. Below listed is how to run the App and how to use the API.

A fork repo of [sher-locked/spring-boot-app](https://github.com/sher-locked/spring-boot-app)

## Run the App 

Download the project

`git clone https://github.com/veerendra2/SpringBootApp.git`

Build the project and create the project's JAR

`mvn clean install`

Run the target JAR

`java -jar target/gs-rest-service-0.1.0.jar`

The app should now be running on localhost on port 8080.

## API Endpoints

The App has 3 REST API Endpoints.


**1. Dummy Endpoint**

`GET localhost:8080`

This is primarily to check if the service is up and running. This should return a simple String response.
`RESPONSE 200 Your Application is working!`


**2. Get Group Detais by Name**

`GET localhost:8080/group?name={group-name}`

Here Group-Name indicates the desired name of the group details desired.

***Example***

`GET localhost:8080/group?name=memory`

This should prompt the Response
`RESPONSE 200 OK`

```
{  
   "groupName":"Memory Group",
   "numberOfFailedMetrics":1,
   "groupScore":83.333336
}
```

In case of an invalid Group-Name, the API responds with an error message.
`GET localhost:8080/group?name=random`

This should return an Error Response
`RESPONSE 404 NOT_FOUND`

```
{  
   "error":{  
      "errorCode":404,
      "errorMessage":"No such group found"
   }
}
```


**3. Get Metric Details by Name**

`GET localhost:8080/metric?name={metric-name}`

Here Metric-Name indicares the desired name of the metric desired.

***Example***

`GET http://localhost:8080/metric?name=proc.stat.cpu__user_cumulative`

This should prompt the Response
`RESPONSE 200 OK`

```
{  
   "metricType":"Compute KPI",
   "metricName":"proc.stat.cpu__user_cumulative",
   "metricColor":"green",
   "relevance":"2"
}
```

In case of an invalid Metric-Name, the API responds with an error message.
`GET http://localhost:8080/metric?name=random`

This should return an Error Response
`RESPONSE 404 NOT_FOUND`

```
{  
   "error":{  
      "errorCode":404,
      "errorMessage":"No such metric found"
   }
}
```


