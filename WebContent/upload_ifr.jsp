<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8" />
    <title>xxxxxx</title>
</head>
<body>
    <script type="text/javascript">
    function callback_func(msg){
    	alert(msg);
    }
    
    </script> 
    <iframe name="ajaxifr" style="display:none;"></iframe>
    <form action="UploadIfr" method="post" enctype="multipart/form-data" target="ajaxifr">
    file:<input type="file" name="upfile" /><br/>
    <input type="submit" value="upload" />
    </form>
    <div id="ajaxMsg"></div>
</body>
</html>