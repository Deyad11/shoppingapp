# shoppingapp
The relational schema,er diagram and classs diagram in db file.
In demo10 is my acutal project with all the files is created and I used MySQL for database.
In application properties file make sure to add your MYSQL workbench username and password instead of mine.
The assumptions I made in this project-
1. There is only a single product with fixed price and fixed quantity avaiable and it will remain same after you restart the application but will change accordinly during the process of placing order. I also created a uri to add user into the database.
2. In the coupon case i also created a uri to add coupon and the assumption is that a single coupon can only be used once by a user when placing order in a single session. and i can be reused when you restart the application.
3. In case of placing order it will take usreid,orderid,the coupon used and show the amount after calculating.it will handle error based on req. specified .
4. In case of transaction/payment it will randmonly return any of the status code you mentioned like successful,no response from bank etc.
5. It will also return the details of the all the order and another uri to return order details along the transaction details associtated with that order Id.
I have created three packages in this project-
In the model package, I defined Java classes to represent the core entities of our application, such as User, Order, Coupon, and Transaction.
These classes encapsulate the essential data and behaviors associated with each entity, providing a clear and structured representation of our domain model.
DAO (Data Access Object) Package:

Within the DAO package, I implemented classes responsible for data access and database interaction.
Each DAO class contains methods to perform CRUD operations on the corresponding database tables, ensuring separation of concerns and maintainability in our application architecture.
For example, the OrderDAOImpl class provides methods to place orders, retrieve orders by user ID, and fetch orders with transaction details from the database.
Controller Package:

The controller package contains classes that handle incoming HTTP requests and produce appropriate responses.
These classes, annotated with request mapping annotations like @GetMapping and @PostMapping, define methods to handle specific HTTP endpoints.
Within these methods, I invoke corresponding methods in the DAO classes to perform business logic and retrieve data from the database.
For instance, the OrderController class includes methods to place orders, calculate order amounts, validate coupons, and respond to client requests accordingly.
