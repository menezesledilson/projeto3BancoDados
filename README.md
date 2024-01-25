# Sistema de Cliente

Este é um sistema de cliente criado no IntelliJ com comunicação ao banco de dados PostgreSQL para salvar informações.

## Requisitos do Sistema

Certifique-se de ter as seguintes ferramentas instaladas antes de executar o sistema:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [PostgreSQL](https://www.postgresql.org/download/)

## Configuração do Banco de Dados

1. Crie um banco de dados no PostgreSQL para o sistema.
2. Atualize as informações de conexão com o banco de dados no dao em ConnectionFactory

private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
            		"jdbc:postgresql://localhost:5432/vendas_online_2", "postgres", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
