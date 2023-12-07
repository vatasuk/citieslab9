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
            <div class="col-8 border bg-light px-4">
                <h3>Список городов</h3>
                <table class="table">
                    <thead>
                    <th scope="col">Код</th>
                    <th scope="col">Город</th>
                    <th scope="col">Население</th>
                    <th scope="col">Редактировать</th>
                    <th scope="col">Удалить</th>
                    </thead>
                    <tbody>
                    <c:forEach var="city" items="${cities}">
                        <tr>
                            <td>${city.getId()}</td>
                            <td>${city.getName()}</td>
                            <td>${city.getPop()}</td>
                            <td width="20"><a href="#" role="button"
                                              class="btn btn-outline-primary">
                                <img alt="Редактировать"
                                     ></a></td>
                            <td width="20"><a href="#" role="button"
                                              class="btn btn-outline-primary">
                                <img alt="Удалить"
                                     ></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-4 border px-4">
                <form method="POST" action="">
                    <h3>Новый город</h3>
                    <div class="mb-3 row">
                        <label for="cityname"
                               class="col-sm-3 col-form-label">Название</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="staticCityname"name="cityname" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="pop"
                               class="col-sm-3 col-form-label">Население</label>
                        <div class="col-sm-7">
                            <input type="text"
                                   class="form-control" id="staticpop"
                                   name="pop" />
                        </div>
                    </div>
                    <p>
                        <br> <br> <br>
                        <button type="submit" class="btn btn-primary">Добавить</button>
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

