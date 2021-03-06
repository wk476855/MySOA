<%@ page import="com.demo.resource.Theater" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: ERA
  Date: 2015/6/26
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Theater> tlist=(List<Theater>)request.getAttribute("Theaters");
    String movname = (String)request.getAttribute("movname");
%>
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
          <li><a href="/servlet/HotMovies">主页</a></li>
        <li class="active"><a href="#about">附近影院</a></li>
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
        <h1>附近影院</h1>
        <p>查看附近影院，选择适当的影院看喜欢的电影！</p>
      </div>
      <div class="row">
        <%--<div class="col-xs-6 col-lg-4">--%>
        <%--<h2>Heading</h2>--%>
        <%--<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>--%>
        <%--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>--%>
        <%--</div><!--/.col-xs-6.col-lg-4-->--%>
          <%for(int i=0;i<tlist.size();i++){
            if(i%4==0) {
                %>
                    <div class="row">
                <%
            }
          %>
          <div class="col-xs-3 col-lg-3">
          <h2><%=tlist.get(i).getName()%></h2>
          <%--<p> PIC：<%=tlist.get(i).getImage()%><p/>--%>
          <p>地址：<%=tlist.get(i).getAddress()%></p>
          <p>电话：<%=(tlist.get(i).getTelephone()==null?"无":tlist.get(i).getTelephone())%></p>

            <%--<form action = "/servlet/TheatersDetails">--%>
              <p><a class="btn btn-default" href="/servlet/TheatersDetails?movname=<%=movname%>&uid=<%=tlist.get(i).getUid()%>" role="button">详细信息 &raquo;</a></p>
            <%--<input type="hidden" name="uid" value=<%=tlist.get(i).getUid()%> />--%>
            <%--</form>--%>
          </div>
          <%
            if(i%4==3) {
                %></div>
                        <%
            }
          }%>
      </div><!--/row-->
    </div><!--/.col-xs-12.col-sm-9-->
  </div><!--/row-->

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
