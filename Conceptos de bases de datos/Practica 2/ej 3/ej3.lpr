program ej3;
uses sysutils;
const
  n=20;
  valoralto=9999;
type
  calzadosdet=record
    codigo:integer;
    numero:real;
    vendida:integer;
  end;
  calzadosmae=record
    codigo:integer;
    numero:real;
    descripcion:string[255];
    precio:real;
    color:String[255];
    stock:integer;
    stockmin:integer;
  end;
  archdet=file of calzadosdet;
  archmae=file of calzadosmae;
  vectorreg=array [1..20] of calzadosdet;
  vectorarch=array [1..20] of archdet;
procedure leer(var archivo: archdet; var dato: calzadosdet);
begin
  if(not eof(archivo)) then
    read(archivo, dato)
  else
    dato.codigo:= 9999;
end;
procedure calcularMinimo(var calzadosv: vectorreg; var indice_min:integer);
var
  i: integer;
  min: integer;
  numeroc: real;
begin
  min:= 9999;
  numeroc:= 9999;
  for i:=1 to n do begin
    if(calzadosv[i].codigo < min) then begin
      min:= calzadosv[i].codigo;
      indice_min:= i;
    end
    else
      if ((calzadosv[i].codigo = min) and (calzadosv[i].numero < numeroc)) then begin
         min:= calzadosv[i].codigo;
         indice_min:= i;
         numeroc:= calzadosv[i].numero;
      end;
  end;
end;
var
  det:vectorarch;
  mae:archmae;
  sinstock:text;
  calzados:vectorreg;
  mcalzado:calzadosmae;
  i:integer;
  indicemin:integer;
  min:calzadosdet;
  aux:real;
  ventas:integer;
begin
  assign(mae,'maestro.dat');
  reset(mae);
  read(mae,mcalzado);
  assign(sinstock,'calzadosinstock.txt');
  rewrite(sinstock);
  for i:=1 to n do begin
    assign(det[i],concat('detalle',IntToStr(i),'.dat'));
    reset(det[i]);
    leer(det[i],calzados[i]);
  end;
  calcularMinimo(calzados,indicemin);
  min:=calzados[indicemin];
  while (mcalzado.codigo <> min.codigo) and (mcalzado.numero <> min.numero)do begin
    read(mae,mcalzado);
  end;
  while ( min.codigo <> valoralto ) do begin
        aux:=min.numero;
        ventas:=0;
        while (min.numero = aux) do begin
          ventas:=ventas+min.vendida;
          //se tomo como ventas en forma general
          calcularMinimo(calzados,indicemin);
          min:=calzados[indicemin];
          leer(det[indicemin],calzados[indicemin]);
        end;
        if ((mcalzado.stock-ventas)>mcalzado.stockmin) then begin
           with mcalzado do write(sinstock,codigo,numero,stock);
           writeln(sinstock,ventas);
        end
        else begin
              mcalzado.stock:=mcalzado.stock-ventas;
              seek(mae,filepos(mae)-1);
              write(mae,mcalzado);
        end;
        if (ventas=0) then
          writeln('sin venta el calzado: ',mcalzado.codigo,mcalzado.numero,mcalzado.color,mcalzado.stockmin);
        read(mae,mcalzado);
  end;
  close(mae);
  close(sinstock);
  for i:=1 to n do begin
        close(det[i]);
  end;
end.

