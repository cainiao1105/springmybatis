<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setDateHeader("Expires",0);
    response.setHeader("Pragma","no-cache");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/extBrowser.js" charset="utf-8"></script>

<!-- 引入kindEditor插件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/js/kindeditor-4.1.7/themes/default/default.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/kindeditor-4.1.7/kindeditor-all-min.js" charset="utf-8"></script>

<!-- 引入Highcharts -->
<script src="${pageContext.request.contextPath}/frame/js/Highcharts-3.0.1/js/highcharts.js" type="text/javascript" charset="utf-8"></script>

<!-- 引入bootstrap样式 -->
<%-- <link href="${pageContext.request.contextPath}/frame/js/bootstrap-2.3.1/css/bootstrap.min.css" rel="stylesheet" media="screen"> --%>

<!-- 引入EasyUI -->
<link id="easyuiTheme" rel="stylesheet" href="${pageContext.request.contextPath}/frame/js/jquery-easyui-1.3.3/themes/default/easyui.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/js/jquery-easyui-1.3.3/themes/icon.css" type="text/css">

<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/jquery-easyui-1.3.3/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<!-- 修复EasyUI1.3.3中layout组件的BUG -->
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/jquery-easyui-1.3.3/plugins/jquery.layout.js" charset="utf-8"></script>

<!-- 引入EasyUI Portal插件 -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/js/jquery-easyui-portal/portal.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/jquery-easyui-portal/jquery.portal.js" charset="utf-8"></script>

<!-- 扩展EasyUI -->
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/extEasyUI.js?v=201305241044" charset="utf-8"></script>

<!-- 扩展EasyUI Icon -->
<!--<link rel="stylesheet" href="${pageContext.request.contextPath}/frame/css/extEasyUIIcon.css?v=201305301906" type="text/css">-->
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/frame/css/myIcon.css?v=201305301906" type="text/css"> --%>

<!-- 扩展jQuery -->
<script type="text/javascript" src="${pageContext.request.contextPath}/frame/js/extJquery.js?v=201305301341" charset="utf-8"></script>
