<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> 
<script src="/public/js/parsley.js"></script>
<t:wrapper>
    <div>
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <h2>REGISTER</h2>
            <form:form class="form-signin" modelAttribute="newUser" method="POST" action="/register" data-parsley-validate="true">
                <form:input id='username' type='text' path='username' class="trans-input" placeholder="Login" required="true"/>
                <form:input type='password' id='password' path='password' class="trans-input" placeholder="Password" required="true"/>
                <input type='password' data-parsley-equalto="#password" id='password2' class="trans-input" placeholder="Repeat password" required="true"/>
                <button class="btn btn-default btn-lg" type="submit">SIGN UP</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </form:form>
        </div>  
        <div class="col-sm-4"></div>
    </div>
</t:wrapper>
