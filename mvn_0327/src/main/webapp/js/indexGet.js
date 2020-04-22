$(function () {
    //失去焦点事件
    $("#name").blur(function () {

        //获得数
        var name = $(this).val();

        //判断
        if (name == "") {
            $("#nameDiv").html("用户名不能为空！").css("color", "red");
            return;
        }

        //无刷新
        // $.get( url [, data] [, success] [, dataType] );

        // $.get("index","name="+name,function(data){
        //     if (data == 1) {
        //         $("#nameDiv").html("用户名已存在！").css("color", "cyan");
        //     } else {
        //         $("#nameDiv").html("用户名可以使用！").css("color", "green");
        //     }
        // },"text");


        //无刷新
        // $.post( url [, data] [, success] [, dataType] );
        $.post("index","name="+name,function(data){
            if (data == 1) {
                $("#nameDiv").html("用户名已存在！").css("color", "red");
            } else {
                $("#nameDiv").html("用户名可以使用！").css("color", "yellow");
            }
        },"text");

    });


});