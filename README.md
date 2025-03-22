# Configuração e Execução do Projeto

## 1. Pré-requisitos
Antes de iniciar, certifique-se de ter os seguintes itens instalados:

- Docker
- Java 21
- Gradle

## 2. Rodando o LocalStack
Para simular o SQS localmente, execute o seguinte comando para iniciar o LocalStack:

```sh
docker-compose up -d --build
```

Em seguida, crie a fila manualmente dentro do container executando:

```sh
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name queue-sqs-test
```

Agora, envie uma mensagem para a fila via terminal:

```sh
aws --endpoint-url=http://localhost:4566 --region us-east-1 sqs send-message --queue-url http://sqs.us-east-1.localhost.localstack.cloud:4566/000000000000/queue-sqs-test --message-body "Hello from LocalStack!"
```

## 3. Executando a Aplicação

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080).

Resultado: 

<img width="1341" alt="image" src="https://github.com/user-attachments/assets/933d3b8a-91f4-4a04-a096-d2a988ef7c68" />


Produzindo uma sms para a fila usando o endpoint

```sh
curl --location 'http://localhost:8080/sqs/send' \
--header 'Content-Type: application/json' \
--data '{
    "nome":"Carlos Fernandes"
}'
```

Resultado: 

<img width="1244" alt="image" src="https://github.com/user-attachments/assets/a7892649-e9bf-4892-847a-075861b57f28" />
<img width="1334" alt="image" src="https://github.com/user-attachments/assets/57ec7280-c351-4430-b1a5-c1647bc20e57" />




