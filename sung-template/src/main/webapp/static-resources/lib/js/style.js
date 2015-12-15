'use strict';
//var menu = JSON.parse(localStorage.menu);
var menu = [{
	title : 'FORM',
	subMenu : [{
		title : 'validation',
		link : '/sample/validation.html'
	}, {
		title : 'elements',
		link : '/sample/elements.html'
	}]
}, {
	title : 'GRID',
	subMenu : [{
		title : 'grid',
		link : '/index.html'
	}, {
		title : 'grid detail',
		link : '/sample/grid-detail.html'
	}, {
		title : 'submenu3',
		link : ''
	}]
}, {
	title : 'DIALOG',
	subMenu : [{
		title : 'dialog',
		link : '/sample/dialog.html'
	}, {
		title : 'submenu2',
		link : ''
	}, {
		title : 'submenu3',
		link : ''
	}]
}, {
	title : 'FILE',
	subMenu : [{
		title : 'fileupload',
		link : '/sample/fileupload.html'
	}, {
		title : 'submenu2',
		link : ''
	}, {
		title : 'submenu3',
		link : ''
	}]
}, {
	title : 'MENU5',
	subMenu : [{
		title : 'submenu1',
		link : ''
	}, {
		title : 'submenu2',
		link : ''
	}, {
		title : 'submenu3',
		link : ''
	}]
}];

var menuItemOn = null;
$(function() {
	//设置页面title
	if (!$('.acticleTitle').text()) {
		$('.acticleTitle').text($('.location span:eq(3)').text());
	}
	$('.leftTitle').text($('.location span:eq(1)').text());
	//设置上侧主菜单
	for(var x in menu) {
		var titleMenu = menu[x].title;
		if(titleMenu) {
			$('.menuCnm ul').append('<li><a>' + titleMenu + '</a></li>');
			if($('.location span:eq(1)').text() === titleMenu) {
				$('.menuCnm ul li:last-child a').addClass('on');
				//设置左侧子菜单
				if(menu[x].subMenu) {
					for(var y in menu[x].subMenu) {
						var titleSubmenu = menu[x].subMenu[y].title;
						if(titleSubmenu) {
							if($('.location span:eq(3)').text() === titleSubmenu) {
								$('.leftMenu ul').append('<li><a class="on">' + titleSubmenu + '</a></li>');
							} else {
								$('.leftMenu ul').append('<li><a href="' + menu[x].subMenu[y].link + '">' + titleSubmenu + '</a></li>');
							}
						}
					}
				}
			}
		}
	}
	$('.menuCnm ul li').css('width',  $('.menuCnm').width() / menu.length);
	$('.menuCnm ul li:last-child').css('width',  $('.menuCnm').width() / menu.length - 1);
	
	menuItemOn = $('.menuCnm li a.on').parent().index(); 
	naviEvent01(); 	 
});

function naviEvent01() { 
	$('.menuCnm li a').mouseover(function() {
		var inx = $(this).parent().index();
		$('.menuCnm li a').removeClass('on');
		$(this).addClass('on'); 
		var subMenu = menu[inx].subMenu, posleft = $('.menuCnm').width() / menu.length * inx;
		var ul = '<ul style="left: ' + posleft + 'px">';
		for(var i=0; i<subMenu.length; i++) {
			ul += '<li><a href=' + subMenu[i].link + '>' + subMenu[i].title + '</a>';
		}
		ul += '</ul>'; 
		$('.subMenu').show().empty().append(ul);
		
		$('.subMenu').mouseleave(function() {
			$('.subMenu').hide();
			$('.menuCnm li a').removeClass('on');
			if (menuItemOn !== -1) {
				$('.menuCnm li').eq(menuItemOn).children('a').addClass('on');
			}
		});
		
//		$('.contents, .detailContents, .defaultbox, .mapContents, .location').mouseenter(function() {
//			$('.subMenu').hide();
//			$('.menuCnm li a').removeClass('on');
//			if (menuItemOn !== -1) {
//				$('.menuCnm li').eq(menuItemOn).children('a').addClass('on');
//			}
//		});
	});
}

/**
 * 
 * @functionName: hideForm
 * @Description: 隐藏表单元素
 * @author: Double
 * 
 */
jQuery.fn.hideForm = function() {
	$(this).find('input:visible, select:visible, textarea:visible, button:visible').addClass('formMark');
	$(this).find('img.ui-datepicker-trigger').addClass('formMark');
	$(this).find('button.btnEdit').removeClass('formMark').show();
	
	if(!$(this).find('.textMark').length) {
		$(this).find('input.formMark').each(function() {
			$(this).after('<span class="textMark">' + $(this).val() + '</span>');
		});
		$(this).find('select.formMark').each(function() {
			$(this).after('<span class="textMark" value="' + $(this).val() + '">' + $(this).find('option:selected').text() + '</span>');
		});
		$(this).find('textarea.formMark').each(function() {
			$(this).after('<pre class="textMark">' + $(this).val() + '</pre>');
		});
	} else {
		$(this).find('input.formMark').each(function() {
			$(this).val($(this).next().html());
		});
		$(this).find('select.formMark').each(function() {
			$(this).val($(this).next().attr('value'));
		});
		$(this).find('textarea.formMark').each(function() {
			$(this).val($(this).next().html());
		});
		
		$(this).find('.textMark').show();
	}
	$(this).find('.formMark').hide();
} 

