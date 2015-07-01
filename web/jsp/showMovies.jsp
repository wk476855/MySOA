<%@ page import="com.demo.resource.MovieInfo" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 15/6/24
  Time: 下午9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<MovieInfo> movieInfos=(List<MovieInfo>)request.getAttribute("movies");%>
<% String lat=(String)request.getAttribute("lat");%>
<% String lng=(String)request.getAttribute("lng");%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
  <meta name="description" content="">
  <meta name="author" content="">
  <link rel="icon" href="../image/SOA.ico">

  <title>热映电影及周边影院信息系统</title>

  <!-- Bootstrap core CSS -->
  <link href="../CSS/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../CSS/offcanvas.css" rel="stylesheet">

  <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
  <!--[if lt IE 9]><script src="ie8-responsive-file-warning.js"></script><![endif]-->
  <script src="../js/ie-emulation-modes-warning.js"></script>

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body>
<nav class="navbar navbar-fixed-top navbar-inverse">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">SOA Project</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">首页</a></li>
        <li><a href="#about">附近影院</a></li>
      </ul>
    </div><!-- /.nav-collapse -->
  </div><!-- /.container -->
</nav><!-- /.navbar -->

<div class="container">

  <div class="row row-offcanvas row-offcanvas-right">

    <div class="col-xs-12 col-sm-12">
      <p class="pull-right visible-xs">
        <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
      </p>
      <div class="jumbotron">
        <h1>热映电影</h1>
        <p>这里有最新的热映电影信息，赶紧来看看吧！！</p>
      </div>
      <%--<div class="row">--%>
        <%--<div class="col-xs-6 col-lg-4">--%>
          <%--<h2>Heading</h2>--%>
          <%--<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>--%>
          <%--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>--%>
        <%--</div><!--/.col-xs-6.col-lg-4-->--%>
        <%for(int i=0;i<movieInfos.size();i++){
          if(i%3==0)
          {
            %><div class="row"><%
          }
          %><div class="col-xs-4 col-lg-4">
        <h2><%=movieInfos.get(i).getName()%></h2>
          <a href="/servlet/Theaters?movname=<%=movieInfos.get(i).getName()%>&lat=<%=lat%>&lng=<%=lng%>"><img src="<%=movieInfos.get(i).getPicture()%>"/></a>
          <p>导演：<%=movieInfos.get(i).getDirector()%></p>
          <p>演员：<%=movieInfos.get(i).getActor()%></p>
          <p>简介：<%=movieInfos.get(i).getBrief()%></p>
          <p>上映时间：<%=movieInfos.get(i).getRelease_date()%></p>
          <p>评分：<%=movieInfos.get(i).getScore()%></p>
      </div><%
          if(i%3==2)
          {
        %></div><%
            }
        }%>
      <%--</div><!--/row-->--%>
    </div><!--/.col-xs-12.col-sm-12-->

  <hr>

  <footer>
    <p>&copy; Company 2015</p>
  </footer>

</div><!--/.container-->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../js/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../js/ie10-viewport-bug-workaround.js"></script>

<script src="../js/offcanvas.js"></script>
</body>
</html>

