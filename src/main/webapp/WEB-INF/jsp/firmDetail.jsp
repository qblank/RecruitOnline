<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>公司详情页</title>
    <link rel="stylesheet" href="css/frimDetail.css">
    <link rel="stylesheet" href="css/base.css">
</head>
<body>
	<%@include file="./header.jsp" %>
    <div class="cWrap">
        <div class="cCompanyTop">
            <span class="cCompany_img">
                <img src="images/firmDetail/companyBanner.jpg" alt="" />
            </span>

            <div class="cCompanyTop_msg">
                <div class="cCompanyTop_logo">
                    <img  src="${firm.flogo }">
                </div>
                <div>
                    <span class="cCompanyTop_name">${firm.fname}</span>
                </div>
            </div>
        </div>
        <!--主体-->
        <div class="cCompanyMain">
            <div class="cMainBgTop">
            </div>
            <div class="cMainbg">
                <div class="cCompanySubNav">
                    <div class="cCompanySubNavBg">
                        <div>
                        </div>
                    </div>
                    <div class="j_companySubNav">
                        <span class="current">
                            <a href="javascript:void(0)">首页</a>
                        </span>
                        <span>
                            <a href="#cCompanySearchTopWrap">职位</a>
                        </span>
                    </div>
                </div>
                <!--主体-->
                <div class="cCompanyMain_content">
                    <div class="cCompanyGuild">
                        <h1>名创优品</h1>
                        <span>公司行业：${firm.industry}</span>
                        <span>公司规模：${firm.fnum }人</span>
                        <span>公司类型：${firm.fcate}</span>
                    </div>

                    <div class="cCompanyIntro">
                        <h3>公司简介</h3>
                        <span>
                            ${firm.fdesc}
                        </span>
                    </div>
                </div>
            </div>

            <div class="cCompanySearchTopWrap" id="cCompanySearchTopWrap">

                <div class="cCompanySearchInfor">
                    共有<b>0</b>家分公司，<b>1</b>个职位
                </div>
            </div>

            <div class="cCompanySearchWrap">
                <div class="j_searchList">
                    <div class="cCompanySearchListWrap j_searchContent">
                        <ul class="cCompanySearchListOld j_cCompanySearchListOld">
                           <%--  <li>
                                <h4><a href="${pageContext.request.contextPath }/job_jobdetail.action">名创优品股份有限公司</a></h4>
                                <span>10个职位</span>
                            </li> --%>
                            <c:forEach items="${positions}" var="position">
	                            <li>
	                            	<h4><a href="${pageContext.request.contextPath }/job_jobdetail.action?pid=${position.pid}">${position.pname}</a></h4>
	                                <span>1个职位</span>
	                            </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    
    <%@include file="./booter.jsp" %>
</body>
</html>