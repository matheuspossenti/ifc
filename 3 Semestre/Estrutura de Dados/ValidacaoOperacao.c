#include <stdio.h>
#include <stdlib.h>

typedef struct Elemento {
    struct Elemento *proximo;
    struct Elemento *previous;
    char dado;
} Elemento;

typedef struct Pilha {
    struct Elemento *tail;
    struct Elemento *head;
    int size;

} Pilha;

Pilha *criaPilha();
Elemento *criaElemento(char);
void push(Pilha *, char);
int pop(Pilha *);
void imprimirPilha(Pilha *);
void liberaMemoriaPilha(Pilha *);
char escreverOperacao(Pilha *);
int validarEscopos(Pilha *, Pilha *);
void validaOperacao(Pilha *, Pilha *);

int main() {
    Pilha *pilha = criaPilha();
    Pilha *pilhaEscopos = criaPilha();

    escreverOperacao(pilha);

    validaOperacao(pilha, pilhaEscopos);
    printf("\n");
}

Elemento *criaElemento(char dado) {
    Elemento *novo = (Elemento *) malloc(sizeof(Elemento));
    novo->proximo = NULL;
    novo->previous = NULL;
    novo->dado = dado;
    return novo;
}

Pilha *criaPilha() {
    Pilha *pilha = (Pilha *) malloc(sizeof(Pilha));
    pilha->head = NULL;
    pilha->tail = NULL;
    pilha->size = 0;

    return pilha;
}

void push(Pilha *pilha, char dado) {
    Elemento *novo = criaElemento(dado);
    if (pilha->size == 0) {
        pilha->head = novo;
        pilha->tail = novo;
    } else {
        novo->proximo = NULL;
        novo->previous = pilha->tail;
        pilha->tail->proximo = novo;
        pilha->tail = novo;
    }
    pilha->size++;
}

int pop(Pilha *pilha) {
    Elemento *removendo = pilha->tail;
    if (removendo == pilha->head && pilha->size > 0) {
        pilha->head = removendo->proximo;
        pilha->tail = NULL;
    } else if (pilha->size > 0) {
        removendo->previous->proximo = NULL;
        pilha->tail = removendo->previous;
    } else {
        printf("Erro na remoção \n");
        return ' ';
    }
    char retorno = removendo->dado;
    free(removendo);
    pilha->size--;
    return retorno;
}

void imprimirPilha(Pilha *pilha) {
    Elemento *aux = pilha->head;
    if (pilha->size == 0) {
        printf("Lista Vazia");
    }

    while (aux != NULL) {
        char palavra = aux->dado;
        printf("%c", palavra);
        aux = aux->proximo;
    }
}

void compararCaracter(Pilha *pilhaOperacao, Pilha *pilhaEscopo) {
    Elemento *auxOperacao = pilhaOperacao->head;
    char caracterOper;
    while (auxOperacao != NULL) {
        caracterOper = auxOperacao->dado;
        if (caracterOper == ')') {
            push(pilhaEscopo, caracterOper);
        } else if (caracterOper == '(') {
            push(pilhaEscopo, caracterOper);
        } else if (caracterOper == '[') {
            push(pilhaEscopo, caracterOper);
        } else if (caracterOper == ']') {
            push(pilhaEscopo, caracterOper);
        } else if (caracterOper == '{') {
            push(pilhaEscopo, caracterOper);
        } else if (caracterOper == '}') {
            push(pilhaEscopo, caracterOper);
        }

        auxOperacao = auxOperacao->proximo;
    }
}

void liberaMemoriaPilha(Pilha *pilha) {
    Elemento *aux = pilha->tail;

    while (aux != NULL) {
        free(aux);
        aux = aux->proximo;
    }
}

Elemento *primeiroDaFila(Pilha *pilha) {

    return pilha->head;
}

char escreverOperacao(Pilha *pilha) {
    char operacao[30];

    printf("Digite a operacao: ");
    scanf("%s", operacao);
    int i = 0;
    while (operacao[i] != '\0') {
        push(pilha, operacao[i]);
        i++;
    }
}

int validarEscopos(Pilha *pilha, Pilha *escopos) {
    int par = 0, chav = 0, colch = 0;
    while (pilha->size > 0) {
        char aux = pop(pilha);
        switch (aux) {
            case ')':
                push(escopos, aux);
                par++;
                break;

            case '(':
                if (par > 0) {
                    push(escopos, aux);
                    par--;
                } else {
                    return 0;
                }
                break;

            case '}':
                if (par == 0 && colch == 0) {
                    push(escopos, aux);
                    chav++;
                } else {
                    return 0;
                }
                break;

            case '{':
                if (chav > 0) {
                    push(escopos, aux);
                    chav--;
                } else {
                    return 0;
                }
                break;

            case ']':
                if (par == 0) {
                    push(escopos, aux);
                    colch++;
                } else {
                    return 0;
                }
                break;

            case '[':
                if (colch > 0) {
                    push(escopos, aux);
                    colch--;
                } else {
                    return 0;
                }
                break;
        }
    }
    return 1;
}

void validaOperacao(Pilha *pilha, Pilha *escopos) {
    int v = validarEscopos(pilha, escopos);
    if (v == 1) {
        printf("Operacao Valida");
    } else {
        printf("Operacao Invalida");
    }
}
