<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
}

button:hover {
  opacity: 0.8;
}

.container {
  padding: 16px;
}

</style>
<%String message=(String)request.getAttribute("message");
if(message!=null)
{out.write(message);}
%>
</head>
<body>

<h2>User Login Page</h2>

<form action="login", method="get">

  <div class="container">
    <label for="phonenumber"><b>Phone Number</b></label>
    <input type="text" placeholder="Enter Phone Number" name="phonenumber" pattern="[789]{1}[0-9]{9}" title="Must contain 10 digits starting with 7/8/9" required>

    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
        
    <button type="submit">Login</button><br>
    <a href="register.jsp">Don't Have Account? Create Here</a>
  </div>

</form>

</body>
</html>