<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<script src="/public/js/forumUtils.js"></script>
<t:wrapper>
    <table class="table table-hover">
        <div>
            <img src="/public/images/face.png"/>
        </div>
        <div>
            <p>
                <c:out value="${targetUser.username}"/>
            </p>
        </div>
    </table>
</t:wrapper>
