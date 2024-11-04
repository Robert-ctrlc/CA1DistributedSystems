<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Student Service REST Example</title>
</head>
<body>
    <h1>Student Service API Test</h1>

    <form action="http://localhost:8080/CA1DistributedSystems/restful-services/students" method="GET">
        <input type="submit" value="View All Students">
    </form>

  
    <form action="http://localhost:8080/CA1DistributedSystems/restful-services/students/1" method="GET">
        <input type="submit" value="View Student with ID 1">
    </form>

    <p>For creating, updating, or deleting students, please use Postman or curl, as these actions require JSON input.</p>
</body>
</html>
