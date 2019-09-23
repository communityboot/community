/**
 * 定义请求前缀
 * @type {string}
 */
let baseUrl ='http://localhost:8088';

/**
 * @param url 请求地址
 * @param data 传给后端的数据
 * @param callback 自定义成功的方法
 */
function ajaxDemo(url,data,callback) {
    $.ajax({
        url:url,
        type:'post',
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        data:data,
        success:callback,
    })
}

function add() {
    
}

/**
 * 打开指定的div的方法
 * @param title 弹窗的标题
 * @param div 指定的div名称
 */
function openLayer(title,div) {
    layer.open({
        title: title,
        type: 1,
        skin: 'layui-layer-rim',
        area: ['700px', '480px'],
        content: $(div)
    });
}

function deleteItems(data,url) {
    let arr = [];
    for (let i = 0; i < data.length; i++) {
        arr.push(data[i].id);
    }
    layer.confirm('确定删除吗？', {
        btn: ['取消', '确定'] //按钮
    }, function () {
        layer.closeAll();
    }, function () {
        $.ajax({
            type: "post",
            url: url,
            dataType: 'json',
            data: {"ids": arr},
            success: function (data) {
                if (data.msg === "success") {
                    layer.msg('删除成功！', {icon: 1});
                    location.reload();//修改成功后刷新父界面
                } else {
                    layer.msg(data.msg, {icon: 5});
                }
            }
        });
    });
}