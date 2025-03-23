<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
var menus = [{
	"backMenu": [{
		"child": [{
			"buttons": ["新增", "修改", "删除"],
			"menu": "用户",
			"menuJump": "列表",
			"tableName": "yonghu"
		}],
		"menu": "用户管理"
	}, {
		"child": [{
			"buttons": ["新增", "修改", "删除", "查看评论"],
			"menu": "车库信息",
			"menuJump": "列表",
			"tableName": "cheku"
		}],
		"menu": "车库管理"
	}, {
		"child": [{
			"buttons": ["删除"],
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
			"buttons": ["新增", "修改", "删除"],
			"menu": "轮播图管理",
			"tableName": "config"
		},{
			"buttons": ["新增", "修改", "删除"],
			"menu": "新闻资讯",
			"tableName": "chekuzixun"
		}],
		"menu": "系统管理"
	}],
	"frontMenu": [],
	"hasBackLogin": "是",
	"hasBackRegister": "否",
	"hasFrontLogin": "否",
	"hasFrontRegister": "否",
	"roleName": "管理员",
	"tableName": "users"
},
{
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
			"buttons": ["续租","删除"],
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

var hasMessage = '';
