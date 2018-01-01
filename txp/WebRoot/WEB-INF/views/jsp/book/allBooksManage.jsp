<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的书籍</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        var url;

        function searchBook() {
            $("#dg").datagrid('load', {
                "bookName": $("#s_bookName").val(),
                "bookType": $("#s_bookType").val(),
                "borrowType": $("#s_borrowType").val()
            });
        }


    </script>
</head>
<body style="margin:1px;">
<table id="dg" title="借书管理" class="easyui-datagrid" fitColumns="true"
       pagination="true" rownumbers="true"
       url="${pageContext.request.contextPath}/book/listAll" fit="true"
       toolbar="#tb">
    <thead>
    <tr>
        <th field="cb" checkbox="true" align="center"></th>
        <th field="bookName" width="100" align="center">书名</th>
        <th field="bookType" width="100" align="center">书籍类型</th>
        <th field="borrowType" width="100" align="center">出借类型</th>
        <th field="userName" width="100" align="center">书主</th>
        <th field="phoneNumber" width="100" align="center">联系电话</th>
    </tr>
    </thead>
</table>
<div id="tb">
    <div>
        &nbsp;书名：&nbsp;<input type="text" id="s_bookName" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
        &nbsp;书籍类型：&nbsp;<input type="text" id="s_bookType" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
        &nbsp;出借类型：&nbsp;<input type="text" id="s_borrowType" size="20" onkeydown="if(event.keyCode==13) searchUser()"/>
        <a href="javascript:searchBook()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
    </div>
</div>

</body>
</html>