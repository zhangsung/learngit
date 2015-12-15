'use strict';
$(function() {
	//模拟赋值--datepicker, 实际赋值时根据具体情况
	$('.startDate').val(formatDate(new Date()));
	
	//创建jQueryUI datepicker
	$('.startDate').datepickerJQueryUI();
});