<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title><spring:message code='title.project.name' /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
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
	

</head>

<body>
		<div class="container">
		 <div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-header" >
				<a class="navbar-brand" href="#">Project name</a>
			</div>
			</div>
		</div>
		<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<form:form id="loginForm" commandName="loginDTO" method="POST"
					action="${pageContext.request.contextPath}/j_spring_security_check"
					cssClass="form-horizontal" >

					<div class="page-header">
					<h3>
						<spring:message code='heading.signin' />
					</h3>
					</div>
					<spring:message code='placeholder.username'	var="placeholderusername" />
					<spring:message code='placeholder.password'	var="placeholderpassword" />
					<spring:message code='login.username.required'	var="msg_username_reqired" />
					<spring:message code='login.password.required'	var="msg_password_reqired" />
					<c:if test="${not empty error}">
						<div class="alert alert-danger">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="alert alert-danger">${msg}</div>
					</c:if>
					<div class="form-group">
						<label class="col-xs-2 control-label" for="rolename"> <spring:message
								code="placeholder.username" />
						</label>
						<div class="col-xs-10">
							<form:input cssClass="form-control" path="j_username"
								maxlength="512" placeholder="${placeholderusername}" required="required" data-bv-notempty-message="${msg_username_reqired}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-xs-2 control-label" for="rolename"> <spring:message
								code="placeholder.password"  />
						</label>
						<div class="col-xs-10">
							<form:password cssClass="form-control" path="j_password"
								maxlength="24" placeholder="${placeholderpassword}" required="required"  data-bv-notempty-message="${msg_password_reqired}"/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-xs-offset-2 col-xs-10">
							<button type="submit" class="btn btn-primary" >
								<spring:message code='btn.signin' />
							</button>
						</div>
					</div>
				</form:form>
				<hr>
				<footer>
					<p>
						<spring:message code='footer.copyright' />
					</p>
				</footer>
			</div>
		</div>
</div>
	<!--/.fluid-container-->
</body>
<script type="text/javascript">
	$(document).ready(function() {
		$('#loginForm').bootstrapValidator();
	});
</script>
</html>
