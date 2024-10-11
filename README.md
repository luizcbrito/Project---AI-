# Project---AI-
Prova 1 - Implementação da cadeira (Inteligência artificial)

# Atividade: Implementação do Quebra-Cabeça de 8

## Objetivo

O objetivo desta atividade é implementar duas versões da função que gera os filhos para o quebra-cabeça de 8 e compará-las usando a busca em profundidade de aprofundamento iterativo (IDDFS). As versões a serem implementadas são:

1. **Versão que copia o estado do nó pai** antes de aplicar as modificações.
2. **Versão que modifica o estado pai diretamente**, desfazendo as modificações conforme necessário.

## Estrutura do Código

O código será dividido em quatro classes principais:

- **`PuzzleState`**: Representa o estado do tabuleiro e contém métodos para manipulação do estado (como mover peças e verificar se o estado é o objetivo).
- **`Node`**: Representa um nó na árvore de busca e possui métodos para gerar filhos usando as duas versões da função.
- **`IDDFS`**: Implementa a busca em profundidade de aprofundamento iterativo, utilizando as duas versões de geração de filhos.
- **`Main`**: Contém o ponto de entrada da aplicação, onde o estado inicial e o estado objetivo são definidos e onde as buscas IDDFS são executadas.

## Como Executar o Código

### Pré-requisitos

- Ambiente de desenvolvimento Java configurado (IDE como IntelliJ IDEA, Eclipse, ou compilador via linha de comando).

### Exemplo de Código

Um exemplo de estado inicial e objetivo pode ser:

```java
int[][] initialState = {
    {1, 2, 3},
    {4, 0, 5},
    {6, 7, 8}
};

int[][] goalState = {
    {1, 2, 3},
    {4, 5, 0},
    {6, 7, 8}
};

### Resultado esperado

Solução encontrada com cópia!
Tempo de execução com cópia: 2000000 ns
Número de nós gerados com cópia: 50

Solução encontrada com modificação direta!
Tempo de execução com modificação direta: 1500000 ns
Número de nós gerados com modificação direta: 30
