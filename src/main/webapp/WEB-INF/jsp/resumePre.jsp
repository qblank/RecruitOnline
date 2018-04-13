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
</head>
<body>
    <div class="previewMain">
        <!--顶部-->
        <table class="preview_top">
            <tr>
                <td>
                    <div class="preview_top_left">
                        <h3>简历预览</h3>
                    </div>
                </td>
                <td>
                    <div class="preview_top_right">
                        <div class="operate">
                            <a href="${pageContext.request.contextPath }/resume_resumeJsp.action"><i class="fa fa-pencil" aria-hidden="true">&nbsp;&nbsp;</i>修改简历</a>
                            <a href="${pageContext.request.contextPath }/resume_exportResume.action"><i class="fa fa-upload" aria-hidden="true">&nbsp;&nbsp;</i>导出简历</a>
                        </div>
                    </div>
                </td>
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
                            <span>${resumeResult.rname}</span>
                        </p>
                        <p>
                            <span class="desTitle">手机号码:&nbsp;&nbsp;</span>
                            <span>${resumeResult.rphone}</span>
                        </p>
                        <p>
                            <span class="desTitle">电子邮箱:&nbsp;&nbsp;</span>
                            <span>${resumeResult.remail}</span>
                        </p>
                        <p>
                            <span class="desTitle">现居住城市:&nbsp;&nbsp;</span>
                            <span>${resumeResult.residentialAddress}</span>
                        </p>
                    </div>
                </td>
                <td width="60%">
                    <div class="per_basicInfo">
                        <p id="li_graduation_date">
                            <span class="desTitle">毕业时间：</span>
                            <span>${resumeResult.rgraduateDate}</span>
                        </p>
                        <p id="li_school_name">
                            <span class="desTitle">学校名称：</span>
                            <span>${resumeResult.rschoolname}</span>
                        </p>
                        <p id="li_major_name">
                            <span class="desTitle">专业：</span>
                            <span>${resumeResult.rprofessional}</span>
                        </p>
                        <p id="li_education_degree">
                            <span class="desTitle">学历：</span>
                            <span>
                            	<c:if test="${resumeResult.reducationType == 1}">本科</c:if>
                            	<c:if test="${resumeResult.reducationType == 2}">大专</c:if>
                            	<c:if test="${resumeResult.reducationType == 3}">专科</c:if>
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
                    <span>${resumeResult.rgender}</span>
                </div>
                <div id="li_birth">
                    <span class="pre_title">出生日期：&nbsp;&nbsp;</span>
                    <span>${resumeResult.rbirthday}</span>
                </div>
                <div id="li_hukou_city">
                    <span class="pre_title">入学前户口所在地：&nbsp;&nbsp;</span>
                    <span>${resumeResult.roriginAddress}</span>
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
                    <span>${resumeResult.rphone}</span>
                </div>
                <div>
                    <span class="pre_title">电子邮箱：&nbsp;&nbsp;</span>
                    <span>${resumeResult.remail}</span>
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
                    <span>${resumeResult.rschoolname}</span>
                </div>
                <div>
                    <span class="pre_title">在校时间：&nbsp;&nbsp;</span>
                    <span>
                    	<fmt:formatDate value="${resumeResult.rstartDate}" pattern="yyyy年MM月" />/
                    	<fmt:formatDate value="${resumeResult.rgraduateDate}" pattern="yyyy年MM月" />
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
                    <span>${resumeResult.rdesiredCity}</span>
                </div>
                <div>
                    <span class="pre_title">期望从事行业：&nbsp;&nbsp;</span>
                    <span>${resumeResult.rdesiredIndustry}</span>
                </div>
                <div>
                    <span class="pre_title">期望从事职业：&nbsp;&nbsp;</span>
                    <span>${resumeResult.rdesiredFunction}</span>
                </div>
                <div>
                    <span class="pre_title">目前状况：&nbsp;&nbsp;</span>
                    <span>${resumeResult.rcurrentStatus}</span>
                </div>
                <div>
                    <span class="pre_title">期望薪资：&nbsp;&nbsp;</span>
                    <span>${resumeResult.rdesiredSalary}</span>
                </div>
                <div>
                    <span class="pre_title">到职时间：&nbsp;&nbsp;</span>
                    <span>${resumeResult.rdesiredWorktime}</span>
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
                    <span>${resumeResult.revaluation }</span>
                </div>
            </div>
        </div>
    </div>
</body>
</html>