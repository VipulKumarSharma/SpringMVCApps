<!DOCTYPE html>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>



<html>
<head>
<meta charset="utf-8">
    <title><spring:message code='title.project.name' /></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
	<link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/css/overcast/jquery-ui-1.10.4.custom.min.css' />" />
	<link rel="stylesheet" type="text/css" media="screen" href="<c:url value='/resources/css/ui.jqgrid.css' />" />
	<link href="<c:url value='/resources/css/custom.css' />" rel="stylesheet">
	<link href="<c:url value='/resources/css/datepicker.css' />" rel="stylesheet" type="text/css" media="screen">
	<link href="<c:url value='/resources/css/jquery.smartmenus.bootstrap.css' />" rel="stylesheet" type="text/css" media="screen">
	<link rel="stylesheet" href="<c:url value='/resources/css/bootstrapValidator.min.css' />"/>
	
	<script src="<c:url value='/resources/js/jquery-1.11.0.min.js' />" type="text/javascript"></script>
	<script src="<c:url value='/resources/js/bootstrap.min.js' />" type="text/javascript"></script>
	<script src="<c:url value='/resources/js/i18n/grid.locale-en.js' />" type="text/javascript"></script>
	<script src="<c:url value='/resources/js/jquery.jqGrid.min.js' />" type="text/javascript"></script>
   	<script src="<c:url value='/resources/js/custom.js' />" type="text/javascript"></script>
   	<script src="<c:url value='/resources/js/bootstrap-datepicker.js' />" type="text/javascript"></script>
 	<script src="<c:url value='/resources/js/jquery.smartmenus.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery.smartmenus.bootstrap.js' />" type="text/javascript"></script>
    <script type="text/javascript" src="<c:url value='/resources/js/bootstrapValidator.min.js' />"></script>	
<script type="text/javascript">

</script>
</head>

<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <tiles:insertAttribute name="header" />
    </div>
    
    <div class="container">
        <tiles:insertAttribute name="mainBody" />
      <hr>
     <tiles:insertAttribute name="footer" />
    </div><!--/.fluid-container-->
    
</body>

</html>
