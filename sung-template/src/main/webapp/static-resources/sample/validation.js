'use strict';
$(function() {
	//模拟赋值--datepicker, 实际赋值时根据具体情况
	var today = new Date();
	$('.endDate').val(formatDate(today));
	today.setMonth(today.getMonth() - 6);
	$('.startDate').val(formatDate(today));
	
	//创建jQueryUI datepicker
	$('.startDate, .endDate').datepickerJQueryUI();
	
	//考虑到此三类标签元素的提示信息可能因父元素的overflow:hidden被隐藏，统一左移
	$('textarea').attr('data-prompt-position', 'topRight:-120,0');
	$('textarea').data('promptPosition', 'topRight:-120,0');
	$('input[class*="inputLarge"]').attr('data-prompt-position', 'topRight:-120,0');
	$('input[class*="inputLarge"]').data('promptPosition', 'topRight:-120,0');
	$('select[class*="inputLarge"]').attr('data-prompt-position', 'topRight:-120,0');
	$('select[class*="inputLarge"]').data('promptPosition', 'topRight:-120,0');
	
	//验证全部表单
	$('#validateAll').click(function() {
		$('#formID').validationEngine('validate');
	});
	
	//验证单个input
	$('#validateOne').click(function() {
		$('#phone').validationEngine('validate');
	});
	
	//扩展jquery.validationEngine-zh_CN.js，添加验证规则
	$.extend($.validationEngineLanguage.allRules,{
		"name": {
            "regex": /^[0-9a-zA-Z\_\-]+$/,
            "alertText": "* 名称由字母数字下划线横杠组成"
        },
        "chinese": {
        	"regex": /^[\u4e00-\u9fa5]*$/,
        	"alertText": "* 只允许中文"
        },
        "ajaxRegisterCheck": {
        	  "url": "/sys/bus.do?method=register_check",
        	  "extraData": "dt="+(new Date()).getTime(),
        	  "alertTextOk": "此名称可以使用", 
        	  "alertText": "* 验证失败！",
        	  "alertTextLoad": "* 验证中，请稍候..."
        }
	});
	
	//formID表单验证参数
	$('#formID').validationEngine({
		focusFirstField: false,    //验证未通过时，不给第一个不通过的控件获取焦点，避免日期弹框
		'custom_error_messages': {
			// Custom Error Messages for Validation Types
			'required_test': {
		        'message': '这里必须填写啦！（使用时请删除所有的_test）'
		      }
		      // Custom Error Messages for IDs
		      ,'#id_test' : {
		        'custom[url_test]': {
		          'message': '这里要填写网址哦！（优先取选择器和验证规则的提示内容）'
		        }
		      }
		      // Custom Error Messages for Classes
		      ,'.class_test': {
		        'required': {
		          'message': '必填（这是使用 class选择器定义的，它的优先级要比规则的高）'
		        }
		      }
		}
	});
});