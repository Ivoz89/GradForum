<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <h1>${threadName}</h1>
    <table class="table table-bordered">
        <tbody>
            <c:forEach items="${posts}" var="post">
                <tr>
            <table class="table">
                <tr>
                    <td>
                        <a href="/user/${post.creator.username}">${post.creator.username}</a>
                    </td>
                    <td>
                        Created: ${post.date.toString()}
                    </td>
                </tr>
                <tr>
                    <td>
                        </br>${post.text}
                    </td>
                </tr>
            </table>
        </tr>
    </c:forEach>
</tbody>
</table>
<c:if test="${!(user.username eq 'anonymous')}">
    <form:form modelAttribute="post" method="POST" action="/board/thread/${threadName}">
        <table>
            <tr>
                <td><form:label path="text">POST:</form:label></td>
                <td><form:textarea class="form-control" rows="5" colspan="10" path="text"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Submit"/>
                </td>
            </tr>
        </table>  
    </form:form>
</c:if>
</t:wrapper>