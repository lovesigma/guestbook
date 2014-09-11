<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<script src="//code.jquery.com/jquery.js"></script>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<form id="writeform" action="/insert" method="post">
		<div id="currentArea" class="minime-avatar-zone" style="width: 600px;">
			<div id="currentMinime" class="minime-avatar" style="display:;">
				<input id="email" name="email" style="width: 50%;" placeholder="Email Address"><input
					name="password" id="password" style="width: 50%;" type="password"  placeholder="Password">
			</div>
			<input id="content" name="content"
				style="width: 100%; height: 300px;"></input> <input type="button" value="방명록남기기" onclick="validateEmail()"
					 placeholder="내용을 입력하세요~!"
				style="right: 30dp" />
		</div>

	</form>
	<c:forEach var="guestBook" items="${ guestBookList }"
		varStatus="status">
		<form id="change" action="/change" method="post">
			<div id="currentArea" class="minime-avatar-zone"
				style="width: 600px; margin-top: 50px">
				<div style="background: #B7F0B1;">
					<div id="currentMinime" class="minime-avatar" style="display:;">
						<p style="width: 50%; margin-right: 50px;">${guestBook.email}</p>
						<p style="width: 20%;">${guestBook.createDate}</p>
						<input style="width: 50px; float: right;" type="button"
							onclick="isVaildPassword(${guestBook.id})" value="수정"
							id="${guestBook.id}changeBtn"> <input
							style="width: 50px; float: right;" type="submit" hidden="true"
							id="${guestBook.id}changeCompleteBtn" value="확인"> <input
							name="password" id="${guestBook.id}password"
							style="width: 20%; float: right;" type="password"> <input
							name="id" id="id" hidden="true" value="${guestBook.id}">
					</div>
					<input id="${guestBook.id}content" name="content"
						readonly="readonly" value="${guestBook.content}"
						style="width: 100%; height: 300px;"></input>
				</div>
			</div>
		</form>
	</c:forEach>
	<script type="text/javascript">
	function validateEmail() {
		var email = $("#email").val();
	    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	    if(re.test(email)){
	    	document.getElementById("writeform").submit();
	    }
	    else{
	    	alert("Email형식이 올바르지 못합니다.")
	    }
	} 
	</script>
	<script type="text/javascript">
		// Get the <datalist> and <input> elements.
		
		var request = new XMLHttpRequest();
		// Handle state changes for the request.
		var targetId;
		request.onreadystatechange = function(response) {
			if (request.readyState === 4) {
				if (request.status === 200) {
					// Parse the JSON
					if(request.responseText=='true'){
						alert('true');
						$("#"+targetId+"content").attr("readonly", false);
						$("#"+targetId+"changeBtn").attr("hidden",true);
						$("#"+targetId+"changeCompleteBtn").attr("hidden",false);
					}
					else{
						alert('false');
					}

				} else {
				}
			}
		};
		// Update the placeholder text.
		function isVaildPassword(id) {
			// Set up and make the request.
			
			var password = $("#"+id+"password").val();
			request.open('GET', '/isValidPassword?id='+id+'&password='+password,
					true);
			request.send();
			targetId = id;
		}
	</script>
</body>
</html>
