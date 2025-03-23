<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>

<!-- 首页 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
</head>
<body>

<div id="app">

    <div class="data-detail">
        <div class="data-detail-breadcrumb">
					<span class="layui-breadcrumb">
						<a href="../home/home.jsp">首页</a>
						<a><cite>{{title}}</cite></a>
					</span>

            <a @click="storeUp()" href="javascript:void(0)">
                <i class="layui-icon" style="font-size: 20px;color: red;">&#xe67a;</i>点我收藏
            </a>

        </div>
        <div class="layui-row">
            <div class="layui-col-md5">
                <div class="layui-carousel" id="swiper">
                    <div carousel-item id="swiper-item">
                    </div>
                </div>

                <div class="tool-container">
                    <div @click="thumbsupnumClick()" style="display: flex;align-items: center;">
                        <i class="layui-icon" style="font-size: 20px;color: red;margin-right: 10px;">&#xe6af;</i>
                        赞一下({{detail.thumbsupnum}})
                    </div>
                    <div @click="crazilynumClick()" style="display: flex;align-items: center;">
                        <i class="layui-icon" style="font-size: 20px;color: red;margin-right: 10px;">&#xe69c;</i>
                        踩一下({{detail.crazilynum}})
                    </div>
                </div>

            </div>
            <div class="layui-col-md7" style="padding-left: 20px;">
                <h1 class="title">{{title}}</h1>

                <div v-if="detail.location" class="detail-item">
                    <span>车库位置：</span>
                    <span class="desc">
								{{detail.location}}
							</span>
                </div>
                <div v-if="detail.ryTypes" class="detail-item">
                    <span>车库主人：</span>
                    <span class="desc">
								{{detail.ryTypes}}
							</span>
                </div>
                <div v-if="detail.garageSize" class="detail-item">
                    <span>车库大小：</span>
                    <span class="desc">
								{{detail.garageSize}}
							</span>
                </div>
                <div v-if="detail.money" class="detail-item">
                    <span>车库价格(天)：</span>
                    <span class="price">
								{{detail.money}}RMB
							</span>
                </div>

                <div class="detail-item">
                    <span>车库状态：</span>
                    <span class="price">
								{{detail.ckztTypes}}
							</span>
                </div>

                <div class="detail-item">


                </div>

                <div class="detail-item" style="text-align: right;">


                    <button data-toggle="modal" data-target="#exampleModal" type="button"
                            class="layui-btn">
                        预定
                    </button>


                </div>
            </div>
        </div>


        <div class="layui-row">
            <div class="layui-tab layui-tab-card">

                <ul class="layui-tab-title">
                    <li class="layui-this">详情</li>

                    <%--<li>评价</li>--%>
                </ul>

                <div class="layui-tab-content">

                    <div class="layui-tab-item layui-show">
                        <div v-html="detail.matterContent"></div>
                    </div>


                    <div class="layui-tab-item">
                        <div class="message-container">
                            <form class="layui-form message-form" style="padding-right: 20px;border-bottom: 0;">
                                <div class="layui-form-item layui-form-text">
                                    <label class="layui-form-label">评价</label>
                                    <div class="layui-input-block">
                                        <textarea name="content" required lay-verify="required" placeholder="请输入内容"
                                                  class="layui-textarea"></textarea>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <div class="layui-input-block">
                                        <button class="layui-btn btn-submit" lay-submit lay-filter="*">立即提交</button>
                                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                    </div>
                                </div>
                            </form>
                            <div class="message-list">
                                <div class="message-item" v-for="(item,index) in dataList" v-bind:key="index">
                                    <div class="username-container">
                                        <img class="avator" src="../../img/avator.png">
                                        <span class="username">用户：{{item.userid}}</span>
                                    </div>
                                    <div class="content">
												<span class="message">
													{{item.content}}
												</span>
                                    </div>
                                </div>
                            </div>
                            <div class="pager" id="pager"></div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>


    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">车库出租</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-sm-4" style="margin-top: 8px">
                            使用时长(天)：
                        </div>
                        <div class="col-sm-8">
                            <input type="number" id="day" class="layui-input"
                                   placeholder="请输入使用时长（天）" aria-controls="tableId">
                            <input type="hidden" id="id">
                        </div>
                    </div>
                    </br>
                    <div class="row" id="div1"></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                    <button type="button" id="receive" onclick="renting()" class="btn btn-primary">发布</button>
                </div>
            </div>
        </div>
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
<!-- 地图 -->
<script type="text/javascript" src="../../js/jquery.js"></script>
<script type="text/javascript" src="http://webapi.amap.com/maps?v=1.3&key=ca04cee7ac952691aa67a131e6f0cee0"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<link href="../../../resources/css/bootstrap.min.css" rel="stylesheet">

