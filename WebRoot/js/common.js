function dataList(u) {
	$('#tlist').datagrid({
		url : u,
		pagination : true,
		rownumbers : true,
		remoteSort : false,
		toolbar : [ {
			text : '新增',
			iconCls : 'icon-add',
			handler : function() {
				add();
			}
		} ]
	});
	$("#tlist").datagrid("getPager").pagination({
		displayMsg : '显示{from}-{to}/共{total}&nbsp;&nbsp;&nbsp;   '
	});
}