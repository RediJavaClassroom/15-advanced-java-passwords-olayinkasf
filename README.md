Template project for Advance Java course

* [Class 2](class2.md)
* [Class 3](class3.md)
* [Class 10](class10.md)
* [Class 12](class12.md) Dockerize the application
* [Class 15](class15.md) Authentication, passwords, hashing

## Starting the app

```
mvn clean package
docker-compose build
docker-compose up
```

---

Alternatively

```
docker run --publish 5432:5432 --env POSTGRES_PASSWORD=mysecretpassword --detach postgres
+ run in IntelliJ IDEA
```

----

## Try application

Create user:
```
curl -X POST http://localhost:8080/users --data '{"email": "test@example.com", "name": "Test", "password": "password"}' -H "Content-Type: application/json" -v
```

Login user:
```
curl -X POST http://localhost:8080/login --data '{"email": "test@example.com", "password": "password"}' -H "Content-Type: application/json" -v
```

Shorten link:
Replaces `JSESSIONID` cookie value with the one that is returned from `/login`

```
curl -X POST http://localhost:8080/links --data '{"url": "https://mkysoft.com"}' -H "Content-Type: application/json"  --cookie "JSESSIONID=D5254338C4C0F61A6FA49B3250D5FA62; Path=/; HttpOnly" -v
```

Expand link:

```
curl http://localhost:8080/xxx -v
```

Alternatively you can call those endpoints from Postman that should handle cookie passing mechanism automatically.

