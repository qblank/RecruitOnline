<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>简历模板页面</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/resume.css">
    <link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/goodinserter/jquery.cxcalendar.css">
</head>
<body>
	<%@include file="./header.jsp" %>
    <div class="resumeWrap">
        <div class="leftResume">
            <div class="resumeTitle">
                <span>个人简历</span>
            </div>
            <div class="resumeMain">
                <div class="tabWrap">
                    <div class="tabTitle">
                        <h3 class="dib">
                            个人信息
                            <span>(必填)</span>
                        </h3>
                        <p>详尽的个人信息能让企业更快的了解您</p>
                        <div class="tabOperate" id="person_edit">
                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        </div>
                    </div>
                    <!--可编辑表单-->
                    <div class="tabMain"  id="person_info">
                        <s:form id="personForm">
                            <div class="itemWrap">
                                <div class="itemTitle">
                                    <i class="icon_must">*&nbsp;</i>
                                    姓名
                                </div>
                                <div class="itemCont">
                                    <input type="text" maxlength="40" name="rname" value="${resumeResult.rname}">
                                </div>
                            </div>
                            <div class="itemWrap">
                                <div class="itemTitle">
                                    <i class="icon_must">*&nbsp;</i>
                                    性别
                                </div>
                                <div class="itemCont">
                                    <select name="rgender">
                                    	<s:set var="gender" value="#resumeResult.rgender"/>
                                        <option value="">--请选择--</option>
                                        <option <s:if test="rgender==man">selected</s:if> value="<s:property value="man"/>">男</option>
                                        <option <c:if test="rgender==woman">selected</c:if> value="woman">女</option>
                                    </select>
                                </div>
                            </div>
                            <div class="itemWrap">
                                <div class="itemTitle">
                                    <i class="icon_must">*&nbsp;</i>
                                    出生日期
                                </div>
                                <div class="itemCont">
                                    <input id="date_e" name="rbirthday" value="${resumeResult.rbirthday}" type="text" readonly>
                                </div>
                            </div>
                            <div class="itemWrap">
                                <div class="itemTitle">
                                    <i class="icon_must">*&nbsp;</i>
                                    证件号码
                                </div>
                                <div class="itemCont">
                                    <input type="text" name="ridentityCard" value="${resumeResult.ridentityCard}" maxlength="40"  />
                                </div>
                            </div>
                            <div class="itemWrap">
                                <div class="itemTitle">
                                    <i class="icon_must">*&nbsp;</i>
                                    现居住地
                                </div>
                                <div class="itemCont">
                                    <input type="text" name="residentialAddress" value="${resumeResult.residentialAddress}" maxlength="40">
                                </div>
                            </div>
                            
                            <div class="itemWrap">
                                <div class="itemTitle">
                                    <i class="icon_must">*&nbsp;</i>
                                    籍贯
                                </div>
                                <div class="itemCont">
                                    <input type="text" name="roriginAddress" value="${resumeResult.roriginAddress}" maxlength="40">
                                </div>
                            </div>
                            <div class="itemWrap">
                                <div class="itemTitle">
                                    <i class="icon_must">*&nbsp;</i>
                                    毕业时间
                                </div>
                                <div class="itemCont">
                                    <input id="date_gradual" name="rgraduateDate" value="${resumeResult.rgraduateDate}" type="text" readonly>
                                </div>
                            </div>
                            <!-- 提交信息 -->
                            <div class="btnWrap">
                            	<a href="javascript:void(0)" class="btnSure" id="personInfo">保存</a>
                            	<a href="javascript:void(0)" class="btnCancel" id="btnCancel">取消</a>
                            </div>
                        </s:form>
                    </div>
                </div>
                <div class="tabWrap">
                    <div class="tabTitle">
                        <h3 class="dib">
                            联系方式
                            <span>(必填)</span>
                        </h3>
                        <p>详尽的个人信息能让企业更快的了解您</p>
                        <div class="tabOperate" id="contact_edit">
                            <i class="fa fa-pencil-square-o"></i>
                        </div>
                    </div>
                    <!--可编辑表单-->
                    <div class="tabMain" id="contact">
                        <form action="">
                            <div class="itemWrap">
                                <div class="itemTitle">
                                    <i class="icon_must">*&nbsp;</i>
                                    手机号码
                                </div>
                                <div class="itemCont">
                                    <input type="text" class="" maxlength="40">
                                </div>
                            </div>
                            <div class="itemWrap">
                                <div class="itemTitle">
                                    <i class="icon_must">*&nbsp;</i>
                                    电子邮箱
                                </div>
                                <div class="itemCont">
                                    <input type="text" class="" maxlength="40">
                                </div>
                            </div>
                        	<!-- 提交信息 -->
                            <div class="btnWrap">
                            	<a href="javascript:void(0)" class="btnSure">保存</a>
                            	<a href="javascript:void(0)" class="btnCancel">取消</a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="tabWrap">
                    <div class="tabTitle">
                        <h3 class="dib">
                            教育经历
                            <span>(必填)</span>
                        </h3>
                        <p>详尽的个人信息能让企业更快的了解您</p>
                        <div class="tabOperate">
                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        </div>
                    </div>
                    <!--可编辑表单-->
                    <div class="tabMain">

                    </div>
                </div>
                <div class="tabWrap">
                    <div class="tabTitle">
                        <h3 class="dib">
                            求职意向
                            <span>(必填)</span>
                        </h3>
                        <p>详尽的个人信息能让企业更快的了解您</p>
                        <div class="tabOperate">
                            <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                        </div>
                    </div>
                    <!--可编辑表单-->
                    <div class="tabMain">

                    </div>
                </div>
            </div>
        </div>
        <div class="rightResume">
            <div class="resumeTop"></div>
            <a href="#" class="btnPreview">预览简历</a>
            <div class="btnMenu" id="btnMenu">
                <ul>
                    <li class="current">
                        <i class="fa fa-user-o">&nbsp;&nbsp;个人信息</i>
                    </li>
                    <li><i class="fa fa-address-card">&nbsp;&nbsp;联系方式</i></li>
                    <li><i class="fa fa-graduation-cap">&nbsp;&nbsp;教育经历</i></li>
                    <li><i class="fa fa-rocket"></i>&nbsp;&nbsp;求职意向</li>
                </ul>
            </div>

        </div>
    </div>
</body>
<script src="js/jquery-1.8.2.js"></script>
<script src="js/goodinserter/jquery.cxcalendar.js"></script>
<script src="js/goodinserter/jquery.cxcalendar.languages.js"></script>
<script src="js/timePicker.js"></script>
<script src="js/resume.js"></script>
</html>