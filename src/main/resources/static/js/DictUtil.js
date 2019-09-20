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

/**
 *
 * @param gender 性别字典
 * @returns {string}
 */
function getGenderDict() {
    let genderMap={ };
    genderMap[0]='男';
    genderMap[1]='女';
    genderMap[2]='未知';
    return genderMap;
}

/**
 *
 * @param value 是否字典
 * @returns {string}
 */
function yesNo(value) {
    if(value === 0){
        return "否";
    }else if(value===1){
        return "是";
    }else {
        return "未知";
    }
}