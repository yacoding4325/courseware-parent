# courseware-parent
# 项目界面





## 首页 课件列表

## 注意

前端utils/common.js中 有阿里oss的图片 前缀,改成自己的

## 2.1 接口说明

接口url：/cwApi/courseware/list

请求方式: get

请求参数:

| 名称  | 类型 | 描述           |
| ----- | ---- | -------------- |
| start | int  | 当前页 从1开始 |

返回数据: 
// http://localhost:5000/cwApi/courseware/list?start=1

{
  "code": 0,
  "message": "操作成功！",
  "data": {
    "pageNum": 1,
    "pageSize": 10,
    "totalPage": 1,
    "total": 4,
    "list": [
      {
        "id": 1,
        "name": "JAVA核心面试知识整理",
        "price": 0.99,
        "count": 1,
        "url": null,
        "cover": "/courseware/cover/java_hexin.png",
        "createTime": "2021-02-18 13:55:11",
        "carouselUrl": "/courseware/carousel/1.jpg",
        "isCarousel": 1
      },
      {
        "id": 4,
        "name": "2021Java面试题大全",
        "price": 0.99,
        "count": 0,
        "url": null,
        "cover": "/courseware/cover/java_ms.png",
        "createTime": "2021-02-18 13:55:11",
        "carouselUrl": "/courseware/carousel/2.jpg",
        "isCarousel": 2
      },
      {
        "id": 20,
        "name": "深入理解MySQL核心技术",
        "price": 0.99,
        "count": 0,
        "url": null,
        "cover": "/courseware/cover/mysql.jpg",
        "createTime": "2021-02-20 21:56:14",
        "carouselUrl": "/courseware/carousel/3.jpg",
        "isCarousel": 3
      },
      {
        "id": 21,
        "name": "软件设计师考点精炼",
        "price": 0.99,
        "count": 0,
        "url": null,
        "cover": "/courseware/cover/ruan.jpg",
        "createTime": "2021-08-07 17:57:52",
        "carouselUrl": "",
        "isCarousel": 0
      }
    ]
  }
}
