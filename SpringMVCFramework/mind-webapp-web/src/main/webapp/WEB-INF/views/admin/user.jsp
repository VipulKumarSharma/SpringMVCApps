<%@include file="../common/import.jsp"%>
<script>
	function submitForm(){
		if('${page}' == 'add'){
			document.forms[0].action="${pageContext.request.contextPath}/siteadmin/saveuser";
		}else if('${page}' == 'edit'){
			document.forms[0].action="${pageContext.request.contextPath}/siteadmin/updateuser";
		} 
		document.forms[0].submit();
	}
	function cancel(){
		document.forms[0].method="GET"
		document.forms[0].submit();
	}
	function getSites(){
		var companyId = $("#companyId").val();
		var data = {
	        	"id":companyId
	        }; 
		$.ajax({
		    url : "${pageContext.request.contextPath}/siteadmin/siteList",
		    type : "POST",
		    data : JSON.stringify(data),
		    dataType: "json",
		    contentType: 'application/json', 
		    success : function(data) {
		    	  $('select#siteIds').find('option').each(function()  
    			   {  
    			    	$(this).remove();  
    			   });   
		    	  $("#siteIds").append("<option value='0'>----Select Site----</option>");
	   			   $.each(data.options, function() {  
		   			 $("#siteIds").append("<option value='"+this.id+"'>"+this.site+"</option>");
	   			   });  
	   			 $('select#approverRoleIds').find('option').each(function()  
	      			   {  
	      			    	$(this).remove();  
	      			   });   
	   			$("#approverRoleIds").append("<option value='0' disabled='true'>--- Select System Role ---</option>");
		    },
		    error : function(data, status){
		    	 alert("Error Occured !!!");
		    }
		}
		);
	}
	function getApproverRoles(){
		var siteId = $("#siteIds").val();
		var data = {
	        	"id":siteId
	        }; 
		$.ajax({
		    url : "${pageContext.request.contextPath}/siteadmin/approverRoleListBySite",
		    type : "POST",
		    data : JSON.stringify(data),
		    dataType: "json",
		    contentType: 'application/json', 
		    success : function(data) {
		    	  $('select#approverRoleIds').find('option').each(function()  
    			   {  
    			    	$(this).remove();  
    			   });   
		    	  $("#approverRoleIds").append("<option value='0' disabled='true'>--- Select System Role ---</option>");
	   			   $.each(data.options, function() {  
		   			 $("#approverRoleIds").append("<option value='"+this.id+"'>"+this.approverRole+"</option>");
	   			   });  
		    },
		    error : function(data, status){
		    	 alert("Error Occured !!!");
		    }
		}
		);
	}
</script>
       <div class="row">
            <div class="col-lg-12">
        <div class="page-header">
    		<h3>
    		<c:if test="${page == 'add'}">
    			<spring:message code='user.addpage.heading' />
			</c:if>
			<c:if test="${page == 'edit'}">
    			<spring:message code='user.editpage.heading' />
			</c:if>
    		</h3>
  		</div>
 	<form:form id="userForm" commandName="userDTO"
		method="POST" action="${pageContext.request.contextPath}/siteadmin/displayuserlist" class="form-horizontal" >
    <form:hidden path="userId" />
    <fieldset>
        <spring:message code='user.username' var="placeholderusername"/>
        <spring:message code='user.password' var="placeholderpassword"/>
        <spring:message code='user.firstname' var="placeholderfirstname"/>
        <spring:message code='user.lastname' var="placeholderlastname"/>
        <spring:message code='user.email' var="placeholderemail"/>
        <spring:message code='user.mobileno' var="placeholdermobileno"/>
        <spring:message code='user.empcode' var="placeholderempcode"/>
        
      
      <div class="form-group">
        <label class="col-xs-2 control-label" for="rolename"><spring:message code="user.username"/></label>
        <div class="col-xs-10">
        <form:input cssClass="form-control" path="loginName" maxlength="512" placeholder="${placeholderusername}"/>
          <!-- Error will come here. -->
        </div>
      </div>
       <div class="form-group">
        <label class="col-xs-2 control-label" for="roledesc"><spring:message code='user.password' /></label>
        <div class="col-xs-10">
          <form:input cssClass="form-control" path="password"  />
          <!-- Error will come here. -->
        </div>
      </div>
       <div class="form-group">
        <label class="col-xs-2 control-label" for="roledesc"><spring:message code='user.passwordconfirm' /></label>
        <div class="col-xs-10">
          
          <form:input cssClass="form-control" path="confirmPassword"  />
          <!-- Error will come here. -->
        </div>
      </div>
      <legend><small><spring:message code="user.personalinfo"/></small></legend>
      <div class="form-group">
        <label class="col-xs-2 control-label" for="rolename"><spring:message code="user.firstname"/></label>
        <div class="col-xs-10">
        <form:input cssClass="form-control" path="firstName" maxlength="512" placeholder="${placeholderfirstname}"/>
          <!-- Error will come here. -->
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label" for="rolename"><spring:message code="user.lastname"/></label>
        <div class="col-xs-10">
        <form:input cssClass="form-control" path="lastName" maxlength="512" placeholder="${placeholderlastname}"/>
          <!-- Error will come here. -->
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label" for="rolename"><spring:message code="user.email"/></label>
        <div class="col-xs-10">
        <form:input cssClass="form-control" path="email" maxlength="512" placeholder="${placeholderemail}"/>
          <!-- Error will come here. -->
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label" for="rolename"><spring:message code="user.mobileno"/></label>
        <div class="col-xs-10">
        <form:input cssClass="form-control" path="mobileNumber" maxlength="512" placeholder="${placeholdermobileno}"/>
          <!-- Error will come here. -->
        </div>
      </div>
      <div class="form-group">
        <label class="col-xs-2 control-label" for="rolename"><spring:message code="user.empcode"/></label>
        <div class="col-xs-10">
        <form:input cssClass="form-control" path="empCode" maxlength="512" placeholder="${placeholderempcode}"/>
          <!-- Error will come here. -->
        </div>
      </div>
       
      <div class="form-group">
				<div class="col-xs-offset-2 col-xs-10">
					<button type="button" class="btn btn-primary"
						onclick="submitForm()">
						<c:if test="${page == 'add'}">
							<spring:message code='button.save' />
						</c:if>
						<c:if test="${page == 'edit'}">
							<spring:message code='button.update' />
						</c:if>
					</button>
					<button class="btn" onclick="cancel()">
						<spring:message code='button.cancel' />
					</button>
				</div>
			</div>
    </fieldset>
	  </form:form>
        </div><!--/span-->
       
