# Alocação de Salas de Aula

# Algoritimos

Os códigos estão na pasta Entrega_02.

Projeto desenvolvido para a disciplina de Técnicas de Análise de Algoritmos.

O objetivo do programa é determinar o número mínimo de salas necessárias para acomodar um conjunto de aulas, utilizando dois algoritmos clássicos de projeto de algoritmos:

- Backtracking
- Branch and Bound
- Estratégia Gulosa
- Programação Dinâmica

Esses algoritmos exploram diferentes possibilidades de alocação de salas, garantindo que aulas com horários conflitantes não sejam colocadas na mesma sala.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

src/

algorithms/
BacktrackingSolver.java
BranchBoundSolver.java
DynamicProgrammingSolver.java
GreedySolver.java

model/
Aula.java

util/
ConflitoUtil.java

app/
Main.java

---

## Como Executar

1. Baixe ou clone este repositório.
2. Abra o projeto em uma IDE Java (IntelliJ IDEA, Eclipse ou similar).
3. Localize a classe `Main.java` no pacote `app`.
4. Execute a classe **Main.java**.

---

## Entrada

A entrada segue o formato:

n  
inicio fim  

Onde:

- **n** = número de aulas
- **inicio** = horário de início da aula
- **fim** = horário de término da aula

Os horários são representados por números inteiros.

### Exemplo de execução

Entrada:
6  
9  10  
9  12  
11 13  
12 14  
13 15  
14 16  

---

## Saída

O programa retorna:

- o número mínimo de salas necessárias
- a alocação de cada aula em uma sala

### Exemplo de Saída

2  
1 1  
2 2  
3 1  
4 2  
5 1  
6 2  

Onde:

- o primeiro número representa o total de salas utilizadas
- cada linha seguinte mostra: **aula → sala atribuída**

---

## Autor

Filipe Antonny Tavares de Santana
Emanuel Diogo Marinho de Souza
Rafael Trajano do Nascimento 
Curso de Ciência da Computação  
Universidade Estadual da Paraíba
