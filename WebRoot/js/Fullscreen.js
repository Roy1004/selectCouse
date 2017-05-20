/**
 * Created by Administrator on 2017/3/21.
 */

document.getElementById("btn1").onclick=function(){
    // var elem = document.getElementById("content");
    // LaunchFullScreen(elem);// 某个页面元素
    LaunchFullScreen(document.documentElement);// 整个网页
};

function LaunchFullScreen(element) {
    // 判断各种浏览器，找到正确的方法
    var requestMethod = element.requestFullScreen || //W3C
    element.webkitRequestFullScreen ||    //Chrome等
    element.mozRequestFullScreen || //FireFox
    element.msRequestFullscreen; //IE11
    if (requestMethod) {
    requestMethod.call(element);
    }
    else if (typeof window.ActiveXObject !== "undefined") {//for Internet Explorer
    var wscript = new ActiveXObject("WScript.Shell");
    if (wscript !== null) {
    wscript.SendKeys("{F11}");
    }
    }
}

//退出全屏 判断浏览器种类

  /* function exitFullscreen() {
       // 判断各种浏览器，找到正确的方法

       var exitMethod = document.exitFullscreen || //W3C
           document.mozCancelFullScreen ||    //Chrome等
           document.webkitExitFullscreen || //FireFox
           document.msExitFullscreen; //IE11
       if (exitMethod) {
           exitMethod.call(document);
       }
       else if (typeof window.ActiveXObject !== "undefined") {//for Internet Explorer
           var wscript = new ActiveXObject("WScript.Shell");
           if (wscript !== null) {
               wscript.SendKeys("{F11}");
           }
       }*/
          /*
          if (document.exitFullscreen) {   //W3C
            document.exitFullscreen();
        } else if (document.mozCancelFullScreen) {  //firefox
            document.mozCancelFullScreen();
        } else if (document.webkitExitFullscreen) {  //chrome
            document.webkitExitFullscreen();
        } else if(document.msExitFullscreen){  //IE
            document.msExitFullscreen();
        }

   } */
