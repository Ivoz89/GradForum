<%@tag description="Bootstrap Wrapper Tag" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<html lang="en">
    <!-- Bootstrap Core CSS -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="/public/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/public/bootstrap/css/grayscale.css" rel="stylesheet">
    <link href="/public/bootstrap/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="/public/css/grad.css" rel="stylesheet">
    <body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top"> 
        <script type="text/javascript" src="/public/bootstrap/js/jquery.js"></script>
        <script type="text/javascript" src="/public/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/public/bootstrap/js/jquery.easing.min.js"></script>
        <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>
        <script type="text/javascript" src="/public/bootstrap/js/grayscale.js"></script>
        <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                        <i class="fa fa-bars"></i>
                    </button>
                    <a class="navbar-brand page-scroll" href="/">
                        <span class="light">GRAD FORUM</span> 
                    </a>
                </div>
                <sec:authorize access="!isAuthenticated()">
                    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                        <a class="navbar-brand page-scroll" href="/login">
                            LOGIN
                        </a>
                        </ul>
                    </div>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                        <c:url var="logoutUrl" value="/logout"/>
                        <form action="${logoutUrl}" method="post">
                            <input class="btn btn-default btn-sm padu" type="submit" value="Log out" />
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        </form>
                    </div>
                </sec:authorize>
                <sec:authorize access="!isAuthenticated()">
                    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                        <a class="navbar-brand page-scroll" href="/register">
                            REGISTER
                        </a>
                        </ul>
                    </div>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                        <a class="navbar-brand page-scroll" href="/user/${pageContext.request.userPrincipal.name}">
                            <span class="glyphicon glyphicon-user"></span>
                        </a>
                    </div>
                </sec:authorize>
            </div>
        </nav>
        <header class="intro">
            <div class="intro-body">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-md-offset-2">
                            <c:if test="${not empty message}">
                                <c:choose>
                                    <c:when test="${message.messageType == 'ERROR'}">
                                        <div class="alert alert-danger fade in">
                                            <a href="#" class="close" data-dismiss="alert">&times;</a>
                                            <strong>Error!</strong> ${message.message}
                                        </div>
                                    </c:when>    
                                    <c:when test="${message.messageType == 'INFO'}">
                                        <div class="alert alert-info fade in">
                                            <a href="#" class="close" data-dismiss="alert">&times;</a>
                                            <strong>NOTE:</strong> ${message.message}
                                        </div>
                                    </c:when>   
                                    <c:otherwise>
                                        <div class="alert alert-success fade in">
                                            <a href="#" class="close" data-dismiss="alert">&times;</a>
                                            <strong>Success!</strong> ${message.message}
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </div>
                    </div>
                    <div class="row">
                        <jsp:doBody/>
                    </div>
                </div>
            </div>
        </header>
        <footer>
            <div class="container text-center">
                <p>Ivo Zielinski</p>
                <p>GFT Graduate Program 2015 Project</p>
                <p>Created using  <a href="https://github.com/IronSummitMedia/startbootstrap">Grayscale</a> bootstrap template</p>
            </div>
        </footer>
    </body>
</html>
