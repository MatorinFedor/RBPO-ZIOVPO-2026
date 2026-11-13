# РБПО
## Ссылка на этот репозиторий:
![QR](files/qr-code.gif)

### Код, который мы пишем на занятиях находится в ветке с названием вашей группы

## [Короткий конспект первого занятия](files/lab1.md)

## [Коллекция с POSTMAN запросами с пар](files/РБПО%20Практика%202026.postman_collection.json). Обновляется после каждого занятия

## [Задание 1. Подготовка репозитория](files/zadanie1.pdf)

Дополнительные материалы к заданию 1:

* [Документ](files/spring_introduction_info.md) с теоретической частью;
* [Инструкция](https://spring.io/quickstart) по созданию нового проекта с SpringBoot;
* Инструмент для автоматического создания проекта на Spring Boot: [Spring Initializer](https://start.spring.io/);
* [Документация и обучающие материалы по Spring](https://spring.io/).

**Срок сдачи:**  
БКС2403 - **03.10.2026**  
БКС2401, БКС2402, БАС2401, БАС2402 - **10.10.2026**  

## [Задание 2. Работа c REST](files/zadanie2)

* Выбрать [тему](files/zadanie2) согласно своему порядковому номеру в списке группы;
* Выполнить задание своего варианта, описанное в файле.

**Срок сдачи:**  
БКС2403 - **10.10.2026**  
БКС2401, БКС2402, БАС2401, БАС2402 - **17.10.2026**  

## [Задание 3. Базы данных, отношения между таблицами](files/zadanie3.pdf)
### Дополнительные материалы к заданию 3:
* [Документация по JPA в Spring](https://docs.spring.io/spring-data/jpa/reference/jpa.html)
* [Отношения между таблицами](https://www.baeldung.com/spring-data-rest-relationships)
* [Типы каскадных операций](https://www.baeldung.com/jpa-cascade-types)
* [Транзакции](https://docs.spring.io/spring-data/jpa/reference/jpa/transactions.html)
* [Курс и шпаргалка по SQL](https://proglib.io/p/sql-cheat-sheet)
* [pgAdmin: параметры подключения](https://www.pgadmin.org/docs/pgadmin4/latest/server_dialog.html)
* [PostgreSQL: права и владение](https://www.postgresql.org/docs/current/ddl-priv.html)
* [OWASP: предотвращение SQL-инъекций](https://cheatsheetseries.owasp.org/cheatsheets/SQL_Injection_Prevention_Cheat_Sheet.html)
* [Download PostgreSQL](https://www.postgresql.org/download/)

**Срок сдачи:**  
БКС2403 - **17.10.2026**  
БКС2401, БКС2402, БАС2401, БАС2402 - **24.10.2026**

## [Задание 4. Аутентификация и авторизация в Spring Security](files/zadanie4.pdf)
### Дополнительные материалы к заданию 4:
* [Устройство Spring Security](https://docs.spring.io/spring-security/reference/servlet/architecture.html)
* [Устройство аутентификации](https://docs.spring.io/spring-security/reference/servlet/authentication/architecture.html)
* [Базовая аутентификация](https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/basic.html)
* [Защита от CSRF](https://docs.spring.io/spring-security/reference/servlet/exploits/csrf.html)
* [CSRF Prevention Cheat Sheet — OWASP](https://cheatsheetseries.owasp.org/cheatsheets/Cross-Site_Request_Forgery_Prevention_Cheat_Sheet.html)
* [CORS и ограничения браузера](https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/CORS)
* [Гайд по SpringSecurity на SpringIO](https://spring.io/guides/gs/securing-web)

**Срок сдачи:**  
БКС2403 - **31.10.2026**  
БКС2401, БКС2402, БАС2401, БАС2402 - **07.11.2026**  

## [Задание 5. Аутентификация с использованием токенов](files/zadanie5.pdf)

* Внимательно ознакомьтесь с [теоретической частью](files/jwt_info.md)

### Дополнительные материалы к заданию 5:
* [Введение в JWT](https://www.jwt.io/introduction#when-to-use-json-web-tokens)
* [RFC 7519 - JSON Web Token](https://www.rfc-editor.org/rfc/rfc7519.html)

**Срок сдачи:**  
БКС2403 - **14.11.2026**  
БКС2401, БКС2402, БАС2401, БАС2402 - **21.11.2026**

## [Задание 6. Создание цепочки сертификатов и настройка HTTPS](files/zadanie6.pdf)

* Внимательно ознакомьтесь с [теоретической частью](files/https_info.md)
* [Корневой сертификат](files/course-root-ca.crt)
* [Хранилище промежуточного CA](files/course-issuing-ca.p12) с закрытым ключом
* Отпечатки SHA-256:
  * Корневой CA `RBPO Root CA`
  ```text
  9A:D6:EC:24:B4:E6:18:A8:2C:4B:F7:E1:9C:8A:F3:F4:E0:22:68:03:A3:97:74:5C:98:79:F7:DC:06:11:36:DF
  ```
  * Промежуточный CA `RBPO Issuing CA`
  ```text
  CB:5A:38:65:37:04:ED:D8:FA:96:4E:89:7E:FE:53:C4:9C:BD:1B:5C:C4:E2:88:F3:73:0F:92:FB:FC:76:E6:7F
  ```

### Дополнительные материалы к заданию 6:

* [Команда keytool](https://docs.oracle.com/en/java/javase/25/docs/specs/man/keytool.html)
* [Выбор размеров ключей и сроков их использования, NIST SP 800-57](https://csrc.nist.gov/pubs/sp/800/57/pt1/r5/final)
* [Сертификаты и ограничения центров сертификации, RFC 5280](https://www.rfc-editor.org/rfc/rfc5280.html)
* [Протокол TLS 1.3, RFC 8446](https://www.rfc-editor.org/rfc/rfc8446.html)
* [Настройка TLS в Spring Boot](https://docs.spring.io/spring-boot/how-to/webserver.html#howto.webserver.configure-ssl)

**Срок сдачи:**  
БКС2403 - **28.11.2026**  
БКС2401, БКС2402, БАС2401, БАС2402 - **05.12.2026**

