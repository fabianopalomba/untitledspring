<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="container">
    <h1>Scegli le date:</h1>
    <div class="card">
        <div class="card-body">
            <form method="post" action="" >
                <table>
                    <tr>
                        <td><label path="initDate">Data Inizio</label></td>
                        <td><input path="initDate" type="date" class="form-control" name="initDate"
                                        placeholder="Enter initDate" required="true"/></td>
                    </tr>
                    <tr>
                        <td><label path="finDate">Data Fine</label></td>
                        <td><input path="finDate"  type="date" class="form-control" name="finDate"
                                        placeholder="Enter finDate" required="true"/></td>
                    </tr>
                    <tr>
                        <td><input class="btn btn-primary" type="submit" value="controlla disponibilità"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>