    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>

 form
	{
		padding-left:630px;
		padding-top:0px;
	}
</style>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="index.jsp" class="navbar-brand"> Hotel Management Application </a>
				<a href="login" class="navbar-brand"> Login </a>
			</div>
			
		</nav>
	</header>
</body>
</head>
<section>
 <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search Customer" aria-label="Search" name="searchbar">
      <button id="bt" class="btn btn-outline-success my-2 my-sm-0" type="submit">Go</button>
</form>
	<h1>Customer List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Name</th><th>lastName</th><th>Destination</th><th>Password</th><th>admin</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${list}"> 
    <tr>
    <td>${emp.id}</td>
    <td>${emp.name}</td>
    <td>${emp.lastName}</td>
    <td>${emp.destination}</td>
     <td>${emp.password}</td>
     <td>${emp.admin}</td>
    <td><a href="editemp/${emp.id}">Edit</a></td>
    <td><a href="deleteemp/${emp.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/> 	
    <a href="empform">Add New Customer</a>

</section>