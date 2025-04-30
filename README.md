
# gerenciador-de-tarefas-spring

Aplicação Spring Boot para gerenciamento de tarefas.

## Tecnologias utilizadas

- Java 21  
- Spring Boot  
- Spring Boot DevTools  
- Spring Data JPA  
- MySQL (porta 3307, banco: `tarefas`)  
- MySQL Connector/J  
- Maven  

## Como rodar

Certifique-se de que o MySQL esteja em execução na porta `3307` e com o banco `tarefas` criado.  
Usuário: `salomao`  
Senha: `123456`

```bash
./mvnw clean package
java -jar target/gerenciador-de-tarefas-spring-0.0.1-SNAPSHOT.jar
```

A aplicação estará disponível em: `http://localhost:8080`

## Configuração do banco de dados (`application.properties`)

```properties
spring.application.name=gerenciador-de-tarefas-spring
spring.datasource.url=jdbc:mysql://localhost:3307/tarefas
spring.datasource.username=salomao
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
```

## Dependência do MySQL (pom.xml)

Certifique-se de que a dependência do MySQL Connector/J esteja incluída no `pom.xml`:

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
</dependency>
```

## Contato

Entre em contato por e-mail: **salomao@taimber.com**
