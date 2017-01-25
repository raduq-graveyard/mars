## Mars

## Como fazer build ?

### Forma 1 - Usando plugin maven do Spring-boot

- ir para pasta root do projeto
- rodar o comando 'mvn spring-boot:run'

### Forma 2 - Usando java -jar

- ir para a pasta root do projeto
- rodar o comando 'mvn clean install '
- rodar o comando 'java -jar target/mars-<versao>.jar'

## Commandos

- get -> /rest/ping : ping do serviço
- post -> /rest/mars/<comando> : executa os commandos (M, L ou R)