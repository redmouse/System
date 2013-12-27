<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script>
<title>Test Popup</title>
</head>
<script type="text/javascript">
//声明全局变量
var pop_window;
function less_pop(){
 var returnValue = window.showModalDialog("pop_child.jsp",window,"dialogWidth:300px;dialogHeight:300px;scroll:no;status:no");
	if(returnValue!=null){
		document.getElementById("father_textarea").value = returnValue;
	}
}
function less_open(){
	pop_window = window.open("pop_child_open.jsp","","height=300,width=400,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
}

</script>

<body>

<form action="Linkage" method="post"> 
  <input type="button" id="lessPop" name="lessPop" onclick="less_pop();" value="lessPop">
  <input type="button" id="lessOpen" name="lessOpen" onclick="less_open();" value="lessOpen">
  <textarea id="father_textarea" rows="5" cols="20"></textarea>
</form> 

</body>
</html>