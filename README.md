# FoodDeliveryApplication

## Functional Requirements:
* User search a restaurant based on **restaurant name**
* Order food by choosing different **menu item**, **quantity** and add a **note** about **diet restriction**
* User can fills in the **delivery address**
* After user ordered, the order should contain **food items**, **quantity**, **price** and **order time**
* User pays for oreder by providing **credit card number**, **expiration date**, **security code**
* After successfully payed, payment return **payment ID**, **timestamp**
* User can see the **estimated delivery time**

## Non-Functional Requirements:
* Use microservices architecture
* reasonable amount of unit tests, integration tests and mvc tests
* at least one place to handle payment error case

## References:

Spring Data REST - Reference Documentation:
https://docs.spring.io/spring-data/rest/docs/current/reference/html/

How to write README.md using markdown:
https://guides.github.com/features/mastering-markdown/

10 Best practices for Better RESTful API:
https://blog.mwaysolutions.com/2014/06/05/10-best-practices-for-better-restful-api/

## Problem Met:
when git hub say :
error: inflate: data stream error (incorrect header check)
error: corrupt loose object '5cdeb9c3a1fe164cb4d2779d1e0d9d9f4ef18c6a'
fatal: loose object 5cdeb9c3a1fe164cb4d2779d1e0d9d9f4ef18c6a (stored in .git/objects/5c/deb9c3a1fe164cb4d2779d1e0d9d9f4ef18c6a)

solve this problem with:
find .git/objects/ -size 0 -exec rm -f {} \;
http://vincesalvino.blogspot.ca/2013/08/git-empty-files-corrupt-objects-and.html
