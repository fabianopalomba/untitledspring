<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <h1>Register Form:</h1>
    <div class="card">
        <div class="card-body">
            <form:form method="POST" action="" modelAttribute="user">
                 <table>
                    <tr>
                        <td><form:label path="firstName">Nome</form:label></td>
                        <td><form:input path="firstName" type="text" class="form-control" name="firstName"
                                        placeholder="Enter first name" required="true"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="lastName">Cognome</form:label></td>
                        <td><form:input path="lastName"  type="text" class="form-control" name="lastName"
                                        placeholder="Enter last name" required="true"/></td>
                    </tr>
                     <tr>
                         <td><form:label path="phone">Telefono</form:label></td>
                         <td><form:input path="phone" type="int" pattern="[3][0-9]{9}" name="phone"  required="true" class="form-control"
                                         placeholder="Enter phone"/></td>
                     </tr>
                     <tr>
                        <td><form:label path="email">Email</form:label></td>
                        <td><form:input path="email" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required="true" class="form-control" name="email"
                                        placeholder="Enter email"/></td>
                    </tr>
                     <tr>
                         <td><form:label path="password">Password</form:label></td>
                         <td><form:input path="password" type="password" class="form-control" name="password"
                                         placeholder="Enter Password" required="true"/></td>
                     </tr>
                     <form:input path="role" value="USER" hidden="true"/>
                     <form:input path="enabled" value="true" hidden="true"/>

                     <tr>
                        <td><input type="submit" value="Submit"/></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
