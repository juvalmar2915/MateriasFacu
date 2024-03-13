#ifndef DICCIONARIO_H_INCLUDED
#define DICCIONARIO_H_INCLUDED

struct nodo{
    char p[20];
    struct nodo * sig;
};
typedef struct nodo * diccionario;
diccionario Creardiccionario();
int Agregarpalabra(diccionario *,char []);
int Existepalabra(diccionario,char []);
int Eliminarpalabra(diccionario *,char []);
diccionario Cargardesdeunarchivo(FILE * ,diccionario );
FILE * Guardaraunarchivo(diccionario,FILE *);
void Destruireldiccionario(diccionario *);

#endif // DICCIONARIO_H_INCLUDED
