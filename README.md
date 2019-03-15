# Micronaut

This repository is to testing Micronaut Framework.

## Details

I tried to use some features that I use in Spring Boot.
- HttpClient to consume API
- JPA
- Restful

It miss some unit test and include security. 

## Database

Create a new docker instance of mysql with name local-mysql, listen in 3306 port (once)

```
$ docker run -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root --name local-mysql -d mysql
```

Connect and create the database

```
$ docker exec -it local-mysql mysql -uroot -proot
> create database preferences;
```

Start container next time:
```
$ docker start local-mysql
```


## References
- https://medium.com/@wilderpereira/introdu%C3%A7%C3%A3o-ao-micronaut-framework-para-jvm-para-cria%C3%A7%C3%A3o-de-microsservi%C3%A7os-leves-e-perform%C3%A1ticos-1e679c010339
- https://docs.micronaut.io/latest/guide/index.html