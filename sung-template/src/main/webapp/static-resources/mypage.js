'use strict'

$(document).ready(function(){
	//formElement表单使用easyUI load方法初始化
	$('#formElement').form('load',{
		email:'12345678@qq.com',
		department:'web',
		phone1:'0631',
		phone2:'5970',
		phone3:'779',
		level:'1',
		inner_phone:'1632',
		tel1:'011',
		tel2:'6312',
		tel3:'3662',
		birthday:'2014-12-09',
		detail:'细节 1:  2014年7月23日, 注册ID'
	});
	$('#name').text('刘康');
	$('#manage').text('worker');
	$('input[name="sex"][value="男"]').attr('checked',true);
	$('input[name="interest"][value="游泳"]').attr('checked',true);
	
	//datagrid初始化
	var datagridElement = '#datagridExp',
 	columns = [ {
		field : 'ck',
		checkbox : true
	}, {
		field: 'id',
		titile: 'id',
		hidden: true
	}, {
		field : 'name',
		title : 'name',
		width : 100,
		formatter : function(value, row, index) {
			return '<a target="_blank" title="点击新开页面" href="mypage.html">' + value + '</a>';
		}
	}, {
		field : 'email',
		title : 'email',
		width : 100,
		formatter : function(value, row, index) {
			return '<a title="点击显示弹窗" onclick="$(\'#dialogElement\').css(\'display\', \'block\');">' + value + '</a>';
		}
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
		columns : [ columns ],
		fitColumns : true
	};
	$(datagridElement).datagridEasyUI(options); //创建easyUI datagrid
	$(datagridElement).datagrid('appendRow',{
		name: '小狗狗',
		email: 'gougou@gougou.com',
		birthday: '2014-12-03',
		tel: 18911111111
	});
	
	$('#addForm').hide();
	transform();  //先转格式后显示
	
	//编辑按钮
	$('#edit').click(function() { 
		$(this).hide();
		$('#print').hide();
		$('span').hide();
		$('.fontS').show();
		$('.fontS').prev().show();
		$('#modify').show();
		$('#cancel').show();
		$('input').show();
		$('select').show();
		$('radioboxgroup').show();
		$('checkboxgroup').show();
		//datebox begin
		$('.datebox').show();
		$('.textbox-addon').show();
		$('.easyui-datebox').hide();
		//datebox end
		$('textarea').show();
		$('#add').show();
		$('#del').show();
		$('#addForm').show();
		$('.datagrid-cell span').show();
	});
	
	//打印按钮
	$('#print').click(function() {
		$('button').hide();
		window.print();
		$('#edit').show();
		$('#print').show();
	})
	
	//修改按钮
	$('#modify').click(function() {
		if($('#formElement').validationEngine('validate')){  //验证通过后修改成功
			alert('修改成功');
			$(this).hide();
			$('#cancel').hide();
			$('#edit').show();
			$('#print').show();
			$('#add').hide();
			$('#del').hide();
			$('#addForm').hide();
			$('#formElement span').remove(); //保存前 删除原来的span,避免产生多个隐藏的span
			$('.fontS').show();
			transform(); 
		}
	});
	
	//取消按钮
	$('#cancel').click(function() {
		history.go(0);
		/*$('#formElement').validationEngine('hide');
		$('#addForm').validationEngine('hide');
		$(this).hide();
		$('#modify').hide();
		$('#edit').show();
		$('#print').show();
		$('span').show();
		$('input').hide();
		$('select').hide();
		$('radioboxgroup').hide();
		$('checkboxgroup').hide();
		$('.datebox').hide();
		$('textarea').hide();
		$('#add').hide();
		$('#del').hide();
		$('#addForm').hide();
		$('input[type="checkbox"]').next().hide();*/
		//把datagird中新增或减少的删除或还原
//		var origin_rows = $(datagridElement).datagrid('getRows');
//		var i=0;
//		while(i<origin_rows.length) {
//			console.info(origin_rows[i]);
//			var rowIndex = $(datagridElement).datagrid('getRowIndex',origin_rows[i]);
//			$(datagridElement).datagrid('deleteRow',rowIndex);
//			i++;
//		}
//		console.info(i);
	});
	
	//添加按钮
	$('#add').click(function() {
		if($('#addForm').validationEngine('validate')){
			var name = $('input[name="add_name"]').val();
			var email = $('input[name="add_email"]').val();
			var birthday = $('input[name="add_birthday"]').val();
			var tel = $('input[name="add_tel"]').val();
			$(datagridElement).datagrid('appendRow',{  //追加一个新行到最后
				name: name,
				email: email,
				birthday: birthday,
				tel: tel
			});
		}
	});
	
	//删除按钮
	$('#del').click(function() {
		var rows = $(datagridElement).datagrid('getChecked');
		if (rows.length) {
			var i=0;
			while(i<rows.length) {
				var rowIndex = $(datagridElement).datagrid('getRowIndex',rows[i]);
				$(datagridElement).datagrid('deleteRow',rowIndex);
				i++;
			}
		} else {
			confirmDialog('请选择要删除的数据。');
		}
	});
	
	//转换各标签方法
	function transform() {
		$('input').each(function() {
			var temp = $(this).val();
			$(this).after('<span>'+temp+'</span>');
			$(this).hide();
		});
		$('select').each(function() {
			var temp = $(this).find("option:selected").text();
			$(this).after('<span>'+temp+'</span>');
			$(this).hide();
		});
		$('radioboxgroup input[name="sex"]:checked').each(function() {
			var temp = $(this).val();
			$(this).parent().after('<span>'+temp+'</span>');
			$(this).parent().hide();
		});
		$('input[type="checkbox"]').each(function() {
			$(this).hide();
			$(this).next().remove();  //若不加，首行头会多个on
		});
		$('checkboxgroup input[name="interest"]:checked').each(function() {
			var temp = $(this).val();
			$(this).parent().hide();
			$(this).parent().after('<span>'+temp+'  </span>');
		});
		$('textarea').each(function() {
			var temp = $(this).val();
			$(this).after('<span>'+temp+'</span>');
			$(this).hide();
		});
		$('.easyui-datebox').each(function() {
			var temp = $(this).datebox('getValue');
			$(this).after('<span>'+temp+'</span>');
			$('.datebox').hide();
		});
	}
	
	//formElement表单验证参数
	$('#formElement').validationEngine({
		autoHidePrompt: true,  //自动隐藏提示信息
		autoHideDelay: 5000,   //自动隐藏提示信息的延迟时间
		scroll: false,          //屏幕不自动滚动到第一个验证不通过的位置
		'ruleName': {
			'regex': RegExp,  //正则表达式，如果正则能匹配内容表示通过  
			'alertText': '验证不通过时的提示信息' 
		},
		'custom_error_messages': {
			// Custom Error Messages for Validation Types
			'required': {
		        'message': '这里必须填写啦！'
		      }
		      ,'custom[url]': {
		        'message': '这个错误信息不会被调用哦，因为下面有更高级的覆盖了我呢！'
		      }
		      // Custom Error Messages for IDs
		      ,'#url' : {
		        'custom[url]': {
		          'message': '这里要填写网址哦！（优先取选择器和验证规则的提示内容）'
		        }
		      }
		      ,'#number': {
		        'min': {
		          'message': '这个数值……我不能接受'
		        }
		      }
		      // Custom Error Messages for Classes
		      ,'.class_url': {
		        'custom[url]': {
		          'message': '这个错误信息不会被调用，因为它是使用 class 的选择器，' +
		              '而当前存在更高级的 id 选择器。'
		        }
		      }
		      ,'.class_req': {
		        'required': {
		          'message': '必填（这是使用 class 选择器定义的，它的优先级要比规则的高）'
		        }
		      }
		}
	});
	
	//addForm表单验证参数
	$('#addForm').validationEngine({
		showOneMessage: true
	});
});