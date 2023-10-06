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
	fnMemberInfo();
  })
  function fnMemberInfo() {
	$('#btn_bmi').click(function() {
		fnProfile();
		$.ajax({
			type: 'get',
			url: '${contextPath}/member/health.check',
			data: 'memberNo=' + $('#memberNo').val(),
			dataType: 'json',
			success: function(resData) {
				fnBmi(resData);	
			}
		})
	})
}
  function fnBmi(resData) {
	  $('#bmi_info').empty();
	  $('#bmi_info').append('<ul><li>' + resData.name + '</li><li>' + resData.bmi + '</li><li>' + resData.state + '</li></ul>')
}
  function fnProfile() {
	  var path = encodeURIComponent('D:\\9DJ69\\assets\\image');
	  var filename = 'flower' + $('#memberNo').val() + '.jpg';
	  $('#image').empty();
	  $('#image').append('<img src="${contextPath}/member/image.do?path=' + path + '&filename=' + filename + '" width = "192px">');
}

</script>
</head>
<body>

  <div> 
    <select id="memberNo">
      <option>1</option>
      <option>2</option>
      <option>3</option>
    </select> 
    <button type="button" id="btn_bmi">BMI정보확인</button>
  </div>
  
  <hr>
  
  <div>
    <div id="image"></div>
    <div id="bmi_info"></div>
  </div>
  
  <hr>
  <div>
    <a href="${contextPath}/shop.go">쇼핑하러 가기</a>
  </div>
</body>
</html>