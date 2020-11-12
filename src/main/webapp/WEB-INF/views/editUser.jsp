<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	
        <form:form method="POST" action="editUser" modelAttribute="user">
            <table>
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" readonly="true" class="form-control" name="email"
                                    placeholder="Enter email"/></td>
                </tr>
                <tr>
                    <td><form:label path="firstName">First Name</form:label></td>
                    <td><form:input path="firstName" type="text" class="form-control" name="firstName"
                                    placeholder="Enter first name" required="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">LastName</form:label></td>
                    <td><form:input path="lastName"  type="text" class="form-control" name="lastName"
                                    placeholder="Enter last name" required="true"/></td>
                </tr>
                <tr>
                    <td><form:label path="phone">Phone</form:label></td>
                    <td><form:input path="phone" type="int" pattern="[3][0-9]{9}" name="phone"  required="true" class="form-control"
                                    placeholder="Enter phone"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password</form:label></td>
                    <td><form:input path="password" type="password" class="form-control" name="password"
                                    placeholder="Enter Password" required="true"/></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>

</body>
</html>