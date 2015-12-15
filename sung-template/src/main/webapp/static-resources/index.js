/**
 * @file datagrid example
 * @author Double
 * @date: 2015/08/19 16:00
 * @version: V1.0
 */

'use strict';

$(function() {
	
	var columns = [ {
		field : 'ck',
		checkbox : true
	}, {
		field : 'id',
		title : 'id',
		hidden : true
	}, {
		field : 'name',
		title : 'name',
		width : 100,
		formatter : function(value, row, index) {
			return '<a target="_blank" title="点击新开页面" href="detail.html">' + value + '</a>';
		}
	}, {
		field : 'email',
		title : 'email',
		width : 100,
		formatter : function(value, row, index) {
			return '<a title="点击显示弹窗" onclick="$index.loadDetail(\'' + row[$($index.datagrid).datagrid('options').idField] + '\');">' + value + '</a>';
		}
	}, {
		field : 'birthday',
		title : 'birthday',
		width : 100,
		sortable : true
	}, {
		field : 'tel',
		title : 'tel',
		width : 100
	}, {
		field : 'options',
		title : '操作',
		width : 30,
		align : 'center',
		formatter : function(value, row, index) {
			return '<button class="btnDefault btnSmall" onclick="confirmDialog(\'My email is ' + row.email + '\')">按钮</button>';
		}
	} ],
 	options = {
		url : '/v1/api/test/sample/table.json',
		columns : [ columns ],
		sortName : 'birthday',
		sortOrder : 'desc',
		pagination : true,
		fitColumns : true,
		crossPageSwitch : true
	};
	
	//创建easyUI datagrid
	$($index.datagrid).datagridEasyUI(options); 
	
	//查询按钮
	$('#searchBtn').click(function() { 
		$($index.datagrid).datagrid('load', serializeObject($('#searchForm')));
	});
	
	//删除按钮
	$('#delBtn').click(function() { 
		
		var rows = $($zipcode.datagrid).datagrid('getChecked'); 
		if (rows.length) {
			confirmDialog('共选择' + rows.length + '条数据,确定要删除吗?', function() {
				var idFields = ['id'], ids = $($index.datagrid).getIdsDatagridEasyUI(idFields);
				confirmDialog(ids);
//				$index.deleteZipcode(ids);
			});
		} else {
			confirmDialog('请选择要删除的数据。');
		}
		
	});
	
	//下载按钮
	$('#dldBtn').click(function() { 
		$($index.datagrid).downloadFileEasyUI('*.excel', '#searchForm', '#dldBtn', ['id']);
	});
	
	//弹框确认按钮
	$('#okBtn').click(function() { 
		confirmDialog('确认要修改吗?', function() {
			$index.update();
		});
	});
	
	//模拟赋值--datepicker, 实际赋值时根据具体情况
	var today = new Date();
	$('.endDate').val(formatDate(today));
	today.setMonth(today.getMonth() - 6);
	$('.startDate').val(formatDate(today));
	
	//创建jQueryUI datepicker
	$('.startDate, .endDate').datepickerJQueryUI();
	
	
	$index.menu();
});

//请求体
var $index = {
	datagrid : '#datagridExp',
	loadDetail : function(id) {
		var formData = {'idField' : id, 'selectLarge' : 'F', 'inputLarge' : 'inputLarge', 'textareaFit' : 'textareaFit\n\ttextareaFit'};
		$('#dialogElement form').form('load', formData);
		$('#dialogElement').showDialog();
	},
	update : function() {
		$($index.datagrid).datagrid('updateRow',{
			index: $($index.datagrid).datagrid('getRowIndex', $('#dialogElement form .idField').val()),
			row: serializeObject($('#dialogElement form'))
		});
		$('#dialogElement').hide();
	},
	deleteRows : function() {
		$($index.datagrid).datagrid('reload');
	},
	menu : function() {
		var menu = new nssoft.openApi.menu.api();
		menu.request({
			method : 'POST',
			async : false,
			url : '/v1/api/common/menu.json'
		});
	}
};

//回调函数
(function() {
	$class('nssoft.openApi.update.api').extend(nssoft.absAPI).define({
		onSuccess : function(status, res) {
			if (res.errCd === 0) {
				var result = res.result;
				if (result) {
					confirmDialog(result.msg);
					//do something
				}
			} else {
				confirmDialog(res.errMsg);
			}
		},
		onFail : function(status) {
			confirmDialog('发生错误');
		}
	});
}());

//回调函数
(function() {
	$class('nssoft.openApi.modifyZipcode.api').extend(nssoft.absAPI).define({
		onSuccess : function(status, res) {
			if (res.errCd === 0) {
				var result = res.result;
				if (result) {
					confirmDialog(result.msg);
					//do something
				}
			} else {
				confirmDialog(res.errMsg);
			}
		},
		onFail : function(status) {
			confirmDialog('发生错误');
		}
	});
}());

(function() {
	$class('nssoft.openApi.menu.api').extend(nssoft.absAPI).define({
		onSuccess : function(status, res) {
			if (res.errCd === 0) {
				var result = res.result;
				if (result) {
					localStorage.menu = JSON.stringify(result);
				}
			} else {
				confirmDialog(res.errMsg);
			}
		},
		onFail : function(status) {
			confirmDialog('发生错误');
		}
	});
}());
