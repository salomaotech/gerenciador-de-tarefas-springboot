
# gerenciador-de-tarefas-spring

API para gerenciamento de listas de tarefas, desenvolvida com Spring Boot, permitindo criar, atualizar, listar e excluir tarefas.

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

### 🔗 Base URL

```
http://localhost:8080/tarefas
```

---

### 🔹 Criar nova tarefa

- **Método:** `POST`
- **Endpoint:** `/tarefas`
- **Corpo da requisição (JSON):**
```json
{
  "titulo": "Estudar Java",
  "descricao": "Praticar Spring Boot",
  "status": "PENDENTE",
  "dataCriacao": "2025-05-01T10:00:00",
  "dataConclusao": "2025-05-10T18:00:00",
  "prioridade": "ALTA"
}
```
- **Resposta:** `201 Created` com a tarefa criada.

---

### 🔹 Listar todas as tarefas

- **Método:** `GET`
- **Endpoint:** `/tarefas`
- **Resposta:** `200 OK` com lista de tarefas.

---

### 🔹 Buscar tarefa por ID

- **Método:** `GET`
- **Endpoint:** `/tarefas/{id}`
- **Resposta:**
    - `200 OK` com a tarefa encontrada
    - `404 Not Found` com mensagem `"Não encontrado :-("`

---

### 🔹 Atualizar tarefa

- **Método:** `PUT`
- **Endpoint:** `/tarefas/{id}`
- **Corpo da requisição (JSON):**
```json
{
  "titulo": "Estudar Java Avançado",
  "descricao": "Aprofundar no Spring Boot",
  "status": "CONCLUIDA",
  "dataCriacao": "2025-05-01T10:00:00",
  "dataConclusao": "2025-05-10T18:00:00",
  "prioridade": "MEDIA"
}
```
- **Resposta:**
    - `200 OK` com tarefa atualizada
    - `404 Not Found` com mensagem `"Não encontrado :-("`

---

### 🔹 Deletar tarefa

- **Método:** `DELETE`
- **Endpoint:** `/tarefas/{id}`
- **Resposta:**
    - `200 OK` com mensagem `"Removido!"`
    - `404 Not Found` com mensagem `"Não encontrado :-("`

---

## Contato

Entre em contato por e-mail: **salomao@taimber.com**
