<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 10/7/2021
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
    <meta http-equiv="content-type" content="text/html" charset="UTF-8">
  </head>
  <body>
  <form action="/translate" method="get">
    <h6>
      English
    </h6>
    <input type="text" id = "english" name="english">
    <br>

    <h6>
      Vietnamese
    </h6>
    <input type="text" id = "vietnamese" name="vietnamese">
    <br>

    <input type="submit"  value="Translate" name="translate">
  </form>
  </body>
</html>
