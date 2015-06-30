<%@ page import="com.demo.resource.Theater" %>
<%@ page import="java.util.List" %>
<%@ page import="com.demo.resource.MovieInfo" %>
<%@ page import="com.demo.resource.TimeTable" %>
<%--
  Created by IntelliJ IDEA.
  User: ERA
  Date: 2015/6/30
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Theater theater=(Theater)request.getAttribute("theater");
  List<MovieInfo> tlist = (List<MovieInfo>)theater.getMovieInfos();
    String movname = (String) request.getAttribute("movname");
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
                <li class="active"><a href="/servlet/Theaters">附近影院</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->

<div class="container">

    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-12">
            <div class="row">
                <div class="jumbotron row">
                    <div class="col-xs-3 col-lg-3">
                        <img src="<%=theater.getImage()%>"/>
                    </div>
                    <div class="col-xs-9 col-lg-9">
                        <p>名称：<%=theater.getName()%></p>
                        <p>地址：<%=theater.getAddress()%></p>
                        <p>电话：<%=theater.getTelephone()%></p>
                    </div>
                </div>
            </div>

            <%
                if(tlist != null) {
                    for(int i=0; i<tlist.size(); i++) {
                        if(movname == null || movname.equals("null"))  movname="";
                        if(tlist.get(i).getName().contains(movname)) {
                            MovieInfo movieInfo = tlist.get(i);
                            List<TimeTable> timeTables = movieInfo.getTimeTables();
                            %>
                                <div class="row">
                                    <div class="col-xs-3 col-lg-3">
                                        <img  src="http://webmap0.map.bdimg.com/maps/services/thumbnails?width=120&height=170&quality=80&src=<%=movieInfo.getPicture()%>"/>
                                    </div>
                                    <div class="col-xs-9 col-lg-9">
                                        <p>名称：<%=movieInfo.getName()%></p>
                                        <p>演员：<%=movieInfo.getActor()%></p>
                                        <p>导演：<%=movieInfo.getDirector()%></p>
                                        <p>上映时间：<%=movieInfo.getRelease_date()%></p>
                                        <p>时长：<%=movieInfo.getTime()%></p>
                                        <p>标签：<%=movieInfo.getTag()%></p>
                                        <p>类型：<%=movieInfo.getType()%></p>
                                        <p>简介时长：<%=movieInfo.getBrief()%></p>
                                    </div>
                                </div>
                                <div class="row">
                                    <table class="table">
                                        <tr>
                                            <td>日期</td>
                                            <td>时间</td>
                                            <td>类型</td>
                                            <td>语言</td>
                                            <td>影院</td>
                                            <td>价格</td>
                                        </tr>
                                    <%
                                        if(timeTables != null) {
                                            for(int j=0; j<timeTables.size(); j++) {
                                            %>
                                                <tr>
                                                    <td><%=timeTables.get(j).getDate()%></td>
                                                    <td><%=timeTables.get(j).getTime()%></td>
                                                    <td><%=timeTables.get(j).getType()%></td>
                                                    <td><%=timeTables.get(j).getLan()%></td>
                                                    <td><%=timeTables.get(j).getTheater()%></td>
                                                    <td><%=timeTables.get(j).getPrice()%></td>
                                                </tr>
                                            <%
                                                    }
                                        }

                                    %>
                                    </table>
                                </div>
                            <%
                        }
                    }
                                }
            %>
            <div class="row">
                <%--<div class="col-xs-6 col-lg-4">--%>
                <%--<h2>Heading</h2>--%>
                <%--<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>--%>
                <%--<p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>--%>
                <%--</div><!--/.col-xs-6.col-lg-4-->--%>

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
