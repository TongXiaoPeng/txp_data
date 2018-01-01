<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>借书宝</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <style type=text/css>
        body {
            text-align: center;
            padding-bottom: 0px;
            background-color: #ddeef2;
            margin: 0px;
            padding-left: 0px;
            padding-right: 0px;
            padding-top: 0px
        }

        A:link {
            COLOR: #000000;
            text-decoration: none
        }

        A:visited {
            COLOR: #000000;
            text-decoration: none
        }

        A:hover {
            COLOR: #ff0000;
            text-decoration: underline
        }

        A:active {
            text-decoration: none
        }

        .input {
            border-bottom: #ccc 1px solid;
            border-left: #ccc 1px solid;
            line-height: 20px;
            width: 182px;
            height: 20px;
            border-top: #ccc 1px solid;
            border-right: #ccc 1px solid
        }

        .input1 {
            border-bottom: #ccc 1px solid;
            border-left: #ccc 1px solid;
            line-height: 20px;
            width: 120px;
            height: 20px;
            border-top: #ccc 1px solid;
            border-right: #ccc 1px solid;
        }
    </style>
    <script type="text/javascript">
        function back(){
        	var basePath = $("#basePath").val();
       	 	window.location.href= basePath + "/system/loginView"; 
        }
        function register(){
        	var userName = $("#userName").val();
            var passWord = $("#passWord").val();
            if (userName == null || userName == "") {
                alert("用户名不能为空！");
                return;
            }
            if (passWord == null || passWord == "") {
                alert("密码不能为空！");
                return;
            }
            $("#adminRegister").submit();
        }
    </script>
</head>
<body>
<input type="hidden" id="basePath" value="${pageContext.request.contextPath}">
<form id=adminRegister method=post
      name=adminRegister action="${pageContext.request.contextPath}/system/register" >
    <div></div>
    <table style="margin: auto; width: 100%; height: 100%" border=0
           cellSpacing=0 cellPadding=0>
        <tbody>
        <tr>
            <td height=150>&nbsp;</td>
        </tr>
        <tr style="height: 254px">
            <td>
                <div style="background-color: #93b2b9;height:200px" >
                <div style="padding:10px; float:left;width: 400px">
                <span style="font-size: 60px; padding-left: 100px;">借书宝</span><span style="font-size: 20px; ">注册</span>
                </div>
                    <div style="padding:10px; width: 400px; float:right">
                        <div style="text-align: left; width: 265px; height: 100px;margin:5px; ">
                            <table border=0 cellSpacing=0 cellPadding=0 width="100%">
                                <tr>
                                	<td>账号:</td>
                                    <td style="height: 45px">
                                    	<input type="text" class=input  name="userName" id="userName">
                                    </td>
                                </tr>
                                <tr>
                                 <td>密码:</td>
                                    <td>
                                    	<input type="password" class=input  name="passWord" id="passWord"/>
                                 	</td>
                                </tr>
                            </table>
                        </div>
                        <div style="height: 1px; clear: both"></div>
                        <div style="width: 380px; clear: both;margin:5px;">
                            <table border=0 cellSpacing=0 cellPadding=0 width=300 >
                                <tbody>

                                <tr>
                                    <td width=100 >
                                    	<button type="button" id=btnRegister name=btnRegister onclick="javascript:register();" >注册</button>
                                    </td>
                                    <td width=100 >
                                    	<button type="button" id=btnBack name=btnBack onclick="javascript:back();" >返回登录</button>
                                    </td>
                                    <td width=100 >
                                    	<button type="button" id=btnReset name=btnReset onclick="javascript:adminRegister.reset();" >重置</button>
                                   	</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </td>
        </tr>
        <tr style="height: 30%">
            <td>&nbsp;</td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
<script type=text/javascript>
    if ('${errorMsg}' != '') {
        alert('${errorMsg}');
    }
</script>