/**
 * 
 * @file: 上传文件
 * @author: Double
 * @date: 2015/08/20 08:30
 * @version: V1.0
 * 
 */

(function(W, D) {
	$(D).ready(function() {
		
		var module_cd = getParameter('moduleCd');
		
		//识别浏览器
	    var userAgent = navigator.userAgent.toLowerCase();
	    var rMsie = /(msie\s|trident.*rv:)([\w.]+)/;
	    var match = rMsie.exec(userAgent);  
	    if (match != null && parseInt(match[2]) == 8) { //IE8
	    	
	    	$('#container').plupload({
				url : contextPath + '/ServiceAPI/common/uploadFiles.form',
				filters : {
					mime_types : [ {
						title : '格式错误',
						extensions : 'jpg,jpeg,png,gif,bmp,tiff,raw,zip'
					} ],
					max_file_size : '500kb'
				},
				dragdrop : true,
				multi_selection : true,
				multipart_params : {
					module_cd : module_cd
				},
				flash_swf_url : '../plugins/plupload-2.1.2/Moxie.swf',
				silverlight_xap_url : '../plugins/plupload-2.1.2/Moxie.xap',
				init : {
					FileUploaded : function(uploader, file, responseObject) {
						var res = $.parseJSON(responseObject.response);
						if(res.errCd == 0) {
							var result = res.result;
							if(result != null) {
								var files = result.files;
								if(files != null) {
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
															<div class="p-pic"><img id="' + files[i].file_id + '" src="' + contextPath + '/files' + files[i].file_path + files[i].file_id + '.' + files[i].file_extension + '" onMouseOver="toolTip(\'<img height=400 width=400 src=' + contextPath + '/files' + files[i].file_path + files[i].file_id + '.' + files[i].file_extension + '>\')" onMouseOut="toolTip()"/></div>\
															<div class="p-des">' + imgName + '</div></a>\
													   </li>';
										}
										parent.$('#filePreIframe')[0].contentWindow.$('.batch-pic ul').append(itemImg);
									}
								}
							}
						} else {
							alert(res.errMsg);
						}
					}
				}
			});
	    	
	    } else {
	    	
	    	$('#container').plupload({
				url : contextPath + '/ServiceAPI/common/uploadFiles.form',
				filters : {
					mime_types : [ {
						title : '格式错误',
						extensions : 'jpg,jpeg,png,gif,bmp,tiff,raw,zip'
					} ],
					max_file_size : '500kb'
				},
				dragdrop : true,
				views : {
					thumbs : true,
					list : true,
					active : 'thumbs'
				},
				multi_selection : true,
				multipart_params : {
					module_cd : module_cd
				},
				flash_swf_url : '../plugins/plupload-2.1.2/Moxie.swf',
				silverlight_xap_url : '../plugins/plupload-2.1.2/MoxiDe.xap',
				init : {
					FileUploaded : function(uploader, file, responseObject) {
						var res = $.parseJSON(responseObject.response);
						if(res.errCd == 0) {
							var result = res.result;
							if(result != null) {
								var files = result.files;
								if(files != null) {
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
															<div class="p-pic"><img id="' + files[i].file_id + '" src="' + contextPath + '/files' + files[i].file_path + files[i].file_id + '.' + files[i].file_extension + '" onMouseOver="toolTip(\'<img height=400 width=400 src=' + contextPath + '/files' + files[i].file_path + files[i].file_id + '.' + files[i].file_extension + '>\')" onMouseOut="toolTip()"/></div>\
															<div class="p-des">' + imgName + '</div></a>\
													   </li>';
										}
										var preIframeId = getParameter('preIframeId');
										if(preIframeId != false && preIframeId != null && preIframeId != '') {
											parent.$('#' + preIframeId)[0].contentWindow.$('.batch-pic ul').append(itemImg);
										} else {
											parent.$('#filePreIframe')[0].contentWindow.$('.batch-pic ul').append(itemImg);
										}
										
									}
								}
							}
						} else {
							alert(res.errMsg);
						}
					}
				}
			});
	    	
	    }
	    
	});	
	
}(window, document));