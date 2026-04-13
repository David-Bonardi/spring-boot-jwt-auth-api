# 🚀 Spring Boot JWT Auth API

## 📌 Sobre o projeto

Esta é uma API REST desenvolvida com **Spring Boot** que implementa autenticação de usuários utilizando **JWT (JSON Web Token)**.

A aplicação segue boas práticas de arquitetura, utilizando **DTOs**, **validação de dados**, **tratamento global de exceções** e **segurança stateless**.

---

## 🛠️ Tecnologias utilizadas

* Java
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* JPA / Hibernate
* PostgreSQL (ou H2 para testes)
* BCrypt (hash de senha)

---

## 🔐 Funcionalidades

* Cadastro de usuários
* Login com autenticação JWT
* Hash seguro de senha com BCrypt
* Rotas protegidas com Spring Security
* Validação de dados com mensagens personalizadas
* Tratamento global de erros
* Uso de DTOs para separar API e entidade

---

## 📡 Endpoints

### 🔑 Auth

* `POST /auth/login` → realiza login e retorna o token JWT

### 👤 Usuários

* `POST /users` → cria um usuário
* `GET /users` → lista todos os usuários *(requer token)*
* `GET /users/{id}` → busca usuário por ID *(requer token)*
* `PUT /users/{id}` → atualiza usuário *(requer token)*
* `DELETE /users/{id}` → deleta usuário *(requer token)*

---

## ⚙️ Configuração

A aplicação utiliza variáveis de ambiente para configurações sensíveis.

### Exemplo:

```bash
JWT_SECRET=sua-chave-base64
DB_USERNAME=postgres
DB_PASSWORD=sua_senha
```

Caso não sejam definidas, valores padrão são utilizados para desenvolvimento.

---

## 🧪 Como testar

1. Criar um usuário:

```
POST /users
```

2. Fazer login:

```
POST /auth/login
```

3. Copiar o token retornado

4. Usar nas requisições protegidas:

```
Authorization: Bearer SEU_TOKEN
```

---

## 🧠 Arquitetura

O projeto segue uma separação clara de responsabilidades:

* **Controller** → recebe requisições HTTP
* **DTOs** → entrada e saída de dados
* **Service** → lógica de negócio
* **Repository** → acesso ao banco
* **Security** → autenticação com JWT

---

## 👨‍💻 Autor

David Bonardi
