<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<script src="/public/js/forumUtils.js"></script>
<t:wrapper>
    <table class="table table-hover">
        <div>
            <c:choose>
                <c:when test="${empty targetUser.avatarString}">
                    <img src="/public/images/face.png" />
                </c:when>    
                <c:otherwise>
                    <img src="data:image/jpg;base64,${targetUser.avatarString}" />
                </c:otherwise>
            </c:choose>
        </div>
        <br/>
        <div>
            <p>
                USER: <c:out value="${targetUser.username}"/>
            </p>
        </div>
        <br/>
        <sec:authorize access="isAuthenticated()">
            <c:if test="${targetUser.username eq pageContext.request.userPrincipal.name}">
                <div class="col-lg-8 col-lg-offset-2">
                    <form class="form-signin" method="POST" action="/user/${targetUser.username}" enctype="multipart/form-data">
                        <h3>CHANGE AVATAR</h3>
                        <span class="btn btn-default btn-file">
                            <input name="image" type="file" />
                        </span>
                        <button type="submit" class="btn btn-default btn-sm">UPLOAD</button> 
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    </form>
                </div>
            </c:if>
        </sec:authorize>
    </table>
</t:wrapper>
