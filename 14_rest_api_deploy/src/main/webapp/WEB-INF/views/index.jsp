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
    fnChkAll();
    fnChkOne();
    fnInit();
	fnMemberRegister();
	fnMemberList();
	fnMemberDetail();
	fnMemberModify();
	fnMemberRemove();
	fnRemoveMembers();
	})
	
	function fnChkAll() {
		$('#chk_all').click(function() {
			$('.chk_one').prop('checked', $(this).prop('checked'));
		})
	}
  	function fnChkOne() {
		$(document).on('click', function() {
			var total = 0;
			$.each($('.chk_one'), function(i, elem) {
				total += $(elem).prop('checked');
			})
			$('#chk_all').prop('checked', total === $('.chk_one').length);
		})
	}
	
	
  function fnMemberRegister() {
	$('#btn_register').click(function() {
		$.ajax({
			type: 'post',
			url: '${contextPath}/members',
			contentType: 'application/json',
			data: JSON.stringify({
				id: $('#id').val(),
				name: $('#name').val(),
				gender: $(':radio:checked').val(),
				address: $('#address').val()
			}),
			// 응답
			dataType: 'json',
			success: function(resData) {		// {"addResult" : 1}
				if(resData.addResult === 1){
					alert('회원 정보가 등록되었습니다.');
					page = 1;
					fnMemberList();
					fnInit();
				} else {
					alert('회원 정보가 등록되지 않았습니다.');
				}
				
			},
			error: function(jqXHR) {
				alert(jqXHR.responseText + '(예외코드 ' + jqXHR.status + ')');
			}
		})
	})
}
  function fnInit() {
	$('#memberNo').val('');
	$('#id').val('').prop('disabled', false);
	$('#name').val('');
	$(':radio[value=none]').prop('checked', true);
	$('#address').val('');
	$('#btn_register').prop('disabled', false);
	$('#btn_modify').prop('disabled', true);
	$('#btn_remove').prop('disabled', true);
}
  
  // 전역 변수
  var page = 1;
  function fnMemberList() {
	$.ajax({
		type: 'get',
		url: '${contextPath}/members/page/' + page,
		dataType: 'json',
		success: function(resData) {
			$('#member_list').empty();
			$.each(resData.memberList, function(i, member) {
				var tr = '<tr>';
				tr += '<td><input type="checkbox" class="chk_one" value="' + member.memberNo + '"></td>';
				tr += '<td>' + member.id + '</td>';
				tr += '<td>' + member.name + '</td>';
				tr += '<td>' + member.gender + '</td>';
				tr += '<td>' + member.address + '</td>';
				tr +=  '<td><button type="button" class="btn_detail" data-member_no="' + member.memberNo + '">조회</button></td>';
				tr += '</tr>';
				$('#member_list').append(tr);
			})
			$('#paging').html(resData.paging);
		}
	})
}
  function fnAjaxPaging(p) {
	page = p;
	fnMemberList();
}
  function fnMemberDetail() {
	$(document).on('click', '.btn_detail', function() {
		$.ajax({
			type: 'get',
			url: '${contextPath}/members/' + $(this).data('member_no'),
			dataType: 'json',
			success: function(resData) {
				var member = resData.member;
				if(!resData){
					alert('회원 정보를 조회할 수 없습니다.');
				} else { 
					$('#memberNo').val(member.memberNo);
					$('#id').val(member.id).prop('disabled', true);
					$('#name').val(member.name);
					$(':radio[value=' + member.gender + ']').prop('checked', true);
					$('#address').val(member.address);
					$('#btn_register').prop('disabled', true);
					$('#btn_modify').prop('disabled', false);
					$('#btn_remove').prop('disabled', false);
				}
			}
			
		})
	})
}
  function fnMemberModify() {
	$('#btn_modify').click(function() {
		$.ajax({
			type: 'put',
			url: '${contextPath}/members',
			contentType: 'application/json',
			data: JSON.stringify({
				memberNo: $('#memberNo').val(),
				name: $('#name').val(),
				gender: $(':radio:checked').val(),
				address: $('#address').val()
			}),
			// 응답
			dataType: 'json',
			success: function(resData) {
				if(resData.modifyResult === 1){
					alert('회원 정보가 수정되었습니다.');
					fnMemberList();
				} else {
					alert('회원 정보가 수정되지 않았습니다.');
				}
			}
		})
	})
}
  function fnMemberRemove() {
	$('#btn_remove').click(function() {
		if(!confirm('회원정보를 삭제할까요?')){
			return;
			}
		$.ajax({
			type: 'delete',
			url: '${contextPath}/member/' + $('#memberNo').val(),
			dataType: 'json',
			success: function(resData) {
				if(resData.removeResult === 1){
					alert('회원 정보가 삭제 되었습니다.');
					page = 1;
					fnInit();
					fnMemberList();
				} else {
					alert('회원 정보가 삭제되지 않았습니다.');
				}
			}
		})
	})
}
  function fnRemoveMembers() {
	$('#btn_remove_list').click(function() {
		var arr = [];
		var chkOne = $('.chk_one');
		$.each(chkOne, function(i, elem) {
			 if($(elem).is(':checked')){
				 arr.push($(elem).val());
			 }
		
		})
		if(arr.length === 0){
			alert('선택된 회원 정보가 없습니다. 다시 시도하세요.');
			return;
		}
		$.ajax({
			type: 'delete',
			url: '${contextPath}/members/' + arr.join(','),
			dataType: 'json',
			success: function(resData) {
				if(resData.removeResult === arr.length){
					alert('선택한 회원 정보들이 삭제되었습니다.');
					page = 1;
					fnInit();
					fnMemberList();
					$('#chk_all').prop('checked', false);
				} else {
					alert('선택한 회원 정보들이 삭제되지 않았습니다.');
				}
			}
			
		})
	})
}
</script>
</head>
<body>
  
  <div>
    <h1>회원 관리하기</h1>
    <div>
      <label for="id">아이디</label>
      <input type="text" id="id">
    </div>
    <div>
      <label for="name">이름</label>
      <input type="text" id="name">
    </div>
    <div>
      <input type="radio" id="none" name="gender" value="none" checked="checked">
      <label for="none">선택안함</label>
      <input type="radio" id="man" name="gender" value="man" >
      <label for="man">남자</label>
      <input type="radio" id="woman" name="gender" value="woman">
      <label for="woman">여자</label>
    </div>
    <div>
      <label for="address">주소</label>
      <select id="address">
        <option value="" >:::선택:::</option>
        <option>서울</option>
        <option>경기</option>
        <option>인천</option>
      </select>
    </div>
      <input type="hidden" id="memberNo" >
    <div>
      <button type="button" onclick="fnInit()">초기화</button>
      <button type="button" id="btn_register">등록</button>
      <button type="button" id="btn_modify">수정</button>
      <button type="button" id="btn_remove">삭제</button>
    </div>
  </div>
  
  <hr>
    <div>
      <button type="button" id="btn_remove_list">선택삭제</button>
    </div>
  <div>
    <table border="1">
      <thead>
        <tr>
          <td><input type="checkbox" id="chk_all"><label for="chk_all">전체선택</label></td>
          <td>아이디</td>
          <td>이름</td>
          <td>성별</td>
          <td>주소</td>
          <td></td>
        </tr>
      </thead>
      <tbody id="member_list"></tbody>
      <tfoot>
        <tr>
          <td colspan="6" id="paging"></td>
        </tr>
      </tfoot>
    </table>
  </div>
  
</body>
</html>