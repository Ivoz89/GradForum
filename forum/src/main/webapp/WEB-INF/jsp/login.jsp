<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <h1>LOG IN</h1>
    <form:form modelAttribute="credentials" method="POST" action="/login">
        <table>
            <tr>
                <td><form:label path="username">Username</form:label></td>
                <td><form:input path="username" class="form-control"/></td>
            </tr>
            <tr>
                <td><form:label path="password">Password</form:label></td>
                <td><form:input path="password" class="form-control"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>  
    </form:form>
</t:wrapper>
