/**
 * Created by Administrator on 2017/3/21.
 */

document.getElementById("btn1").onclick=function(){
    // var elem = document.getElementById("content");
    // LaunchFullScreen(elem);// ĳ��ҳ��Ԫ��
    LaunchFullScreen(document.documentElement);// ������ҳ
};

function LaunchFullScreen(element) {
    // �жϸ�����������ҵ���ȷ�ķ���
    var requestMethod = element.requestFullScreen || //W3C
    element.webkitRequestFullScreen ||    //Chrome��
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

//�˳�ȫ�� �ж����������

  /* function exitFullscreen() {
       // �жϸ�����������ҵ���ȷ�ķ���

       var exitMethod = document.exitFullscreen || //W3C
           document.mozCancelFullScreen ||    //Chrome��
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
