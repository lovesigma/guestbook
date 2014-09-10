<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<form id="writeform" action="/insert" method="post" >
	<div id="currentArea" class="minime-avatar-zone" style="width: 600px;">
	  <div id="currentMinime" class="minime-avatar" style="display:;">
			<input id="email"  name="email" style="width: 50%;"><input name="password" id="password" style="width: 50%;" value="asdasdas">
	  </div>
    <input id="content" name="content" style="width:100%;height:300px;"></input>
    <input type="submit" style="right: 30dp"/>  
	</div>
	
	 
</form>


  
</body>
</html>
