function getViewportHeight() {
	if (window.top.innerHeight!=window.top.undefined) return window.top.innerHeight;
	if (top.document.compatMode=='CSS1Compat') return top.document.documentElement.clientHeight;
	if (top.document.body) return top.document.body.clientHeight; 

	return window.top.undefined; 
}
function getViewportWidth() {
	if (window.top.innerWidth!=window.top.undefined) return window.top.innerWidth;
	if (top.document.compatMode=='CSS1Compat') return top.document.documentElement.clientWidth;
	if (top.document.body) return top.document.body.clientWidth; 

	return window.top.undefined; 
}

/**
 * Gets the real scroll top
 */
function getScrollTop() {
	if (self.pageYOffset) // all except Explorer
	{
		return self.pageYOffset;
	}
	else if (top.document.documentElement && top.document.documentElement.scrollTop)
		// Explorer 6 Strict
	{
		return top.document.documentElement.scrollTop;
	}
	else if (top.document.body) // all other Explorers
	{
		return top.document.body.scrollTop;
	}
}
function getScrollLeft() {
	if (self.pageXOffset) // all except Explorer
	{
		return self.pageXOffset;
	}
	else if (top.document.documentElement && top.document.documentElement.scrollLeft)
		// Explorer 6 Strict
	{
		return top.document.documentElement.scrollLeft;
	}
	else if (top.document.body) // all other Explorers
	{
		return top.document.body.scrollLeft;
	}
}
/*
渐变的弹出图片
使用方法：
将ToolTip.js包含在网页body的结束标签后
调用方法：
<a href="pages.jpg" target='_blank' onMouseOver="toolTip('<img src=http://zhouzh:90/templet/T_yestem_channel/pages_small.jpg>')" onMouseOut="toolTip()"><img src='pages_small.jpg' border=0 width=30 height=20 align="absmiddle" title="点击看大图"></a>

必须CSS样式
.trans_msg
{
	filter:alpha(opacity=100,enabled=1) revealTrans(duration=.2,transition=1) blendtrans(duration=.2);
}
*/
//--初始化变量--
var rT=true;//允许图像过渡
var bT=true;//允许图像淡入淡出
var tw=150;//提示框宽度
var endaction=false;//结束动画
var ns4 = top.document.layers;
var ns6 = top.document.getElementById && !top.document.all;
var ie4 = top.document.all;
offsetX = 10;
offsetY = 20;
var toolTipSTYLE="";
function initToolTips()
{
	tempDiv = top.document.createElement("div");
	tempDiv.id = "toolTipLayer";
	tempDiv.style.position = "absolute";
	tempDiv.style.display = "none";
	top.document.body.appendChild(tempDiv);
	if(ns4||ns6||ie4)
	{
		if(ns4) toolTipSTYLE = top.document.toolTipLayer;
		else if(ns6) toolTipSTYLE = top.document.getElementById("toolTipLayer").style;
		else if(ie4) toolTipSTYLE = top.document.all.toolTipLayer.style;
		if(ns4) top.document.captureEvents(Event.MOUSEMOVE);
		else
		{
		  toolTipSTYLE.visibility = "visible";
		  toolTipSTYLE.display = "none";
		}
		document.onmousemove = moveToMouseLoc;
	}
}
function toolTip(msg, fg, bg)
{
	try {
	  if(toolTip.arguments.length < 1) // hide
	  {
		if(ns4) 
		{
		toolTipSTYLE.visibility = "hidden";
		}
		else 
		{
		  //--图象过渡，淡出处理--
		  if (!endaction) {toolTipSTYLE.display = "none";}
		  if (rT) top.document.all("msg1").filters[1].Apply();
		  if (bT) top.document.all("msg1").filters[2].Apply();
		  top.document.all("msg1").filters[0].opacity=0;
		  if (rT) top.document.all("msg1").filters[1].Play();
		  if (bT) top.document.all("msg1").filters[2].Play();
		  if (rT){ 
		  if (top.document.all("msg1").filters[1].status==1 || top.document.all("msg1").filters[1].status==0){  
		  toolTipSTYLE.display = "none";}
		  }
		  if (bT){
		  if (top.document.all("msg1").filters[2].status==1 || top.document.all("msg1").filters[2].status==0){  
		  toolTipSTYLE.display = "none";}
		  }
		  if (!rT && !bT) toolTipSTYLE.display = "none";
		  //----------------------
		}
	  }
	  else // show
	  {
		if(!fg) fg = "#777777";
		if(!bg) bg = "#eeeeee";
		var content =
		'<table id="msg1" name="msg1" border="0" cellspacing="0" cellpadding="1" bgcolor="' + fg + '" class="trans_msg"><td>' +
		'<table style="border: 1px solid #c4c4c4" cellspacing="2" cellpadding="3" bgcolor="' + bg + 
		'"><td><font face="Arial" color="' + fg +
		'" size="-2">' + msg +
		'</font></td></table></td></table>';
		
		if(ns4)
		{
		  toolTipSTYLE.top.document.write(content);
		  toolTipSTYLE.top.document.close();
		  toolTipSTYLE.visibility = "visible";
		}
		if(ns6)
		{
		  top.document.getElementById("toolTipLayer").innerHTML = content;
		  toolTipSTYLE.display='block';
		}
		if(ie4)
		{
		  top.document.all("toolTipLayer").innerHTML=content;
		  toolTipSTYLE.display='block'
		  //--图象过渡，淡入处理--
		  var cssopaction=top.document.all("msg1").filters[0].opacity
		  top.document.all("msg1").filters[0].opacity=0;
		  if (rT) top.document.all("msg1").filters[1].Apply();
		  if (bT) top.document.all("msg1").filters[2].Apply();
		  top.document.all("msg1").filters[0].opacity=cssopaction;
		  if (rT) top.document.all("msg1").filters[1].Play();
		  if (bT) top.document.all("msg1").filters[2].Play();
		  //----------------------
		}
	  }
	} catch(e) {}
}
function moveToMouseLoc(e)
{
  var scrollTop = getScrollTop();
  var scrollLeft = getScrollLeft();
  if(ns4||ns6)
  {
    x = e.pageX + scrollLeft;
    y = e.pageY - scrollTop;
  }
  else
  {
    x = event.clientX + scrollLeft;
    y = event.clientY;
  }
  
  if (x-scrollLeft > getViewportWidth() / 2) {
  	x = x - top.document.getElementById("toolTipLayer").offsetWidth - 2 * offsetX;
  }
  
  if ((y+top.document.getElementById("toolTipLayer").offsetHeight+offsetY)>getViewportHeight()) {
	y = getViewportHeight()-top.document.getElementById("toolTipLayer").offsetHeight-offsetY;
  }
  
  var topIframe = getParameter('topIframe');
  if(topIframe == false ||　topIframe == null || topIframe =='') {
	  topIframe = 300;
  }
  toolTipSTYLE.left = (x + offsetX + 200) + 'px';
  toolTipSTYLE.top = (y + offsetY + scrollTop + parseInt(topIframe)) + 'px';
  return true;
}
initToolTips();
