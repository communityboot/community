function getDictTag(dictType) {
    let dictMap={ };
    $.ajax({
        type: "post",
        url: "/dv/getDictByCode?dicCode="+dictType,
        //cache:false,
        async:false,
        success: function (data) {
            if (data.code === 200) {
                var a=data.data.length;
                for(var i = 0 ; i < a;i++){
                    let di=data.data[i].dictKey;
                    dictMap[di]=data.data[i].dictVal;
                }
            } else {
                alert("信息有误，请检查!");
            }
        }
    });
    return dictMap;
}