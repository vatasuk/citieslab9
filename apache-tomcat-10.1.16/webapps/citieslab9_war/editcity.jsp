<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="lab9.citieslab9.City"%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Города</title>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cities</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <!-- jQuery -->
    <script defer src="js/code.jquery.com_jquery-3.7.1.js"></script>
    <!-- Bootstrap JS + Popper JS -->
    <script defer src="js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container-fluid">
    <jsp:include page="/views/header.jsp" />
    <div class="container-fluid">
        <div class="row justify-content-start ">
            <div class="col-6 border bg-light px-4">
                <h3>Список городов</h3>
                <table class="table">
                    <thead>
                    <th scope="col">Код</th>
                    <th scope="col">Город</th>
                    <th scope="col">Население</th>
                    </thead>
                    <tbody>
                    <c:forEach var="city" items="${cities}">
                        <tr>
                            <td>${city.getId()}</td>
                            <td>${city.getName()}</td>
                            <td>${city.getPop()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-6 border px-4">
                <form method="POST" action="">
                    <h3>Редактировать города</h3>
                    <br> <br>
                    <div class="mb-3 row">
                        <label for="idcity" class="col-sm-3 col-form-label">
                            Код города</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" readonly
                                   value="${cityEdit.getId()}" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <br> <label for="inputName"
                                    class="col-sm-3 col-form-label">Город</label>
                        <div class="col-sm-6">
                            <input type="text" name="inputName" class="form-control"
                                   value="${cityEdit.getName()}" id="inputName" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <br> <label for="inputPop"
                                    class="col-sm-3 col-form-label">Население</label>
                        <div class="col-sm-6">
                            <input type="text" name="inputPop" class="form-control"
                                   value="${cityEdit.getPop()}" id="inputPop" />
                        </div>
                    </div>
                    <p>
                        <br> <br> <br>
                        <button type="submit"
                                class="btn btn-primary">Редактировать</button>
                        <a href='<c:url value="/city" />' role="button"
                           class="btn btn-secondary">Отменить</a>
                        <br>
                    </p>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>