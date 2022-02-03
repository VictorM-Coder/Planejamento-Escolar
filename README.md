# Planejamento Escolar
##  Descrição
O sistema tem como objetivo auxiliar no planejamento escolar. Realizando funções voltadas para o apoio à organização de atividades estudantis, matérias e cronogramas de estudo. Além disso, o sistema deve permitir o cadastro e a manipulação de suas atividades e matérias.

## Tecnologias Utilizadas
* [**Java**](https://www.java.com/pt-BR/) - *linguagem*
* [**Intellij IDEA**](https://www.jetbrains.com/pt-br/idea/) - *IDE utilizada*
* [**Code With Me**](https://www.jetbrains.com/pt-br/code-with-me/) - *Plugin do Intellij para pair programming*
* [**Visual Studio Code**](https://code.visualstudio.com/) - *Editor de código utlizado*
* [**Discord**](https://discord.com/) - *utilizado para reuniões*

## Funcionalidades
* Adição, remoção e atualização de atividades;
* Manipulação da fase de execução das atividades;
* Visualizar Kanban;
* Visualizar atividades;
* Adição, remoção e atualização das matérias;
* Visualização das matérias;
* Salvamento de dados ao final do uso.

## Requisitos
* Kit de desenvolvimento java (recomenda-se o 15).

## Rodar aplicação

## Como usar?
### Entrar comandos
As entradas de texto são case insensitive. Deste modo, desde que os comandos seja escritos corretamente o tipo de caixa é indiferente.
```
EXEMPLO == exemplo == ExEmPlO
````
### Tela inicial
A partir daqui, o usuário pode entrar três diferentes valores *grade*, *kanban* e *exit*. Caso contrário, uma mensagem avisando a entrada incorreta será mostrada e será soliticado uma nova entrada.
img

* **grade** - leva o usuário para menu de matérias;
* **activities** - leva o usuário para o menu de atividades;
* **exit** - salva os dados e finaliza o programa.

### Grade
É responsável por gerir as questões relativas às matérias.
* **add** - permite a criação de uma nova matéria por meio de um formulário que recebe entradas do usuário;
* **remove** - permite a escolha e remoção de uma matéria por meio de uma lista ordenada das matérias cadastras;
* **update** - permite a atualização de uma matéria já cadastrada;
* **show** - mostra todas as matérias cadastradas;
* **exit** - retorna ao menu inicial.

### Activities
É responsável por gerir questões relativas às atividades
* **add** - permite a criação de uma nova atividade por meio de um formulário que recebe entradas do usuário;
* **remove** - permite a escolha e remoção de uma atividade por meio de uma lista ordenada das atividades cadastras;
* **update** - permite a atualização de uma atividade já cadastrada;
* **kanban** - leva o usuário para o menu do kanban;
* **show** - mostra todas as atividades cadastradas;
* **exit** - retorna ao menu inicial.

### Kanban
É responsável por gerir o kanban. Aqui o usuário pode visualizar as atividades cadastradas e a sua fase de execução, além pode alterar essa fase.
