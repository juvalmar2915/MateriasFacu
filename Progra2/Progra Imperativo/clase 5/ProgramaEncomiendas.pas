Program encomiendas;
Type

   encomienda = record
                  codigo: integer;
                  peso: integer;
                end;

  // Lista de encomiendas
  lista = ^nodoL;
  nodoL = record
    dato: encomienda;
    sig: lista;
  end;
  listapeso=^nodopeso;
  nodopeso=record
    dato:integer;
    sig:listapeso;
  end;

  arbol=^nodoA;
  nodoA=record
    dato:integer;
    lista:listapeso;
    hi:arbol;
    hd:arbol;
  end;

{-----------------------------------------------------------------------------
AgregarAdelante - Agrega una encomienda adelante en l}
procedure agregarAdelante(var l: Lista; enc: encomienda);
var
  aux: lista;
begin
  new(aux);
  aux^.dato := enc;
  aux^.sig := l;
  l:= aux;
end;


{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con datos de las encomiendas }
procedure crearLista(var l: Lista);
var
  e: encomienda;
  i: integer;
begin
 l:= nil;
 for i:= 1 to 20 do begin
   e.codigo := i;
   e.peso:= random (10);
   while (e.peso = 0) do e.peso:= random (10);
   agregarAdelante(L, e);
 End;
end;


{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: Lista);
begin
 While (l <> nil) do begin
   writeln('Codigo: ', l^.dato.codigo, '  Peso: ', l^.dato.peso);
   l:= l^.sig;
 End;
end;

procedure enOrden(a:arbol);
begin
 if (a<>nil) then begin
   enOrden(a^.hi);
   writeln('Peso: ',a^.dato);
   while (a^.lista<>nil) do begin
     write('  Codigo:',a^.lista^.dato);
     a^.lista:=a^.lista^.sig;
   end;
   readln;
   enOrden(a^.hd);
 end;
end;

procedure cargararbol(var a:arbol; l:lista);
var
  nue:listapeso;
begin
   if (a=nil) then begin
     new(a);
     a^.hi:=nil;
     a^.hd:=nil;
     a^.dato:=l^.dato.peso;
     new (a^.lista);
     a^.lista^.sig:=nil;
     a^.lista^.dato:=l^.dato.codigo;
   end
   else begin
     if (a^.dato>l^.dato.peso) then
       cargararbol(a^.hi,l)
     else begin
       if (a^.dato<l^.dato.peso) then
         cargararbol(a^.hd,l)
       else begin
         new (nue);
         nue^.dato:=l^.dato.codigo;
         nue^.sig:=a^.lista;
         a^.lista:=nue;
       end;
     end;
   end;
end;

Var
 a:arbol;
 l,aux: lista;

begin
 Randomize;
 crearLista(l);
 writeln ('Lista de encomiendas generada: ');
 imprimirLista(l);
 aux:=l;
 while (aux<>nil) do begin
   cargararbol(a,aux);
   aux:=aux^.sig;
 end;
 readln;
 enOrden(a);
 readln;
end.