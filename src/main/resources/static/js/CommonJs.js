/**
 * 备注：使用该js的前提：需要在html中引入jquery，不然会出现 $，或者 ajax 没有定义
 * <script th:src="@{/webjars/jquery/3.4.1/jquery.min.js}"></script>
 */

/**
 * 定义请求前缀
 * @type {string}
 */
//本地开发，请开启
const baseUrl ='http://localhost:8088/community';
    //部署服务器地址: druid.html 加载src页面的需要注意
//const baseUrl ='http://39.106.121.52:8088/community';
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

/**
 * 指定对象信息删除
 * @param data
 * @param url
 */
function deleteItem(data,url) {
    layer.confirm('确定删除吗？', {
        btn: ['取消', '确定'] //按钮
    }, function () {
        layer.closeAll();
    }, function () {
        $.ajax({
            type: "post",
            url: url,
            contentType : 'application/json',
            data: JSON.stringify(data[0]),
            success: function (data) {
                if (data.code === 200) {
                    layer.msg(data.msg, {time:1500,icon: 1},function () {location.reload();});
                } else {layer.msg(data.msg,{time:1000,icon: 1})}
            }
        });
    });
}


/**
 *
 * @param data 传方法的data   var data = checkStatus.data;
 * @param url 后台地址 例如   baseUrl+/xxx/xx
 */
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
                if (data.code === 200) {
                    layer.msg(data.msg, {time:1500,icon: 1},function () {location.reload();});
                } else {layer.msg(data.msg,{time:1000,icon: 1})}
            }
        });
    });
}

/**
 * @param data 传入得到的返回值
 */
function saveorupd(data) {
    if (data.code === 200) {
        layer.msg(data.msg,{time:1000,icon: 1},function () {
            location.reload();
        });
    } else {
        layer.msg(data.msg,{time:3000,icon: 3});
    }
}

/**
 * 保存成功之后需要跳转页面
 * @param data 传入data就行
 * @param url 新增成功需要跳转的地址
 */
function saveJump(data) {
    if (data.code === 200) {
        layer.msg(data.msg,{time:1000,icon: 1},function () {
            window.location.href=(baseUrl+data.data);
        });
    } else {
        layer.msg(data.msg,{time:1000,icon: 3});
    }
}

/**
 * 批量或者单条记录
 * @param data
 * @param url 后台请求的url
 * @param callback 回调函数
 */
function modify(data,url,callback) {
    if (data.length === 1) {
        ajaxDemo(url,dictValId=data[0].id,callback);
        openLayer('字典信息修改','#edit');
    } else if (data.length === 0) {
        layer.msg("所选数量为0，请选择需要操作的数据");
    } else {
        layer.msg("所选数量超过1，只能对单条数据进行编辑！")
    }
}

/**
 * 修改操作表单回显功能
 * @param data
 */
function reviewParams(data) {
    var div = document.getElementById("edit");
    var inputs = div.getElementsByTagName("input");
    var names={};
    for(var i=0;i<inputs.length;i++) {
        names[inputs[i].id]=inputs[i].id;
    }
    for(var k in names){
        $("#"+k+"").val(data.data[k]);
    }
}