<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>简历预览</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/resumePre.css">
    <script type="text/javascript" src="js/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="js/html2pdf/canvg2.js"></script>
    <script type="text/javascript" src="js/html2pdf/html2canvas-0.4.1.js"></script>
    <script type="text/javascript" src="js/html2pdf/jspdf.min.js"></script>
</head>
<body>
	
<div class="preview_top_right">
    <div class="operate">
        <%-- <a href="${pageContext.request.contextPath }/resume_resumeJsp.action"><i class="fa fa-pencil" aria-hidden="true">&nbsp;&nbsp;</i>修改简历</a> --%>
        <%-- <a href="${pageContext.request.contextPath }/resume_exportResume.action"><i class="fa fa-upload" aria-hidden="true">&nbsp;&nbsp;</i>导出简历</a> --%>
        <a href="javascript:void(0)" id="downloadPdf"><i class="fa fa-upload" aria-hidden="true">&nbsp;&nbsp;</i>导出简历</a>
    </div>
</div>
<div id="pdfContainer" style="background-color:#fff;">	
	    <div class="previewMain">
		     
	        <!--顶部-->
	        <table class="preview_top">
	            <tr>
	                <td>
	                    <div class="preview_top_left">
	                        <h3>简历预览</h3>
	                    </div>
	                </td>
	                <%-- <td>
	                    <div class="preview_top_right">
	                        <div class="operate">
	                            <a href="${pageContext.request.contextPath }/resume_resumeJsp.action"><i class="fa fa-pencil" aria-hidden="true">&nbsp;&nbsp;</i>修改简历</a>
	                            <a href="${pageContext.request.contextPath }/resume_exportResume.action"><i class="fa fa-upload" aria-hidden="true">&nbsp;&nbsp;</i>导出简历</a>
	                            <a href="javascript:void(0)" id="downloadPdf"><i class="fa fa-upload" aria-hidden="true">&nbsp;&nbsp;</i>导出简历</a>
	                        </div>
	                    </div>
	                </td> --%>
	            </tr>
	        </table>
	        <!--基本信息-->
	        <table class="per_basic" width="100%">
	            <tr>
	                <td width="15%">
	                    <div class="per_photo">
	                    	<img alt="" src="images/header/me.jpg" width="108px" height="144px">
	                    </div>
	                </td>
	                <td width="25%">
	                    <div class="per_basicInfo">
	                        <p>
	                            <span class="desTitle">姓名:&nbsp;&nbsp;</span>
	                            <span>${adminResume.rname}</span>
	                        </p>
	                        <p>
	                            <span class="desTitle">手机号码:&nbsp;&nbsp;</span>
	                            <span>${adminResume.rphone}</span>
	                        </p>
	                        <p>
	                            <span class="desTitle">电子邮箱:&nbsp;&nbsp;</span>
	                            <span>${adminResume.remail}</span>
	                        </p>
	                        <p>
	                            <span class="desTitle">现居住城市:&nbsp;&nbsp;</span>
	                            <span>${adminResume.residentialAddress}</span>
	                        </p>
	                    </div>
	                </td>
	                <td width="60%">
	                    <div class="per_basicInfo">
	                        <p id="li_graduation_date">
	                            <span class="desTitle">毕业时间：</span>
	                            <span>${adminResume.rgraduateDate}</span>
	                        </p>
	                        <p id="li_school_name">
	                            <span class="desTitle">学校名称：</span>
	                            <span>${adminResume.rschoolname}</span>
	                        </p>
	                        <p id="li_major_name">
	                            <span class="desTitle">专业：</span>
	                            <span>${adminResume.rprofessional}</span>
	                        </p>
	                        <p id="li_education_degree">
	                            <span class="desTitle">学历：</span>
	                            <span>
	                            	<c:if test="${adminResume.reducationType == 1}">本科</c:if>
	                            	<c:if test="${adminResume.reducationType == 2}">大专</c:if>
	                            	<c:if test="${adminResume.reducationType == 3}">专科</c:if>
	                            </span>
	                        </p>
	                    </div>
	                </td>
	            </tr>
	        </table>
	        <!--预览信息-->
	        <div class="pre_info">
	            <div class="per_title">
	                <p>个人信息</p>
	            </div>
	            <div class="per_infoCont">
	                <div id="li_gender">
	                    <span class="pre_title">&nbsp;性别：&nbsp;&nbsp;</span>
	                    <span>${adminResume.rgender}</span>
	                </div>
	                <div id="li_birth">
	                    <span class="pre_title">出生日期：&nbsp;&nbsp;</span>
	                    <span>${adminResume.rbirthday}</span>
	                </div>
	                <div id="li_hukou_city">
	                    <span class="pre_title">入学前户口所在地：&nbsp;&nbsp;</span>
	                    <span>${adminResume.roriginAddress}</span>
	                </div>
	            </div>
	        </div>
	        <div class="pre_info">
	            <div class="per_title">
	                <p>联系方式</p>
	            </div>
	            <div class="per_infoCont">
	                <div>
	                    <span class="pre_title">手机号码：&nbsp;&nbsp;</span>
	                    <span>${adminResume.rphone}</span>
	                </div>
	                <div>
	                    <span class="pre_title">电子邮箱：&nbsp;&nbsp;</span>
	                    <span>${adminResume.remail}</span>
	                </div>
	            </div>
	        </div>
	        <div class="pre_info">
	            <div class="per_title">
	                <p>教育经历</p>
	            </div>
	            <div class="per_infoCont">
	                <div>
	                    <span class="pre_title">学校：&nbsp;&nbsp;</span>
	                    <span>${adminResume.rschoolname}</span>
	                </div>
	                <div>
	                    <span class="pre_title">在校时间：&nbsp;&nbsp;</span>
	                    <span>
	                    	<fmt:formatDate value="${adminResume.rstartDate}" pattern="yyyy年MM月" />/
	                    	<fmt:formatDate value="${adminResume.rgraduateDate}" pattern="yyyy年MM月" />
	                    </span>
	                </div>
	            </div>
	        </div>
	        <div class="pre_info">
	            <div class="per_title">
	                <p>求职意向</p>
	            </div>
	            <div class="per_infoCont">
	                <div>
	                    <span class="pre_title">期望工作城市：&nbsp;&nbsp;</span>
	                    <span>${adminResume.rdesiredCity}</span>
	                </div>
	                <div>
	                    <span class="pre_title">期望从事行业：&nbsp;&nbsp;</span>
	                    <span>${adminResume.rdesiredIndustry}</span>
	                </div>
	                <div>
	                    <span class="pre_title">期望从事职业：&nbsp;&nbsp;</span>
	                    <span>${adminResume.rdesiredFunction}</span>
	                </div>
	                <div>
	                    <span class="pre_title">目前状况：&nbsp;&nbsp;</span>
	                    <span>${adminResume.rcurrentStatus}</span>
	                </div>
	                <div>
	                    <span class="pre_title">期望薪资：&nbsp;&nbsp;</span>
	                    <span>${adminResume.rdesiredSalary}</span>
	                </div>
	                <div>
	                    <span class="pre_title">到职时间：&nbsp;&nbsp;</span>
	                    <span>${adminResume.rdesiredWorktime}</span>
	                </div>
	            </div>
	        </div>
	        <div class="pre_info">
	            <div class="per_title">
	                <p>自我评价</p>
	            </div>
	            <div class="per_infoCont">
	                <div>
	                    <span class="pre_title">自我评价：&nbsp;&nbsp;</span>
	                    <span>${adminResume.revaluation }</span>
	                </div>
	            </div>
	        </div>
	    </div>
    </div>
