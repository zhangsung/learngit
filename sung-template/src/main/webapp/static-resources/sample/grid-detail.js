/**
 * @file datagrid detail
 * @author Double
 */

'use strict';

$(function() {
	
	var datagridElement = '#datagridExp',
 	columns = [ {
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
			return '<a title="点击显示弹窗" onclick="$(\'#dialogElement\').showDialog();">' + value + '</a>';
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
		idField : 'id',
		columns : [ columns ],
		sortName : 'birthday',
		sortOrder : 'desc',
		pagination : true,
		fitColumns : true,
		crossPageSwitch : true,
		detailView : true,
		detailFormatter : function(index, row){
            return '<div>idField: ' + row[$(datagridElement).datagrid('options').idField] + '</div>';
        }
	};
	
	//创建easyUI datagrid
	$(datagridElement).datagridEasyUI(options); 
	
	//查询按钮
	$('#searchBtn').click(function() { 
		$(datagridElement).datagrid('load', serializeObject($('#searchForm')));
	});
	
	//删除按钮
	$('#delBtn').click(function() { 
//		$(datagridElement).deleteRowsEasyUI();
		var rows = $(datagridElement).datagrid('getChecked'), idField = $(datagridElement).datagrid('options').idField; 
		if (rows.length) {
			confirmDialog('确定要删除吗?', function() {
				var ids = [];
				for (var i=0; i<rows.length; i++) {
					ids.push(rows[i][idField]);
				}
				confirmDialog(ids);
			});
		} else {
			confirmDialog('请选择要删除的数据。');
		}
	});
	
	//下载按钮
	$('#dldBtn').click(function() { 
		$(datagridElement).downloadFileEasyUI('*.excel', '#searchForm', '#dldBtn');
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
	
});

//请求体
var $index = {
	update : function() {
		var update = new nssoft.openApi.update.api();
		$.each($('#dialogElement form').serializeArray(), function(index, field) {
			update.addParam(field.name, field.value);
		});
		update.request({
			method : 'POST',
			async : false,
			url : './ServiceAPI/auth/getSession.json'
		});
	}
};

//回调函数
(function() {
	$class('nssoft.openApi.update.api').extend(nssoft.absAPI).define({
		onSuccess : function(status, res) {
			var result = res.result;
			if (res.errCd === 0 && result && result.success) {
				//do something
				
			} else {
				confirmDialog(result.msg || res.errMsg);
			}
		},
		onFail : function(status) {
			confirmDialog('发生错误');
		}
	});
}());
