Program tp_compras;
Uses
    sysutils;
const
p = 2000;
f = 7000;
Type
    fechaYHora = record
        dia: 1..31;
        mes: 1..12;
        anio: integer;
        hora: 0..23;
        min: 0..59;
    end;

    compra = record
        dni: longint; //es un entero que permite 8 cifras (sin puntos)
        codProducto: integer;
        fechaHora: fechaYHora;
        monto: real;
    end;

    listaCompras = ^nodoLista;
    nodoLista = record
        dato: compra;
        sig: listaCompras;
    end;

    listadni=  ^nododni;
        nododni = record
        dni:longint;
        sig:listadni;
    end;

    arbolproducto = ^nodoarbol;
    nodoarbol = record
        cod:integer;
        recaudado:real;
        compradores:listadni;
        HI,HD: arbolproducto;
    end;

{-----------------------------------------------------------------------------
CARGARFECHA - Genera una FECHA Y HORA aleatorias }
procedure cargarFecha(var f: fechaYHora);
begin
  with f do begin
    dia := random(30)+1;
    mes := random(12)+1;
    if(mes = 2)then
      dia:= (dia mod 29)+1
    else
    if(mes = 4)or(mes = 6)or(mes = 9)or(mes = 11)then
      dia:= (dia mod 31)+1;
    anio:= ((random(20)+1)*2018) mod 2020;
    hora:= random(24);
    min:= random(60);
  end;
end;

{-----------------------------------------------------------------------------
AGREGARADELANTE - Agrega adelante}
Procedure agregarAdelante(var l: listaCompras; c: compra);
var
  nue:listaCompras;
begin
  new(nue);
  nue^.dato:=c;
  nue^.sig:=l;
  l:=nue;
end;

{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con compras aleatorias }
procedure crearLista(var l: listaCompras);
var
  i: integer;
  c: compra;
begin
  for i:=1 to random(20)+5 do begin
    c.dni := random(46000000)+10000000;
    c.codProducto := random (32000);
    c.monto := Random * random(4000);
    cargarFecha(c.fechaHora);
    agregarAdelante(l, c);
  end;
end;

{-----------------------------------------------------------------------------
IMPRIMIRELEMENTO - Muestra en pantalla una fechaHora }
procedure imprimirFechaHora(f: fechaYHora);
begin
  with(f) do begin
    if(dia < 10)then //imprime el cero anterior
      write('0');
    write(dia,'/');
    if(mes < 10)then //imprime el cero anterior
      write('0');
    write(mes,'/', anio,' a las ');
    if(hora < 10)then //imprime el cero anterior
        write('0');
      write(hora, ':');
    if(min < 10)then //imprime el cero anterior
      write('0');
    write(min, 'hs.');
  end;
end;

{-----------------------------------------------------------------------------
IMPRIMIRELEMENTO - Muestra en pantalla una compra }
procedure imprimir(c: compra);
begin
  with(c) do begin
    write('Compra realizada el ');
    imprimirFechaHora(fechaHora);
    write(' del cliente con dni ', dni, ' por el monto de $', monto:1:2, ' y el producto ', codProducto);
    writeln();
  end;
end;

{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: listaCompras);
begin
  while (l <> nil) do begin
    imprimir(l^.dato);
    l:= l^.sig;
  end;
end;

procedure crear_lista_compradores (var l:listadni; c:longint);
var
  nue:listadni;
begin
  new(nue);
  nue^.dni:=c;
  nue^.sig:=l;
  l:=nue;
end;

procedure crear_arbol (var a:arbolproducto; c:compra); //Genera el arbol
begin
 if (a = nil) then begin
   new(a);
   a^.cod:= c.codProducto;
   a^.HD:= nil;
   a^.HI:= nil;
   a^.recaudado:=0;
   a^.recaudado:= a^.recaudado + c.monto;
   a^.compradores:=nil;
   crear_lista_compradores (a^.compradores,c.dni);
 end
 else begin
   if (a^.cod > c.codProducto) then begin
     crear_arbol (a^.HI,c) end
   else
   if (a^.cod < c.codProducto) then begin
     crear_arbol (a^.HD,c)
   end
   else begin
   if (a^.cod = c.codProducto) then begin
     a^.recaudado:= a^.recaudado + c.monto;
     crear_lista_compradores(a^.compradores,c.dni);
   end;
   end;
 end;
end;

procedure reco_lista (var a:arbolproducto; l:listaCompras);
begin
  while (l <> nil) do begin
    crear_arbol(a,l^.dato);
    l:=l^.sig;
  end;
end;

function lista(l:listaCompras):integer;
var
  i:integer;
begin
  i:=0;
  while (l<>nil) do begin
     if (l^.dato.monto>=500) then
       i:=i+1;
     l:=l^.sig
  end;
  lista:=i;
end;

procedure reco_arbol (a:arbolProducto); //Recorro el arbol para informar el total de dinero
begin
 if (a <> nil) then begin
  if (a^.cod > p) then begin
   if (a^.cod < f) then  begin
     writeln ('El total de dinero del cod ',a^.cod, ' es de: ',a^.recaudado:0:2);
     reco_arbol (a^.HI);
     reco_arbol (a^.HD);
     end
   else
       reco_arbol(a^.HI);
  end
  else
      reco_arbol(a^.HD);
   end;
end;

Var
    l: listaCompras;
    a:arbolproducto;
    i:integer;
begin
    Randomize;
    l:= nil;
    crearLista(l);
    writeln ('Lista disponible: ');
    imprimirLista(l);
    a:=nil;
    i:=lista(l);
    reco_lista(a,l);
    writeln('Cantidad de compras que alcanzaron los 500 pesos:',i);
    reco_arbol(a);
    readln;
    writeln('Fin del programa');
    readln;
end.
