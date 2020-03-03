<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Курсы</title>
<style> form fieldset{ width:40%;} form fieldset label {display: black;} form fieldset input, form fieldset textarea {width:100;} </style>
</head>
<body>
	<h1>Курсы</h1>
	 <form method="POST">
	 
	 <fieldset>
	 
	 <div>
	 <label> Nazvanie: </label>
	 <input type ="text" name = "title" value ="${course.title}">
	 </div>
	 	 	<div>
	 	 	 	 <input type ="description" name = "description" value = "${course.description}" >
	 	 	 	 </div>
	 	 	 	<div>
	 	 	    <input type ="id" name = "id" value = "${course.id}" >
	 	 	 	 </div>
	 	 	 	<div>
	 	 	 	 <input type ="submit" value = "сохранить" >
	 	 	 	 </div>
	 </div>
	 </fieldset>
	 
	 </form>

</body>
</html>