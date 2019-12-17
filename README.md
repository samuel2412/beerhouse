# Cadastro de cervejas artesanais


postman collection: https://www.getpostman.com/collections/3017b041501b588fe6db

altere o arquivo application.properties, inserindo suas configurações do banco de dados e crie um schema chamado "craftbeer"
/craftbeer-master/src/main/resources/application.properties


#path

GetResquest:
/beerhouse/beers	->retorna todas as cervejas cadastradas.
/beerhouse/beers/{id}	->retorna a cerveja com o id passado, caso ela exista.

PostRequest:
/beerhouse/beers	->recebe um json no corpo da requisição e o salva.

PutRequest:
/beerhouse/beers/{id}	->recebe um json no corpo da requisição e altera a cerveja cujo id foi passado na url, caso ela exista.

DeleteRequest:
/beerhouse/beers/{id}	->deleta a cerveha cin i id passado, caso ela exista.

