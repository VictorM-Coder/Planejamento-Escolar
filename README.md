# Planejamento Escolar
## :white_check_mark:Descrição
O sistema tem como objetivo auxiliar no planejamento escolar. Realizando funções voltadas para o apoio à organização de atividades estudantis, matérias e cronogramas de estudo. Além disso, o sistema deve permitir o cadastro e a manipulação de suas atividades e matérias.

## :white_check_mark:Tecnologias Utilizadas
* [**Java**](https://www.java.com/pt-BR/) - *linguagem*
* [**Intellij IDEA**](https://www.jetbrains.com/pt-br/idea/) - *IDE utilizada*
* [**Code With Me**](https://www.jetbrains.com/pt-br/code-with-me/) - *Plugin do Intellij para pair programming*
* [**Visual Studio Code**](https://code.visualstudio.com/) - *Editor de código utlizado*
* [**Discord**](https://discord.com/) - *utilizado para reuniões*

## :white_check_mark:Funcionalidades
* Adição, remoção e atualização de atividades;
* Manipulação da fase de execução das atividades;
* Visualizar Kanban;
* Visualizar atividades;
* Adição, remoção e atualização das matérias;
* Visualização das matérias;
* Salvamento de dados ao final do uso.

## :white_check_mark:UML
![schoolarPlanning-final-final](https://user-images.githubusercontent.com/84944695/152566037-afcfe393-20cf-4ac3-884b-aac33159302c.png)

## :white_check_mark:Requisitos
* Kit de desenvolvimento java (recomenda-se o 15).

## :white_check_mark:Rodar aplicação (windows)
1. Baixe este repositório
2. Separe o pasta [setup](https://github.com/VictorM-Coder/Planejamento-Escolar/tree/main/setup);
3. Abra o prompt de comando como administrador
4. Bigite *cd* e o endereço da pasta *setup* e dê enter
5. Digite o comando: *java -jar base.jar*

**EX.:** <br>
![Capturar](https://user-images.githubusercontent.com/84944695/152575136-9ef489ce-684e-4563-ae94-865994e81e53.PNG) <br>

Ao abrir pela primeira vez será exibida duas mensagens *no data saved*, isso ocorre pois ainda não há dados salvos. Logo após você fechar o programa serão criados dois novos arquivos na pasta *setup* onde serão armazenados os dados cadastrados NÃO OS APAGUE, ou perderá as informações que adicionou. <br>
![image](https://user-images.githubusercontent.com/84944695/152575766-4aba4333-5f13-47ec-8778-f16c1dd1ca95.png)

## :white_check_mark:Como usar
### Entrar comandos
As entradas de texto são case insensitive. Deste modo, desde que os comandos seja escritos corretamente o tipo de caixa é indiferente.
```
EXEMPLO == exemplo == ExEmPlO
````
### Tela inicial
A partir daqui, o usuário pode entrar três diferentes valores *grade*, *kanban* e *exit*. Caso contrário, uma mensagem avisando a entrada incorreta será mostrada e será soliticado uma nova entrada.
```
-----------------------------
| GRADE | ACTIVITIES | EXIT | 
-----------------------------
```
* **grade** - leva o usuário para menu de matérias;
* **activities** - leva o usuário para o menu de atividades;
* **exit** - salva os dados e finaliza o programa.

### Grade
É responsável por gerir as questões relativas às matérias.
```
---------------------------------------
| ADD | REMOVE | UPDATE | SHOW | EXIT |
---------------------------------------
```
* **add** - permite a criação de uma nova matéria por meio de um formulário que recebe entradas do usuário;
* **remove** - permite a escolha e remoção de uma matéria por meio de uma lista ordenada das matérias cadastras;
* **update** - permite a atualização de uma matéria já cadastrada;
* **show** - mostra todas as matérias cadastradas;
* **exit** - retorna ao menu inicial.

### Activities
É responsável por gerir questões relativas às atividades
```
------------------------------------------------
| ADD | REMOVE | UPDATE | SHOW | KANBAN | EXIT |
------------------------------------------------
```
* **add** - permite a criação de uma nova atividade por meio de um formulário que recebe entradas do usuário;
* **remove** - permite a escolha e remoção de uma atividade por meio de uma lista ordenada das atividades cadastras;
* **update** - permite a atualização de uma atividade já cadastrada;
* **kanban** - leva o usuário para o menu do kanban;
* **show** - mostra todas as atividades cadastradas;
* **exit** - retorna ao menu inicial.

### Kanban
É responsável por gerir o kanban. Aqui o usuário pode visualizar as atividades cadastradas e a sua fase de execução, além pode alterar essa fase.
```
--------------------
| DO | DONE | EXIT |
--------------------
```
* **do** - seleciona uma atividade e muda o estágio dela para *doing*
* **done** - seleciona uma atividade e muda o estágio dela para *done*
* **exit** - retorna para o menu de activities

## :white_check_mark:Casos de uso
### Adicionar matéria
```
-----------------------------
| GRADE | ACTIVITIES | EXIT | 
-----------------------------
grade
---------------------------------------
| ADD | REMOVE | UPDATE | SHOW | EXIT |
---------------------------------------
add
[SUBJECT FORM]
	Subject name: poo
	teacher: Atilio
	description: programacao orientada a objetos
```

### Remover matéria
```
---------------------------------------
| ADD | REMOVE | UPDATE | SHOW | EXIT |
---------------------------------------
remove
	Switch a subject:
	[0] - Discreta:PH
	[1] - poo:Atilio
	number: 0
Are you sure about that? (all activities of this subject will be deleted) [yes/no]: yes
```

### Atualizar matéria
```
---------------------------------------
| ADD | REMOVE | UPDATE | SHOW | EXIT |
---------------------------------------
update
	Switch a subject:
	[0] - poo:Atilio
	number: 0
[SUBJECT FORM]
	Subject name: POO
	teacher: Atilio
	description: programacao orientada a objetos
```

### Mostrar matérias
```
---------------------------------------
| ADD | REMOVE | UPDATE | SHOW | EXIT |
---------------------------------------
show
GRADE:
[Subject: POO]
 Teacher: Atilio
 Description: programacao orientada a objetos
```

### Adicionar atividade
```
-----------------------------
| GRADE | ACTIVITIES | EXIT | 
-----------------------------
activities
------------------------------------------------
| ADD | REMOVE | UPDATE | SHOW | KANBAN | EXIT |
------------------------------------------------
add
[ACTIVITY FORM]
	Activity name: trabalho final
	Description: produzir um sistema de planejamento escolar
	Start date[MM-dd-yyyy]: 01-10-2022
	DeadLine[MM-dd-yyyy]: 02-04-2022
	Switch a subject:
	[0] - POO:Atilio
	number: 0
is a group activity? [yes / enter anything for not]: yes
	participant name: Higor Santiago
continue?[no / enter anything to continue]: 
	participant name: Victor Martins
continue?[no / enter anything to continue]: no
```

### Remover atividade
```
------------------------------------------------
| ADD | REMOVE | UPDATE | SHOW | KANBAN | EXIT |
------------------------------------------------
remove
	Switch a activity:
	[0] - relatorio[TO_DO] | subject: POO | Days Remaining: -3
	[1] - ativ01[TO_DO] | subject: POO | Days Remaining: 1
	number: 0
```
### Atualizar Atividade
```
------------------------------------------------
| ADD | REMOVE | UPDATE | SHOW | KANBAN | EXIT |
------------------------------------------------
update
	Switch a activity:
	[0] - ativ01[TO_DO] | subject: POO | Days Remaining: 1
	number: 0
[ACTIVITY FORM]
	Activity name: trabalho final
	Description: produzir um sistema de planejamento escolar
	Start date[MM-dd-yyyy]: 01-10-2022
	DeadLine[MM-dd-yyyy]: 02-08-2022
	Switch a subject:
	[0] - POO:Atilio
	number: 0
is a group activity? [yes / enter anything for not]: yes
	name participant: Higor Santiago
continue?[no / enter anything to continue]: 
	name participant: Victor Martins
continue?[no / enter anything to continue]: no
```

### Mostrar atividades
```
------------------------------------------------
| ADD | REMOVE | UPDATE | SHOW | KANBAN | EXIT |
------------------------------------------------
show
Kanban(All Activies):
trabalho final[TO_DO]
```
### Fazer atividade
```
------------------------------------------------
| ADD | REMOVE | UPDATE | SHOW | KANBAN | EXIT |
------------------------------------------------
kanban
TO_DO
	[Activity: trabalho final | Phase: TO_DO | Time left: 1
	Start Date: 2022-01-10 | DeadLine: 2022-02-04
	Description: produzir um sistema de planejamento escolar|
	Participants: Higor Santiago, Victor Martins
DOING
DONE

--------------------
| DO | DONE | EXIT |
--------------------
do
	Switch a activity:
	[0] - trabalho final[TO_DO] | subject: POO | Days Remaining: 1
	number: 0
```

### Terminar Atividade
```
--------------------
| DO | DONE | EXIT |
--------------------
done
	Switch a activity:
	[0] - trabalho final[DOING] | subject: POO | Days Remaining: 1
	number: 0
```

## :white_check_mark:Autores
[**Victor Martins**](https://github.com/VictorM-Coder) & [**Higor Santiago**](https://github.com/HigorSantiago)
