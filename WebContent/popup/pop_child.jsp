<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<title>Test linkage</title>
</head>
<script type="text/javascript">
//window.dialogArguments 父窗口传来的参数     
var fatherWin = window.dialogArguments;
function return_value(){
	window.returnValue = document.getElementById("child_textarea").value;
	window.close();
}

</script>

<body onblur="self.focus();">

<form> 
  <textarea id="child_textarea" rows="5" cols="20"></textarea>
  <input type="button" onclick="return_value();" value="returnValue">
  <input type="button" onclick="window.close();" value="cancel">
</form> 

</body>
</html>