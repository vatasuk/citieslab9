<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page import="lab9.citieslab9.City"%>
<%@ page import="lab9.citieslab9.Park"%>

<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Сотрудники</title>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Persons</title>
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <!-- jQuery -->
  <script defer src="js/code.jquery.com_jquery-3.7.1.js"></script>
  <!-- Bootstrap JS + Popper JS -->
  <script defer src="js/bootstrap.bundle.min.js"></script>
  <script
          src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
</head>
<body>
<body>
<div class="container-fluid">
  <jsp:include page="/views/header.jsp" />
  <div class="container-fluid">
    <div class="row justify-content-start ">
      div class="col-8 border bg-light px-4">
      <h3>Список парков</h3>
      <table class="table">
        <thead>
        <th scope="col">ID</th>
        <th scope="col">Город</th>
        <th scope="col">Площадь</th>
        <th scope="col">Наличие водоемов</th>
        <th scope="col">Тип</th>
        <th scope="col">Название</th>
        <th scope="col">Дата создания</th>
        <th scope="col">Редактировать</th>
        <th scope="col">Удалить</th>
        </thead>
        <tbody>
        <c:forEach var="park" items="${parks}">
          <tr>
            <td>${park.getId()}</td>
            <td>${park.getCityID()}</td>
            <td>${park.getS()}</td>
            <td>${park.getWater()}</td>
            <td>${park.getType()}</td>
            <td>${park.getName()}</td>
            <td>${park.getDate()}</td>

            <td width="20"><a href="#" role="button"
                              class="btn btn-outline-primary">
              <img alt="Редактировать"
                   src="images/icon-edit.png"></a>
            </td>
            <td width="20"><a href="#" role="button"
                              class="btn btn-outline-primary">
              <img alt="Удалить"
                   src="images/icon-delete.png"></a>
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
    <div class="col-4 border px-4">
      <form method="POST" action="">
        <h3>Новый сотрудник</h3>
        <br>
        <div class="mb-3 row">
          <label for="lastname"
                 class="col-sm-3 col-form-label">Площадь</label>
          <div class="col-sm-7">
            <input type="text" class="form-control"
                   id="staticLastname"name="lastname" />
          </div>
        </div>
        <div class="mb-3 row">
          <label for="firstname"
          class="col-sm-3 col-form-label">Водоемы</label>
          <div class="col-sm-7">
            <input type="text"
                   class="form-control" id="staticFirstname"
                   name="firstname" />
          </div>
        </div>
        <div class="mb-3 row">
          <label for="cityname"
          class="col-sm-3 col-form-label">Город</label>
          <div class="col-sm-7">
            <select name="role" class="form-control">
              <option>Выберите город</option>
              <c:forEach var="city" items="${cities}">
              <option value="${city}">
                <c:out value="${city.getName()}"></c:out>
              </option>
              </c:forEach>
            </select>
          </div>
        </div>

        <div class="mb-3 row">
          <label for="phone"
                 class="col-sm-3 col-form-label">Тип</label>
          <div class="col-sm-7">
            <input type="text"
                   class="form-control" id="staticphone"
                   name="phone" />
          </div>
        </div>
        <div class="mb-3 row">
          <label for="email"
                 class="col-sm-3 col-form-label">Название</label>
          <div class="col-sm-7">
            <input type="text" class="form-control"
                   id="staticemail" name="email" />
          </div>
        </div>
        <div class="mb-3 row">
          <label for="date"
                 class="col-sm-3 col-form-label">Дата создания</label>
          <div class="col-sm-7">
            <input type="text" class="form-control"
                   id="staticdate" name="date" />
          </div>
        </div>
        <p> <br>
          <button type="submit"
                  class="btn btn-primary">Добавить</button>
        </p>
      </form>
    </div>
  </div>
</div>
<jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>