# Тестовое задание "Subscription manager"

### Описание эндпоинтов:
  В корне проекта содержится коллекция для Postman

  
### Стек

- Java 17
- Maven
- Docker
- Spring Boot
- Postgres
- Hibernate

## Сборка и запуск

1. В корневой папке проекта создать docker-образ приложения командой
    ```
    docker build -t subman:latest .
    ```
2. Запустить контейнеры с помощью docker compose командой 
    ```
   docker-compose up -d
   ```
