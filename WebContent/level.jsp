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
$(document).ready(function(){
	$("#level1Id").change(function(){
		$("#level2Area").load("Linkage",{level1Id:$("#level1Id  option:selected").val()});
		});
});
function level2_changed(){
	$("#level3Area").load("Linkage",{level2Id:$("#level2Id  option:selected").val()});
}
</script>

<body>

<form action="Linkage" method="post" enctype="multipart/form-data"> 
  <input type="file" name="file"> 
  <input type="submit" name="Submit" value="upload">
  <br/> 
  <input type="text" name="testBox" value ="xxxxxx"><c:out value="${testString}"/>
  <br/>
  <select id="level1Id">
	  <option value ="0">選択</option>
	  <c:forEach items="${linkageBean.mst001List}" var="mst001Bean">
        <option value ="${mst001Bean.level1Id}" 
          <c:if test="${mst001Bean.level1Id == linkageBean.selectedLevel1Id }"> selected </c:if>
        ><c:out value="${mst001Bean.name}"/>
        </option>
      </c:forEach>
  </select>
  <span id="level2Area">
  <select id="level2Id" onChange="level2_changed()">
      <option value ="0">選択</option>
	  <c:forEach items="${linkageBean.mst002List}" var="mst002Bean">
          <option value ="${mst002Bean.level2Id}" 
            <c:if test="${mst002Bean.level2Id == linkageBean.selectedLevel2Id }"> selected </c:if>
          ><c:out value="${mst002Bean.name}"/></option>
      </c:forEach>
  </select>
  <span id="level3Area">
  <select id="level3Id">
	  <option value ="0">選択</option>
	  <c:forEach items="${linkageBean.mst003List}" var="mst003Bean">
          <option value ="${mst003Bean.level3Id}" 
            <c:if test="${mst003Bean.level3Id == linkageBean.selectedLevel3Id }"> selected </c:if>
        ><c:out value="${mst003Bean.name}"/></option>
      </c:forEach>
  </select>
  </span>
  </span>  
  <input type="submit" value="Submit" />
  <input type="button" id="btnLinkage" name="btnLinkage" value="btnLinkage">
  <input type="button" id="btnLinkage1" name="btnLinkage1" value="btnLinkage1">
</form> 

</body>
</html>