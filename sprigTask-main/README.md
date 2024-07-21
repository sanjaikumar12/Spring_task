MySQL Database

Create a database named feedback_db and a table named feedback with the following columns:

Column Name	Data Type
id	int
name	varchar(255)
book_name	varchar(255)
feedback	text
Steps to Run the Application

Create a new dynamic web project in your preferred IDE (e.g., Eclipse, IntelliJ IDEA).
Create the feedback.html file in the project's root directory.
Create the FeedbackServlet.java file in the project's src directory.
Configure the web.xml file to map the servlet to the /feedback URL pattern.
Create the MySQL database and table as described above.
Deploy the project to a servlet container (e.g., Apache Tomcat).
Access the application by navigating to http://localhost:8080/feedback.html in your web browser.
Fill out the feedback form and click the "Submit" button.
The application should respond with "feedback saved!" and store the feedback data in the MySQL database.
