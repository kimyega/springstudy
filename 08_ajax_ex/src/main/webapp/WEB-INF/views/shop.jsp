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
	
  })
  
</script>
</head>
<body>

  <form action="#">
    <div>
      <span>검색결과건수</span>
      <select>
        <c:forEach var="n" begin="10" end="100" step="10">
          <option>${n}</option>
        </c:forEach>
      </select>
    </div>
    <div>
      <input type="radio" class="sort" id="sim" name="sort">
      <label for="sim">유사도순</label>
      <input type="radio" class="sort" id="date" name="sort">
      <label for="date">날짜순</label>
      <input type="radio" class="sort" id="asc" name="sort">
      <label for="asc">높은가격순</label>
      <input type="radio" class="sort" id="dec" name="sort">
      <label for="dec">낮은가격순</label>
    </div>
    <div>
      <span>검색어 입력</span>
      <input type="text">
      <button type="submit">검색</button>
    </div>
  </form>
  <hr>
  
  <table border="1">
    <thead>
      <tr>
        <td>상품명</td>
        <td>썸네일</td>
        <td>최저가</td>
        <td>판매처</td>
      </tr>
    </thead>
    <tbody class="shop_tb">
    </tbody>
  </table>













</body>
</html>