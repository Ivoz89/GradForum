<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="/public/js/forumUtils.js"></script>
<t:wrapper>
    <table class="table table-hover">
        <div>
            <img src="/public/images/404.png"/>
        </div>
        <br/>
        <br/>
        <div class="col-lg-8 col-lg-offset-2">
            <h2><spring:message code='error.404'/></h2>
        </div>
    </table>
</t:wrapper>
