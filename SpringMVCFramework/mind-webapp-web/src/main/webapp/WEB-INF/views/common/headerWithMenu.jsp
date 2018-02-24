<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
          </div>
          <div class="navbar-collapse collapse">
        
            <!-- Left nav -->
            <%-- <c:forEach items="${headerDTO.userMenuDTOs}" var="userMenuDTO"> --%>
             Menu
            <ul class="nav navbar-nav">
             <li><a href="#"> Menu</a>
                <ul class="dropdown-menu">
                 <%-- <c:forEach items="${userMenuDTO.menuDTOs}" var="menus"> --%>
                  <%-- <spring:message code='${menus.keyValue}' var="submenutext"/> --%>
                <li><a href="${pageContext.request.contextPath}/siteadmin/displayuserlist">User</a></li>
               
                <%-- </c:forEach> --%>
             </ul>
             </li>
             </ul>
             <%-- </c:forEach> --%>
                    
        
            <ul class="nav navbar-nav navbar-right" id="loginuser">
            	<li><a href="${pageContext.request.contextPath}/home"><i class="glyphicon glyphicon-home" ></i>&nbsp;<spring:message code='header.home' /></a></li>
             	<li><a href="#">${loginUser}</a>
					<ul class="dropdown-menu">
						<li ><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;<spring:message code='header.profile' /></a></li>
						<li class="divider"></li>
						<li><a href="${pageContext.request.contextPath}/<c:url value="j_spring_security_logout" />"><span class="glyphicon glyphicon-log-out"></span>&nbsp;<spring:message code='header.logout' /></a></li>
					</ul>
				</li>
				
				</ul>
          
          </div><!--/.nav-collapse -->
        		
				
      </div>