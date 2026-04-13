# Spring Boot JWT Auth API

## 🚀 Sobre o projeto

Esta é uma API REST construída com Spring Boot que implementa autenticação de usuários utilizando JWT (JSON Web Token).

O projeto inclui operações CRUD de usuários, hash de senha com BCrypt e autenticação stateless.

---

## 🛠️ Tecnologias utilizadas

* Java
* Spring Boot
* Spring Security
* JPA / Hibernate
* H2 Database (ou PostgreSQL)

---

## 🔐 Funcionalidades

* Cadastro de usuários
* Login com autenticação JWT
* Hash de senha com BCrypt
* Rotas protegidas com JWT
* API REST seguindo boas práticas

---

## 📡 Endpoints

### Auth

* `POST /auth/login` → realiza login e retorna o token JWT

### Usuários

* `POST /users` → cria um usuário
* `GET /users` → lista todos os usuários
* `GET /users/{id}` → busca usuário por ID
* `PUT /users/{id}` → atualiza usuário
* `DELETE /users/{id}` → deleta usuário

---

## 🧪 Como testar

1. Criar um usuário:
   POST /users

2. Fazer login:
   POST /auth/login

3. Copiar o token retornado

4. Usar nas requisições:
   Authorization: Bearer SEU_TOKEN

---

## 📌 Autor

David Bonardi
