# Real-State-E-business-System

The project specification 

The persistence tier

a .The real estate company manages two types of property: properties  for  sale and properties for rent. 
A major assumption is that the two types of property have some common attributessuch  as  property  ID,  property  address,  
property  description  etc.  However,  a  sale  propertyhas speciality properties such as Sale Price; a rent property has 
speciality properties such as Weekly Rent.

b. The propertyinformation must be persisted into a Derby database.
You are required to use Java  Persistence  API  (JPA)  to  persist  the  property  information  into  a  Derby  database. 
In order to minimise code redundancy, you should use inheritance mapping. In the design, the Java  classes  should  be
at  least  3  with  1  class  as  the  super  class  to  abstract  the  common  attributes and operations for the two
types of property and the other 2 classes are used to abstract  other  attributes  and  operations  that  are  particular 
to  a  type  of  property,  such  as  weekly  rent  price  for  a  rent  property  or  sale  price  for  a  sale  property. 
You  are  required  to use Java Persistence API (JPA) to persist the property information into a Derby database. You are
required to use the Joined-Subclass Strategy in your design of entities. 

c. The  real  estate  company  needs  to  persist
the  contact  details  of  a  property  manager  and  his/her  allocations,  which  is  a  list  of  properties  that  is 
assigned  to  him/her  for  sale  or  rent  management.  You  are  required  to  use  entities  to  persist  property  
managers  and  their  allocations (managed properties). The relationship between a property manager and his/her 
3 allocations  must  be  one-to-many   unidirectional  i.e.  a  property  manager  can  manage  multiple properties

2. The business tier

Develop the business tier by using Enterprise Java Beans (EJB). The business tier will process the  data  persistence  or
retrieval  requests  from  users  and  interact  with  the  persistence  tier  for accomplishing the requests.

3. The Presentation Tier

Develop  the  presentation  tier  by  using  JavaServer  Faces  (JSF).  The presentation  tier  will  provide  a 
web-based  user  interface,  which  will  allow  users  to  enter  property  details, property  manager  details 
and  allocation  details  and  retrieve  these  persisted  information  later  on.  Presenting  exception  messages, 
e.g.  a  user  doesn’t  enter  data  for  a  required  textbox, is necessary and required for this tier.

