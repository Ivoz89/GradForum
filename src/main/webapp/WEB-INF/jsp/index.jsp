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
            url: "/board/" + name,
            type: "POST",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader(header, token);
            },
            success: function (board) {
                var tableRef = document.getElementById('boards').getElementsByTagName('tbody')[0];
                var newRow = tableRef.insertRow(tableRef.rows.length);
                var nameCell = newRow.insertCell(0);
                var a = document.createElement('a');
                a.href = "board/" + escapeHtml(board.name);
                a.text = escapeHtml(board.name);
                nameCell.appendChild(a);
                var sizeCell = newRow.insertCell(1);
                sizeCell.appendChild(document.createTextNode(0));
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
        <table id="boards" class="table table-hover">
            <h3>BOARDS</h3>
            <thead align="center">
                <tr>
                    <th>BOARD</th>
                    <th>THREAD COUNT</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${boards}" var="board">
                    <tr>
                        <td>
                            <a href="board/${board.name}"><c:out value="${board.name}"/></a>
                        </td>
                        <td>
                            ${board.threads.size()}
                        </td>
                        <td></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <sec:authorize access="isAuthenticated()">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Create new Board</h2>
                <label path="name">Board name</label>
                <input path="name" id="name" class="form-control trans-input"/>
                <errors path="name" cssClass="has-error"/>
                <input type="button" class="btn btn-default btn-sm" value="CREATE" onClick="doAjaxPost()"/>
                <input type="hidden" id="csrfToken" value="${_csrf.token}"/>
                <input type="hidden" id="csrfHeader" value="${_csrf.headerName}"/>
            </div>
        </sec:authorize>
    </t:wrapper>
