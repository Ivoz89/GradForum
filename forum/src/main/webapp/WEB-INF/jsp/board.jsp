<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <h1>${boardName}</h1>
    <table class="table table-hover">
        <thead>
            <tr>
                <th>THREAD</th>
                <th>POST COUNT</th>
            </tr></thead>
        <tbody>
            <c:forEach items="${threads}" var="thread">
                <tr>
                    <td>
                        <a href="thread/${thread.name}">${thread.name}</a>
                    </td>
                    <td>
                        CREATED BY <a href="/user/${thread.creator.username}">${thread.creator.username}</a>
                    </td>
                    <td>
                        ${thread.posts.size()}
                    </td>
                    <td></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <c:if test="${!(user.username eq 'anonymous')}">
        <form:form modelAttribute="thread" method="POST" action="/board/${boardName}">
            <h2>Create new Thread</h2>
            <table>
                <tr>
                    <td><form:label path="name">Thread name</form:label></td>
                    <td><form:input path="name" class="form-control"/></td>
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
