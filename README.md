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

### 1.1. Clonando projeto ### 
 
Clone do projeto no github:

    git clone https://github.com/PedroJeunon/desafioContaAzul.git

### 1.2. Importando Projeto STS ###  

<img src="docs/ImportandoSTS.gif" />


### 1.3. Executando projeto STS ###

<img src="docs/ExecutandoSTS.gif" />


### 1.4. Rodando testes unitarios STS ### 

<img src="docs/TestesUnitariosTS.gif" />


## 2. Testes integrados Postman ##
O arquivo para realização dos testes estao dentro do projeto na pasta de [test](https://github.com/PedroJeunon/desafioContaAzul/blob/master/src/test/ContaAzul.postman_collection.json)

### 2.1. Importando Projeto Postman ###

<img src="docs/ImportandoPostman.gif" />

### 2.2. Executando Projeto Postman ###

<img src="docs/ExecutandoPostman.gif" />

## 3. Operações ##

### 3.1. Criar boleto ###

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

<strong>Mensagens Respostas</strong>:
- 201 : Bankslip created
- 400 : Bankslip not provided in the request body
- 422 : Invalid bankslip provided.The possible reasons are: A field of the provided bankslip was null or with invalid values

### 3.2. Listar boletos ###
- Metodo GET
- URL http://localhost:8080/rest/bankslips
- Saida JSON
<pre><code>
	[
		{
			"id":"84e8adbf-1a14-403b-ad73-d78ae19b59bf",
			"due_date":"2018-01-01",
			"total_in_cents":"100000",
			"customer":"Ford Prefect Company",
		},
		{
			"id":"c2dbd236-3fa5-4ccc-9c12-bd0ae1d6dd89",
			"due_date":"2018-02-01",
			"total_in_cents":"200000",
			"customer":"Zaphod Company",
		}
	]
</code></pre>

<strong>Mensagens Respostas</strong>:
- 200 : OK
- 204 : No Content


### 3.3. Ver detalhes ###
- Metodo GET
- URL http://localhost:8080/rest/bankslips/{id}
- Saida JSON
<pre><code>
	{
		 "id":"c2dbd236-3fa5-4ccc-9c12-bd0ae1d6dd89",
		 "due_date":"2018-01-01",
		 "total_in_cents":"100000",
		 "customer":"Ford Prefect Company",
		 "fine":"1000",
		 "status":"PENDING"
	}
</code></pre>

<strong>Mensagens Respostas</strong>:
- 200 : Ok
- 400 : Invalid id provided - it must be a valid UUID
- 404 : Bankslip not found with the specified id


### 3.4. Pagar um boleto ###
- Metodo PUT
- URL http://localhost:8080/rest/bankslips/{id}/pay
- Saida JSON
<pre><code>
	{
		"id":"c2dbd236-3fa5-4ccc-9c12-bd0ae1d6dd89",
		"status":"PAID"
	}
</code></pre>

<strong>Mensagens Respostas</strong>:
- 200 : Bankslip paid
- 403 : Bankslip not modified.The status is the same or ID of link does not corresponding the ID of body or Status was invalid
- 404 : Bankslip not found with the specified id

### 3.5. Cancelar um boleto ###

- Metodo DELETE
- URL http://localhost:8080/rest/bankslips/{id}/cancel
- Saida JSON
<pre><code>
	{
		"id":"c2dbd236-3fa5-4ccc-9c12-bd0ae1d6dd89",
		"status":"CANCELLED"
	}
</code></pre>

<strong>Mensagens Respostas</strong>:
- 200 : Bankslip cancelled
- 403 : Bankslip not modified.The status is the same or ID of link does not corresponding the ID of body or Status was invalid
- 404 : Bankslip not found with the specified id

## 4. Acompanhamento do Projeto ##

O projeto foi planejado e executado utilizando a ferramenta do trello. O [quadro](https://trello.com/b/MawSr9TJ/desafio-conta-azul) está disponivel para visualização.



