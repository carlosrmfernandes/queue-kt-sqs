# Configuração e Execução do Projeto

## 1. Pré-requisitos
Antes de iniciar, certifique-se de ter instalado:

- Docker
- Java 17+
- Gradle

## 2. Rodando o LocalStack
Para simular o SQS localmente, execute o seguinte comando para iniciar o LocalStack:

```sh
docker-compose up -d --build
```

Em seguida, crie a fila manualmente executando:

```sh
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name queue-sqs-test
```

## 3. Executando a Aplicação

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

