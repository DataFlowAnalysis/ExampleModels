## Table of Contents
### Palladio Component Model (PCM)
1. [Bank Branches](#bank-branches)
2. [Branching Online Shop](#branching-online-shop)
3. [CoCar](#cocar)
4. [Corona Warn App](#corona-warn-app-cwa)
5. [International Online Shop](#international-online-shop)
6. [Mobility as a Service(MaaS) Ticket System](#mobility-as-a-servicemaas-ticket-system)
7. [Travel Planner](#travel-planner)

### Data Flow Diagrams (DFDs)
1. Online Shop 
2. Simple Online Shop 
3. Models from TU Hamburg



# Models
## PCM Models 
### Bank Branches
#### Overview
This is an scenario from [Seifermann et al.](https://doi.org/10.1016/j.jss.2021.111138).
It contains a banking system deployed in the US and Asia.
Two actors interact with the system:
A clerk that can register customers, find customers and determine a credit line for them. 
A manager can register celebrities or move customers between regions, in addition to the capabilities of a clerk. 

#### Characteristic Types
There are 4 characteristic types in the model: 
The `Role` characteristic type describes the role of an actor, and can be either `Clerk` or `Manager`.
The `Location` characteristic type describes the location of an actor, and can be either `USA` or `Asia`.
The `Origin` characteristic type describes the origin of the request, and can be either `USA` or `Asia` as well. 
The `Status` characteristic type describes the status of the customer. It can be either `Regular` or `Celebrity`.

#### Security Requirements
The two security requirements for this model are the following:
1. Clerks must only access data about customers in the same region 
2. Only managers should be able to access data about celebrities

### Branching Online Shop 
#### Overview 
This is an 

### CoCar 

### Corona Warn App (CWA)

### International Online Shop 

### Mobility as a Service(MaaS) Ticket System 

### Travel Planner
#### Overview 
This is an scenario from [Seifermann et al.](https://doi.org/10.1109/ICSA.2019.00009).
It models a user booking a flight with an travel planner application.
Flights are queried using a travel agency that in turn communicates with the airline to determine flights. 
Using the flight information the user books an flight with their credit card details. 

#### Characteristic Types 
There are 2 characteristic types in the model: 
The `AssignedRoles` characteristic type describes the role of an system component. It can be either `User` or `Airline`.
The `GrantedRoles` characteristic type describes the roles that can access given data. It can be either `User` or `Airline`.
