#include <stdio.h>
#include <stdlib.h>

typedef struct sNodo{
    int dado;
    struct sNodo *esq;
    struct sNodo *dir;
} Nodo;

typedef struct{
    struct sNodo *raiz;
} ABB;

//Protótipo
Nodo* criaNodo(int);
Nodo* inserir(Nodo*, int);
ABB* criaABB();
void insereNaABB(ABB*, int);
void escreveABB(ABB*);
void liberaMemoriaABB(Nodo*);
void removeABB(ABB*);
void emOrdem(Nodo*);
Nodo* buscar(Nodo*, int);
Nodo* remover(Nodo*, int);


int main(){
    ABB *abb = criaABB();
    int opcao, dado;
    do{
        printf("\n1 - Inserir\n");
        printf("2 - Remover\n");
        printf("3 - Buscar\n");
        printf("4 - Escrever\n");
        printf("0 - Sair\n");
        scanf("%i", &opcao);
        switch(opcao){
            case 1:
                printf("Digite o valor a ser inserido: ");
                scanf("%i", &dado);
                insereNaABB(abb, dado);
                break;
            case 2:
                printf("Digite o valor a ser removido: ");
                scanf("%i", &dado);
                remover(abb->raiz, dado);
                break;
            case 3:
                printf("Digite o valor a ser buscado: ");
                scanf("%i", &dado);
                if (buscar(abb->raiz, dado) == NULL) {
                    printf("Valor não encontrado!\n");
                }
                break;
            case 4:
                escreveABB(abb);
                break;
            case 0:
                removeABB(abb);
                break;
            default:
                printf("Opção inválida!\n");
        }
    }while(opcao != 0);
    return 0;
}

void removeABB(ABB* abb){
    if (abb != NULL){
        liberaMemoriaABB(abb->raiz);
        free(abb);
    }
}

void liberaMemoriaABB(Nodo* nodo) {
    if (nodo != NULL) {
        liberaMemoriaABB(nodo->esq);
        liberaMemoriaABB(nodo->dir);
        free(nodo);
    }
}
void escreveABB(ABB *abb){
    printf("Valores na ABB:\n");
    if (abb != NULL && abb->raiz != NULL)
        emOrdem(abb->raiz);
    else
        printf("Arvore vazia!\n");
}

void insereNaABB(ABB *abb, int valor){
    if (abb != NULL)
        abb->raiz = inserir(abb->raiz, valor);
}

Nodo* criaNodo(int dado){
    Nodo* nodo;
    nodo = (Nodo*) malloc(sizeof(Nodo));
    if (nodo != NULL)
        nodo->dir = NULL;
        nodo->esq = NULL;
        nodo->dado = dado;
        
    return nodo;
}

ABB* criaABB(){
    ABB *abb;
    abb = (ABB*) malloc(sizeof(ABB));
    if (abb != NULL)
        abb->raiz = NULL;

    return abb;
}

Nodo* inserir(Nodo* nodo, int dado){
    if (nodo == NULL){
        return criaNodo(dado);
    }
    
    if (dado > nodo->dado){
        nodo->dir = inserir(nodo->dir, dado);
    }else {
        nodo->esq = inserir(nodo->esq, dado);
    }

    return nodo;
}

Nodo* remover(Nodo* nodo, int dado){
    if (nodo == NULL){
        return NULL;
    }
    
    if (dado > nodo->dado){
        nodo->dir = remover(nodo->dir, dado);
    }else if (dado < nodo->dado){
        nodo->esq = remover(nodo->esq, dado);
    }else {
        if (nodo->esq == NULL && nodo->dir == NULL){
            free(nodo);
            return NULL;
        }else if (nodo->esq == NULL){
            Nodo* aux = nodo->dir;
            free(nodo);
            return aux;
        }else if (nodo->dir == NULL){
            Nodo* aux = nodo->esq;
            free(nodo);
            return aux; 
        }else {
            Nodo* aux = nodo->esq;
            while (aux->dir != NULL){
                aux = aux->dir;
            }
            nodo->dado = aux->dado;
            aux->dado = dado;
            nodo->esq = remover(nodo->esq, dado);
        }
    }

    return nodo;
}

void emOrdem(Nodo* raiz) {
    if (raiz != NULL){
        emOrdem(raiz->esq);
        printf("%i, ", raiz->dado);
        emOrdem(raiz->dir);
    }
}

Nodo* buscar(Nodo *raiz, int dado){
    if(raiz == NULL){
        return NULL;
    }else{
        if(dado == raiz->dado){
            printf("Valor encontrado!\n");
            return raiz;
        }else{
            if(dado < raiz->dado){
                return buscar(raiz->esq, dado);
            }else{
                return buscar(raiz->dir, dado);
            }
        }
    }
}