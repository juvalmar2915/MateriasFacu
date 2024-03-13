Program listas;
Type
  Lista= ^Nodo;
  Nodo= Record
           Datos: integer;
           Sig: Lista;
        End;
Var
 L: Lista;
 n: integer;

Procedure AgregarAdelante (var L:lista; num:integer);
Var nue:Lista;
  Begin
    New(nue);
    nue^.datos:=num;
    nue^.sig:=L;
    L:=nue;
  End;


//Procedure Imprimir (pri:lista);
//Begin
//   while (pri <> NIL) do begin
//     write (pri^.datos, ' ');
//     pri:= pri^.sig
//  end;
//  writeln;
//end;

function Maximo (L:Lista):integer;
var
   max:integer;
begin
     if (L<>nil) then begin
         max:=Maximo(L^.sig);
         if (max<L^.Datos) then
           Maximo:=L^.Datos
         else
           Maximo:=max;
     end
     else
         Maximo:=-1;
end;

Procedure Imprimir (L:lista);
begin
   if (L<>nil) then begin
         Imprimir (L^.sig);
         write(L^.Datos,' ');
     end
end;

begin
 L:=nil;
 randomize;
 n := random (100);
 While (n<>0) do Begin
   AgregarAdelante (L, n);
   n := random (100);
 End;
 writeln ('Lista generada: ');
 imprimir (L);
 readln;
 writeln (Maximo (L));
 readln
end.
