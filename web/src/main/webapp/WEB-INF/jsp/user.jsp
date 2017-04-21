<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
var userQueryParams = {};
$(function() {
	$('#user_grid').datagrid({
		url: './test/user.do',
		toolbar: '#user_toolbar',
		idField: 'id',
		queryParams: userQueryParams,
		columns: [[
			{field:'id',checkbox:true},
			{field:'username',width:100,title:'',sortable:true},
			{field:'password',width:100,title:'',sortable:true},
			{field:'gendar',width:100,title:'',sortable:true},
			{field:'telephone',width:100,title:'',sortable:true},
			{field:'birthday',width:100,title:'',sortable:true},
			{field:'remark',width:100,title:'',sortable:true}
		]]
	});
});

/**
 * 添加
 */
function userAdd() {
	openDialog('./test/useradd.do');
}

/**
 * 修改
 */
function userEdit() {
	var selRow = $('#user_grid').datagrid('getSelected');
	if(selRow==null){
		$.messager.alert('提示', '请先选择你要修改的项', 'info');
		return;
	}
	openDialog('./test/useredit.do?id='+selRow.id);
}

/**
 * 删除
 */
function userRemove() {
	var chekcedRows = $('#user_grid').datagrid('getChecked');
	if(chekcedRows==null || chekcedRows.length==0){
		$.messager.alert('提示', '请勾选你要删除的数据.', 'info');
		return;
	}

	var checkdIds = new Array();
	$.each(chekcedRows, function(i, row){
		checkdIds.push(row.id);
	});

	doDelete({
		url: './test/userdelete.do',
		data:{'ids':checkdIds.join(',')},
		success:function(data){
			$.messager.show({title:'提示', msg:'删除成功.', timeout:5000, showType:'slide'});
			$('#user_grid').datagrid();
		}
	});
}

/**
 * 搜索
 */
function userSearch() {
	$.extend(userQueryParams,{
	});
	$('#user_grid').datagrid();
}

</script>
<table id="user_grid" data-options="fit:true"></table>
<div id="user_toolbar" style="height:auto">
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="userAdd()">添加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="userEdit()">修改</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="userRemove()">删除</a>
	<div style="float:right">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="userSearch();">查询</a>
	</div>
</div>
