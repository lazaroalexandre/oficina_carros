# Oficina de carros

    Sistema de controle de revisões de carros em uma oficina.


# Tecnologias usadas

    Spring - Java


# Dependências

    Spring Web
    Spring Data JPA
    Lombok
    Spring Boot DevTools
    H2 Database


# Execução

    [LINUX] Execute o comando para limpar e reconstruir o projeto spring:

    mvn clean package
    mvn dependency:tree


    [LINUX] Execute o comando para rodar o projeto:

    mvn spring-boot:run


# Endpoints 

    - Carros:

        GET: http://localhost:8080/carro/list
        GET: http://localhost:8080/carro/detail/{id}
        POST: http://localhost:8080/carro/create
        PUT: http://localhost:8080/carro/update/{id}
        DELETE: http://localhost:8080/carro/delete/{id}
