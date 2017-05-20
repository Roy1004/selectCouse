

jQuery(document).ready(function() {

   "use strict";

   jQuery("#cancel").click(function(){
      var r=confirm("确认退出？");
      if (r==true)
      {
          $.removeCookie('Sid');
          $.removeCookie('Tid');
          $.removeCookie('Name');
          window.location.href="login.html";
        }else{
         return;
      }
   });
   // Toggle Left Menu切换左侧菜单
   jQuery('.leftpanel .nav-parent > a').live('click', function() {

      var parent = jQuery(this).parent();
      var sub = parent.find('> ul');

      // Dropdown works only when leftpanel is not collapsed不折叠时候下拉可以工作
      if(!jQuery('body').hasClass('leftpanel-collapsed')) {
         if(sub.is(':visible')) {
            sub.slideUp(200, function(){
               parent.removeClass('nav-active');
               parent.removeClass('active');
               jQuery('.mainpanel').css({height: ''});
             //  adjustmainpanelheight();
            });
         } else {
            closeVisibleSubMenu();
            parent.siblings().removeClass('nav-active');
            parent.addClass('nav-active');
            parent.siblings().removeClass('active');
            parent.addClass('active');
            sub.slideDown(200, function(){
             //  adjustmainpanelheight();
            });
         }
      }
      return false;
   });
   /*jQuery(".leftpanel .no-parent> a").click(function(){
         jQuery(this).parent().siblings().removeClass('active');

          closeVisibleSubMenu();
          jQuery(this).parent().addClass('active');
   });*/
   function closeVisibleSubMenu() {//关闭可见子菜单
      jQuery('.leftpanel .nav-parent').each(function() {
         var t = jQuery(this);
         if(t.hasClass('nav-active')) {
            t.find('> ul').slideUp(200, function(){
               t.removeClass('nav-active');
               t.removeClass('active');
            });
         }
      });
   }

   function adjustmainpanelheight() {
     //Adjust mainpanel height调整主面板高度
  // var docHeight = jQuery(document).height();
    // if(docHeight > jQuery('.mainpanel').height())
     // jQuery('.mainpanel').height(docHeight);
   }
  adjustmainpanelheight();


   // Tooltip工具提示
   // jQuery('.tooltips').tooltip({ container: 'body'});

   // Popover   弹窗
   // jQuery('.popovers').popover();

   // Close Button in Panels面板中的关闭按钮
/*   jQuery('.panel .panel-close').click(function(){
      jQuery(this).closest('.panel').fadeOut(200);
      return false;
   });*/

   // Form Toggles表单切换
   // jQuery('.toggle').toggles({on: true});

   // jQuery('.toggle-chat1').toggles({on: false});

 /*  var scColor1 = '#428BCA';
   if (jQuery.cookie('change-skin') && jQuery.cookie('change-skin') == 'bluenav') {
      scColor1 = '#fff';
   }*/

   // Minimize Button in Panels面板中的最小化按钮
   // jQuery('.minimize').click(function(){
   //    var t = jQuery(this);
   //    var p = t.closest('.panel');
   //    if(!jQuery(this).hasClass('maximize')) {
   //       p.find('.panel-body, .panel-footer').slideUp(200);
   //       t.addClass('maximize');
   //       t.html('&plus;');
   //    } else {
   //       p.find('.panel-body, .panel-footer').slideDown(200);
   //       t.removeClass('maximize');
   //       t.html('&minus;');
   //    }
   //    return false;
   // });

// Menu Toggle  菜单切换
   /* jQuery('.menutoggle').click(function(){

        var body = jQuery('body');
        var bodypos = body.css('position');

        if(bodypos != 'relative') {

            if(!body.hasClass('leftpanel-collapsed')) {
                body.addClass('leftpanel-collapsed');
                jQuery('.nav-bracket ul').attr('style','');

                jQuery(this).addClass('menu-collapsed');

            } else {
                body.removeClass('leftpanel-collapsed chat-view');
                jQuery('.nav-bracket li.active ul').css({display: 'block'});

                jQuery(this).removeClass('menu-collapsed');

            }
        } else {

            if(body.hasClass('leftpanel-show'))
                body.removeClass('leftpanel-show');
            else
                body.addClass('leftpanel-show');

            adjustmainpanelheight();
        }

    });*/

   // Add class everytime a mouse pointer hover over it每当鼠标指针悬浮在时添加class
   jQuery('.nav-bracket > li').hover(function(){
      jQuery(this).addClass('nav-hover');
   }, function(){
      jQuery(this).removeClass('nav-hover');
   });




   // Chat View
   /*jQuery('#chatview').click(function(){

      var body = jQuery('body');
      var bodypos = body.css('position');

      if(bodypos != 'relative') {

         if(!body.hasClass('chat-view')) {
            body.addClass('leftpanel-collapsed chat-view');
            jQuery('.nav-bracket ul').attr('style','');

         } else {

            body.removeClass('chat-view');

            if(!jQuery('.menutoggle').hasClass('menu-collapsed')) {
               jQuery('body').removeClass('leftpanel-collapsed');
               jQuery('.nav-bracket li.active ul').css({display: 'block'});
            } else {

            }
         }

      } else {

         if(!body.hasClass('chat-relative-view')) {

            body.addClass('chat-relative-view');
            body.css({left: ''});

         } else {
            body.removeClass('chat-relative-view');
         }
      }

   });*/

  /* reposition_topnav();
   reposition_searchform();

   jQuery(window).resize(function(){

      if(jQuery('body').css('position') == 'relative') {

         jQuery('body').removeClass('leftpanel-collapsed chat-view');

      } else {

         jQuery('body').removeClass('chat-relative-view');
         jQuery('body').css({left: '', marginRight: ''});
      }


      reposition_searchform();
      reposition_topnav();

   });*/



   /* This function will reposition search form to the left panel when viewed
    * in screens smaller than 767px and will return to top when viewed higher
    * than 767px搜索框自适应 宽于767显示在top 低于767显示在左侧面板
    */
  /* function reposition_searchform() {
      if(jQuery('.searchform').css('position') == 'relative') {
         jQuery('.searchform').insertBefore('.leftpanelinner .userlogged');
      } else {
         jQuery('.searchform').insertBefore('.header-right');
      }
   }

*/

   /* This function allows top navigation menu to move to left navigation menu
    * when viewed in screens lower than 1024px and will move it back when viewed
    * higher than 1024px菜单导航栏自适应
    */
   /*function reposition_topnav() {
      if(jQuery('.nav-horizontal').length > 0) {

         // top navigation move to left nav
         // .nav-horizontal will set position to relative when viewed in screen below 1024
         if(jQuery('.nav-horizontal').css('position') == 'relative') {

            if(jQuery('.leftpanel .nav-bracket').length == 2) {
               jQuery('.nav-horizontal').insertAfter('.nav-bracket:eq(1)');
            } else {
               // only add to bottom if .nav-horizontal is not yet in the left panel
               if(jQuery('.leftpanel .nav-horizontal').length == 0)
                  jQuery('.nav-horizontal').appendTo('.leftpanelinner');
            }

            jQuery('.nav-horizontal').css({display: 'block'})
                                  .addClass('nav-pills nav-stacked nav-bracket');

            jQuery('.nav-horizontal .children').removeClass('dropdown-menu');
            jQuery('.nav-horizontal > li').each(function() {

               jQuery(this).removeClass('open');
               jQuery(this).find('a').removeAttr('class');
               jQuery(this).find('a').removeAttr('data-toggle');

            });

            if(jQuery('.nav-horizontal li:last-child').has('form')) {
               jQuery('.nav-horizontal li:last-child form').addClass('searchform').appendTo('.topnav');
               jQuery('.nav-horizontal li:last-child').hide();
            }

         } else {
            // move nav only when .nav-horizontal is currently from leftpanel
            // that is viewed from screen size above 1024
            if(jQuery('.leftpanel .nav-horizontal').length > 0) {

               jQuery('.nav-horizontal').removeClass('nav-pills nav-stacked nav-bracket')
                                        .appendTo('.topnav');
               jQuery('.nav-horizontal .children').addClass('dropdown-menu').removeAttr('style');
               jQuery('.nav-horizontal li:last-child').show();
               jQuery('.searchform').removeClass('searchform').appendTo('.nav-horizontal li:last-child .dropdown-menu');
               jQuery('.nav-horizontal > li > a').each(function() {

                  jQuery(this).parent().removeClass('nav-active');

                  if(jQuery(this).parent().find('.dropdown-menu').length > 0) {
                     jQuery(this).attr('class','dropdown-toggle');
                     jQuery(this).attr('data-toggle','dropdown');
                  }

               });
            }

         }

      }
   }
*/

   // Sticky Header固定顶部
   // if(jQuery.cookie('sticky-header'))
   //    jQuery('body').addClass('stickyheader');

   // // Sticky Left Panel固定左侧面板
   // if(jQuery.cookie('sticky-leftpanel')) {
   //    jQuery('body').addClass('stickyheader');
   //    jQuery('.leftpanel').addClass('sticky-leftpanel');
   // }

   // Left Panel Collapsed左侧面板折叠
  /*if(jQuery.cookie('leftpanel-collapsed')) {
      jQuery('body').addClass('leftpanel-collapsed');
      jQuery('.menutoggle').addClass('menu-collapsed');
   }*/

   // Changing Skin 改变皮肤
 /*  var c = jQuery.cookie('change-skin');
   var cssSkin = 'css/style.'+c+'.css';
   if (jQuery('body').css('direction') == 'rtl') {
      cssSkin = '../css/style.'+c+'.css';
      jQuery('html').addClass('rtl');
   }
   if(c) {
      jQuery('head').append('<link id="skinswitch" rel="stylesheet" href="'+cssSkin+'" />');
   }

   // Changing Font改变字体
   var fnt = jQuery.cookie('change-font');
   if(fnt) {
      jQuery('head').append('<link id="fontswitch" rel="stylesheet" href="css/font.'+fnt+'.css" />');
   }
   // Check if leftpanel is collapsed    如果左侧面板折叠时检查

    if(jQuery('body').hasClass('leftpanel-collapsed'))
      jQuery('.nav-bracket .children').css({display: ''});


   // Handles form inside of dropdown处理下拉式内容
   jQuery('.dropdown-menu').find('form').click(function (e) {
      e.stopPropagation();
   });*/


   // This is not actually changing color of btn-primary 并不实际上改变btn-primary 的颜色
   // This is like you are changing it to use btn-orange instead of btn-primary
   // This is for demo purposes only仅用于演示
 /*  var c = jQuery.cookie('change-skin');
   if (c && c == 'greyjoy') {
      $('.btn-primary').removeClass('btn-primary').addClass('btn-orange');
      $('.rdio-primary').addClass('rdio-default').removeClass('rdio-primary');
      $('.text-primary').removeClass('text-primary').addClass('text-orange');
   }*/

});

