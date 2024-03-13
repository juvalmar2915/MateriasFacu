program ej2;
const
  valoralto=9999;
type
  cdr=record
    cod:integer;
    autor:string[40];
    nombredisco:string[40];
    genero:string[40];
    ventas:integer;
  end;
  archcd=file of cdr;
procedure leer(var archivo: archcd; var dato: cdr);
begin
  if(not(EOF(archivo))) then
    read(archivo, dato)
  else
    dato.cod := 9999;
end;
var
  mae:archcd;
  acrear:text;
  cd:cdr;
  autoract:String;
  totalaut:integer;
  aux1:String;
  generotot:integer;
  totaldiscografica:integer;
begin
  assign(mae,'maestroEjercicio2.dat');
  reset(mae);
  assign(acrear,'info.txt');
  rewrite(acrear);
  leer(mae,cd);
  totaldiscografica:=0;
  while (cd.cod <> valoralto) do begin
    autoract:=cd.autor;
    totalaut:=0;
    while (cd.autor = autoract) do begin
      writeln('Autor: ',cd.autor);
      writeln(acrear,'Autor: ',cd.autor);
      writeln(acrear,'');
      aux1:=cd.genero;
      generotot:=0;
      while (cd.genero = aux1) and (cd.autor = autoract) do begin
        generotot:=generotot+cd.ventas;
        writeln('Genero: ',cd.genero);
        writeln(acrear,'Genero: ',cd.genero);
        writeln;
        writeln(acrear,'');
        writeln('Nombre Disco: ',cd.nombredisco,'Cantidad vendida: ',cd.ventas);
        writeln(acrear,'Nombre Disco: ',cd.nombredisco,'Cantidad vendida: ',cd.ventas);
        leer(mae,cd);
      end;
      totalaut:=totalaut+generotot;
      writeln('Total Genero: ',generotot);
      writeln(acrear,'Total Genero: ',generotot);
    end;
    writeln('Total Autor: ',totalaut);
    writeln(acrear,'Total Autor: ',totalaut);
    totaldiscografica:=totaldiscografica+totalaut;
  end;
  writeln('Total Discografica: ',totaldiscografica);
  writeln(acrear,'Total Discografica: ',totaldiscografica);
  close(mae);
  close(acrear);
end.

