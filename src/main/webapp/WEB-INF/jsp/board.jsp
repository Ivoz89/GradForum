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
        var name = $('#name').val();
        $.ajax({
            url: "/board/${boardName}/" + name,
            type: "POST",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader(header, token);
            },
            success: function (thread) {
                var tableRef = document.getElementById('threads').getElementsByTagName('tbody')[0];
                var newRow = tableRef.insertRow(tableRef.rows.length);
                var nameCell = newRow.insertCell(0);
                var a = document.createElement('a');
                a.href = escapeHtml("${boardName}") + "/" + escapeHtml(thread.name);
                a.text = escapeHtml(thread.name);
                nameCell.appendChild(a);
                var creatorCell = newRow.insertCell(1);
                creatorCell.appendChild(document.createTextNode("CREATED BY "))
                a2 = document.createElement('a');
                a2.href = "/user/" + escapeHtml(thread.creator.username);
                a2.text = escapeHtml(thread.creator.username);
                creatorCell.appendChild(a2);
                var nameCell = newRow.insertCell(2);
                nameCell.appendChild(document.createTextNode("0"));
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
        <h3><c:out value="${boardName}"/> BOARD</h3>
        <table id="threads" class="table table-hover">
            <thead>
                <tr>
                    <th>THREAD</th>
                    <th>CREATOR</th>
                    <th>POST COUNT</th>
                </tr></thead>
            <tbody>
                <c:forEach items="${threads}" var="thread">
                    <tr>
                        <td>
                            <a href="${boardName}/${thread.name}"><c:out value="${thread.name}"/></a>
                        </td>
                        <td>
                            CREATED BY <a href="/user/${thread.creator.username}"><c:out value="${thread.creator.username}"/></a>
                        </td>
                        <td>
                            ${thread.posts.size()}
                        </td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <sec:authorize access="isAuthenticated()">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Create new Thread</h2>
                <label path="name">Thread name</label>
                <input path="name" id="name" class="form-control trans-input"/>
                <errors path="name" cssClass="has-error"/>
                <input type="button" class="btn btn-default btn-sm" value="CREATE" onClick="doAjaxPost()"/>
                <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
                <input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
            </div>
        </sec:authorize>
    </div>
</t:wrapper>
