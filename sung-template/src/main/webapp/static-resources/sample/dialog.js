'use strict';

$(function() {
	
	//模拟赋值--datepicker, 实际赋值时根据具体情况
	var today = new Date();
	$('.endDate').val(formatDate(today));
	today.setMonth(today.getMonth() - 6);
	$('.startDate').val(formatDate(today));
	
	//创建jQueryUI datepicker
	$('.startDate, .endDate').datepickerJQueryUI();
	
	//显示基本弹窗
	$('#btnShowDialog').click(function() {
		$('#dialog').showDialog();
	});
	
	//显示扩展弹窗
	$('#btnShowExtendDialog').click(function() {
		//模拟数据
		var data = {
			"id":"sample_table_tables",
			"result":{
				"total":5,
				"summarys":null,
				"rows":[{"birthday":"2015-01-08","name":"1111","tel":"15243434343","email":"121@qq.com"},
						{"birthday":"2015-01-08","name":"1111","tel":"15243434343","email":"121@qq.com"},
						{"birthday":"2015-01-08","name":"1111","tel":"15243434343","email":"121@qq.com"},
						{"birthday":"2015-01-08","name":"1111","tel":"15243434343","email":"121@qq.com"},
						{"birthday":"2015-01-08","name":"1111","tel":"15243434343","email":"121@qq.com"}]},
				"errMsg":"Success",
				"errCd":0,
				"trId":"*oqc_sample_table_tables_1439779290668"
		};
		
		var datagridElement = '#popupVerticalTable',
	 	columns = [ {
			field : 'name',
			title : 'name',
			width : 100
		}, {
			field : 'email',
			title : 'email',
			width : 100
		}, {
			field : 'birthday',
			title : 'birthday',
			width : 100
		}, {
			field : 'tel',
			title : 'tel',
			width : 100
		} ],
	 	options = {
			columns : columns,
			data : data
		};
		
		//创建弹框中用于显示数据的垂直表格
		$('#popupVerticalTable').createVerticalTable(options);
		
		$('#extendDialog').showDialog();
	});
	
	//alert
	$('#btnShowAlert').click(function() {
		confirmDialog('Hello, I\'m a alert.');
	});
	
	//confirm
	$('#btnShowConfirm').click(function() {
		confirmDialog('Hello, I\'m a confirm.', function() {
			confirmDialog('你点击了确认按钮.');
		});
	});
	
});