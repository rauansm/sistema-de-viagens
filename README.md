# Sistema de Viagens ✈️

## 📑 Sobre o Projeto
O Sistema de Reservas de Viagens é uma aplicação que permite aos usuários buscar informações sobre voos, hotéis e aluguel de carros com base em suas preferências de quantidade de pessoas, datas e localizações.

## Architecture Haiku
### Objetivos do Negócio
- Buscar opções de viagem com base nos critérios de quantidade de pessoas, datas de ida e volta, local de origem e destino.
- Exibir opções de voos, hotéis e aluguel de carros disponíveis.
- Gerenciar reservas de viagens feitas pelos usuários.

### Restrições
- Operação na nuvem.
- Async
- Foco no back-end.

### Atributos de Qualidade
Segurança > Disponibilidade > Escalabilidade

### Decisões de Design
- Java Spring Boot.
- API RESTful.
- Spring Cloud OpenFeign.
- Spring Data JPA.
- Spring Security e JWT.
- Lombok.
- H2 Database (para ambiente de desenvolvimento).

## C4 Model
![C4 Model](https://github.com/rauansm/sistema-de-viagens/blob/master/src/main/resources/doc/sistema%20viagens.png?raw=true)

## 📂 Pré-Requisitos
- Java 17
- Maven

## 💻  Como Executar o Projeto
1. Clone o repositório: git clone https://github.com/rauansm/sistema-de-viagens
2. Executar a aplicação Spring Boot
3. O sistema estará rodando e acessível em http://localhost:8080.
