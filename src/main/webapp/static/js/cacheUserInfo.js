layui.config({
    base : "../../js/"
}).use(['form','jquery',"address","element"],function() {
    var form = layui.form,
        $ = layui.jquery,
        address = layui.address;

    //判断是否设置过头像，如果设置过则修改顶部、左侧和个人资料中的头像，否则使用默认头像
    // if(window.sessionStorage.getItem('userFace')){
    //     $("#userFace").attr("src",window.sessionStorage.getItem('userFace'));
    //     $(".userAvatar").attr("src",$(".userAvatar").attr("src").split("images/")[0] + "images/" + window.sessionStorage.getItem('userFace').split("images/")[1]);
    // }else{
    //     $("#userFace").attr("src","../../images/shenyouchu.png");
    // }

});