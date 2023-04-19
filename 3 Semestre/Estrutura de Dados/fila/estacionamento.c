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


Nodo *alocaMemoriaNodo();
Lista *alocaMemoriaLista();
Nodo *criaNodo(int);
Lista *criaLista();
int insereElementoNaLista(Lista *, Nodo *, int);
void percorreListaHeadTail(Lista *);
int removeElementoDaLista(Lista *, Nodo *);
Nodo *buscaElemento(Lista *, int);

void insereNaFila(Lista *, int);
int removeDaFila(Lista *);
int filaVazia(Lista *);
void mostraFila(Lista *);
int tamanhoFila(Lista *);
int primeiroFila(Lista *);


void insereEstacionamento(Lista *, Lista *, int);
void removeEstacionamento(Lista *, Lista *);
void reorganizarEstacionamento(Lista *, Lista *, int);

int main() {

  Lista *estacionamento;
  estacionamento = alocaMemoriaLista();

  Lista *espera;
  espera = alocaMemoriaLista();
  
    int esc;
    int plc;
    printf("Bem vindo ao estacionamento do Vero, digite qual operacao deseja fazer! \n");
    printf("1 = Inserir veiculo \n");
    printf("2 = Remover veiculo \n");
    printf("3 = Ver o estacionamento principal \n");
    printf("4 = Ver a fila de espera \n");
    printf("5 = Rotacionar o estacionamento \n");
    printf("0 = Sair \n");
    
    do{
        scanf("%d", &esc);
        
        switch(esc){
            case 1 : 
                printf("Informe a placa do veiculo \n");
                scanf("%d", &plc);
                insereEstacionamento(estacionamento, espera, plc);
                break;
            case 2 :
                removeEstacionamento(estacionamento, espera);
                printf("Veiculo removido!");
                break;
            case 3 :
                printf("Inicio: ");
                mostraFila(estacionamento);
                printf(" Fim!\n");
                break;
            case 4 :
                mostraFila(espera);
                break;
            case 5 :
                printf("Informe a placa do veiculo a ser removido \n");
                scanf("%d", &plc);
                reorganizarEstacionamento(estacionamento, espera, plc);
                break;
            default :
                if (esc > 5){
                    printf("Escolha uma opcao valida!");
                } else{
                    if (esc == 0){
                        printf("Encerrando...");
                    }
                }
        }
    } while(esc !=0);
 
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
  }

  if ((pivo == NULL) && (lista->size != 0)) {
    printf("só aceita pivo NULL na inserção do primeiro elemento\n");
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
    printf("%i == ", nodo->dado);
    nodo = nodo->next;
  }
}

int removeElementoDaLista(Lista *lista, Nodo *nodoRemover) {
  Nodo *antigo;
  int dado;
  if ((nodoRemover != NULL) && (lista->size != 0)) {
    if (nodoRemover == lista->head) {
      antigo = lista->head;
      lista->head = nodoRemover->next;
      if (lista->head == NULL) {
        antigo = lista->tail;
        lista->tail = NULL;
      } else {
        antigo = nodoRemover->next->prev;
        nodoRemover->next->prev = NULL;
      }
    } else {
      nodoRemover->prev->next = nodoRemover->next;
      if (nodoRemover->next == NULL) {
        antigo = lista->tail;
        lista->tail = nodoRemover->prev;
      } else {
        antigo = nodoRemover->next->prev;
        nodoRemover->next->prev = nodoRemover->prev;
      }
    }
    dado = antigo->dado;
    free(nodoRemover);
    lista->size--;
  }
  return dado;
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

void insereNaFila(Lista *lista, int placa) {
  insereElementoNaLista(lista, lista->tail, placa);
}

int removeDaFila(Lista *lista) {
  return removeElementoDaLista(lista, lista->head);
}

int filaVazia(Lista *lista) {
  if (lista->size == 0)
    return 0;
  else
    return 1;
}

int primeiroFila(Lista *lista) {
  Nodo *nodo = lista->head;
  int placa;
  placa = lista->head->dado;
  return placa;
}

void mostraFila(Lista *lista) { 
  percorreListaHeadTail(lista); 
}

int tamanhoFila(Lista *lista) { 
  return lista->size; 
}

void insereEstacionamento(Lista *estacionamento, Lista *espera, int placa) {
  if (estacionamento->size < 10) {
    insereNaFila(estacionamento, placa);
  } else {
    insereNaFila(espera, placa);
  }
}

void removeEstacionamento(Lista *estacionamento, Lista *espera) {
  int placa;
  if ((tamanhoFila(estacionamento) > 9) &&
      (filaVazia(espera) != 0)) {
    removeDaFila(estacionamento);
    placa = removeDaFila(espera);
    insereNaFila(estacionamento, placa);
  } else {
    removeDaFila(estacionamento);
  }
}

void reorganizarEstacionamento(Lista *estacionamento, Lista *espera, int placa) {
  int aux = primeiroFila(estacionamento);
  int auxB;
  int auxC = aux;
  
  if(placa == aux){
    removeEstacionamento(estacionamento, espera);
  } else{
    while(placa != auxC){
      auxB = removeDaFila(estacionamento);
      insereNaFila(estacionamento, auxB);
      auxC = primeiroFila(estacionamento);
    }
    removeDaFila(estacionamento);
    while(auxC != aux){
        auxB = removeDaFila(estacionamento);
        insereNaFila(estacionamento, auxB);
        auxC = primeiroFila(estacionamento);
    }
    auxB = removeDaFila(espera);
    insereNaFila(estacionamento, auxB);
  }
   
}

// void reorganizarEstacionamento(Lista *estacionamento, Lista *espera, int placa) {
//   int pos;
//   int currentPlate = primeiroFila(estacionamento);

//   // If the desired car is already at the front of the queue, remove it
//   if (placa == currentPlate) {
//     removeDaFila(estacionamento);
//   } else {
//     // Otherwise, find its position in the queue and move it to the front
//     pos = 0;
//     while (currentPlate != placa && pos < estacionamento->size) {
//       removeDaFila(estacionamento);
//       insereNaFila(estacionamento, currentPlate);
//       currentPlate = primeiroFila(estacionamento);
//       pos++;
//     }

//     // If the car was found and moved, move all other cars to maintain order
//     if (pos < estacionamento->size) {
//       removeDaFila(estacionamento);
//       insereNaFila(estacionamento, currentPlate);
//       while (estacionamento->size > 1) {
//         insereNaFila(estacionamento, removeDaFila(estacionamento));
//       }
//       if (!filaVazia(espera)) {
//         insereNaFila(estacionamento, removeDaFila(espera));
//       }
//     } else {
//       printf("Car with plate %d was not found.\n", placa);
//     }
//   }
// }