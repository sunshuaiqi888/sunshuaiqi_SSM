<%--
  Created by IntelliJ IDEA.
  User: sunsq
  Date: 2020/8/6
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>任务书页面</title>
</head>
<body>
        <table width="100%" border="15">
            <caption>所有任务书信息</caption>
            <thead>
            <tr>
                <th>ID</th>
                <th>任务描述</th>
            </tr>
            </thead>
            <tbody>

            <%--   是EL表达式中的一个隐含对象，类似request，                                 --%>
            <%--   如：${requestScope.username} 表示在request域中取得username属性所对应的值，--%>
            <%--   相当于request.getAttribute(“username”)。                               --%>
            <c:forEach items="${requestScope.rwsxx}" var="rws">
                <tr>
                    <td>${rws.task_id}</td>
                    <td>${rws.task_des}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
</body>
</html>