/**
 * 
 * @functionName: showForm
 * @Description: 显示表单元素
 * @author: Double
 * 
 */
jQuery.fn.showForm = function() {
	$(this).find('.textMark').hide();
	$(this).find('.formMark').show();
	$(this).find('button.btnEdit').hide();
	
	$(this).find('.idField').next().show();
	$(this).find('.idField').hide();
} 

/**
 * 
 * @functionName: initForm
 * @Description: 显示表单元素
 * @author: Double
 * 
 */
jQuery.fn.initForm = function() {
	$(this).find('.textMark').remove();
	$(this).find('.formMark').show();
	$(this).find('.formMark').removeClass('formMark');
	$(this).find('button.btnEdit').hide();
	
	$(this).find('form')[0].reset();
} 

/**
 * 
 * @functionName: dragDialog
 * @Description: 对dialog进行拖拽
 * @author: Double
 * 
 */
jQuery.fn.dragDialog = function() {
	var _IsMove = 0, _MouseLeft = 0, _MouseTop = 0;
	return $(this).bind('mousemove', function(e) {
		if (_IsMove == 1) {
			$(this).parent().offset({
				top : e.pageY - _MouseTop,
				left : e.pageX - _MouseLeft
			});
		}
	}).bind('mousedown', function(e) {
		_IsMove = 1;
		var offset = $(this).offset();
		_MouseLeft = e.pageX - offset.left;
		_MouseTop = e.pageY - offset.top;
	}).bind('mouseup', function() {
		_IsMove = 0;
	}).bind('mouseout', function() {
		_IsMove = 0;
	});
} 

/**
 * 
 * @functionName: showDialog
 * @Description: 弹出dialog
 * @author: Double
 * 
 */
jQuery.fn.showDialog = function() {
	$(this).show();
	var heightWindow = $(window).height(),
	popup = $(this).find('.aplPopupWrapper'), marginTop = (heightWindow - popup.height()) / 2, heightBody = $(document.body).height();
	marginTop = marginTop > 10 ? marginTop : 10;
	popup.css('margin-top', marginTop + $(document).scrollTop());
	$(this).css('height', heightBody < heightWindow ? heightWindow : heightBody);
	$(this).hideForm(); //dialog show之后隐藏表单元素
} 

/**
 * 
 * @functionName: confirmDialog
 * @Description: 写回调函数为confirm, 不写为alert
 * @author: Double
 * 
 */
function confirmDialog(info, callback) {
	var heightWindow = $(window).height(), heightBody = $(document.body).height(),
	appendHtml = '\
		<div class="confirmWrapper" style="height: ' + (heightBody < heightWindow ? heightWindow : heightBody) + 'px">\
			<div class="aplConfirmWrapper">\
				<div class="aplConfirmTitle">\
					<div class="aplConfirmTitleFont">提示</div>\
					<div class="aplConfirmXbtn"><a title="关闭"><img src="/lib/img/btn/btn_popupX.png" alt="关闭"/></a></div>\
				</div>\
				<p class="aplConfirmContent">' + info + '</p>\
				<div class="aplConfirmBtnbox">';
	appendHtml += callback ? '<button class="btnPrimary aplConfirmOk">确认</button><button class="btnPrimary aplConfirmCancel">取消</button>' : '<button class="btnPrimary aplConfirmCancel">确认</button>';
	appendHtml += '</div></div></div>';
	$('body').append(appendHtml);
	$('.aplConfirmWrapper').css('margin-top', (heightWindow - $('.aplConfirmWrapper').height()) / 2 + $(document).scrollTop());
	$('.aplConfirmTitle').dragDialog();  //alert, confirm拖拽效果
	if (callback) {
		$('.aplConfirmOk').click(function() { 
			callback();
		});
	}
}

/**
 * 
 * @functionName: createVerticalTable
 * @Description: 在dialog中创建用于显示数据的垂直表格
 * @author: Double
 * @param: options
 */
