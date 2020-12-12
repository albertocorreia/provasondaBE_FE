README
-----------------

Projeto Provasonda (https://github.com/albertocorreia/provasondaBE_FE)

Autor: Alberto Correia (alberto.correia@gmail.com)

Funcionamento
-----------------
A página de consulta pode ser acessada pelo endereço
http://java.dynamotech.com.br:8080/ProvaJavaSondaFE/
nesta o usuário é apresentado a uma listagem de aeronaves e pode manipulá-la, criando, alterando ou excluindo as mesmas. Esta aplicação é single page.

Os endpoints podem ser acessados no endereço abaixo

- GET -  Retornar todas as aeronaves
http://java.dynamotech.com.br:8080/ProvaJavaSondaBE/aeronaves

- GET -  Retornar uma aeronave
http://java.dynamotech.com.br:8080/ProvaJavaSondaBE/aeronaves/{id}

- POST -  Adiciona uma aeronave
http://java.dynamotech.com.br:8080/ProvaJavaSondaBE/aeronaves

- PUT -  Atualiza os dados de uma aeronave
http://java.dynamotech.com.br:8080/ProvaJavaSondaBE/aeronaves/{id}

- DELETE -  Exclui uma aeronave
http://java.dynamotech.com.br:8080/ProvaJavaSondaBE/aeronaves/{id}

O endpoint GET /aeronaves/find não foi implementado, assim como as respectivas pesquisas que seriam geradas por este na página http://java.dynamotech.com.br:8080/ProvaJavaSondaFE/

Arquitetura
-----------------
O projeto foi dividido em duas aplicações
ProvaJavaSondaFE que é a aplicação cliente que consome os dados da API RESTful do projeto. O mesmo foi desenvolvido com:
- JSP
- HTML
- Javascript
- Jquery
- CSS
- Bootstrap

O mesmo foi desenvolvido no Eclipse IDE.

O mesmo foi testado nos navegadores Chrome, Edge e Firefox em ambiente desktop e no Chrome e Firefox em ambiente mobile. 

O mesmo está publicado em um Apache Tomcat 9 instalado em um Debian Linux na AWS (EC2).

O projeto está versionado na pasta source/ProvaJavaSondaFE deste repositório.

ProvaJavaSondaBE é a API RESTful do projeto. O mesmo foi desenvolvido com:
- Spring MVC
- JPA

O Maven está sendo utilizado para o gerenciamento de dependências.

A base da dados é MySQL, cujo schema se chama aeronaves e a tabela principal aer_aeronave – na pasta data deste repositório está o MER em PDF e o mesmo em formato editável MWB do MySQL Workbench.

O mesmo foi desenvolvido no Eclipse IDE.

Os endpoints do projeto foram testados no aplicativo Postman.

O mesmo está publicado em um Apache Tomcat 9 instalado em um Debian Linux na AWS (EC2).

O projeto está versionado na pasta source/ProvaJavaSondaBE deste repositório.


Instalação
-----------------
Criar a base de dados no MySQL
Na pasta data estão os arquivos que devem ser utilizados nesta ordem: 
1) createdb_aeronaves.sql : criação do schema e do usuário com seus respectivos grants (com perfil de desenvolvimento)
2) estruturadb_aeronaves.sql: criação das tabelas e demais objetos do banco de dados

Após a criação do banco de dados pasta realizar o deplay do WAR de ambos os projetos em um servidor de aplicações apropriado, como o Tomcat.

O WAR pode ser gerado a partir dos fontes ou existe uma versão dos mesmos na pasta WAR deste repositório.

Caso o servidor de aplicações e o banco de dados não estejam no mesmo servidor, a criação do usuário no arquivo createdb_aeronaves.sql e o arquivo persistence.xml do projeto ProvaJavaSondaBE devem ser submetidos as alterações necessárias.

Caso os projetos ProvaJavaSondaFE e ProvaJavaSondaBE sejam publicados em servidores diferentes, os endpoints referenciados no index.jsp do projeto ProvaJavaSondaFE devem ser submetidos as alterações necessárias.


To do
-----------------
Algumas melhorias desejadas no projeto
- finalização do endpoint restante;
- finalização das consultas em tela;
- utilização de uma tabela (criada), relacionamentos e a respectiva API para gerenciar as marcas de aeronaves.

Lista de aplicativos utilizados
-----------------
- Eclipse IDE (https://www.eclipse.org/downloads/packages/release/2020-09/r/eclipse-ide-enterprise-java-developers)
- Postman (https://www.postman.com/product/rest-client/)
- MySQL (https://www.mysql.com/)
- MySQL Workbench (https://www.mysql.com/products/workbench/)
- Apache Tomcat 9 (https://tomcat.apache.org/download-90.cgi)
