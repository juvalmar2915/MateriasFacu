program ej7;
uses sysutils;
const
  n=10;
  valoralto=9999;
type
  productomae=record
    codigo:integer;
    nombre:String[255];
    descripcion:String[255];
    precio:double;
    stock:integer;
    stockmin:integer;
  end;
  productodet=record
    codigop:integer;
    ventas:integer;
  end;
  archdet=file of productodet;
  archmae=file of productomae;
  vdet=array [1..10] of archdet;
  vpdet=array [1..10] of productodet;
procedure leer(var archivo: archdet; var dato: productodet);
begin
  if(not(EOF(archivo))) then
    read(archivo, dato)
  else
    dato.codigop := 9999;
end;
procedure calcularMinimo(var producdet: vpdet; var indice_min:integer);
var
  i: integer;
  min: integer;
begin
  min:= 9999;
  for i:=1 to n do begin
    if(producdet[i].codigop < min) then begin
      min:= producdet[i].codigop;
      indice_min:= i;
    end;
  end;
end;
procedure creararch(var maestro:archmae;var txtp:text);
var
  pmae:productomae;
begin
  with pmae do readln(txtp,codigo,nombre,descripcion,precio,stock,stockmin);
  while (not eof(txtp)) do begin
    write(maestro,pmae);
    with pmae do readln(txtp,codigo,nombre,descripcion,precio,stock,stockmin);
  end;
  write(maestro,pmae);
end;
procedure actualizararch(var maestro:archmae;var detalles:vdet;var p:vpdet);
var
  aux:integer;
  indmin:integer;
  min:productodet;
  pmaestro:productomae;
  totalventas:integer;
begin
  calcularMinimo(p,indmin);
  read(maestro,pmaestro);
  min:=p[indmin];
  while (min.codigop <> valoralto) do begin
    aux:=min.codigop;
    totalventas:=0;
    while(pmaestro.codigo <> min.codigop) do begin
      read(maestro,pmaestro);
    end;
    while (aux = min.codigop) do begin
      totalventas:=totalventas+min.ventas;
      calcularMinimo(p,indmin);
      min:=p[indmin];
      leer(vdet[indmin],p[indmin]);
    end;
    if (pmaestro.stock-totalventas>pmaestro.stockmin) then begin
       seek(maestro,filepos(maestro)-1);
       pmaestro.stock:=pmaestro.stock-totalventas;
       write(maestro,pmaestro);
    end
    else begin
      writeln('no hay suficiente stock para contabilizar todas las ventas');
    end;
    read(maestro,pmaestro);

  end;
end;
var
  caso:integer;
  productxt:text;
  detalles:vdet;
  detp:vpdet;
  maestro:archmae;
  x:integer;
begin
  writeln('ingrese 1 si quiere crear el archivo maestro a partir de productos.txt o 2 en caso de querer actualizar el maestro en base a los archivos diarios.');
  readln(caso);
  case caso of
  1: begin
    assign(productxt,'productos.txt');
    assign(maestro,'maestro.dat');
    rewrite(maestro);
    reset(productxt);
    creararch(maestro,productxt);
    close(productxt);
    Close(maestro);
  end;
  2: begin
    assign(maestro,'maestro.dat');
    reset(maestro);
    for x:=1 to n do begin
      assign(detalles[x],concat('detalle',IntToStr(x),'.dat'));
      reset(detalles[x]);
      leer(detalles[x],detp[x]);
    end;
    actualizararch(maestro,detalles,detp);
    for x:=1 to n do begin
      close(detalles[x]);
    end;
    close(maestro);
  end
  else writeln('ingreso un numero incorrecto');
  end;

end.

