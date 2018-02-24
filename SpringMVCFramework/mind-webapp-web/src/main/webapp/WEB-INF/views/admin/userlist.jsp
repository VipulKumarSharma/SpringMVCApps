<%@include file="../common/import.jsp"%>
<script >
   
   $(function () {
	    $("#list").jqGrid({
	    	url:'userList',
	    	mtype: 'POST',
	    	datatype: 'json',
	    	height: 350,
	    	width:getWidth("loginuser"),
	    	colNames:['#','User Name','First Name','Last Name','EMail'],
	       	colModel:[
	       		{name:'userId',index:'userId', width:60, sorttype:"int", search: true},
	       		{name:'loginName',index:'loginName', width:200, search: true},
	       		{name:'firstName',index:'firstName', width:200, search: true},
	       		{name:'lastName',index:'lastName', width:200, search: true},
	       		{name:'email',index:'email', width:200, search: true}
	       	],
	       	pager: "#pager",
	       	viewrecords: true,
	        shrinkToFit:false,
	       	caption: "User List",
	       		onSelectRow: function(ids) {
	       			//alert(ids);
	       		}
	    });
	    jQuery("#list")
	    .navGrid('#pager',{edit:false,add:false,del:false,search:false})
	    .navButtonAdd('#pager',{
	    	caption:"", 
	       buttonicon:"ui-icon-plus", 
	       onClickButton: function(){ 
	         //alert("Adding Row");
	         window.location.href="${pageContext.request.contextPath}/siteadmin/adduser"
	       }, 
	       position:"last"
	    })
	    .navButtonAdd('#pager',{
	    	caption:"", 
	       buttonicon:"ui-icon-pencil", 
	       onClickButton: function(){
	    	  // alert(jQuery("#list").getRowData(jQuery("#list").jqGrid('getGridParam', 'selrow')).userId);
	    	   window.location.href="${pageContext.request.contextPath}/siteadmin/edituser/"+jQuery("#list").getRowData(jQuery("#list").jqGrid('getGridParam', 'selrow')).userId;
	       }, 
	       position:"last"
	    })
	    .navButtonAdd('#pager',{
	       caption:"", 
	       buttonicon:"ui-icon-cancel", 
	       onClickButton: function(){ 
	    	  var selRow = jQuery("#list").getRowData(jQuery("#list").jqGrid('getGridParam', 'selrow')).userId;
	    	  deleteRole(selRow);
	       }, 
	       position:"last"
	    });
	   // jQuery("#list").jqGrid('filterToolbar',{});
   });
   
   function deleteRole(roleId){
	   var data = {
	        	"id":roleId
	        }; 
		$.ajax({
		    url : "${pageContext.request.contextPath}/siteadmin/deleterole",
		    type : "POST",
		    data : JSON.stringify(data),
		    dataType: "json",
		        contentType: 'application/json', 
		    success : function(data) {
		        alert("Role deleted successfully !!!");
		        jQuery("#list").trigger("reloadGrid");
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
    		<h3><spring:message code='userlist.heading' /></h3>
  		</div>
  		<table id="list"></table> 
   		 <div id="pager"></div> 
</div><!--/span-->
</div>