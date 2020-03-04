# Spring Boot GIS
- SpringBoot+MySql+GeoTools 处理地图数据简单应用

## 技术
- SpringBoot
- GeoTools
- MySql

## demo
### 添加
```http request
POST http://localhost:9001/point/add
Content-Type: application/json

{
 "name":"test",
 "geom":"POINT(1 1)"
}
```
- 返回值
```json
{
  "id" : null,
  "name" : "test",
  "geom" : "POINT(1 1)",
  "geoHash" : null
}
```

### 查询
```http request
GET http://localhost:9001/point/1

```
- 返回值
```json
{
  "id" : 1,
  "name" : "22",
  "geom" : "POINT(1 1)",
  "geoHash" : null
}
```