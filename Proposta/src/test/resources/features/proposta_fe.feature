#language: pt
Funcionalidade: Concluir os testes com exito

Realizar uma pesquisa, efetuar uma compra, logar com sucesso e fazer um login inválido


Contexto: 
Dado que estou acessando uma aplicação

Cenário: Deve realizar uma pesquisa
Quando Fazer uma pesquisa de "blouses"
Então Conclua a pesquisa com sucesso

Cenário: Deve realizar uma compra
Quando Selecionar o produto
Então Concluir a compra

Cenário: Logar na página
Quando entrar na minha conta
Então acesso minha conta

Cenário: Login inválido
Quando entrar na minha conta
Então apresenta erro de login inválido
