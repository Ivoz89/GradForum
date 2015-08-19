<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<t:wrapper>
    <div>
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <h2>SIGN IN</h2>
            <form name='loginForm' class="form-signin" action="<c:url value='/login' />" method='POST'>
                <input type='text' name='username' class="trans-input" placeholder="Login" >
                <input type='password' name='password' class="trans-input" placeholder="Password"/>
                <button class="btn btn-default btn-lg" type="submit"><spring:message code='main.login'/></button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form>
        </div>  
        <div class="col-sm-4"></div>
    </div>
</t:wrapper>