<script>
    var vue = new Vue({
        el: '#app',
        data: {
            // 轮播图
            swiperList: [],
            // 数据详情
            detail: {
            },
            // 商品标题
            title: '',
            // 倒计时
            count: 0,
            // 加入购物车数量
            buynumber: 1,
            // 当前详情页表
            detailTable: 'cheku',
            // 评价列表
            dataList: [],
            // 选座座位列表
            numberList: [],
            yonghu:[],
            dr:[]
        },
        // 倒计时效果
        computed: {
            SecondToDate: function () {
                var time = this.count;
                if (null != time && "" != time) {
                    if (time > 60 && time < 60 * 60) {
                        time =
                            parseInt(time / 60.0) +
                            "分钟" +
                            parseInt((parseFloat(time / 60.0) - parseInt(time / 60.0)) * 60) +
                            "秒";
                    } else if (time >= 60 * 60 && time < 60 * 60 * 24) {
                        time =
                            parseInt(time / 3600.0) +
                            "小时" +
                            parseInt(
                                (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                            ) +
                            "分钟" +
                            parseInt(
                                (parseFloat(
                                    (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                                    ) -
                                    parseInt(
                                        (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                                    )) *
                                60
                            ) +
                            "秒";
                    } else if (time >= 60 * 60 * 24) {
                        time =
                            parseInt(time / 3600.0 / 24) +
                            "天" +
                            parseInt(
                                (parseFloat(time / 3600.0 / 24) - parseInt(time / 3600.0 / 24)) *
                                24
                            ) +
                            "小时" +
                            parseInt(
                                (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                            ) +
                            "分钟" +
                            parseInt(
                                (parseFloat(
                                    (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                                    ) -
                                    parseInt(
                                        (parseFloat(time / 3600.0) - parseInt(time / 3600.0)) * 60
                                    )) *
                                60
                            ) +
                            "秒";
                    } else {
                        time = parseInt(time) + "秒";
                    }
                }
                return time;
            }
        },
        //  清除定时器
        destroyed: function () {
            window.clearInterval(this.inter);
        },
        methods: {
            jump(url) {
                jump(url)
            },
            isAuth(tablename, button) {
                return isFrontAuth(tablename, button)
            },
            // 倒计时初始化
            countDown() {
                let reversetime = new Date(this.detail.reversetime).getTime()
                let now = new Date().getTime();
                let count = reversetime - now;
                if (count > 0) {
                    this.count = count / 1000
                    var _this = this;
                    this.inter = window.setInterval(function () {
                        _this.count = _this.count - 1;
                        if (_this.count < 0) {
                            window.clearInterval(_this.inter);
                            layer.msg("活动已结束", {
                                time: 2000,
                                icon: 5
                            })
                        }
                    }, 1000);
                }
            },

            // 赞
            thumbsupnumClick() {
                this.detail.thumbsupnum = this.detail.thumbsupnum+1
                layui.http.request(`${this.detailTable}/thumbsupnumClick?ids=`+this.detail.id, 'get', {}, function (res) {
                    console.log(res);
                })
            },
            // 踩
            crazilynumClick() {
                this.detail.crazilynum = this.detail.crazilynum+1
                layui.http.request(`${this.detailTable}/crazilynumClick?ids=`+this.detail.id, 'get', {}, function (res) {
                    console.log(res);
                })
            },
            // 跨表
            onAcrossTap(acrossTable) {
                localStorage.setItem('crossTable', `cheku`);
                localStorage.setItem('crossObj', JSON.stringify(this.detail));
                jump(`../${acrossTable}/add.jsp?corss=true`);
            },


            // 收藏商品
            storeUp() {
                layui.http.requestJson('storeup/save', 'post', {
                    userid: localStorage.getItem('userid'),
                    name: this.title,
                    picture: this.swiperList,
                    refid: this.detail.id,
                    tablename: this.detailTable
                }, function (res) {
                    layer.msg(`收藏成功`, {
                        time: 2000,
                        icon: 6
                    });
                });
            },


        }
    })

    function renting(){
        var mymessage = confirm("真的要预定吗？");
        if (mymessage == true) {
            layui.http.request("cheku/renting?id="+layui.http.getParam('id')+"&day="+$("#day").val(), "get", {}, function (res) {
                if(res.code == 0 ){
                alert('预定成功');
                $('#exampleModal').modal('hide')
                $('#day').val()
                vue.detail.ckztTypes = "已租"
            }
        })
            ;
        }
        else {
            $('#day').val()
            $('#id').val()
            alert("已取消操作");
        }
    }

    layui.use(['layer', 'form', 'element', 'carousel', 'http', 'jquery', 'laypage'], function () {
        var layer = layui.layer;
        var element = layui.element;
        var form = layui.form;
        var carousel = layui.carousel;
        var http = layui.http;
        var jquery = layui.jquery;
        var laypage = layui.laypage;

        var limit = 10;

        // 数据ID
        var id = http.getParam('id');
        vue.detail.id = id;

        http.request(`yonghu/page`, 'get', {}, function (res) {
             vue.yonghu = res.data.list
        })

        http.request(`dictionary/page?page=1&limit=100&sort=&order=&dicCode=ckzt_types`, 'get', {}, function (res) {
            vue.dr = res.data.list
       } )


        // 商品信息
        http.request(`${vue.detailTable}/info/` + id, 'get', {}, function (res) {
            // 详情信息
            vue.detail = res.data
            vue.title = vue.detail.name;
            // 轮播图片
            vue.swiperList = vue.detail.imgPhoto;
            var swiperItemHtml = '';
                swiperItemHtml +=
                    '<div>' +
                    '<img class="swiper-item" src="' + vue.swiperList + '">' +
                    '</div>';
            jquery('#swiper-item').html(swiperItemHtml);

            for(var i=0 ; i<vue.yonghu.length ; i++){
                if(vue.detail.ryTypes == vue.yonghu[i].id){
                    vue.detail.ryTypes = vue.yonghu[i].name;
                }
            }

            for(var i=0 ; i<vue.dr.length ; i++){
                if(vue.detail.ckztTypes == vue.dr[i].codeIndex){
                    vue.detail.ckztTypes = vue.dr[i].indexName;
                }
            }

            // 轮播图
            carousel.render({
                elem: '#swiper',
                width: swiper.width, height: swiper.height,
                arrow: swiper.arrow,
                anim: swiper.anim,
                interval: swiper.interval,
                indicator: swiper.indicator
            });


        });

        // 获取评论
        http.request(`discuss${vue.detailTable}/list`, 'get', {
            page: 1,
            limit: limit,
            refid: vue.detail.id,
            userid: localStorage.getItem('userid')
        }, function (res) {
            vue.dataList = res.data.list
            // 分页
            laypage.render({
                elem: 'pager',
                count: res.data.total,
                limit: limit,
                jump: function (obj, first) {
                    //首次不执行
                    if (!first) {
                        http.request(`discuss${vue.detailTable}/list`, 'get', {
                            page: obj.curr,
                            limit: obj.limit,
                            userid: localStorage.getItem('userid')
                        }, function (res) {
                            vue.dataList = res.data.list
                        })
                    }
                }
            });
        })

        // 提交评论
        form.on('submit(*)', function (data) {
            data = data.field;
            data.userid = localStorage.getItem('userid')
            data.refid = vue.detail.id
            http.requestJson(`discuss${vue.detailTable}/save`, 'post', data, function (res) {
                layer.msg('评价成功', {
                    time: 2000,
                    icon: 6
                }, function () {
                    window.location.reload();
                });
                return false
            });
            return false
        });

    });
</script>
</body>
</html>
