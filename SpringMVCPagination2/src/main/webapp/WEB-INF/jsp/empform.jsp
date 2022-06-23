<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand"> Hotel Management Application </a>
				<a href="login" class="navbar-brand"> Login </a>
				 
			</div>
			
		</nav>
	</header>
</body>
		<h1>Add New Customer</h1>
       <form:form method="post" action="save">  
      	<table >  
         <tr>  
          <td>Name: </td> 
          <td><form:input path="name"  /></td>
         </tr>  
         <tr>  
          <td>LastName :</td>  
          <td><form:input path="lastName" /></td>
         </tr> 
         <tr>  
          <td>Destination :</td>  
          <td><form:input path="destination" /></td>
         </tr> 
         <tr>  
          <td>Password :</td>  
          <td><form:input path="password" /></td>
         </tr> 
          <tr>  
          <td>Admin :</td>  
          <td><form:input path="admin" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  
