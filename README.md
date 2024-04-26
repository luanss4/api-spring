# Api Spring utilizada com o projetos base spring boot, spring data, ja aplicando camada de segurança com spring security, estratégia de geração de token para acesso aos endpoints privados

## Descrição

Este é um projeto **Java** utilizando a versão **17**, com **Spring Boot**, **Spring Data**, **Spring Security**, **JWT** e **Lombok**. O projeto também utiliza **Docker** e **docker-compose** para a criação e gerenciamento de containers. Além disso, o projeto conta com integração contínua e entrega contínua (CI/CD) utilizando **GitHub Actions**.

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- Java 17
- Docker
- Docker Compose

## Como usar

Para copiar e executar este projeto, você vai precisar do Git instalado em seu computador. A partir da linha de comando:

```bash
# Clone este repositório
$ git clone <url-do-repositorio>

# Acesse a pasta do projeto no terminal/cmd
$ cd nome-do-projeto

# Execute a aplicação em modo de desenvolvimento
$ ./mvnw spring-boot:run

# O servidor inciará na porta:8080 - acesse http://localhost:8080
