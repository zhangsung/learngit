/**
 * 
 * @functionName: datagridViewEasyUI
 * @Description:扩展easyUI的datagridView
 * @author: Double
 * @param:
 */
// $.fn.datagrid.defaults.view
var datagridViewEasyUI = $.extend({}, $.fn.datagrid.defaults.view, {
	onAfterRender : function(target) {
		$.fn.datagrid.defaults.view.onAfterRender.call(this, target);
		var vc = $(target).datagrid('getPanel').children('div.datagrid-view').children('.datagrid-view2');
		vc.parent('div.datagrid-view').css('background-color', '#fff');
		vc.children('div.datagrid-empty').remove();
		if (!$(target).datagrid('getRows').length) {
			vc.parent('div.datagrid-view').css('background-color', '#efefef');
			$('<div class="datagrid-empty"></div>').html( '<img src="/lib/img/pic/pic_empty.png"/><p>未查询到数据</p>').appendTo(vc);
		}
	}
});

/**
 * 
 * @functionName: datagridEasyUI
 * @Description: 自定义easyUI的create datagrid 方法
 * @author: Double
 * @param: options
 */
jQuery.fn.datagridEasyUI = function() {
	if (arguments.length === 1) {
		var options = arguments[0],
		options_extend = {
			view : datagridViewEasyUI,
			checkOnSelect : false,
			selectOnCheck : false,
			singleSelect : true,
			loadFilter : function(data) {
				if (data && data.errCd === 0) {
					data = data.result;
				} else {
					confirmDialog('Error: ' + data.errMsg + '(' + data.errCd + ')');
					data = {
						'total' : 0,
						'summarys' : null,
						'rows' : []
					};
				}
				if (data.summarys) {
					var summaryLi = $(this).parents('.datagrid').prevAll('.membership:eq(0)').find('ul li');
					for (var x in data.summarys) {
						summaryLi.eq(x).children('span').text(data.summarys[x]);
					}
				} else {
					$(this).parents('.datagrid').prevAll('.membership:eq(0)').find('ul li span').text(0);
				}
				return data;
			},
			onLoadSuccess : function(data) {
				if($(this).parents('.datagrid-view').next().find('.crossPageSwitch').length && !$(this).parents('.datagrid-view').next().find('.crossPageSwitch').switchbutton('options').checked) { //关闭跨页选择
	            	$(this).datagrid('clearChecked'); //uncheck所有行
				}
			},
			onLoadError : function(e) {
				$(this).datagrid('loadData', {}); 
				confirmDialog('Error: ' + e.statusText + '(' + e.status + ')');
			}
		};
		//跨页选择开关
		if (options.crossPageSwitch) {
			$(this).after('<div class="pagerButtons">\
				跨页选择:<input class="crossPageSwitch" style="width: 40px; height: 18px;" checked />\
				</div>');
			$('.crossPageSwitch').switchbutton({
			    checked : getCookie('crossPageSwitch') === 'off' ? false : true,
			    onChange : function(checked) {
			        checked ? setCookie('crossPageSwitch', 'on') : setCookie('crossPageSwitch', 'off');
			        if (!checked) {
			        	var datagridElement = '#' + $(this).parents('.datagrid-pager').prev().children('table').attr('id');
			        	$(datagridElement).datagrid('clearChecked'); //uncheck所有行
			        	//check当前页
			        	var allCheckedRows = $(datagridElement).datagrid('getChecked'), recentPageRows = $(datagridElement).datagrid('getRows');
						if (allCheckedRows && recentPageRows) {
							for (var i = 0; i < recentPageRows.length; i++) {
								for (var j = 0; j < allCheckedRows.length; j++) {
									if (recentPageRows[i][$(datagridElement).datagrid('options').idField] === allCheckedRows[j][$(datagridElement).datagrid('options').idField]) {
										$(datagridElement).datagrid('checkRow', $(datagridElement).datagrid('getRowIndex', recentPageRows[i]));
									}
								}
							}
						}
			        }
			    }
			});
			options.crossPageSwitch = undefined;
		}
		//是否展示细节
		if (options.detailView) {
			$.extend(options_extend.view, detailview);
			options.detailView = undefined;
		}
		$.extend(options, options_extend);
		//创建datagrid
		$(this).datagrid(options); 
		if (options.pagination) {
			var pager = $(this).datagrid('getPager'); // get the pager of datagrid
			pager.pagination({
				buttons: '.pagerButtons'
			});
		}
	} else {
		alert('datagridEasyUI : 参数错误, 支持1个参数(options)');
	}
} 

/**
 * 
 * @functionName: downloadFileEasyUI
 * @Description: 自定义easyUI的下载方法
 * @author: Double
 * @param: url, searchForm, btn
 * 
 */
jQuery.fn.downloadFileEasyUI = function() {
	if (arguments.length === 3) {
		var url = arguments[0], searchForm = arguments[1], btn = arguments[2],
		rows = $(this).datagrid('getChecked'), dldType = (rows.length ? 'check' : 'query'),  queryParam;
		if (dldType === 'check') { //根据勾选行下载
			var ids = [];
			for (var i=0; i<rows.length; i++) {
				ids.push(rows[i][$(this).datagrid('options').idField]);
			}
			queryParam = {'ids' : JSONArrayToList(ids)};
		} else { //未勾选行，根据搜索条件下载
			queryParam = serializeObject($(searchForm));
		}
		queryParam.type = dldType;
		
		downloadByForm(url, queryParam, btn);
	} else {
		alert('downloadEasyUI : 参数错误, 支持3个参数(url, searchForm, btn)');
	}
} 

/**
 * 
 * @functionName: deleteRowsEasyUI
 * @Description: 自定义easyUI datagrid 删除行
 * @author: Double
 * @param: 
 * 
 */
jQuery.fn.deleteRowsEasyUI = function() {
	if (arguments.length === 0) {
		var rows = $(this).datagrid('getChecked'), idField = $(this).datagrid('options').idField; 
		if (rows.length) {
			confirmDialog('确定要删除吗?', function() {
				var ids = [];
				for (var i=0; i<rows.length; i++) {
					ids.push(rows[i][idField]);
				}
				return ids;
			});
		} else {
			confirmDialog('请选择要删除的数据。');
		}
	} else {
		confirmDialog('deleteRowsEasyUI : 参数错误, 不支持参数');
	}
} 