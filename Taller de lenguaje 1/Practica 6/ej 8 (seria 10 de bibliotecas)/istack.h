#ifndef ISTACK_H_INCLUDED
#define ISTACK_H_INCLUDED

struct pila{
    int num;
    struct pila *tope;
};
typedef struct pila * stack;
stack s_create ();
int s_push(stack *, int );
int s_pop (stack *);
int s_top (stack *);
int s_empty(stack *);
int s_length(stack *);

#endif // ISTACK_H_INCLUDED
