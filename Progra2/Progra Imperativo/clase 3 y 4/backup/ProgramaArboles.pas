Program arboles;
Type

  // Lista de enteros
  lista = ^nodoL;
  nodoL = record
    dato: integer;
    sig: lista;
  end;

  // Arbol de enteros
  arbol= ^nodoA;
  nodoA = Record
    dato: integer;
    HI: arbol;
    HD: arbol;
  End;

  // Lista de Arboles
  listaNivel = ^nodoN;
  nodoN = record
    info: arbol;
    sig: listaNivel;
  end;


{-----------------------------------------------------------------------------
AgregarAdelante - Agrega nro adelante de l}
procedure agregarAdelante(var l: Lista; nro: integer);
var
  aux: lista;
begin
  new(aux);
  aux^.dato := nro;
  aux^.sig := l;
  l:= aux;
end;



{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con números aleatorios }
procedure crearLista(var l: Lista);
var
  n: integer;
begin
 l:= nil;
 n := random (20);
 While (n <> 0) do Begin
   agregarAdelante(L, n);
   n := random (20);
 End;
end;


{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: Lista);
begin
 While (l <> nil) do begin
   write(l^.dato, ' - ');
   l:= l^.sig;
 End;
end;

{-----------------------------------------------------------------------------
CONTARELEMENTOS - Devuelve la cantidad de elementos de una lista l }

function ContarElementos (l: listaNivel): integer;
  var c: integer;
begin
 c:= 0;
 While (l <> nil) do begin
   c:= c+1;
   l:= l^.sig;
 End;
 contarElementos := c;
end;


{-----------------------------------------------------------------------------
AGREGARATRAS - Agrega un elemento atrás en l}

Procedure AgregarAtras (var l, ult: listaNivel; a:arbol);
 var nue:listaNivel;

 begin
 new (nue);
 nue^.info := a;
 nue^.sig := nil;
 if l= nil then l:= nue
           else ult^.sig:= nue;
 ult:= nue;
 end;


{-----------------------------------------------------------------------------
IMPRIMIRPORNIVEL - Muestra los datos del árbol a por niveles }

Procedure imprimirpornivel(a: arbol);
var
   l, aux, ult: listaNivel;
   nivel, cant, i: integer;
begin
   l:= nil;
   if(a <> nil)then begin
                 nivel:= 0;
                 agregarAtras (l,ult,a);
                 while (l<> nil) do begin
                    nivel := nivel + 1;
                    cant:= contarElementos(l);
                    write ('Nivel ', nivel, ': ');
                    for i:= 1 to cant do begin
                      write (l^.info^.dato, ' - ');
                      if (l^.info^.HI <> nil) then agregarAtras (l,ult,l^.info^.HI);
                      if (l^.info^.HD <> nil) then agregarAtras (l,ult,l^.info^.HD);
                      aux:= l;
                      l:= l^.sig;
                      dispose (aux);
                     end;
                     writeln;
                 end;
               end;
end;

Procedure insertar (var A:arbol; i:integer);
begin
    if a=nil then begin
       new (a);
       a^.dato:=i;
       a^.hd:=nil;
       a^.hi:=nil;
    end
    else
     if (i>a^.dato) then
        insertar(a^.hd,i)
     else
        insertar(a^.hi,i);
end;

Procedure enOrden( a: arbol );
begin
  if ( a <> nil ) then begin
    enOrden (a^.HI);
    write (a^.dato,' ');
    enOrden (a^.HD)
  end;
end;

Procedure preOrden( a: arbol );
begin
  if ( a <> nil ) then begin
    write (a^.dato,' ');
    preOrden (a^.HI);
    preOrden (a^.HD)
  end;
end;

Procedure postOrden( a: arbol );
begin
  if ( a <> nil ) then begin
    postOrden (a^.HI);
    postOrden (a^.HD);
    write (a^.dato,' ')
  end;
end;

{ Procedure Buscar(a:arbol;n:integer;var p:arbol);
Begin
 if (a <> nil) then begin
   If (a^.dato=n) then
      p:=a;
   If (a^.dato=n) then
      p:=a;
   Buscar (a^.HD,n,p);
   Buscar (a^.HI,n,p);
 end;
end; }

{ Procedure vermin(a:arbol;var M:integer);
begin
   if ( a <> nil ) then begin
    if (a^.dato<M) then
       M:=a^.dato;                         //como procedure
    vermin (a^.HI,m);
    vermin (a^.HD,m);
   end;
end;

Procedure vermax(a:arbol;var M:integer);
begin
   if ( a <> nil ) then begin
    if (a^.dato>M) then
       M:=a^.dato;
    vermax (a^.HI,m);                    //como procedure
    vermax (a^.HD,m);
   end;
end; }

Function vermin(a:arbol):integer;
var
 recursion:integer;
begin
   if ( a <> nil ) then begin
    recursion:=vermin (a^.HD);
    recursion:=vermin (a^.HI);
    if (a^.dato<recursion) then
       recursion:=a^.dato;
    vermin:=recursion;
   end
   else
     vermin:=99999
end;

Function vermax(a:arbol):integer;
var
 recursion:integer;
begin
   if ( a <> nil ) then begin
    recursion:=vermax (a^.HI);
    recursion:=vermax (a^.HD);
    if (a^.dato>recursion) then
       recursion:=a^.dato;
    vermax:=recursion;
   end
   else
     vermax:=-1
end;

Var

 l,aux: lista;
 Arb:arbol;
 num,min,max:integer;
 Puntero:arbol;
begin
 Randomize;
 crearLista(l);
 aux:=l;
 writeln ('Lista generada: ');
 imprimirLista(l);
 while (aux<>nil) do begin
  Insertar(Arb,aux^.dato);
  aux:=aux^.sig;
 end;
 readln;
 enOrden(Arb);
 readln;
 preOrden(Arb);
 readln;
 postOrden(Arb);
 readln;
 //Writeln('inserte un numero');
 //Read(num);
 //Puntero:=nil;
 //Buscar(Arb,num,Puntero);
 //Writeln(Puntero^.dato);
 { if ( arb <> nil ) then begin
   Min:=100000;
   Vermin(Arb,min);
 end
 else
   Min:=-1;
 Writeln(min);
 Max:=-1;
 Vermax(Arb,max);
 Writeln(max);}
 Min:=-1;
 if ( arb <> nil ) then
   Min:=Vermin(Arb);
 Writeln(Min);
 readln;
 Max:=Vermax(Arb);
 Writeln(max);
 Readln;
end.
