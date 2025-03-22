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

Em produzinnho sms para a fila

```sh
aws --endpoint-url=http://localhost:4566 --region us-east-1 sqs send-message --queue-url http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/queue-sqs-test --message-body "Hello from LocalStack!"
```

Resultado: 

<img width="1341" alt="image" src="https://github.com/user-attachments/assets/933d3b8a-91f4-4a04-a096-d2a988ef7c68" />


## 3. Executando a Aplicação

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

