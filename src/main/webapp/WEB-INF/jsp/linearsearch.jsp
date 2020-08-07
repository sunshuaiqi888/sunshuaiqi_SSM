<%--
  Created by IntelliJ IDEA.
  User: sunsq
  Date: 2020/8/7
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String appContext = request.getContextPath();

    String basePath =request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + appContext;
%>
<html>
<head>
    <title>线性查找</title>
</head>
<body>
    <form id="form1" name="form1" action="">
        <h2>提示：仅输入整数型数据，例如-1,10,23,-88....</h2>
        <table border="0">
            <tr>
                <td align="right">输入源数组：</td>
                <td align="left"><input type="text" id="orge" name="orge" onkeyup="this.value=this.value.replace(/[^\d\,]/g,'')"/></td>
            </tr>
            <tr>
                <td align="right">输入要查找的字符：</td>
                <td align="left"><input type="text" id="orgechar" name="orgechar" onkeyup="this.value=this.value.replace(/[^\d\,]/g,'')"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td align="center" colspan="2"><input type="button" id="sub" value="执行算法"/></td>
            </tr>
        </table>

    </form>
    <div id="fgx" ></div>

</body>

<script src="../../js/jquery.js"></script>
<script>

    $(function(){
        $("#sub").click(function(){
            var arraydata = $("#orge").val();
            var arraychardata = $("#orgechar").val();
            $.ajax({
                type:"post",
                url:"<%=basePath%>/rws/lineSearch",
                data:{"arraydata":arraydata,"arraychardata":arraychardata},
                dataType:"json",
                success:function(data){
                    $("#fgx").empty();
                    $("#fgx").append("<br><h2>响应：</h2><div >"+data.result+"</div>")
                },
                error:function(data){
                    console.log("error:"+data);
                }
            })
        })
    })
</script>
</html>
