<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>增加演员信息</title>
</head>
<script src="/js/jquery-1.11.0.min.js"></script>
<script src="/js/jquery.serialize-object.min.js"></script>
<!--semantic引入的文件-->
<script src="/js/semantic.min.js"></script>
<link rel="stylesheet" href="/styles/semantic.min.css">
<!--layui引入的文件-->
<link rel="stylesheet" href="/js/layui/css/layui.css">
<script src="/js/layui/layui.js"></script>
<#--bootstrap引入的文件-->
<link rel="stylesheet" href="/js/bootstrap/bootstrap-theme.min.css">
<link rel="stylesheet" href="/js/bootstrap/bootstrap.min.css">
<script src="/js/bootstrap/bootstrap.min.js"></script>
<body>
<#--<ul class="layui-nav">-->
<#--    <li class="layui-nav-item" style="text-align: center;line-height: 50px">-->
<#--        <a href="/admin/index" style="display: inline-block;color: white">首页</a>》》添加演员信息-->
<#--    </li>-->
<#--</ul>-->
<div class="ui grid container">
    <div style="width: 80%; height: 50px; margin: 0 auto">
        <h3 style="text-align: center;line-height: 50px">添加演员信息</h3>
    </div>
    <div class="twelve wide column centered">
        <form class="ui form segment" id="cast-add-form">
            <div class="field">
                <label for="chinese_name">中文名</label>
                <input type="text" name="chinese_name" id="chinese_name" autocomplete="off" placeholder="请输入中文名">
            </div>
            <div class="field">
                <label for="english_name">英文名</label>
                <input type="text" name="english_name" id="english_name" autocomplete="off" placeholder="请输入英文名">
            </div>
            <div class="field">
                <label for="gender">性别</label>

                <div class="ui selection dropdown">
                    <div class="default text">请选择性别</div>
                    <i class="dropdown icon"></i>
                    <input type="hidden" name="gender" id="gender"/>
                    <div class="menu">
                        <div class="item" data-value="男"><i class="male icon"></i>男</div>
                        <div class="item" data-value="女"><i class="female icon"></i>女</div>
                        <div class="item" data-value="不详"><i class="question circle icon"></i>不详</div>
                    </div>
                </div>
            </div>
            <div class="field">
                <label for="birthday">生日</label>
                <input type="date" name="birthday" id="birthday" autocomplete="off" placeholder="请选择生日">
            </div>

            <div class="field">
                <label for="region">地区</label>
                <div class="ui selection dropdown">
                    <input type="hidden" name="region">
                    <div class="default text">请选择地区</div>
                    <i class="dropdown icon"></i>
                    <div class="menu">
                        <div class="item" data-value="中国大陆"><i class="cn flag"></i>中国大陆</div>
                        <div class="item" data-value="中国香港"><i class="hk flag"></i>中国香港</div>
                        <div class="item" data-value="中国台湾"><i class="tw flag"></i>中国台湾</div>
                        <div class="item" data-value="美国"><i class="us flag"></i>美国</div>
                        <div class="item" data-value="英国"><i class="uk flag"></i>英国</div>
                        <div class="item" data-value="印度"><i class="india flag"></i>印度</div>
                        <div class="item" data-value="意大利"><i class="italy flag"></i>意大利</div>
                        <div class="item" data-value="法国"><i class="france flag"></i>法国</div>
                        <div class="item" data-value="其他"><i class="map marker icon"></i>其他</div>
                        <div class="item" data-value="其他"><i class="question circle icon"></i>不详</div>
                    </div>
                </div>
            </div>
            <div class="field">
                <label for="summary">简介</label>
                <textarea name="summary" id="summary" cols="80" rows="5" onkeyup="wordStatic(this);" maxlength="500">
        </textarea>
                <div class=""><span id="num">0</span>/500</div>
            </div>
            <div class="field">
                <label for="avator_url">海报URL</label>
                <input type="text" name="avator_url" id="avator_url" placeholder="请输入海报URL" autocomplete="off" value="">
                </textarea>
            </div>

            <div class="ui error message"></div>
            <input type="submit" value="保存" class="ui primary button">

        </form>
    </div>

</div>
<#--<ul class="layui-footer" style="text-align: center;background-color: black;height: 60px;line-height: 60px;color: white;font-size: medium">Copyright &copy; 宁夏大学信息工程学院 12016242402 张康璐 All rights reserved.-->
<#--</ul>-->
</body>
<script>

    $('.ui .dropdown').dropdown();
    var castAddFrom = $('#cast-add-form').form({
        on: 'blur',
        fields: {
            chinese_name: {
                rules: [
                    {
                        type: 'empty', prompt: '中文名不能为空！'
                    }
                ]
            },
            english_name: {
                rules: [
                    {
                        type: 'empty', prompt: '英文名不能为空！'
                    }
                ]
            },
            summary: {
                rules: [
                    {
                        type: 'empty', prompt: '简介不能为空！'
                    }
                ]
            },
            gender: {
                rules: [
                    {
                        // type: 'empty', prompt: '性别不能为空！'
                    }
                ]
            },
            region: {
                rules: [
                    {
                        // type: 'empty', prompt: '地区不能为空！'
                    }
                ]
            }

            // 字段名：{
            //          rules:[
            //              {type:'验证规则类型1',prompt;'错误提示1'},
            //              {type:'验证规则类型2',prompt;'错误提示2'},
            //              {type:'验证规则类型3',prompt;'错误提示3'}
            //          ]
            //
            //   }
        }
    });
    castAddFrom.api({
        url: '/cast/save',
        method: 'post',
        serializeFrom: true,
        successTest: function (response) {
            return response.success || false;
        },
        onSuccess: function (response) { //提交成功success-->true
            alert(response.message);
            window.location.href = '/cast/list';
            // history.go(-1);
        },
        onFailure: function (response) {
            alert(response.message);
            // history.go(-1);

            window.location.href = '/cast/list';
        }
    });

    function wordStatic(input) {
        // 获取要显示已经输入字数文本框对象
        var content = document.getElementById('num');
        if (content && input) {
            // 获取输入框输入内容长度并更新到界面
            var value = input.value;
            // 将换行符不计算为单词数
            value = value.replace(/\n|\r/gi, "");
            // 更新计数
            content.innerText = value.length;
        }
    }
</script>
</html>