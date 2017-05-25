<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/layouts/header.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户管理</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/CommonUtil.js?uuid=111" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
});

//刷新
function refresh(){
	// 刷新列表数据
	CommonUtil.refreshGrid("applyGrid");
}
</script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',border:false">
		<div id="tab" class="easyui-tabs" data-options="fit:true,border:false" style="">
			<div title="用户管理">
           		<table id="applyGrid" class="easyui-datagrid" title="" data-options="url:'${pageContext.request.contextPath}/user/queryUserList.do',rownumbers:true,fit:true,striped:true,singleSelect:false,pagination:true,fitColumns:true">
					<thead>
						<tr>
							<th data-options="field:'id',width:100,align:'center'">用户id</th>							
							<th data-options="field:'nickname',width:90,align:'center'">昵称</th>
							<th data-options="field:'state',width:60,align:'center'">状态</th>
						</tr>
					</thead>
				</table>
	        </div>
	     </div>
	</div>
</div>
</body>
</html>