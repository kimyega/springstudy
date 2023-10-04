<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
  var addResult = '${addResult}';
  
  if(addResult !== ''){
	  if(addResult === '1'){
		  alert('add 성공했어요!');
	  } else {
		  alert('add 실패했어요..ㅜ');
	  }
  }
</script>
</head>
<body>
  faq 목록
  <div>${addResult}</div>
</body>
</html>