<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-table.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-table.min.css">
<script type="text/javascript">
$(function(){
	$("#table").bootstrapTable({
		url:'${pageContext.request.contextPath}/getcustomers',
		method:'get',
		pagination:true,
		pageNumber:1,
		pageSize:10,
		pageList:[10,'all'],
		toolbar:'#toolbar',
		uniqueId:"id",
		sortable:false,
		sortOrder:"asc",
		sidePagination:"server",
		queryParamsType:"",
		undefinedText:'无',
		showRefresh:true,
		showToggle:true,
		queryParams:queryParams=function(params){
			return {
				pageSize:params.pageSize,
				pageNumber:params.pageNumber,
				search_name:$("#search_name").val(),
				search_phone:$("#search_phone").val(),
				search_email:$("#search_email").val(),
			};
		},
		striped:true,
		columns:[{
			field:'id',
			title:'id',
			sotable:true
		},{
			field:'name',
			title:'用户名'
		},{
			field:'phone',
			title:'联系号码'
		},{
			field:'email',
			title:'邮件'
		},{
			field:'sex',
			title:'性别',
			formatter:function(value,row,index){
				if(value==1){
					return '男';
				}
				if(value==2){
					return '女';
				}
				if(value==3){
					return '保密';
				}
			}
		}]
	});
	
	$("#start_search").click(function(){
		$("#table").bootstrapTable('refresh');
	});
});

</script>
</head>
<body>
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-heading">查询条件</div>
			<div class="panel-body">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1"
							for="search_name">用户名</label>
						<div class="col-sm-2">
							<input type="text" class="form-control"
								id="search_name">
						</div>
						<label class="control-label col-sm-1" for="search_email">邮件</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="search_email">
						</div>
						
			            <label class="control-label col-sm-1" for="search_phone">联系电话</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" id="search_phone">
						</div>
						<div class="col-sm-2" style="text-align: left;">
							<button type="button" style="margin-left: 50px" id="start_search"
								class="btn btn-primary">查询</button>
						</div>
					</div>
				</form>
			</div>
		</div>

		<table id="table"></table>
	</div>
</body>
</html>