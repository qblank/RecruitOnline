<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>校园招聘网</title>
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="fontawesome/css/font-awesome.min.css">
    <script src="js/jquery-1.8.2.js"></script>
    <script src="js/carousel.js"></script>
    <script src="js/index.js"></script>
</head>
<body>
	<%@include file="./header.jsp" %>
	<%@include file="./search.jsp" %>
    <div class="content" id="top">
        <!--左边导航栏-->
        <div class="content_left">
            <ul class="left_nav" id="left_nav">
                <li><a href="#">工学</a></li>
                <li><a href="#">理学</a></li>
                <li><a href="#">农学</a></li>
                <li><a href="#">医学</a></li>
                <li><a href="#">法学</a></li>
                <li><a href="#">其他</a></li>
            </ul>
            <div class="detail" id="detail">
                <p class="detail_title"></p>
                <div class="detail_all">
                   <!-- <a href="#">测试</a>-->
                </div>
            </div>
        </div>
        <!--轮播图-->
        <div id="main">
            <ul id="picture">
                <li><img src="images/index/b1.jpg" width="1059px" height="480px"></li>
                <li><img src="images/index/b2.jpg" width="1059px" height="480px"></li>
                <li><img src="images/index/b3.jpg" width="1059px" height="480px"></li>
                <li><img src="images/index/b4.jpg" width="1059px" height="480px"></li>
                <li><img src="images/index/b5.jpg" width="1059px" height="480px"></li>
                <li><img src="images/index/b6.jpg" width="1059px" height="480px"></li>
                <li><img src="images/index/b7.jpg" width="1059px" height="480px"></li>
                <li><img src="images/index/b8.jpg" width="1059px" height="480px"></li>
            </ul>
            <div class="pointList" id="pointList">
             		<li class="pointer" style="background-color:#db192a"></li>
	                <li class="pointer"></li>
	                <li class="pointer"></li>
	                <li class="pointer"></li>
	                <li class="pointer"></li>
	                <li class="pointer"></li>
	                <li class="pointer"></li>
	                <li class="pointer"></li>
            </div>
            <div id="arr">
                <span id="left"><</span>
                <span id="right">></span>
            </div>
        </div>
        <!--新闻模块-->
        <div class="news">
            <div class="new new_apply">
                <dl>
                    <dt>
                        <i class="fa fa-internet-explorer"></i>
                        <span class="title_text">最新网申</span>
                    </dt>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="网络营销员">
                                    <a href="#">网络营销员</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="新媒体营销讲师">
                                    <a href="#">新媒体营销讲师</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="CFO助理">
                                    <a href="#">CFO助理</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="销售运营专员/助理">
                                    <a href="#">销售运营专员/助理</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="网络营销员">
                                    <a href="#">网络营销员</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                </dl>
            </div>
            <div class="new new_work">
                <dl>
                    <dt>
                        <i class="fa fa-shopping-bag" aria-hidden="true"></i>
                        <span class="title_text">最新实习</span>
                    </dt>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="网络营销员">
                                    <a href="#">网络营销员</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="新媒体营销讲师">
                                    <a href="#">新媒体营销讲师</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="CFO助理">
                                    <a href="#">CFO助理</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="销售运营专员/助理">
                                    <a href="#">销售运营专员/助理</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="网络营销员">
                                    <a href="#">网络营销员</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                </dl>
            </div>
            <div class="new new_talk">
                <dl>
                    <dt>
                        <i class="fa fa-users" aria-hidden="true"></i>
                        <span class="title_text">最新宣讲会</span>
                    </dt>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="网络营销员">
                                    <a href="#">网络营销员</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="新媒体营销讲师">
                                    <a href="#">新媒体营销讲师</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="CFO助理">
                                    <a href="#">CFO助理</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="销售运营专员/助理">
                                    <a href="#">销售运营专员/助理</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                    <dd>
                        <div class="dd_content_wrap">
                            <div class="news_info_text">
                                <p title="网络营销员">
                                    <a href="#">网络营销员</a>
                                </p>
                                <a href="#" class="btn_apply">立即申请</a>
                            </div>
                        </div>
                    </dd>
                </dl>
            </div>
        </div>
        <!--下边栏-->
        <!--模块1-->
        <c:forEach var="firmCate" items="${firmCates}">
	        <div class="model" id="model${firmCate.fcid}">
	            <div class="pro_nav">
	                <span class="des_title">${firmCate.fcname}</span>
	                <span>这是${firmCate.fcname}的世界</span>
	            </div>
	            <!--重复代码-->
	            <div class="pros_content">
	                <ul>
	                    <!--以下内容可以通过数据库获取数据-->
	                    <c:forEach var="firmIT" items="${firmCate.firms}">
	                    <li>
	                        <a href="${pageContext.request.contextPath }/job_firmDetail.action?fid=${firmIT.fid}">
	                            <div class="pro_des">
	                                <img src="${firmIT.flogo}" width="130px"><br>
	                                <span class="des_word">${firmIT.fname}</span>
	                            </div>
	                            <div class="mask">${firmIT.fname}</div>
	                        </a>
	
	                    </li>
	                    </c:forEach>
	                    <li>
	                        <a href="html/jobdetail.html">
	                            <div class="pro_des">
	                                <img src="images/jobs/job.jpg" width="130px"><br>
	                                <span class="des_word">邮政</span>
	                            </div>
	                            <div class="mask">我是邮政</div>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="html/jobdetail.html">
	                            <div class="pro_des">
	                                <img src="images/jobs/job.jpg" width="130px"><br>
	                                <span class="des_word">邮政</span>
	                            </div>
	                            <div class="mask">我是邮政</div>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="html/jobdetail.html">
	                            <div class="pro_des">
	                                <img src="images/jobs/job.jpg" width="130px"><br>
	                                <span class="des_word">邮政</span>
	                            </div>
	                            <div class="mask">我是邮政</div>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="html/jobdetail.html">
	                            <div class="pro_des">
	                                <img src="images/jobs/job.jpg" width="130px"><br>
	                                <span class="des_word">邮政</span>
	                            </div>
	                            <div class="mask">我是邮政</div>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="html/jobdetail.html">
	                            <div class="pro_des">
	                                <img src="images/jobs/job.jpg" width="130px"><br>
	                                <span class="des_word">邮政</span>
	                            </div>
	                            <div class="mask">我是邮政</div>
	                        </a>
	                    </li>
	                    <li>
	                        <a href="html/jobdetail.html">
	                            <div class="pro_des">
	                                <img src="images/jobs/job.jpg" width="130px"><br>
	                                <span class="des_word">邮政</span>
	                            </div>
	                            <div class="mask">我是邮政</div>
	                        </a>
	                    </li>
	                </ul>
	            </div>
	        </div>
        </c:forEach>
        <!--左边悬浮导航栏-->
        <div class="left_list">
            <ul id="lefts_nav">
                <li><a >IT</a></li>
                <li><a>金融</a></li>
                <li><a>房地产</a></li>
                <li><a>汽车</a></li>
                <li><a>热门</a></li>
                <li><a>机电</a></li>
                <li><a href="#top">顶部</a></li>
            </ul>
        </div>
    </div>
    
    <%@include file="booter.jsp" %>
</body>
<!-- <script>
    /*测试导入搜索框*/
    var post = document.querySelector("link[rel = 'import']").import;
    var con = post.querySelector("div");
    document.querySelector("#header").appendChild(con.cloneNode(true));
</script> -->
</html>