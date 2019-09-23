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
        type:'post',
        url:url,
        contentType: "application/json; charset=utf-8",
        dataType: 'json',
        data:data,
        success:callback,
    })
}