<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>注册</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script>
    addEventListener("load", function () {
      setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
      window.scrollTo(0, 1);
    }
  </script>
  <link rel="stylesheet" href="../../layui/css/layui.css">
  <link rel="stylesheet" href="../../xznstatic/css/style.css" type="text/css" media="all">
  <link href="../../xznstatic/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>
  <div id="mian" class="main-bg">
    <h1 v-text="projectName"></h1>
    <div class="sub-main-w3">
      <div class="image-style"></div>
      <div class="vertical-tab">
        <div id="section1" class="section-w3ls">
          <input type="radio" name="sections" id="option1" checked="checked">
            <article>
			        <form class="layui-form login-form">
                <div class="layui-form-item layui-form-text input">
                  <div class="layui-input-inline" style="width: 300px;">
                    <input type="text" id="gequbianhao" name="gequbianhao" placeholder="请输入车库编号" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item layui-form-text input">
                  <div class="layui-input-inline" style="width: 300px;">
                    <input type="text" id="gequmingcheng" name="gequmingcheng" placeholder="请输入车库名称" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item layui-form-text input">
                  <div class="layui-input-inline" style="width: 300px;">
                    <input type="text" id="geshou" name="geshou" placeholder="请输入歌手" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item layui-form-text input">
                  <div class="layui-input-inline" style="width: 300px;">
                    <input type="text" id="puqu" name="puqu" placeholder="请输入谱曲" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item layui-form-text input">
                  <div class="layui-input-inline" style="width: 300px;">
                    <input type="text" id="shizhang" name="shizhang" placeholder="请输入时长" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item layui-form-text input">
                  <div class="layui-input-inline" style="width: 300px;">
                    <input type="text" id="gequ" name="gequ" placeholder="请输入车库" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item layui-form-text input">
                  <div class="layui-input-inline" style="width: 300px;">
                    <input type="text" id="xiangguanxinxi" name="xiangguanxinxi" placeholder="请输入相关信息" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item layui-form-text input">
                  <div class="layui-input-inline" style="width: 300px;">
                    <input type="text" id="thumbsupnum" name="thumbsupnum" placeholder="请输入赞" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item layui-form-text input">
                  <div class="layui-input-inline" style="width: 300px;">
                    <input type="text" id="crazilynum" name="crazilynum" placeholder="请输入踩" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item layui-form-text input">
                  <div class="layui-input-inline" style="width: 300px;">
                    <input type="text" id="clicknum" name="clicknum" placeholder="请输入点击次数" autocomplete="off" class="layui-input">
                  </div>
                </div>
                <div class="layui-form-item" style="margin-bottom: 0;">
                  <div class="layui-input-block" style="margin-left: 0;">
                    <button class="layui-btn btn-submit btn submit" style="height: 50px;line-height: 25px;" lay-submit lay-filter="register">注册</button>
                  </div>
                </div>
                <a class="bottom-text-w3ls" href="javascript:window.location.href='../login/login.jsp'">已有账号？去登录</a>
              </form>
            </article>
          </div>
        </div>
        <div class="clear"></div>
      </div>
      <div class="copyright">
        <h2><a href="#"></a></h2>
      </div>
    </div>

  <script src="../../layui/layui.js"></script>
  <script src="../../js/vue.js"></script>
  <!-- 组件配置信息 -->
  <script src="../../js/config.js"></script>
  <!-- 扩展插件配置信息 -->
  <script src="../../modules/config.js"></script>
  <!-- 工具方法 -->
  <script src="../../js/utils.js"></script>
  <!-- 校验格式工具类 -->
  <script src="../../js/validate.js"></script>

  <script>
    var vue = new Vue({
      el: '#mian',
      data: {
        projectName: projectName
      }
    });

    layui.use(['layer', 'element', 'carousel', 'form', 'http', 'jquery'], function() {
      var layer = layui.layer;
      var element = layui.element;
      var carousel = layui.carousel;
      var form = layui.form;
      var http = layui.http;
      var jquery = layui.jquery;

      var tablename = http.getParam('tablename');
              
      // 注册
      form.on('submit(register)', function(data) {
        data = data.field;
                        if(!data.gequmingcheng){
          layer.msg('车库名称不能为空', {
            time: 2000,
            icon: 5
          });
          return false
        }
                        if(!data.gequleibie){
          layer.msg('车库类别不能为空', {
            time: 2000,
            icon: 5
          });
          return false
        }
                        if(!data.geshou){
          layer.msg('歌手不能为空', {
            time: 2000,
            icon: 5
          });
          return false
        }
                                                                                                                        if(!isIntNumer(data.thumbsupnum)){
          layer.msg('赞应输入整数', {
            time: 2000,
            icon: 5
          });
          return false
        }
                        if(!isIntNumer(data.crazilynum)){
          layer.msg('踩应输入整数', {
            time: 2000,
            icon: 5
          });
          return false
        }
                                        if(!isIntNumer(data.clicknum)){
          layer.msg('点击次数应输入整数', {
            time: 2000,
            icon: 5
          });
          return false
        }
                        http.requestJson(tablename + '/register', 'post', data, function(res) {
          layer.msg('注册成功', {
            time: 2000,
            icon: 6
          },function(){
            // 路径访问设置
            window.location.href = '../login/login.jsp';
          });
        });
        return false
      });
    });
  </script>
</body>
</html>
