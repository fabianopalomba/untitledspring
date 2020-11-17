<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <div class="card">
        <div class="card-body">
            <div class="col-12">
                <h1>Your data</h1>
                <table  class="table">
                    <thead>
                    <tr class="table-light">
                        <th scope="col">first name</th>
                        <th scope="col">last name</th>
                        <th scope="col">phone</th>
                        <th scope="col">email</th>
                        <th scope="col">password</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr  class="table-info">
                        <td> ${user.firstName} </td>
                        <td> ${user.lastName} </td>
                        <td> ${user.phone} </td>
                        <td> ${user.email} </td>
                        <td> ${user.password} </td>
                        <td> <a class="btn btn-primary" data-toggle="collapse" href="<spring:url value="/editUser"/>" role="button" aria-expanded="false" aria-controls="collapseExample">update</a></td>
                        <td> <a class="btn btn-danger" data-toggle="collapse" href="<spring:url value="/deleteUser"/>" onclick="if(!(confirm('Are you sure you wanna delete?')))return false" role="button" aria-expanded="false" aria-controls="collapseExample">delete</a></td>
                    </tr>
                    </tbody>
                </table>
                <h1>Your rents</h1>
                <table class="table">
                    <thead>
                    <tr class="table-light">
                        <th scope="col">brand</th>
                        <th scope="col">model</th>
                        <th scope="col">init Date</th>
                        <th scope="col">finish Date</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${rents}" var="rents">
                        <tr class="table-info">
                            <td> ${rents.car.brand} </td>
                            <td> ${rents.car.model} </td>
                            <td> <fmt:formatDate type = "date" value = "${rents.initDate}" /></td>
                            <td> <fmt:formatDate type = "date" value = "${rents.finDate}" /></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
