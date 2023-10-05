<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
  $(function() {
	fnList();
	fnDetail();
  })
  
  function fnList() {
	$('#btn_list').click(function() {
		$.ajax({
			type: 'get',
			url: '${contextPath}/ajax1/list.do',
			dataType: 'json',
			success: function(resData) {
				$('#list').empty();
				$.each(resData, function(i, elem) {
					$('#list').append('<div class="row"><span>' + elem.name + '</span>, ' + elem.age + '<div>');
				})
			}
		})
	})	
}
  function fnDetail() {
	$(document).on('click', '.row', function() {
		$.ajax({
			type: 'get',
			url: '${contextPath}/ajax1/detail.do',
			data: 'name=' + $(this).find('span').text(),
			dataType: 'json',
			success: function(resData) {
				alert(resData.name + ', ' + resData.age);
			}
		})
	})
} 
</script>
</head>
<body>

  <div>
    <button id="btn_list">목록보기</button>
  </div>
  
  <hr>
  
  <div id="list"></div>
    
</body>
</html>