<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>搜索页面</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
    <script src="js/jquery-1.8.2.js"></script>
    <script src="js/carousel.js"></script>
    <script type="text/javascript" src="js/base.js"></script>
    <link rel="stylesheet" href="css/searchPage.css">
</head>
<body>
	<!-- 引入头部 -->
	<%@ include file="./header.jsp" %>
	<%@ include file="./search.jsp" %>

    <div class="searchTab">
        <div class="screenings">
            <ul>
                <li class="screeningsList">
                    <div class="screeningsName">工作地点</div>
                    <div class="screeningsItems">
                        <div class="screeningsItemsBox">
                            <a href="#">长沙(20)</a>
                            <a href="#">广州(0)</a>
                            <a href="#">深圳(0)</a>
                            <a href="#">上海(0)</a>
                            <a href="#">北京(0)</a>
                        </div>
                    </div>
                </li>
                <li class="screeningsList">
                    <div class="screeningsName">招聘类型</div>
                    <div class="screeningsItems">
                        <div class="screeningsItemsBox">
                            <a href="#">兼职(9)</a>
                            <a href="#">全职(0)</a>
                        </div>
                    </div>
                </li>
                <li class="screeningsList">
                    <div class="screeningsName">公司性质</div>
                    <div class="screeningsItems">
                        <div class="screeningsItemsBox">
                            <a href="#">民营(9)</a>
                            <a href="#">国企(0)</a>
                        </div>
                    </div>
                </li>
                <li class="screeningsList">
                    <div class="screeningsName">职位类型</div>
                    <div class="screeningsItems">
                        <div class="screeningsItemsBox">
                            <a href="#">IT(9)</a>
                            <a href="#">医学(0)</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <div class="searchMain">
        <div class="searchResultBox">
            <div class="searchResultHead">
                <div class="searchResultInfo">
                    <span class="searchResultTol">共找到 <em>100</em>个符合条件的职业</span>
                    <span class="searchResultPagePer"><em>1</em>/5</span>
                </div>
            </div>
            <div class="searchResultList">
                <ul class="searchResultListU1">
                	<c:forEach items="${searchPositions }" var="searchPosition">
	                    <li>
	                        <div class="searchResultItemSimple">
	                            <div class="searchResultJobinfo">
	                                <p class="searchResultJobName">
	                                    <a href="${pageContext.request.contextPath }/job_jobdetail.action?pid=${searchPosition.position.pid}"><span style="color:#F87002;"></span>${searchPosition.position.pname }</a>
	                                    <span class="tips">校园招聘</span>
	                                </p>
	                                <p class="searchResultJobAdrNum">
	                                    <span class="searchResultKeyval">
	                                        <!--地点图标-->
	                                        <i class="nicon niconAdr"></i>
	                                        <span>城市：<em class="searchResultJobCityval">${searchPosition.firm.fsite}</em></span>
	                                    </span>
	                                    <span class="searchResultKeyval">
	                                        <!--人数图标-->
	                                        <i class="nicon niconPeopnum"></i>
	                                        <span>人数：<em class="searchResultJobPeopnum">${searchPosition.position.pnum }</em></span>
	                                    </span>
	                                </p>
	                                <p class="pt15 pb10">
	                                <span class="searchResultKeyval">
	                                    <!--时间图标-->
	                                    <i class="nicon niconReleasetime"></i>
	                                    <span>发布时间：<em></em><fmt:formatDate value="${searchPosition.position.pubdate }" pattern="yyyy-MM-dd"/></span>
	                                </span>
	                                </p>
	                            </div>
	                            <div class="searchResultCompanyinfo">
	                                <p class="searchResultCompanyname">
	                                    <span>${searchPosition.firm.fname }</span>
	                                </p>
	                                <p class="searchResultCompanyIndustry">${searchPosition.firm.industry}</p>
	                            </div>
	                        </div>
	                    </li>
                    </c:forEach>
                    <!--以下为重复数据-->
                    
                </ul>
            </div>
        </div>
    </div>
    
    <!-- 引入尾部 -->
    <%@ include file="./booter.jsp" %>
</body>
</html>