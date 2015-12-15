/**
 * 
 * @JSName: files
 * @Description: 文件预览
 * @author: Double
 * @date: 2015/02/26/ 15:30:00
 * @version: V1.0
 * 
 */


(function(W, D) {
	
	W.$files = W.$files || {};
	
	$(D).ready(function() {
		var module_cd = getParameter('moduleCd'), module_no = getParameter('moduleNo');
		if(module_cd != false && module_cd != null && module_cd != '' && module_no != false && module_no != null && module_no != '') {
			$files.getFiles(module_cd, module_no);
		}
	});
	
	$files = {
		getFiles : function(module_cd, module_no) {
			var getFiles = new nssoft.openApi.getFiles.api();
			getFiles.addParam('module_cd', module_cd);
			getFiles.addParam('module_no', module_no);
			getFiles.request({
				method : 'POST',
				async : false,
				url : contextPath + '/ServiceAPI/common/getFiles.json'
			});
		},
		toolTip : function(file_path, file_id, file_extension) {
			toolTip('<img height="400" width="400" src="' + contextPath + '/files' + file_path + file_id + '.' + file_extension + '" />');
		}
	};
	
	//callback function for getFiles
	(function() {
		$class('nssoft.openApi.getFiles.api').extend(nssoft.absAPI).define({
			onSuccess : function(status, res) {
				var result = res.result;
				if (res.errCd == 0) {
					if(result != null) {
						var files = result;
						for(var i = 0; i < files.length; i++) {
							var imgName = files[i].file_nm + '.' + files[i].file_extension;
							if(imgName.length > 20) {
								imgName = imgName.substr(0, 7) + '...' + imgName.substr(imgName.length-10, 10);
							}
							var itemImg = null;
							if(files[i].file_extension.toLowerCase() == 'zip') {
								itemImg = '<li>\
										   		<a title="点击删除图片" onclick="$(this).parent().remove();"><div class="delete-pic">x</div></a>\
												<a title="' + files[i].file_nm + '.' + files[i].file_extension + '" href="' + contextPath + '/files' + files[i].file_path + files[i].file_id + '.' + files[i].file_extension + '" target="_blank">\
												<div class="p-pic"><div id="' + files[i].file_id + '">zip</div></div>\
												<div class="p-des">' + imgName + '</div></a>\
										   </li>';
							} else {
								itemImg = '<li>\
										   		<a title="点击删除图片" onclick="$(this).parent().remove();"><div class="delete-pic">x</div></a>\
												<a title="' + files[i].file_nm + '.' + files[i].file_extension + '" href="' + contextPath + '/files' + files[i].file_path + files[i].file_id + '.' + files[i].file_extension + '" target="_blank">\
												<div class="p-pic"><img id="' + files[i].file_id + '" src="' + contextPath + '/files' + files[i].file_path + files[i].file_id + '.' + files[i].file_extension + '" \
												onMouseOver="$files.toolTip(\'' + files[i].file_path + '\', \'' + files[i].file_id + '\', \'' + files[i].file_extension + '\')" onMouseOut="toolTip()"/></div>\
												<div class="p-des">' + imgName + '</div></a>\
										   </li>';
							}
							$('.batch-pic ul').append(itemImg);
							
							if(getParameter('hideDelIcon') == 'Y') {
								$('.batch-pic ul li a div.delete-pic').parent().hide();
							}
						}
					}
				} else {
					BUI.Message.Alert(res.errMsg, 'error');
				}
			},
			onFail : function(status) {
				BUI.Message.Alert('发生错误', 'error');
			}
		});
	}());
	
}(window, document));