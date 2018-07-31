<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
파일 번호 : ${music.fileId }<br/>
타이틀 : ${music.title }<br/>
곡 소개 : ${music.intro }<br/>
장르 : ${music.intro }<br/>
등록일 : ${music.regDate }<br/>
공개여부 : ${music.visibility }<br/>
다운로드 공개여부 : ${music.downloadAccept }<br/>
</body>
</html>
