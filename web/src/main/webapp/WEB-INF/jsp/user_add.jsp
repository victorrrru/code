<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="user_add_dlg" class="easyui-dialog" title="添加??" style="width:400px;height:500px;padding:10px" data-options="buttons:'#user_add_dlg_buttons',resizable:true,modal:true,maximizable:true,onClose:function(){$(this).dialog('destroy');}">
	<script type="text/javascript">
	$(function(){
		$('#user_add_form').form({
			success: function(data) {
				if ( typeof data == "string") {
					data = jQuery.parseJSON(data);
				}
				if (data.result == 0) {
					$.messager.alert('错误', data.message, 'error');
				} else {
					$.messager.show({title:'提示', msg:'添加成功.', timeout:5000, showType:'slide'});
					$('#user_add_dlg').dialog('destroy');
					$('#user_grid').datagrid();
				}
			}
		});
	});
	</script>
	<form id="user_add_form" method="post" action="./test/useradd.do">
		<table class="form_table" width="100%">
			<tr class="form_row">
				<td class="field_name">
					<label for="user_username">:<span class="required">*</span></label>
				</td>
				<td class="field">
					<input type="text" id="user_username" name="user.username" class="easyui-validatebox" data-options="required:true,validType:['maxlength[50]']" />
				</td>
			</tr>
			<tr class="form_row">
				<td class="field_name">
					<label for="user_password">:<span class="required">*</span></label>
				</td>
				<td class="field">
					<input type="text" id="user_password" name="user.password" class="easyui-validatebox" data-options="required:true,validType:['maxlength[50]']" />
				</td>
			</tr>
			<tr class="form_row">
				<td class="field_name">
					<label for="user_gendar">:<span class="required">*</span></label>
				</td>
				<td class="field">
					<input type="text" id="user_gendar" name="user.gendar" class="easyui-validatebox" data-options="required:true,validType:['maxlength[50]']" />
				</td>
			</tr>
			<tr class="form_row">
				<td class="field_name">
					<label for="user_telephone">:<span class="required">*</span></label>
				</td>
				<td class="field">
					<input type="text" id="user_telephone" name="user.telephone" class="easyui-validatebox" data-options="required:true,validType:['maxlength[50]']" />
				</td>
			</tr>
			<tr class="form_row">
				<td class="field_name">
					<label for="user_birthday">:<span class="required">*</span></label>
				</td>
				<td class="field">
					<input type="text" id="user_birthday" name="user.birthday" class="easyui-my97" data-options="required:true" />
				</td>
			</tr>
			<tr class="form_row">
				<td class="field_name">
					<label for="user_remark">:</label>
				</td>
				<td class="field">
					<input type="text" id="user_remark" name="user.remark" class="easyui-validatebox" data-options="validType:['maxlength[50]']" />
				</td>
			</tr>
		</table>
	</form>
</div>
<div id="user_add_dlg_buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#user_add_form').submit()">添加</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="$('#user_add_dlg').dialog('destroy')">取消</a>
</div>
