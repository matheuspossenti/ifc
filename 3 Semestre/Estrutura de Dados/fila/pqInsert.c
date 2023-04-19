#include <stdio.h>
#include <stdlib.h>

typedef struct Elemento {
    struct Elemento* proximo;
    int dado;
} Elemento;

typedef struct Fila {
    struct Elemento* head;
    struct Elemento* tail;
} Fila;

Fila* criaFila();
Elemento* criaElemento(int);
Elemento* ultimoDaFila(Fila*);
Elemento* removeElemento(Fila*);
int removeMenor(Fila*);
void pqInsert(Fila*, int);
Elemento* pqMinRemove(Fila*);
void mostrarFila(Fila*);


int main(){
    Fila* fila = criaFila();
    pqInsert(fila, 25);
    pqInsert(fila, 15);
    pqInsert(fila, 40);
    pqInsert(fila, 80);

    mostrarFila(fila);
    printf("\n");

    removeMenor(fila);

    pqInsert(fila, 40);
    pqInsert(fila, 80);

    mostrarFila(fila);
    printf("\n");

    removeMenor(fila);

    pqInsert(fila, 10);
    pqInsert(fila, 5);

    mostrarFila(fila);
    printf("\n");

    return 0;
}

Elemento* criaElemento(int dado) {
    Elemento* elemento = (Elemento*) malloc(sizeof(Elemento));

    if (elemento == NULL) {
        printf("Nao foi possível alocar memoria para o elemento");
        return NULL;
    } else {
        elemento->proximo = NULL;
        elemento->dado = dado;
    }
    return elemento;
}

Fila* criaFila() {
    Fila* fila = (Fila*) malloc(sizeof(Fila));

    if (fila == NULL) {
        printf("Nao foi possível alocar memoria para a fila");
        return NULL;
    } else {
        fila->head = NULL;
        fila->tail = NULL;
    }
    return fila;
}

void pqInsert(Fila* fila, int dado) {
    Elemento* novo_elemento = criaElemento(dado);

    if (novo_elemento == NULL) {
        printf("Nao foi possível alocar memória");
        return;
    }

    novo_elemento->proximo = NULL;
    if (fila->head == NULL) {
        fila->head = novo_elemento;
    } else {
        fila->tail->proximo = novo_elemento;
    }
    fila->tail = novo_elemento;
}

Elemento* removeElemento(Fila* fila) {
    Elemento* aux = fila->head;
    Elemento* dado = NULL;
    if (aux != NULL) {
        fila->head = aux->proximo;
        aux->proximo = NULL;
        dado = aux;
    } else {
        printf("Lista Vazia");
        return NULL;
    }

    return dado;
}

Elemento* ultimoDaFila(Fila* fila) {
    return fila->tail;
}

int removeMenor(Fila* fila) {
    Elemento* excluiMenor = NULL;
    Elemento* menor = pqMinRemove(fila);
    Elemento* ultimo = ultimoDaFila(fila);
    Elemento* proximoFila = NULL;
    Elemento* aux = fila->head;

    do {
        proximoFila = removeElemento(fila);
        if (proximoFila == menor) {
            excluiMenor = menor;
        } else {
            pqInsert(fila, proximoFila->dado);
            free(proximoFila);
        }
    } while (fila->tail != ultimo);

    free(excluiMenor);

    return 0;
}

Elemento* pqMinRemove(Fila* fila) {
    Elemento* aux = fila->head;
    Elemento* menor = fila->head;

    while (aux != NULL) {
        if (aux->dado < menor->dado) {
            menor = aux;
        }
        aux = aux->proximo;
    }

    return menor;
}

void mostrarFila(Fila* fila){
    Elemento* aux = fila->head;

    while (aux != NULL) {
        printf("%i,", aux->dado);
        aux = aux->proximo;
    }
}
