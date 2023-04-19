#include <stdio.h>
#include <stdlib.h>

typedef struct sNodo {
  int dado;
  struct sNodo *next;
  struct sNodo *prev;
} Nodo;

typedef struct sLista {
  struct sNodo *head;
  struct sNodo *tail;
  int size;
} Lista;

// Prototipação
Nodo *alocaMemoriaNodo();
Lista *alocaMemoriaLista();
Nodo *criaNodo(int);
Lista *criaLista();
int insereElementoNaLista(Lista *, Nodo *, int);
void percorreListaHeadTail(Lista *);
int removeElementoDaLista(Lista *, Nodo *);
Nodo *buscaElemento(Lista *, int);

// Implementação
int main() {

  Nodo *aux;
  Lista *lista;
  lista = alocaMemoriaLista();
  insereElementoNaLista(lista, NULL, 27);
  insereElementoNaLista(lista, lista->tail, 1);
  insereElementoNaLista(lista, lista->tail, 2);
  insereElementoNaLista(lista, lista->tail, 3);

  percorreListaHeadTail(lista);

  aux = buscaElemento(lista, 27);
  if (aux != NULL) {
    aux->dado=50;
  }
  percorreListaHeadTail(lista);
  
  aux = buscaElemento(lista, 3);
  if (aux != NULL) {
    removeElementoDaLista(lista, aux);
  }

  percorreListaHeadTail(lista);
  return 0;
}

Nodo *alocaMemoriaNodo() { return (Nodo *)malloc(sizeof(Nodo)); }

Lista *alocaMemoriaLista() { return (Lista *)malloc(sizeof(Lista)); }

Nodo *criaNodo(int dado) {
  Nodo *nodo = alocaMemoriaNodo();
  if (nodo != NULL) {
    nodo->dado = dado;
    nodo->next = NULL;
  }
  return nodo;
}

Lista *criaLista() {
  Lista *lista = alocaMemoriaLista();
  if (lista != NULL) {
    lista->head = NULL;
    lista->tail = NULL;
    lista->size = 0;
  }
  return lista;
}

int insereElementoNaLista(Lista *lista, Nodo *pivo, int dado) {
  Nodo *novo = criaNodo(dado);
  if (novo == NULL) {
    return -1; // n possivel alocar memoria
  }

  if ((pivo == NULL) && (lista->size != 0)) {
    printf("O pivô precisa ser Nulo na primeira posição\n");
  }

  if (lista->size == 0) {
    lista->head = novo;
    lista->tail = novo;
  } else {
    novo->next = pivo->next;
    novo->prev = pivo;
    if (pivo->next == NULL) {
      lista->tail = novo;
    } else {
      pivo->next->prev = novo;
    }
    pivo->next = novo;
  }

  lista->size++;
  return lista->size;
}

void percorreListaHeadTail(Lista *lista) {
  Nodo *nodo = lista->head;

  if (nodo == NULL)
    printf("Lista Vazia!\n");
  while (nodo != NULL) {
    printf("%i, ", nodo->dado);
    nodo = nodo->next;
  }
  printf("Fim da lista!\n");
}

int removeElementoDaLista(Lista *lista, Nodo *nodoRemover) {
  if ((nodoRemover != NULL) && (lista->size != 0)) {
    if (nodoRemover == lista->head) {
      lista->head = nodoRemover->next;
      if (lista->head == NULL) {
        lista->tail = NULL;
      } else {
        nodoRemover->next->prev = NULL;
      }
    } else {
      nodoRemover->prev->next = nodoRemover->next;
      if (nodoRemover->next == NULL) {
        lista->tail = nodoRemover->prev;
      } else {
        nodoRemover->next->prev = nodoRemover->prev;
      }
    }
    free(nodoRemover);
    lista->size--;
  }
  return 0;
}

Nodo *buscaElemento(Lista *lista, int n) {
  Nodo *nodo = lista->head;

  if (nodo == NULL)
    return NULL;
  while (nodo != NULL) {
    if (nodo->dado == n) {
      return nodo;
    }

    nodo = nodo->next;
  }
  return NULL;
}