<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<form action="addMusic" method="POST">
	제목 : <input type="text" name="title"><br/>
	소개 : <input type="text" name="intro"><br/>
	공개 여부 : <input type="radio" name="visibility" value="true">공개
	<input type="radio" name="visibility" value="false">비공개<br/>
	다운로드 허용 여부 : <input type="radio" name="downAccept" value="true">다운로드 허용
	<input type="radio" name="downAccept" value="false">다운로드 비허용<br/>
	장르 : <input type="text" name="genre">
	<button type="submit">등록</button>
</form>
</body>
</html>