jQuery.fn.createVerticalTable = function(options) {
	var data = options.data;
	if (data.errCd === 0) {
		var columns = options.columns, result = data.result, rows = result.rows,
		colgroup = '', thead = '', visibleRows = '', leftoverRows = '', visibleRowsCount = 10;
		for (var i=0; i<columns.length; i++) {
			colgroup += '<col width="' + columns[i].width + '"/>';
			thead += '<th>' + columns[i].title + '</th>';
		}
		
		for (var i=0; i<rows.length && i<visibleRowsCount; i++) {
			visibleRows += '<tr>';
			for (var j=0; j<columns.length; j++) {
				visibleRows += '<td>' + rows[i][columns[j].field] + '</td>'
			}
			visibleRows += '</tr>';
		}
		
		for (var i=visibleRowsCount; i<rows.length; i++) {
			leftoverRows += '<tr>';
			for (var j=0; j<columns.length; j++) {
				leftoverRows += '<td>' + rows[i][columns[j].field] + '</td>'
			}
			leftoverRows += '</tr>';
		}
		if ($(this).prev().hasClass('popupVerticalTableTh')) {
			$(this).prev().remove();
		}
//		$(this).before('<table class="popupVerticalTable" summary="垂直表格标题"><colgroup>' + colgroup + '</colgroup><thead><tr>' + thead + '</tr></thead></table>');
		$(this).addClass('popupVerticalTable');
		$(this).html('<colgroup>' + colgroup + '</colgroup><thead><tr>' + thead + '</tr></thead><tbody>' + visibleRows + '</tbody>');
		if (rows.length > visibleRowsCount) {
			/*var scrollWidth = getScrollWidth(), relativeScrollWidth = scrollWidth * columns[0].width / $(this).prev('table.popupVerticalTableTh').find('thead th:eq(0)').width();
			
			$(this).css({'margin': '0', 'width': '100%'});
			$(this).wrap('<div style="margin: 0 auto; width: 95%; overflow-y: scroll; height: ' + $(this).height() + 'px;"></div>');
			
			var theadTable = $(this).parent().prev('table.popupVerticalTableTh');
			theadTable.css({'margin': '0', 'width': $(this).width()});
			theadTable.wrap('<div style="margin: 0 auto; width: 95%; background-color: #fafafa; border-style: solid; border-color: #cacaca; border-width: 0px;"></div>');
			
//			theadTable.css({'margin': '0', 'width': $(this).width()}).wrap('<div style="margin: 0 auto; width: 95%; background-color: #fafafa; border-style: solid; border-color: #cacaca; border-width: 1px 1px 1px 0px;"></div>');
			
//			theadTable.find('tr th').css('border-width', '0 0 0 1px');
*/			
			$(this).css({'margin': '0', 'width': '100%'});
			$(this).wrap('<div class="popupVerticalTableScroll"></div>');
			$(this).find('tbody').append(leftoverRows);
			$(this).find('thead tr:first-child th').css('border-top-width', '0');
			$(this).find('tbody tr:last-child td').css('border-bottom-width', '0');
		}
	}
} 

$(function() {
	//logo link
	$('.defaultbox .logo a').attr('href', './index.html').attr('title', '点击进入网站首页');
	//mypage link
	$('.defaultbox .navi a').attr('href', './mypage.html').attr('title', '点击进入个人中心').text('个人中心');
	//page footer
	$('body').append('<div class="footerWrapper">\
		<div class="footer">\
			<p class="footerLogo">\
				<img src="/lib/img/pic/pic_footer.png" alt="footer logo" />\
			</p>\
			<p class="footerFont">\
				威海睿博软件有限公司 TEL:0631-5970779 FAX:0631-5970778<br />copyright NS Soft\
				Co.,Ltd. all rights reserved. since 2013\
			</p>\
		</div>\
	</div>');
	
	//dialog拖拽效果
	$('.aplPopupTitle').dragDialog();
	
	//关闭dialog
	$('.aplPopupXbtn').click(function() {
		$(this).parents('.popupWrapper').initForm();
		$(this).parents('.popupWrapper').hide();
	});
	
	//编辑按钮
	$('.btnEdit').click(function() {
		if ($(this).parents('.popupWrapper').length) {
			$(this).parents('.popupWrapper').showForm();
		} else {
			$(this).parents('.acticle').showForm();
		}
	});
	
	//取消编辑按钮
	$('.btnCancel').click(function() {
		if ($(this).parents('.popupWrapper').length) {
			$(this).parents('.popupWrapper').hideForm();
		} else {
			$(this).parents('.acticle').hideForm();
		}
	});
	
	//关闭alert confirm弹窗
	$(document).on('click', '.aplConfirmCancel, .aplConfirmXbtn, .aplConfirmOk', function() {
		$(this).parents('.confirmWrapper').remove();
	});
	
	//为查询条件表单searchForm定义验证
	$(document).on('focus', '.searchForm input', function() {
		$('.searchForm input').attr('maxlength', 30);
	});
	$(document).on('change', '.searchForm input', function() {
		var str = $(this).val().replace(/[^\w\s\u4e00-\u9fa5_\\\/\|-]/g, '');
		$(this).val(str);
	});
});