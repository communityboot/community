function getDictTag(dictType) {
    let dictMap = {};
    $.ajax({
        type: "post",
        url: "/dv/getDictByCode?dicCode=" + dictType,
        //cache:false,
        async: false,
        success: function (data) {
            if (data.code === 200) {
                var a = data.data.length;
                for (var i = 0; i < a; i++) {
                    let di = data.data[i].dictKey;
                    dictMap[di] = data.data[i].dictVal;
                }
            } else {
                alert("信息有误，请检查!");
            }
        }
    });
    return dictMap;
}

/**
 *性别字典
 * @returns {string}
 */
function getGenderDict() {
    let genderMap = {};
    genderMap[0] = '男';
    genderMap[1] = '女';
    genderMap[2] = '未知';
    return genderMap;
}

/**
 * 是否字典
 * @returns {string}
 */
function yesNo() {
    let genderMap = {};
    genderMap[0] = '否';
    genderMap[1] = '是';
    genderMap[2] = '未知';
    return genderMap;
}

/**
 * 是否启用字典
 */
function isEnable() {
    let genderMap = {};
    genderMap[0] = '启用';
    genderMap[1] = '未启用';
    genderMap[2] = '未知';
    return genderMap;
}