# coupon-system

## Overview

The simple background of the coupon card package system, the HBase distributed database used in the original project, is modified here to Mysql implementation. The system mainly includes two modules, a merchant system and a user system. The merchant system allows the creation of merchant information and query of merchant information. The merchant sends coupon information to the system to the message middleware kafka. The main functions of the user system include creating user information and querying user information , Receiving coupons, querying available coupons, using coupons, querying used and unused coupons, storing coupon information in the message middleware, and uploading coupon token information by merchants, etc.

## Tech Stack

The entire system is constructed through spring-boot, the database uses Mysql, and mybatis serves as the persistence layer framework. The merchant system and the user system exchange information through the message middleware kafka to achieve understanding and coupling. In addition, redis is used to cache the token information of the coupon.

## Environment Preparartion
Create four data tables, coupons coupon table, merchants merchant table, user_coupons coupon table received by user, and users user table. The data table files are in the project db directory.

Start zookeeper service, kafka service needs to rely on this.

When the kafka service is started, the coupons placed by the merchant will be consumed by the user system through kafka and stored in the library.

Start the redis service, and the token information of the coupon will be cached based on redis.

Create a storage directory for the token files uploaded by the merchant. The default is /tmp/token.

## APIs

### Merchant System

All APIs of the merchant system need to carry the necessary token field in the request header, and the content is coupons_keeper_merchant_token.
1. Create business information
```
BODY: 
{
    "name": "McDonald's",
    "logoUrl": "https://www.mcdonalds.com.cn/",
    "businessLicenseUrl": "https://www.mcdonalds.license.com.cn/",
    "phone": "1234567",
    "address": "New York City"
}
```

2. Query merchant information

```
GET: localhost:8081/merchant/{merchantId}
```

3. Merchants put coupons

```
POST: localhost:8081/merchant/drop

BODY:

{
    "background": 3,
    "desc": "McDonald's coupon desc",
    "end": 1956759583868,
    "hasToken": false,
    "merchantId": 1,
    "limit": 10000,
    "start": 1555049583866,
    "summary": "McDonald's coupon summary",
    "title": "McDonald's coupon - no token"
}
```


### User system

1. Merchant coupon token upload interface
```
GET: http://localhost:8080/merchant/upload
```

2. Create user information

```
POST: localhost:8080/coupons/create-user

BODY:
{
	"name": "Jennie",
	"age": 23,
	"gender": "female",
	"phone": "1234567890",
	"address": "New York City"
}
```

3. User receives coupon

```
GET: http://localhost:8080/coupons/gain-coupon/{userId}/{couponId}
```

4. Check the coupon received by the user

```
GET: http://localhost:8080/coupons/user-coupons/{userId}
```

5. Check the coupons used by the user

```
GET: http://localhost:8080/coupons/used-coupons/{userId}
```

6. User use coupon

```
GET: http://localhost:8080/coupons/use-coupons/{userCouponId}
```

7. Query the coupons that users can receive, excluding coupons that have been received or expired

```
GET: http://localhost:8080/coupons/available-coupons/{userId}
```

8. Global exception test interface

```
GET: http://localhost:8080/coupons/exception
```