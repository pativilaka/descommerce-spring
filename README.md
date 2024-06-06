# Sistema de Gestão de Usuários e Produtos

Este projeto é um sistema completo para cadastro de usuários, produtos e categorias. Ele permite a navegação por um catálogo de produtos, adição de itens a um carrinho de compras e finalização de pedidos. O sistema diferencia entre usuários clientes e administradores, fornecendo funcionalidades específicas para cada tipo de usuário.

Este sistema foi criado no curso Java Spring Professional e faz parte da avaliação para conclusão do curso.

![](https://github.com/pativilaka/descommerce-spring/blob/main/img/modelo-conceitual.png)

## Funcionalidades Principais

#### Cadastro de Usuários

- **Clientes e Administradores**: Todo usuário cadastrado é, por padrão, um cliente. Apenas administradores podem acessar a área administrativa.

- **Funcionalidades do Cliente**: Atualizar cadastro, registrar pedidos e visualizar seus próprios pedidos.

- **Funcionalidades do Administrador**: Gerenciar cadastros de usuários, produtos e categorias.

  

#### Cadastro de Produtos e Categorias

- **Dados do Produto**: Nome, descrição, preço e imagem.

- **Categorias**: Produtos classificados em categorias para melhor organização e filtragem.

  

#### Catálogo de Produtos

- **Navegação**: Usuários podem navegar no catálogo de produtos.

- **Filtragem**: Produtos podem ser filtrados pelo nome e id.

  

#### Carrinho de Compras

- **Adicionar/Remover Itens**: Usuários podem adicionar ou remover produtos do carrinho.

- **Visualização do Carrinho**: Usuários podem visualizar os itens adicionados ao carrinho.

  

#### Registro de Pedidos

- **Finalizar Pedido**: Usuários podem finalizar o pedido, que será salvo com o status "aguardando pagamento".

- **Dados do Pedido**: Instante em que foi salvo, status, e lista de itens com produtos e quantidades.

- **Status do Pedido**: Pode ser "aguardando pagamento", "pago", "enviado", "entregue" e "cancelado".

- **Pagamento**: Instante do pagamento é registrado quando o usuário paga por um pedido.

  

## Requisitos do Sistema

#### Usuários Não Identificados

- Podem se cadastrar no sistema.
- Podem navegar no catálogo de produtos e no carrinho de compras.

#### Clientes

- Podem atualizar seu cadastro no sistema.
- Podem registrar pedidos e visualizar seus próprios pedidos.

#### Administradores

- Acesso à área administrativa.
- Gerenciar cadastros de usuários, produtos e categorias.



## Contato

[Linkedin ](https://www.linkedin.com/in/pativilaka/)