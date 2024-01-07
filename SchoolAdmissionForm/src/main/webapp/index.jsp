<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ABC MHSS</title>
<script type="text/javascript">
function val(){
	var fname = document.getElementById("fname").value;
	if(fname==""){
		alert("Enter your father name");
	}
}

</script>
 <style>
       .regCenter{
       display:flex;
       flex-direction:column;
       justify-content:center;
        align-items:center;
        }

        table,th,td{
        border:1px solid black;
        border-collapse: collapse;
        }
   </style>
</head>
<body style="background-color:rgb(245, 235, 235); margin:0; padding:5px;">
<marquee behavior="" direction="" style="color:red;">Admission open for the academic year 2023 - 2024</marquee>
<h1 style="text-align:center; color:rgb(134, 112, 112);"><i>ABC Matriculation Higher Secondary School</i></h1>
<img src="https://images.unsplash.com/photo-1503676260728-1c00da094a0b?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2022&q=80" alt="school image" height="40%" width="100%">

<div class="regCenter">

    <div>
  <h3>Admission FORM</h3>
    </div>

    <div>
    <form  action="SchoolServlet" method="get">
        <label for="name">Name</label><br>
        <input type="text" id="name" name="name" required autofocus><br><br>

        <label for="std">Class</label><br>
        <select id="std" name="std">
            <option>Select</option>
            <option>1 to 5</option>
            <option>6 to 10</option>
            <option>11 and 12</option>
        </select><br><br>

        <label for="dob">Date Of Birth</label><br>
        <input type="date" name="dob" id="dob"><br><br>
       

        <label for="age">Age</label><br>
        <input type="number" name="age" id="age"><br><br>

        <label>Gender</label><br>
        <input type="radio" name="gender" id="male" value="Male">
        <label for="male">Male</label>
        <input type="radio" name="gender" id="female" value="Female">
        <label for="female">Female</label><br><br>

        <label>Languages Known</label><br>
        <input type="checkbox" name="lang" id="eng" value="English">
        <label for="eng">English</label>
        <input type="checkbox" name="lang" id="french" value="French">
        <label for="french">French</label>
        <input type="checkbox" name="lang" id="tam" value="Tamil">
        <label for="tam">Tamil</label>
        <input type="checkbox" name="lang" id="hindi" value="Hindi">
        <label for="hindi">Hindi</label><br><br>

        <label for="fname">Father Name</label><br>
        <input type="text" id="fname" name="fname"><br><br>

        <label for="mobilenum">Mobile Number</label><br>
        <input type="tel" name="mobilenum" id="mobilenum" required><br><br>

        <label for="email">Email</label><br>
        <input type="email" name="email" id="email"><br><br>

        <label for="msg">Message</label><br>
        <textarea name="message" id="msg" cols="50" rows="8"></textarea><br><br>

        <input type="submit" value="SUBMIT" onclick="val()">
        <input type="reset" value="RESET">

    </form>
    </div>

</div>
<br><br>

<table style="width:100%">
    <caption style="text-align:left"><b>CONTACT US</b></caption>
    <tr>
        <th>Contact Person</th>
        <th>Phone</th>
        <th>Email</th>
    </tr>
    <tr>
        <td>Office</td>
        <td>044-234567</td>
        <td>abcmhss@gmail.com</td>
    </tr>
    <tr>
        <td>Principal</td>
        <td>91345678290</td>
        <td>abcmhsspricipal@gmail.com</td>
    </tr>
    <tr>
        <td>Correspondent</td>
        <td>6783459012</td>
        <td>abcmhsscoress@gmail.com</td>
    </tr>

</table>

</body>
</html>