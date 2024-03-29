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
CREARLISTA - Genera una lista con n�meros aleatorios }
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
AGREGARATRAS - Agrega un elemento atr�s en l}

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
IMPRIMIRPORNIVEL - Muestra los datos del �rbol a por niveles }

Procedure imprimirpornivel(a: arbol);
var
   l, aux, ult: listaNivel;
   nivel, cant, i: integer;
begin
   l:= nil;
   if(a <> nil)then begin
                 nivel:= -1;
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
       if (i<a^.dato) then
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

function vermin(a:arbol):integer;
var
 int:integer;
begin
   if (a<>nil) then begin
     int:=vermin(a^.HI);
     if (int=-1) then
        int:=a^.dato
   end
   else
     int:=-1;
   vermin:=int;
end;

function buscar(a:arbol; int:integer):arbol;
var
  aux:arbol;
begin
  if(a<>nil) then begin
    if (int=a^.dato) then
        aux:=a
    else begin
        if (int>a^.dato) then
            aux:=buscar(a^.HD,int)
        else
            aux:=buscar(a^.HI,int)
    end;
  end
  else
      aux:=nil;
  buscar:=aux;
end;

Function vermax(a:arbol):integer;
var
 int:integer;
begin
   if (a<>nil) then begin
     int:=vermax(a^.HD);
     if (int=-1) then
        int:=a^.dato
   end
   else
     int:=-1;
   vermax:=int;
end;

Procedure postOrden( a: arbol );
begin
  if ( a <> nil ) then begin
    postOrden (a^.HI);
    postOrden (a^.HD);
    write (a^.dato,' ')
  end;
end;

Procedure vervaloresenrango(a:arbol;inf:integer;sup:integer);
begin
 begin
   if (a <> nil) then
     if (a^.dato>= inf) then
       if (a^.dato<= sup) then begin
         write(a^.dato,'  ');
         vervaloresenrango(a^.hi, inf, sup);
         vervaloresenrango(a^.hd, inf, sup);
       end
       else
         vervaloresenrango(a^.hi, inf, sup)
     else
       vervaloresenrango(a^.hd, inf, sup);
 end;

end;

Procedure BorrarElemento (var a:arbol ;n:integer);
var
   aux:arbol;
begin
  if(a<>nil) then begin
    if (n>a^.dato) then
        BorrarElemento (a^.HD,n)
    else begin
       if (n<a^.dato) then
           BorrarElemento (a^.HI,n)
       else begin
           if (a^.HI=nil) then begin
               aux:=a;
               a:=a^.HD;
               dispose(aux);
           end
           else begin
               if (a^.HD=nil) then begin
                   aux:=a;
                   a:=a^.HI;
                   dispose(aux);
               end
               else begin
                   aux:=a^.HD;
                   while (aux^.HI<>nil) do
                       aux:=aux^.HI;
                   a^.dato:=aux^.dato;
                   BorrarElemento (a^.HD,aux^.dato);
               end;
           end;
       end;
    end;
  end
  else
      writeln('el dato no se encuentra en el arbol');
end;

Var
 int,inf,sup:integer;
 l,aux: lista;
 Arb,arbaux:arbol;
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
 write('insertar valor a buscar:');
 read(int);
 if (Arb<>nil) and (Arb^.dato=int) then
    arbaux:=Arb
 else
     arbaux:=buscar(arb,int);
 if (arbaux<>nil) then begin
    writeln(arbaux^.dato);
    readln;
 end;
 int:=vermax(Arb);
 writeln (int);
 int:=vermin(Arb);
 writeln (int);
 readln;
 writeln('inserte inferior: ');
 readln(inf);
 writeln('inserte superior: ');
 readln(sup);
 vervaloresenrango(arb,inf,sup);
 readln;
 imprimirpornivel(arb);
 Writeln('ingrese dato a borrar: ');
 readln(int);
 borrarelemento(arb,int);
 readln;
 Imprimirpornivel(arb);
 readln;
end.
