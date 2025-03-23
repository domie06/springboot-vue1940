
var projectName = '车库智能管理平台';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.jsp'
}, 
{
	name: '我的收藏',
	url: '../storeup/list.jsp'
}
]


var indexNav = [

{
	name: '车库信息',
	url: './pages/cheku/list.jsp'
},
{
	name: '平台新闻',
	url: './pages/news/list.jsp'
}

]

var adminurl =  "http://localhost:8080/zhinengguanli/index.jsp";

var cartFlag = false

var chatFlag = false




var menu = [{
        "backMenu": [{
            "child": [{
                "buttons": ["新增", "修改", "删除", "查看评论"],
                "menu": "车库信息",
                "menuJump": "列表",
                "tableName": "cheku"
            }],
            "menu": "车库管理"
        }, {
            "child": [{
                "buttons": [],
                "menu": "预约记录",
                "menuJump": "列表",
                "tableName": "yuyvejilu"
            }],
            "menu": "预约记录模块"
        }, {
            "child": [{
                "buttons": [],
                "menu": "新闻资讯",
                "tableName": "chekuzixun"
            }],
            "menu": "新闻资讯"
        }],
        "frontMenu": [],
        "hasBackLogin": "是",
        "hasBackRegister": "否",
        "hasFrontLogin": "否",
        "hasFrontRegister": "否",
        "roleName": "车库主人",
        "tableName": "yonghu"
    },
    {
        "backMenu": [{
            "child": [{
                "buttons": ["预定"],
                "menu": "车库信息",
                "menuJump": "列表",
                "tableName": "cheku"
            }],
            "menu": "车库管理"
        }, {
            "child": [{
                "buttons": ["续租"],
                "menu": "预约记录",
                "menuJump": "列表",
                "tableName": "yuyvejilu"
            }],
            "menu": "预约记录模块"
        }, {
            "child": [{
                "buttons": ["删除"],
                "menu": "我的收藏管理",
                "tableName": "storeup"
            }],
            "menu": "我的收藏管理"
        }, {
            "child": [{
                "buttons": [],
                "menu": "新闻资讯",
                "tableName": "chekuzixun"
            }],
            "menu": "新闻资讯"
        }],
        "frontMenu": [],
        "hasBackLogin": "是",
        "hasBackRegister": "否",
        "hasFrontLogin": "否",
        "hasFrontRegister": "否",
        "roleName": "用户",
        "tableName": "yonghu"
    }];

var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
