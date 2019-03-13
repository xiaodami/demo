<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 米
  Date: 2019/2/21
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

     <table>
       <tr>
         <td>
           <form action="/insert.do" method="post"  enctype="multipart/form-data">
             <input type="file" name="up">
             <input type="submit">
           </form>
         </td>
       </tr>
       <c:forEach items="${sessionScope.down}" var="t">
         <tr>
           <td>
             <form action="/download.do?path="+t.id method="post"  enctype="multipart/form-data">
               <input type="text" value="t.id" name="path">
               <input type="submit">
             </form>

           </td>
         </tr>
       </c:forEach>

     </table>
  </body>
</html>
