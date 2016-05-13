<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="./actions.js"></script>
    </head>
    <body>
        <h1>Create User!</h1>
        <div>
            <br>First Name:<input type="text" name="first_name"> 
            <br>Last Name:<input type="text" name="last_name">
            <br>Display Name:<input type="text" name="display_name">
            <br>Phone:<input type="text" name="phone">
            <br>Email:<input type="text" name="email">
            <br>Password:<input type="text" name="password">
            <br>Street:<input type="text" name="street">
            <br>City:<input type="text" name="city">
            <br>State:<input type="text" name="state">
            <br>Country:<input type="text" name="country">
            <br>Zip Code:<input type="text" name="zipcode">
            <br><button  onclick="create_user()">Create New User</button>
        </div>
    </body>
</html>
