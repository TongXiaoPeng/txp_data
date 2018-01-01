<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>借书宝系统主页</title>
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
        function addTab(url, text, iconCls) {
            var content = "<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${pageContext.request.contextPath}/"
                    + url + "'></iframe>";
            $("#tabs").tabs("add", {
                title: text,
                iconCls: iconCls,
                closable: true,
                content: content
            });
        }
        function openTab(text, url, iconCls) {
            if ($("#tabs").tabs("exists", text)) {
                $("#tabs").tabs("close", text);
                addTab(url, text, iconCls);
                $("#tabs").tabs("select", text);
            } else {
                addTab(url, text, iconCls);
            }
        }

        function openPasswordModifyDialog() {
            $("#dlg").dialog("open").dialog("setTitle", "修改密码");
            url = "${pageContext.request.contextPath}/system/modifyPassword?userId=${currentUser.userId}";
        }
        function closePasswordModifyDialog() {
            $("#dlg").dialog("close");
            $("#oldPassword").val("");
            $("#newPassword").val("");
            $("#newPassword2").val("");
        }
        function modifyPassword() {
            $("#fm").form("submit", {
                url: url,
                onSubmit: function () {
                    var newPassword = $("#newPassword").val();
                    var newPassword2 = $("#newPassword2").val();
                    if (!$(this).form("validate")) {
                        return false;
                    }
                    if (newPassword != newPassword2) {
                        $.messager.alert("系统提示", "确认密码输入错误！");
                        return false;
                    }
                    return true;
                },
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.success) {
                        $.messager.alert("系统提示", "密码修改成功，下一次登录生效！");
                        closePasswordModifyDialog();
                    } else {
                        $.messager.alert("系统提示", "密码修改失败");
                        return;
                    }
                }
            });
        }
        
		function openUserInfoModifyDialog() {
            $("#dlg1").dialog("open").dialog("setTitle", "个人资料");
            url = "${pageContext.request.contextPath}/user/modifyUserInfo?userId=${currentUser.userId}";
        }
        function closeUserInfoModifyDialog() {
            $("#dlg1").dialog("close");
            
        }
        function modifyUserInfo() {
            $("#fm1").form("submit", {
                url: url,
                success: function (result) {
                    var result = eval('(' + result + ')');
                    if (result.success) {
                        $.messager.alert("系统提示", "修改成功！");
                        closePasswordModifyDialog();
                    } else {
                        $.messager.alert("系统提示", "修改失败");
                        return;
                    }
                }
            });
        }
        
        function logout() {
            $.messager
                    .confirm(
                            "系统提示",
                            "您确定要退出系统吗",
                            function (r) {
                                if (r) {
                                    window.location.href = "${pageContext.request.contextPath}/system/logout";
                                }
                            });
        }
    </script>
    <jsp:include page="login_chk.jsp"></jsp:include>
<body class="easyui-layout">
<div region="north" style="height: 78px;background-color: #ffff">
    <table width="100%">
        <tr>
            <td width="50%"></td>
            <td valign="bottom" style="font-size: 20px;color:#8B8B8B;font-family: '楷体';" align="right" width="50%">
                <font size="3">&nbsp;&nbsp;<strong>当前管理员：</strong>${currentUser.userName}</font>【管理员】
            </td>
        </tr>
    </table>
</div>
<div region="center">
    <div class="easyui-tabs" fit="true" border="false" id="tabs">
        <div title="首页" data-options="iconCls:'icon-home'">
            <div align="center" style="padding-top: 100px">
                <font color="grey" size="10"></font>
            </div>
        </div>
    </div>
</div>
<div region="west" style="width: 200px;height:500px;" title="导航菜单"
     split="true">
    <div class="easyui-accordion">
		<div title="借书宝" data-options="iconCls:'icon-jiaocai'"
             style="padding:10px;border:none;">
            <a href="javascript:openTab(' 我的书籍','book/myBooksManage','icon-shuben')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-shuben'"
               style="width: 150px;"> 我的书籍</a>
            <a href="javascript:openTab(' 借书','book/allBooksManage','icon-shujia')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-shujia'"
               style="width: 150px;"> 借书</a>
        </div>
        <div title="系统管理" data-options="iconCls:'icon-item'"
             style="padding:10px;border:none;">
           <!--  <a href="javascript:openTab(' 管理员列表','user/userManage','icon-lxr')"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-lxr'" style="width: 150px;"> 管理员列表</a>  -->
            <a href="javascript:openUserInfoModifyDialog()"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-lxr'"
               style="width: 150px;"> 个人资料</a>
            <a href="javascript:openPasswordModifyDialog()"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-modifyPassword'"
               style="width: 150px;"> 修改密码</a>
            <a href="javascript:logout()"
               class="easyui-linkbutton"
               data-options="plain:true,iconCls:'icon-exit'"
               style="width: 150px;">安全退出</a>
        </div>
        
    </div>
</div>
<div id="dlg" class="easyui-dialog"
     style="width: 400px;height:250px;padding: 10px 20px" closed="true"
     buttons="#dlg-buttons">
    <form id="fm" method="post">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td><input type="text" id="userName" name="userName"
                           value="${currentUser.userName }" readonly="readonly"
                           style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td>原密码：</td>
                <td><input type="password" id="oldPassword"
                           class="easyui-validatebox" required="true" style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td>新密码：</td>
                <td><input type="password" id="newPassword" name="password"
                           class="easyui-validatebox" required="true" style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td>确认新密码：</td>
                <td><input type="password" id="newPassword2"
                           class="easyui-validatebox" required="true" style="width: 200px"/>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:modifyPassword()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a><a
        href="javascript:closePasswordModifyDialog()"
        class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>

<div id="dlg1" class="easyui-dialog"
     style="width: 400px;height:250px;padding: 10px 20px" closed="true"
     buttons="#dlg1-buttons">
    <form id="fm1" method="post">
        <table cellspacing="8px">
            <tr>
                <td>用户名：</td>
                <td><input type="text" id="userName" name="userName"
                           value="${currentUser.userName }" readonly="readonly"
                           style="width: 200px"/>
                </td>
            </tr>
            <tr>
                <td>联系电话：</td>
                <td><input type="text" id="phoneNumber" name="phoneNumber"
                		value="${currentUser.phoneNumber}"
                           class="easyui-validatebox" required="true" style="width: 200px"/>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="dlg1-buttons">
    <a href="javascript:modifyUserInfo()" class="easyui-linkbutton"
       iconCls="icon-ok">保存</a><a
        href="javascript:closeUserInfoModifyDialog()"
        class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
</div>
</body>
</html>
