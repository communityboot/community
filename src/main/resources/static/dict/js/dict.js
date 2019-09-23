layui.use(['table','form','jquery'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.jquery;
    var tableGrid = table.render({
        elem: '#dict'
        , url: '/dict/getAllLamp'
        , toolbar: '#toolbarDemo'
        , title: '字典表'
        ,baseDict:{'dictName':'dictionary','dictLabel':'zidian','enabled':1}
        , page: true
        , even: true
        , cellMinWidth: 30 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', title: 'ID', width: 80}
            , {field: 'dictName', width: 140, title: '字典名称'}
            , {field: 'dictLabel', title: '字典类型', width: 140}
            , {field: 'enabled', title: '是否启用', width: 80, templet: function (d) {if (d.enabled === 1) {return "启用";} else {return "未启用";}}}
            , {field: 'remark', width: 80, title: '备注'}
            , {field: 'createTime', width: 200, title: '创建时间'}
            , {field: 'updateTime', width: 200, title: '更新时间'}
            , {fixed: 'right', width: 180, title: '操作', toolbar: '#barDemo'}
        ]]
    });
    form.on('submit(btnSearch)', function (data) {
        console.log(data.field);
        console.log(JSON.stringify(data.field));
        tableGrid.reload({
            url:'/dict/getAllLampTe',
            method:'post',
            where:data.field
        })
    });
    //头工具栏事件
    table.on('toolbar(dict)', function (obj) {
        var $ = layui.jquery;
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'addDict':
                var data = checkStatus.data;
                layer.open({
                    title: "字典信息修改",
                    type: 1,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['700px', '480px'], //宽高
                    content: $("#edit")
                });
                break;
            case 'delDict':
                var data = checkStatus.data;
                var arr = [];
                for (var i = 0; i < data.length; i++) {
                    arr.push(data[i].id);
                }
                layer.confirm('确定删除吗？', {
                    btn: ['取消', '确定'] //按钮
                }, function () {
                    layer.closeAll();
                }, function () {
                    $.ajax({
                        type: "post",
                        url: "/dict/delBatchDict",
                        dataType: 'json',
                        data: {"ids": arr},
                        success: function (data) {
                            if (data.result === "success") {
                                layer.msg("删除成功!");
                                window.parent.location.reload();//修改成功后刷新父界面
                                layer.closeAll();
                            } else {
                                layer.msg(data.msg);
                            }
                        }
                    });
                });
                break;
            case 'modifyDict':
                var data = checkStatus.data;
                if (data.length === 1) {
                    var $ = layui.jquery, form = layui.form;
                    $.ajax({
                        type: "post",
                        url: "/dict/getDictInfo",
                        dataType: 'json',
                        data: "id=" + data[0].id,
                        success: function (data) {
                            if (data.result === "000") {
                                $("#dictId").val(data.dict.id);
                                $("#dictName").val(data.dict.dictName);
                                $("#dictLabel").val(data.dict.dictLabel);
                                $("input[name=enabled][value= '1']").attr("checked", data.dict.enabled === 1 ? true : false);
                                $("input[name=enabled][value= '0']").attr("checked", data.dict.enabled === 0 ? true : false)
                                $("#remark").val(data.dict.remark);
                                form.render();
                            } else {
                                layer.msg("信息有误，请检查!");
                            }
                        }
                    });
                    layer.open({
                        title: "字典信息修改",
                        type: 1,
                        skin: 'layui-layer-rim', //加上边框
                        area: ['700px', '480px'], //宽高
                        content: $("#edit")
                    });
                } else if (data.length === 0) {
                    layer.msg("所选数量为0，请选择需要操作的数据");

                } else {
                    layer.msg("所选数量超过1，只能对单条数据进行编辑！")
                }
                break;
            default:
                break;
        }
    });

    //监听行工具事件
    table.on('tool(dict)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                $.ajax({
                    type: "post",
                    url: "/dict/delDictById",
                    dataType: 'json',
                    data: "id=" + data.id,
                    success: function (data) {
                        if (data.result === "删除成功") {
                            layer.msg("删除成功!");
                            window.parent.location.reload();//修改成功后刷新父界面
                            layer.closeAll();
                        } else {
                            layer.msg(data.msg);
                            obj.del();
                        }
                    }
                });
            });
        } else if (obj.event === 'edit') {
            layui.use('form', function () {
                var $ = layui.jquery, form = layui.form;
                $.ajax({
                    type: "post",
                    url: "/dict/getDictInfo",
                    dataType: 'json',
                    data: "id=" + data.id,
                    success: function (data) {
                        if (data.result === "000") {
                            $("#dictId").val(data.dict.id);
                            $("#dictName").val(data.dict.dictName);
                            $("#dictLabel").val(data.dict.dictLabel);
                            $("input[name=enabled][value= '1']").attr("checked", data.dict.enabled === 1 ? true : false);
                            $("input[name=enabled][value= '0']").attr("checked", data.dict.enabled === 0 ? true : false)
                            $("#remark").val(data.dict.remark);
                            form.render();
                        } else {
                            layer.msg("信息有误，请检查!");
                        }
                    }
                })
            });
            layer.open({
                title: "字典信息修改",
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['700px', '480px'], //宽高
                content: $("#edit"),
            });
        } else if (obj.event === 'manageDict') {
            let id = data.id;
            window.location.href = "http://localhost:8088/dv/toDvPage/" + id;
        }
    });
});

layui.use(['form', 'jquery'], function () {
    var form = layui.form;
    var $ = layui.jquery;
    form.on('submit(submitBtn)', function (data) {
        $.ajax({
            type: "post",
            url: "/dict/updateDict",
            contentType: "application/json; charset=utf-8",
            dataType: 'json',
            data: JSON.stringify(data.field),
            success: function (data) {
                if (data.result === "000") {
                    layer.closeAll();
                    layer.msg("更新成功")
                } else {
                    layer.msg("信息有误，请检查!");
                }
            }
        });
        return false;
    });
});

layui.use(['jquery'], function () {
    var $ = layui.jquery;
    $("#closeDialog").click(function () {
        $("#dictId").val("");
        $("#dictName").val("");
        $("#dictLabel").val("");
        $("#enabled").val("");
        $("#remark").val("");
        layer.closeAll();
        return false;
    });
});