</body>
<script type="text/javascript">
    $(function () {
        $("#downloadPdf").click(function () {
            var targetDom = $("#pdfContainer");
            //把需要导出的pdf内容clone一份，这样对它进行转换、微调等操作时才不会影响原来界面
            var copyDom = targetDom.clone();
            //新的div宽高跟原来一样，高度设置成自适应，这样才能完整显示节点中的所有内容（比如说表格滚动条中的内容）
            copyDom.width(targetDom.width() + "px");
            copyDom.height(targetDom.height() + "px");

            $('body').append(copyDom);//ps:这里一定要先把copyDom append到body下，然后再进行后续的glyphicons2canvas处理，不然会导致图标为空

            svg2canvas(copyDom);
            html2canvas(copyDom, {
                onrendered: function (canvas) {
                    var imgData = canvas.toDataURL('image/jpeg');
                    var img = new Image();
                    img.src = imgData;
                    //根据图片的尺寸设置pdf的规格，要在图片加载成功时执行，之所以要*0.225是因为比例问题
                    img.onload = function () {
                        //此处需要注意，pdf横置和竖置两个属性，需要根据宽高的比例来调整，不然会出现显示不完全的问题
                        if (this.width > this.height) {
                            var doc = new jsPDF('l', 'mm', [this.width * 0.225, this.height * 0.225]);
                        } else {
                            var doc = new jsPDF('p', 'mm', [this.width * 0.225, this.height * 0.225]);
                        }
                        doc.addImage(imgData, 'jpeg', 0, 0, this.width * 0.225, this.height * 0.225);
                        //根据下载保存成不同的文件名
                        doc.save('pdf_' + new Date().getTime() + '.pdf');
                    };
                    //删除复制出来的div
                    copyDom.remove();
                },
                background: "#fff",
                //这里给生成的图片默认背景，不然的话，如果你的html根节点没设置背景的话，会用黑色填充。
                allowTaint: true //避免一些不识别的图片干扰，默认为false，遇到不识别的图片干扰则会停止处理html2canvas
            });
        });
    });

    function svg2canvas(targetElem) {
        var svgElem = targetElem.find('svg');
        svgElem.each(function (index, node) {
            var parentNode = node.parentNode;
            //由于现在的IE不支持直接对svg标签node取内容，所以需要在当前标签外面套一层div，通过外层div的innerHTML属性来获取
            var tempNode = document.createElement('div');
            tempNode.appendChild(node);
            var svg = tempNode.innerHTML;
            var canvas = document.createElement('canvas');
            //转换
            canvg(canvas, svg);
            parentNode.appendChild(canvas);
        });
    }

    function glyphicons2canvas(targetElem, fontClassName, fontFamilyName) {
        var iconElems = targetElem.find('.' + fontClassName);
        iconElems.each(function (index, inconNode) {
            var fontSize = $(inconNode).css("font-size");
            var iconColor = $(inconNode).css("color");
            var styleContent = $(inconNode).attr('style');
            //去掉"px"
            fontSize = fontSize.replace("px", "");
            var charCode = getCharCodeByGlyphiconsName(iconName);
            var myCanvas = document.createElement('canvas');
            //把canva宽高各增加2是为了显示图标完整
            myCanvas.width = parseInt(fontSize) + 2;
            myCanvas.height = parseInt(fontSize) + 2;
            myCanvas.style = styleContent;
            var ctx = myCanvas.getContext('2d');
            //设置绘图内容的颜色
            ctx.fillStyle = iconColor;
            //设置绘图的字体大小以及font-family的名字
            ctx.font = fontSize + 'px ' + fontFamilyName;
            ctx.fillText(String.fromCharCode(charCode), 1, parseInt(fontSize) + 1);
            $(inconNode).replaceWith(myCanvas);
        });
    }
    //根据glyphicons/glyphicon图标的类名获取到对应的char code
    function getCharCodeByGlyphiconsName(iconName) {
        switch (iconName) {
            case("glyphicons-resize-full"):
                return "0xE216";
            case ("glyphicons-chevron-left"):
                return "0xE225";
            default:
                return "";
        }
    }
</script>
</html>