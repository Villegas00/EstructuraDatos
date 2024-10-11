/*A01329696 Rodrigo Emmanuel Oliveros Vazquez*/
/*a01625055 Sergio Ivan Villegas Arenas*/

#include <stdio.h>
#include <stdlib.h>

struct nodo{
	struct nodo * izquierda;
	int data;
	struct nodo * derecha;
};

struct nodo* nuevoNodo(int n) 
{ 
    struct nodo * temporal = (struct nodo *) malloc(sizeof(struct nodo)); 
    temporal->data  = n; 
    temporal->izquierda  = NULL; 
    temporal->derecha = NULL; 
    return(temporal); 
} 

struct nodo * RotacionSimpleDerecha(struct nodo * c){
	struct nodo * auxiliar = c -> derecha;
	c -> derecha = auxiliar -> izquierda;
	auxiliar -> izquierda = c;
	return auxiliar;
}

struct nodo * RotacionSimpleIzquierda(struct nodo * c){
	struct nodo * auxiliar = c -> izquierda;
	c -> izquierda = auxiliar -> derecha;
	auxiliar -> derecha = c;
	return auxiliar;
}

int max(int a, int b){
	if(a>b)
		return a;
	else
		return b;
}

int Altura (struct nodo * r){
    if (r==NULL){
    	return 0;  
    }
    else
    	return (1 + max(Altura(r-> izquierda),Altura(r-> derecha)));
}


struct nodo *  Avl (struct nodo * r ){
	if(r){ 
		Avl(r-> izquierda);
		Avl(r-> derecha);
		int izq = Altura(r->izquierda);
		int der = Altura(r->derecha);
		printf("r %d altIzq %d altder %d\n", r-> data, izq, der );
		if ((izq-der)>1 || (izq-der)<-1){
			printf("No es Avl\n");
			if((izq-der) > 1 && r-> data < r-> izquierda -> data){
				printf("RSP\n");
				return RotacionSimpleDerecha(r);
			} 
			if((izq-der) < -1 && r-> data > r-> derecha -> data) {
				printf("RSI\n");
				return RotacionSimpleIzquierda(r);
			}
			if((izq-der) > 1 && r-> data > r-> izquierda -> data){
				printf("RDD\n");
				r->izquierda = RotacionSimpleIzquierda(r->izquierda);  
				return RotacionSimpleDerecha(r);
			}
			if((izq-der) < -1 && r-> data < r-> derecha -> data) {
				printf("RDI\n");
				r->derecha = RotacionSimpleDerecha(r->derecha);
				return RotacionSimpleIzquierda(r);
			}		 
		}
		else{
		printf("Es Avl\n");
		return r;
		}	
	}
	return r;
}

struct nodo * insertar(struct nodo * ptr, int n){
	if(ptr == NULL)
		return(nuevoNodo(n));
	if (n < ptr->data) 
        ptr->izquierda = insertar(ptr->izquierda, n); 
    else if (n > ptr->data) 
        ptr->derecha = insertar(ptr->derecha, n); 
    else{
    	printf("Valor repetido \n");
        return ptr; 
    }
    
    ptr=Avl(ptr);
    return ptr;
}


void imprimirArbolPreorden (struct nodo * r){
    if (r){
        printf ("%d, ", r -> data);
        imprimirArbolPreorden (r -> izquierda);
        imprimirArbolPreorden (r -> derecha);
    }
    
}

void imprimirArbolInorden (struct nodo * r){
    if (r){
        imprimirArbolInorden (r -> izquierda);
        printf ("%d, ", r -> data);
        imprimirArbolInorden (r -> derecha);
    }
}

void imprimirArbolPostorden (struct nodo * r){
    if (r){
        imprimirArbolPostorden (r -> izquierda);
        imprimirArbolPostorden (r -> derecha);
        printf ("%d, ", r -> data);
    }
}

void imprimirNiveles (struct nodo * r, int n){
	if(r){
		if(n == 0){
			printf("%d, ", r -> data);
		}
		imprimirNiveles(r -> izquierda, n-1);
		imprimirNiveles(r -> derecha, n-1);
	}
}

void imprimirArbolNiveles (struct nodo * r, int n){
	for (int i=0; i<=n; i++)
	{
		imprimirNiveles(r,i);
	}
	printf("\n");
}

void imprimirArbolPreordenConvexo (struct nodo * r){
    if (r){
        printf ("%d, ", r -> data);
        imprimirArbolPreordenConvexo (r -> derecha);
        imprimirArbolPreordenConvexo (r -> izquierda);
    }
    
}

void imprimirArbolInordenConvexo (struct nodo * r){
    if (r){
    	imprimirArbolInordenConvexo (r -> derecha);
        printf ("%d, ", r -> data);
        imprimirArbolInordenConvexo (r -> izquierda);
    }
}

void imprimirArbolPostordenConvexo (struct nodo * r){
    if (r){
    	imprimirArbolPostordenConvexo (r -> derecha);
        imprimirArbolPostordenConvexo (r -> izquierda);
        printf ("%d, ", r -> data);
    }
}

int main(){
	
	int numero;
	int numDatos;
	printf("Inserta el numero de datos que vas a meter al arbol -> ");
	scanf("%d", &numDatos);

	struct nodo * raiz;
	raiz = NULL;

	for (int i = 1; i <= numDatos; i++){
		printf("Inserta el numero %d-> ", i);
		scanf("%d", &numero);
		raiz = insertar(raiz, numero);
		printf("\n");
	}

	
	printf("\n");
	printf("Preorden ");
	imprimirArbolPreorden(raiz);
	printf("\n");
	printf("Inorden ");
	imprimirArbolInorden(raiz);
	printf("\n");
	printf("Postorden ");
	imprimirArbolPostorden(raiz);
	printf("\n");
	printf("Por nivel ");
	imprimirArbolNiveles(raiz, numDatos);
	printf("Preorden Convexo ");
	imprimirArbolPreordenConvexo(raiz);
	printf("\n");
	printf("Inorden Convexo ");
	imprimirArbolInordenConvexo(raiz);
	printf("\n");
	printf("Postorden Convexo ");
	imprimirArbolPostordenConvexo(raiz);
	return 0;
}
