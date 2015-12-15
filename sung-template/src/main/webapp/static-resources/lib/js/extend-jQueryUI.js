/**
 * 
 * @functionName: datepickerJQueryUI
 * @Description: 自定义easyUI的create datepicker 方法
 * @author: Double
 * @param: options-选填
 */
jQuery.fn.datepickerJQueryUI = function() {
	var options = (arguments.length > 0 ? arguments[0] : {}),
	options_extend = {
		changeYear : true,
		changeMonth : true,
		showAnim : 'slideDown',
		showOn : 'both',
		buttonImageOnly: true,
		buttonImage : '/lib/img/ico/ico_calendar.png',
		buttonText : '选择日期',
		onClose : function(selectedDate) {
			 if ($(this).hasClass('startDate')) {
				if ($(this).next().next().hasClass('endDate')) {
					$(this).next().next().datepicker('option', 'minDate', selectedDate);
				}
			} else if ($(this).hasClass('endDate')) {
				if ($(this).prev().prev().hasClass('startDate')) {
					$(this).prev().prev().datepicker('option', 'maxDate', selectedDate);
				}
			}
		}
	};
	$.extend(options, options_extend);
	$(this).datepicker(options);
} 