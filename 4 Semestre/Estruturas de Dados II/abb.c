#include <stdio.h>
#include <stdlib.h>

//Structs
typedef struct sNodo{
    int dado;
    struct sNodo *esq;
    struct sNodo *dir;
} Nodo;

typedef struct sArvore{
    Nodo *raiz;
} ABB;

//Prototipação
ABB* criaABB();
Nodo* criaNodo(int);
Nodo* inserir(int, Nodo*);
Nodo* buscar(int, Nodo*);
Nodo* remover(int, Nodo*);
void destroiABB(Nodo*);
void emOrdem(Nodo*);
void preOrdem(Nodo*);
void posOrdem(Nodo*);

//Funções
ABB* criaABB(){
    ABB *arvore = (ABB*) malloc(sizeof(ABB));
    if (arvore != NULL)
        arvore->raiz = NULL;
    return arvore;
}

Nodo* criaNodo(int dado){
    Nodo *nodo = (Nodo*) malloc(sizeof(Nodo));
    if (nodo != NULL){
        nodo->dado = dado;
        nodo->esq = NULL;
        nodo->dir = NULL;
    }
    return nodo;
}

Nodo* inserir(int dado, Nodo *raiz){
    if(raiz == NULL){
        return criaNodo(dado);
    }else{
        if(dado < raiz->dado){
            raiz->esq = inserir(dado, raiz->esq);
        }else{
            raiz->dir = inserir(dado, raiz->dir);
        }
    }
    return raiz;
}

Nodo* buscar(int dado, Nodo *raiz){
    if(raiz == NULL){
        return NULL;
    }else{
        if(dado == raiz->dado){
            return raiz;
        }else{
            if(dado < raiz->dado){
                return buscar(dado, raiz->esq);
            }else{
                return buscar(dado, raiz->dir);
            }
        }
    }
}

Nodo* remover(int dado, Nodo *raiz){
    if(raiz == NULL){
        return NULL;
    }else{
        if(dado == raiz->dado){
            if(raiz->esq == NULL && raiz->dir == NULL){
                free(raiz);
                return NULL;
            }else{
                if(raiz->esq == NULL){
                    Nodo *aux = raiz->dir;
                    free(raiz);
                    return aux;
                }else{
                    if(raiz->dir == NULL){
                        Nodo *aux = raiz->esq;
                        free(raiz);
                        return aux;
                    }else{
                        Nodo *aux = raiz->esq;
                        while(aux->dir != NULL){
                            aux = aux->dir;
                        }
                        raiz->dado = aux->dado;
                        aux->dado = dado;
                        raiz->esq = remover(dado, raiz->esq);
                    }
                }
            }
        }else{
            if(dado < raiz->dado){
                raiz->esq = remover(dado, raiz->esq);
            }else{
                raiz->dir = remover(dado, raiz->dir);
            }
        }
    }
    return raiz;
}

void destroiABB(Nodo *raiz){
    if(raiz != NULL){
        destroiABB(raiz->esq);
        destroiABB(raiz->dir);
        free(raiz);
    }
}

void emOrdem(Nodo *raiz){
    if(raiz != NULL){
        emOrdem(raiz->esq);
        printf("%d ", raiz->dado);
        emOrdem(raiz->dir);
    }else{
        printf("Arvore vazia!\n");
    }
}

void preOrdem(Nodo *raiz){
    if(raiz != NULL){
        printf("%d ", raiz->dado);
        preOrdem(raiz->esq);
        preOrdem(raiz->dir);
    }else{
        printf("Arvore vazia!\n");
    }
}

void posOrdem(Nodo *raiz){
    if(raiz != NULL){
        posOrdem(raiz->esq);
        posOrdem(raiz->dir);
        printf("%d ", raiz->dado);
    }else{
        printf("Arvore vazia!\n");
    }
}

//Main
int main(){
    ABB *arvore = criaABB();
    int opcao, dado;
    do{
        printf("\n1 - Inserir\n2 - Buscar\n3 - Remover\n4 - Destruir\n5 - Imprimir\n0 - Sair\n");
        printf("Digite a opcao desejada: ");
        scanf("%d", &opcao);
        switch(opcao){
            case 1:
                printf("Digite o dado a ser inserido: ");
                scanf("%d", &dado);
                arvore->raiz = inserir(dado, arvore->raiz);
                break;
            case 2:
                printf("Digite o dado a ser buscado: ");
                scanf("%d", &dado);
                if(buscar(dado, arvore->raiz) != NULL){
                    printf("Dado encontrado!\n");
                }else{
                    printf("Dado nao encontrado!\n");
                }
                break;
            case 3:
                printf("Digite o dado a ser removido: ");
                scanf("%d", &dado);
                arvore->raiz = remover(dado, arvore->raiz);
                break;
            case 4:
                destroiABB(arvore->raiz);
                arvore->raiz = NULL;
                break;
            case 5:
                printf("\n1 - Em ordem\n2 - Pre ordem\n3 - Pos ordem\n");
                printf("Digite a opcao desejada: ");
                scanf("%d", &opcao);
                switch(opcao){
                    case 1:
                        emOrdem(arvore->raiz);
                        break;
                    case 2:
                        preOrdem(arvore->raiz);
                        break;
                    case 3:
                        posOrdem(arvore->raiz);
                        break;
                    default:
                        printf("Opcao invalida!\n");
                        break;
                }
                break;
            case 0:
                destroiABB(arvore->raiz);
                free(arvore);
                break;
            default:
                printf("Opcao invalida!\n");
                break;
        }
    }while(opcao != 0);
    return 0;
}
