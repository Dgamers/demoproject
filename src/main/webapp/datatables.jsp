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
	src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">	
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/dataTables.bootstrap.min.css">
	
<title>Insert title here</title>

<script type="text/javascript">
$(function (){
	var table=$('#mytable').DataTable({
		serverSide:true,
		processing:true,
		pageLength:10,
		ordering:true,
		pagingType:"full_numbers",/* 除首页、上一页、下一页、末页四个按钮还有页数按钮 */
		autoWidth:false,
		stateSave:true,
		searching:false,
		ajax:{
			type:'get',
			url:'${pageContext.request.contextPath}/getdatas',
			dataSrc:"data",
			data:function(d){
				var param={};
				param.draw=d.draw;
				param.start=d.start;
				param.length=d.length;
				param.order=d.order;
				param.columns=d.columns;
				param.search_name=$("#search_name").val();
				param.search_phone=$("#search_phone").val();
				param.search_email=$("#search_email").val();
				return param;
			},
		},
		columns:[
			{"data":"id"},
			{"data":"name"},
			{"data":"phone"},
			{"data":"email"},
			{"data":"sex",
				render:function(data,type,row){
					if(data==1){
						return "男";
					}
					if(data==2){
						return "女";
					}
					if(data==3){
						return "保密";
					}
				}},
		],
		language: {
	        "sProcessing": "处理中...",
	        "sLengthMenu": "显示 _MENU_ 项结果",
	        "sZeroRecords": "没有匹配结果",
	        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
	        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
	        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
	        "sInfoPostFix": "",
	        "sSearch": "搜索:",
	        "sUrl": "",
	        "sEmptyTable": "表中数据为空",
	        "sLoadingRecords": "载入中...",
	        "sInfoThousands": ",",
	        "oPaginate": {
	            "sFirst": "首页",
	            "sPrevious": "上页",
	            "sNext": "下页",
	            "sLast": "末页"
	        },
	        "oAria": {
	            "sSortAscending": ": 以升序排列此列",
	            "sSortDescending": ": 以降序排列此列"
	        }
	    }
		
	});
	$("#start_search").click(function(){
		table.draw();
	})
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
		</div>
<table id="mytable" class="table table-striped table-bordered">
<thead>
<tr>
<th>ID</th>
<th>用户名</th>
<th>联系电话</th>
<th>邮件</th>
<th>性别</th>
</thead>

</table>

</body>
</html>