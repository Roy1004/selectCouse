

/**
 *
 * @param html 载入网页地址
 * @param dialogButton 按钮组
 * @param afterFunction 载入完成的操作（function）
 */
function showForm(html,dialogButton,afterFunction,dialogTitle){
    BootstrapDialog.show({
        message: function(dialog) {
            var $message = $('<div></div>');
            var pageToLoad = dialog.getData('pageToLoad');
            $message.load(pageToLoad);
            return $message;
        },
        title:dialogTitle,
        data: {
            'pageToLoad': html
        },
        buttons:dialogButton,
        onshown:afterFunction,
      //  closable : false
    });
}

/**
 * 显示提示框
 * @param tips 提示语言
 */
function showDialog(tips,able){
    BootstrapDialog.show({
        title: "",
      //  closable: false,
        message:'<b><font size=\"3px\">'+tips+'</font></b>',
        buttons: [{
            id: 'btn-ok',
            icon: 'glyphicon glyphicon-check',
            label: 'OK',
            cssClass: 'btn-primary',
           autospin: false,
            action: function(dialogRef){
                dialogRef.close();
            }
        }]
    });
}



/**
 * @param url RUL
 * @param data form选择器
 * @returns {Function}
 */
function dialogBtnClick_PUT(url,data) {
    return function (dialog) {
        $.ajax({
            type: 'put',
            dataType: 'json',
            contentType: 'application/json;charset=UTF-8',
            url: url,
            data:JSON.stringify( $(data).serializeJSON()),
            success:function(data){

                var r = eval(data);
                if(r.result=="no"){

                    showDialog("失败");
                }else{
                    showDialog("成功");
                }

                pressF5();
            }
        });
        dialog.close()
    }
}
function pressF5(){
    $('#ill-table').bootstrapTable('refresh');
}

/**
 * @param url RUL
 * @param data form选择器
 * @returns {Function}
 */
function dialogBtnClick_POST(url,data) {
    return function (dialog) {
        $.ajax({
            type: 'post',
            dataType: 'json',
            contentType: 'application/json;charset=UTF-8',
            url: url,
            data:JSON.stringify( $(data).serializeJSON()),
            success:function(data){

                var r = eval(data);
                if(r.result=="no"){
                    showDialog("失败");
                }else{
                    showDialog("成功");
                }

                pressF5();
            }
        });
        dialog.close()
    }
}

/**
 * @param formId form选择器
 * @param data 填充数据
 * @returns {Function}
 */
function formAutofll(formId,data){
    return function(){
        $(formId).autofill(data, {
            findbyname: true,
            restrict: false
        });
    }
}


/**
 * @param selectId select选择器
 * @param url
 * @returns {Function}
 */
function fillSelect(selectId,url) {
    $.ajax({
            type: 'get',
            url: url,
            success:function(data){
                $(selectId).empty();
                for(var i=0;i<data.length;i++) {
                    $(selectId).append("<option value='" + data[i] + "'>"+data[i]+"</option>");
                }
            }
        }
    )
}



/**
 * 日期格式化
 * @param str
 * @returns {String}
 */
function DateFormatter(str)
{	
	var dateObj = JSON.parse(str);
	var dateStr = null;
	if(dateObj!=null){
		var date = new Date(dateObj);
		var dateStr = date.getFullYear() + '-' + date.getMonth() + '-' + date.getDate()
		+ ' '+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds();		
	}
	return dateStr;
}