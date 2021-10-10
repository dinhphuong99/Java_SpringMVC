<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>simple caculator</title>
</head>

<body>
<b>Caculate</b>
<form action="${pageContext.request.contextPath}/calculator" method="get">
    <label for="number"></label><input type="text" id="number" name="number">
    <label for="number1"></label><input type="text" id="number1" name="number1">

    <button type="submit" name = "mess" value="Addition">Addition( + )</button>
    <button type="submit" name = "mess" value="Subtraction">Subtraction( - )</button>
    <button type="submit" name = "mess" value="Multiplication">Multiplication( x )</button>
    <button type="submit" name = "mess" value="Division">Division( / )</button>
</form>
<div>
    Result ${mess} : ${result}
</div>
<div>
    ${error}
</div>
<div>
    ${error}
</div>

</body>

</html>