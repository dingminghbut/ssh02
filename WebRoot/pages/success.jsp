<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>转帐操作</h1>
	${waring1 } ${waring2 } ${waring3 }
	<form action="turn" method="post">
	转入帐号<input type="text" name="accname" value=${accname }><br>
	转帐金额<input type="text" name="money" value=${money }><br>
	<input type="submit" value="确定转帐">
	</form>
</body>
</html>