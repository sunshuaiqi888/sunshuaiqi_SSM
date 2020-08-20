<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%
    String appContext = request.getContextPath();
    String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + appContext;
%>
<h2>首页asdasd</h2>
<form id="form1" name="form1">
    <input type="button" id="cxrws" onclick="selectrws()" value="查询全部任务书" />
</form>
<br>
<h4>数组算法：</h4>
<form id="sf" name="sf" >
    <input type="button" value="数组线性查找" id="linesearch"/><br><br>
    <input type="button" value="数组二分查找" id="binarysearch"/><br><br>
    <input type="button" value="数组冒泡排序" id="bubblesort"/><br><br>
    <input type="button" value="数组快速排序" id="quicksort"/>
</form>

</body>

<script src="js/jquery.js"></script>
<script type="javascript">



    function selectrws(){
        document.form1.action = "<%=basePath%>/rws/rwslist";
        document.form1.submit();
    }

    $(function(){
        $("#linesearch").click(function(){
            document.sf.action = "<%=basePath%>/rws/tzline";
            document.sf.submit();
        });

        $("#binarysearch").click(function(){
            document.sf.action = "<%=basePath%>/rws/tzbinary";
            document.sf.submit();
        });

    })


</script>

</html>
