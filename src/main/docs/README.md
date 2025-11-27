📌 Descrição do Projeto:

Resumo: # Autor-Livro API (Spring Boot)

Projeto de exemplo com relacionamento One-to-Many: Autor -> Livro

## O que contém
- CRUD completo para Autor e Livro
- DTOs para resposta (evita exposição direta das entidades JPA)
- Docker Compose com PostgreSQL
- Postman collection pronta para importação

## Como usar
1. Rode `docker compose up -d` para subir o PostgreSQL.
2. Configure a URL do banco em `src/main/resources/application.properties` (padrão já aponta para localhost).
3. Rode a aplicação com Maven:
    - `./mvnw spring-boot:run` (Linux/Mac) ou `mvnw.cmd spring-boot:run` no Windows
    - Ou compile: `mvn clean package` e rode o jar.
4. Importar `postman_collection.json` no Postman e testar endpoints.

======================================================
Detalhado: 

API REST para gerenciamento de livros, utilizando:

Spring Boot

Docker + Docker Compose

Banco de Dados PostgreSQL

DTOs para evitar recursão e exposição indevida

Arquitetura: Controller → Service → Repository

🚀 Como Executar o Projeto
1️⃣ Pré-requisitos

Docker e Docker Compose instalados

docker -v
docker compose version

2️⃣ Iniciar o banco de dados

Na raiz do projeto executar:

docker compose up -d

Isso fará:

Criar container PostgreSQL

Database: meubanco

Usuário: postgres

Senha: postgres

3️⃣ Rodar o Spring Boot

🔌 Endpoints da API

Base URL:http://localhost:8080/livros
Método	Endpoint	     Descrição
GET	    /livros	         Lista todos os livros
GET	    /livros/{id}	 Busca livro por ID
POST	/livros	         Cadastra um novo livro
PUT	    /livros/{id}	 Atualiza um livro existente
DELETE	/livros/{id}	 Remove um livro

🗄 Banco de Dados (DBeaver ou PGAdmin)

Credenciais:

Item	Valor
Host	localhost
Porta	5432
Banco	meubanco
Usuário	postgres
Senha	postgres

🛠️ Tecnologias

Java 17+

Spring Boot 3+

Spring Data JPA

PostgreSQL

Docker

🧱 Estrutura do Projeto

src/main/java/br/com/ulbra/aula27/
├─ controllers/
│   └─ LivroController.java
├─ services/
│   └─ LivroService.java
├─ repositories/
│   └─ LivroRepository.java
├─ dtos/
│   ├─ LivroRequestDTO.java
│   └─ LivroResponseDTO.java
└─ entities/
└─ Livro.java

✔ Status

Projeto em desenvolvimento para estudo da 
disciplina de Programação Orientada a Objetos.