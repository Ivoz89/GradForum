<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>  
<script type="text/javascript">
    function doAjaxPost() {
        var token = $('#csrfToken').val();
        var header = $('#csrfHeader').val();
        var text = $('#text').val();
        $.ajax({
            url: "/board/${boardName}/${threadName}/" + text,
            type: "POST",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader(header, token);
            },
            success: function (post) {
                var divRef = document.getElementById('posts');
                var newArticle = document.createElement('article');
                var p = document.createElement('p');
                var a = document.createElement('a');
                a.href = "/user/" + escapeHtml(post.creator.username);
                a.text = escapeHtml(post.creator.username);
                p.appendChild(a);
                var date = new Date(post.date);
                var dateString = date.format("ddd mmm dd yyyy HH:MM:ss");
                p.appendChild(document.createTextNode(" on " + dateString + " wrote:"));
                textP = document.createElement('p');
                textP.appendChild(document.createTextNode(escapeHtml(post.text)));
                newArticle.appendChild(p);
                newArticle.appendChild(textP);
                divRef.appendChild(newArticle);
            }
        });
    }

    function escapeHtml(unsafe) {
        return unsafe
                .replace(/&/g, "&amp;")
                .replace(/</g, "&lt;")
                .replace(/>/g, "&gt;")
                .replace(/"/g, "&quot;")
                .replace(/'/g, "&#039;");
    }
</script>
<t:wrapper>
    <div class="col-lg-8 col-lg-offset-2">
        <h2><c:out value="${threadName}"/></h2>
        <div id="posts">
            <c:forEach items="${posts}" var="post">
                <article>
                    <p>
                        <c:choose>
                            <c:when test="${empty post.creator.avatarString}">
                                <img src="/public/images/face.png" />
                            </c:when>    
                            <c:otherwise>
                                <img src="data:image/jpg;base64,${post.creator.avatarString}" />
                            </c:otherwise>
                        </c:choose>
                    </p>
                    <p><a href="/user/${post.creator.username}"><c:out value="${post.creator.username}"/></a> on ${post.date.toString()} wrote:</p>
                    <p><c:out value="${post.text}"/></p>
                </article>
            </c:forEach>
        </div>
        <sec:authorize access="isAuthenticated()">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Create new Post</h2>
                <label path="name">Content:</label>
                <textarea id="text" class="form-control" rows="10"></textarea>
                <input type="button" class="btn btn-default btn-sm" value="Submit" onClick="doAjaxPost()"/>
                <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
                <input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
            </div>
        </sec:authorize>
    </div>
</t:wrapper>