<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <h1>BOARDS</h1>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>BOARD</th>
                <th>THREAD COUNT</th>
            </tr></thead>
        <tbody>
            <c:forEach items="${boards}" var="board">
                <tr>
                    <td>
                        <a href="board/${board.name}">${board.name}</a>
                    </td>
                    <td>
                        ${board.threads.size()}
                    </td>
                    <td></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${!(user.username eq 'anonymous')}">
        <form:form modelAttribute="newBoard" method="POST" action="/">
            <h2>Create new Board</h2>
            <table>
                <tr>
                    <td><form:label path="name">Board name</form:label></td>
                    <td><form:input path="name" class="form-control"/></td>
                    <td><form:errors path="name" cssClass="has-error"/></td>
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
