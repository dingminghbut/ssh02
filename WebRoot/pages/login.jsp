<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>系统登录</h1>
	${waring1 } ${waring2 }
	<form action="check" method="post">
	帐号<input type="text" name="accountname" value=${accountname }><br>
	密码<input type="text" name="password" value=${password }><br>
	  <input type="submit" value="登录">
	</form>
	<form action="reset" method="post">
	  <input type="submit" value="重置">
	</form>
</body>
</html>