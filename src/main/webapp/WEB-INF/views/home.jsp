<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<form id="writeform" action="/insert" method="post">
		<div id="currentArea" class="minime-avatar-zone" style="width: 600px;">
			<div id="currentMinime" class="minime-avatar" style="display:;">
				<input id="email" name="email" style="width: 50%;"><input
					name="password" id="password" style="width: 50%;" value="asdasdas">
			</div>
			<input id="content" name="content"
				style="width: 100%; height: 300px;"></input> <input type="submit"
				style="right: 30dp" />
		</div>


	</form>
	<c:forEach var="guestBook" items="${ guestBookList }"
		varStatus="status">
		<div id="currentArea" class="minime-avatar-zone" style="width: 600px;">
			<div id="currentMinime" class="minime-avatar" style="display:;">
				<p style="width: 50%;margin-right: 50px;"> ${guestBook.email}</p>
				<p style="width: 20%;">${guestBook.createDate}</p>
				<button style="width: 50px; float: right;"></button>
				<input
					name="password" id="password" style="width: 20%; float: right;"type="password">
					
			</div>
			<input id="content" name="content" readonly="readonly" value="${guestBook.content}"
				style="width: 100%; height: 300px;"></input> 
				
		</div>
	
	</c:forEach>
	<!-- 	<tr>
													<td style="display: none;" id="index">${ sap.id }</td>
													<td
														class="col-lg-6 col-md-4 col-sm-4 overflow_hidden callinfo"><b>${ sap.title }</b></td>
													<td class="callinfo m-hide"><b>${ sap.respondentCnt }</b>
														참여</td>
													<td class="callinfo m-hide"><fmt:formatDate
															pattern="yy-MM-dd" value="${ sap.opendate }" /> ~ <fmt:formatDate
															pattern="yy-MM-dd" value="${ sap.deadline }" /></td>
													<td><a href="/statistics/${ sap.id }" id="joinbtn"
														class="btn">결과보기</a></td>
												</tr>
 -->



</body>
</html>
