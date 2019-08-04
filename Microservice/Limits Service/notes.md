#Microservices 

##Important things considered to build an microservice
-Rest -should be exposed to rest 
-&small well chosen Deployable units
-&Cloud enabled

*Cloud enabled above specifies no of microservices built should be able to easily scale up and scale down

##Chalenges to be handles while building an microservice
*Bounded Context
when you have no of microservices identify the right boundries among them

*Configuration Management
when you have 3 microservices having multiple instances in each of them so the instance and load
alloted them should be managed by operation team

*Dynamic Scale up and scale down
The loads of different microservices will be different at different instances of time and partiular time
But if i need 10 instances at one service and need to scale down other instances down which is not needed
All this can be achieved by dynamic load balancing

*Visibility
All activites happening around no of microservices should have a centralized log which becomes easy to
monitor each service if any bug or failure arrives

*Pack of Cards
We have no of microservices build in which one microservice calls another calling another.ie Services depenedent on one another
So there would be certain microservice which would be fundamental for the whole thing and if that particular microservice goes down whole application might go down
So this is like pack of cards you are building one over top of another and so on 	

##Introduction to Spring cloud 
###Challenges faced and solutions used 

**Configuration Management
There would be alot of configuration to run no of microservices which can have multiple instances
along with many environment.Hence alot of configurations to be managed by operation team

Soo Spring Cloud Config Server provides an approach where you can store all your configs 

**Dynamic Scale up and scale down
->Naming server(Eureka)
->Ribbon (Client side load balancing)
->Feign (Easier REST Clients)

**Visibility and monitoring
->Zipkin Distributed Tracing
->Netflix API Getway
	

  