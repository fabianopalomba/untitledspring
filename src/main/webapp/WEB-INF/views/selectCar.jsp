<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <h1>Choose your car:</h1>
    <div class="card">
        <div class="card-body">
            <form:form action="" method="post" modelAttribute="car">
                <div class="form-group row">
                    <form:label path="carsid">Choose a car:</form:label>
                    <form:select path="carsid">
                        <c:forEach items="${cars}" var="car">
                            <form:option value="${car.carsid}">${car.brand} ${car.model}</form:option>
                        </c:forEach>
                    </form:select>
                    <input class="btn btn-primary" type="submit" value="Submit">
                </div>
            </form:form>
        </div>
    </div>
</div>
