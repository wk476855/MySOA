<%--
  Created by IntelliJ IDEA.
  User: ERA
  Date: 2015/6/30
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String TheaterPosition = (String)request.getAttribute("Position");%>
<html>
<span style="visibility:hidden">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
  <style type="text/css">
    body, html {width: 100%;height: 100%;margin:0;font-family:"微软雅黑";}
    #allmap{width:100%;height:500px;}
    p{margin-left:5px; font-size:14px;}
  </style>
  <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ytHIjvuN24Dh9yiSBc7uRioh"></script>
  <title>SOA</title>
</head>
<body>
<div id="allmap"></div>
<p>返回北京市“景点”关键字的检索结果，并展示在地图上</p>
</body>
  </span>
</html>
<script type="text/javascript">
  var position ="<%=TheaterPosition%>";
  // 百度地图API功能
  var map = new BMap.Map("allmap");
  map.centerAndZoom("上海", 11);
  var local = new BMap.LocalSearch(map, {
    renderOptions:{map: map}
  });
//  alert(position);
  local.search(position);
  local.setSearchCompleteCallback(function(rs) {
    if (local.getStatus() == BMAP_STATUS_SUCCESS) {
      var poi = rs.getPoi(0);
    }
//    alert(poi.point.lat+","+poi.point.lng);
    window.location.href="/servlet/Theaters?lat="+poi.point.lat+"&lng="+poi.point.lng;
  });
</script>
