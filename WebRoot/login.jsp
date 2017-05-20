<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="zh">
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="images/logo.png" type="image/png">
    <title>登录</title>
    <link href="css/style.default.css" rel="stylesheet">
    <link href="css/bootstrap-override.css" rel="stylesheet">
    <link href="dialog/bootstrap-dialog.css" rel="stylesheet">
    <script src="js/jquery-1.11.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="dialog/bootstrap-dialog.js"></script>
    <script src="js/public.js"></script>
    <script src="js/jquery.cookie.js"></script>
    <script src="js/jquery.serializejson.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <!--解决低版本IE浏览器无法识别HTML5标签-->
<!--    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>&lt;!&ndash;解决低版本IE浏览器不支持css3媒体查询&ndash;&gt;-->
    <style type="text/css">
        .signin-info h1{font-size: 40px;}
        .checkInput{width: 50%;  height: 25px;float: left;}
        .showCode{display: block;float: left;margin-top: 15px;margin-left: 10px;padding:0 5px;width: 30%;
            background-color: #8F8584;color:#6DFCFF;cursor: pointer;letter-spacing: 3px;}
        input:focus::-webkit-input-placeholder {  color: transparent;  }
        /* Mozilla Firefox 4 to 18 */
        input:focus:-moz-placeholder {  color: transparent;  }
        /* Mozilla Firefox 19+ */
        /* Internet Explorer 10+ */
        .hb{box-shadow:8px 8px 6px #c0c0c0;border-radius: 5px;-webkit-border-radius: 5px;-moz-border-radius: 5px;}
    </style>
</head>

<body class="signin">
<section>
    <div class="signinpanel">
        <div class="row">
            <div class="col-md-6">
                <div class="signin-info">
                    <div class="logopanel">
                        <h1>体育选课系统</h1>
                    </div><!-- logopanel -->
                </div><!-- signin0-info -->
            </div><!-- col-sm-7 -->
         </div>
        <div class="row">
            <div class="col-md-6 nopadding"><img src="images/timg.jpg" class="hb" style="width: 100%;height: 100%;"></div>
            <div class="col-md-1"></div>
            <div class="col-md-5">
                <form role="form" id="login">
                    <h5 class="nomargin">登陆到你的账户：</h5>
                    <input type="text" name="username" id="username" class="form-control uname" placeholder="用户名" />
                    <input type="password" name="password" id="password" class="form-control pword" placeholder="密码" />
                    <div>
                        <input type="text" name="checkCode" id="Code" class="form-control checkInput" placeholder="验证码" autocomplete="off">
                        <span class="showCode" id="showCode"></span>
                    </div>
                    <div style="clear: both;">
                        <input type="radio" name="radio" value="1" id="admin"><label for="admin">管理员</label>
                        <input type="radio" name="radio" value="2" id="teacher"><label for="teacher">教师</label>&nbsp;&nbsp;
                        <input type="radio" name="radio" value="3" id="student" checked="checked"><label for="student">学生</label>
                    </div>
                    <button id="button" class="btn btn-success btn-block">登陆</button>
                </form>
            </div><!-- col-sm-5 -->
        </div><!-- row -->
    </div><!-- signin -->
</section>



<!--<script src="js/jquery-migrate-1.2.1.min.js"></script> &lt;!&ndash;解决不同jquery版本之间的兼容问题&ndash;&gt;-->
<!--<script src="js/bootstrap.min.js"></script>-->
<!--<script src="js/modernizr.min.js"></script>  &lt;!&ndash;监测浏览器是否支持CSS3特性&ndash;&gt;
<script src="js/jquery.cookies.js"></script>-->
<!--
<script src="js/toggles.min.js"></script>  &lt;!&ndash;显示与隐藏之间切换&ndash;&gt;
<script src="js/retina.min.js"></script>  &lt;!&ndash;查找高分辨图片&ndash;&gt;&ndash;&gt;-->
<!--<script src="js/custom.js"></script>-->
<script type="text/javascript">

    //创建验证码
    $(function() {
    var code;
    var codeLength=5;
    var codeArray= new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
        'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    function createCode(){
        code="";//每次点击将code清空
        var codeNum;
        for(var i=0;i<codeLength;i++){
            codeNum=Math.floor(Math.random()*62);
            code+=codeArray[codeNum];
        }
        $(".showCode").text(code);
    }
    createCode();
    $(".showCode").click(function(){
        createCode();
    });
    //为登录按钮绑定enter事件
    $(document).keydown(function (event) {
        if (event.keyCode == 13) {
            $("#button").click();
        }
    });

    $("#button").click(function () {
        var userName=$.trim($("#username").val());
        var passWord=$("#password").val();
        var checkCode=$.trim($("#Code").val());
        var showCode=$("#showCode").text();
        var checkedValue= $("input[type='radio']:checked").val();
            if(userName=="")
            {
                alert("请输入用户名!")
              // showDialog("请输入用户名!");
                return false;}
            else if(passWord=="")
            {alert("请输入密码!");return false;}
            else if(checkCode=="")
            {alert("请输入验证码!");return false;}
            else if(checkCode.toUpperCase()!=showCode.toUpperCase()){
                alert("验证码错误!");createCode();
                return false;
            }
            $.cookie("user",userName,{path: '/'});
            $.cookie("password",passWord,{path: '/'});
            $.ajax({
                type:"post",
                url:"",
                data:JSON.stringify( $('#login').serializeJSON()),
                dataType:"json",
                success:function (data) {
                    if(data==1){
                        if(checkedValue==1){
                            window.location.href="admin.html";
                        }else if(checkedValue==2){
                            window.location.href="teacherMain.html";
                        }else {
                            window.location.href="studentMain.html";
                        }
                    }else{
                        alert("用户名或密码错误!");
                        createCode();
                    }
                }
            })
        })
    })
</script>
</body>
</html>

