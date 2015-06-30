<%@ page import="com.demo.resource.Theater" %>
<%@ page import="java.util.List" %>
<%@ page import="com.demo.resource.MovieInfo" %>
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
%>
<html>
<head>
    <title></title>
  <img src="<%=theater.getImage()%>"/>
  <%=theater.getUid()%>
  <%=theater.getTelephone()%>
  <%=theater.getName()%>
  <%=theater.getAddress()%>
  <%
    for(int i=0;i<tlist.size();i++)
    {
      %>
        <p><%=tlist.get(i).getName()%><p/>
        <img src="http://webmap0.map.bdimg.com/maps/services/thumbnails?width=120&height=170&quality=80&src=<%=tlist.get(i).getPicture()%>"/>
       <p><%=tlist.get(i).getActor()%><p/>
       <p><%=tlist.get(i).getBrief()%><p/>
      <%
    }
  %>

</head>
<body>

</body>
</html>
