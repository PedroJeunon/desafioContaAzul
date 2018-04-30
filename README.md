# Desafio #
O objetivo do desafio é construir uma API REST para geração de boletos que será
consumido por um módulo de um sistema de gestão financeira de microempresas.
No final do desafio vamos ter os seguintes endpoints para:
- Criar boleto
- Listar boletos
- Ver detalhes
- Pagar um boleto
- Cancelar um boleto

* Algumas descrições estão em .gif para visualizar melhor a forma de utilização.

## Ferramentas Utilizadas ##
 - Java 8
 - Banco de dados H2
 - Maven
 - Spring boot
 - Junit
 - Postman

## 1. Criando Projeto ##

#### 1.1. Clonando projeto #### 
 
Clone do projeto no github:

    git clone https://github.com/PedroJeunon/desafioContaAzul.git

#### 1.2. Importando Projeto STS ####  

<img src="docs/ImportandoSTS.gif" />


#### 1.3. Executando projeto STS ####

<img src="docs/ExecutandoSTS.gif" />


#### 1.4. Rodando testes unitarios STS #### 

<img src="docs/TestesUnitariosTS.gif" />


## 2. Testes automatizados Postman ##
O arquivo para realização dos testes estao dentro do projeto na pasta de [test](https://github.com/PedroJeunon/desafioContaAzul/blob/master/src/test/ContaAzul.postman_collection.json)

#### 2.1. Importando Projeto Postman ####

<img src="docs/ImportandoPostman.gif" />

#### 2.2. Executando Projeto Postman ####

<img src="docs/ExecutandoPostman.gif" />

## 3. Operações ##

#### 3.1. Criar boleto ####

- Metodo POST
- URL http://localhost:8080/rest/bankslips
- Entrada JSON
<pre><code>
	{
		"due_date":"2018-01-01",
		"total_in_cents":"100000",
		"customer":"Trillian Company",
		"status":"PENDING"
	}
</code></pre>

**Mensagens Respostas
- 201 : Bankslip created
- 400 : Bankslip not provided in the request body
- 422 : Invalid bankslip provided.The possible reasons are: A field of the provided bankslip was null or with invalid values

#### 3.2. Listar boletos ####

#### 3.3. Ver detalhes ####

#### 3.4. Pagar um boleto ####

#### 3.5. Cancelar um boleto ####

## 4. Acompanhamento do Projeto ##

O projeto foi planejado e executado utilizando a ferramenta do trello. O [quadro](https://trello.com/b/MawSr9TJ/desafio-conta-azul) está disponivel para visualização.



