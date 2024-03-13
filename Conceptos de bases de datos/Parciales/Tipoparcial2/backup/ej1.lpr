program ej1;
const
  valoralto=9999;
type
  informacion=record
    codprov:integer;
    codlocalidad:integer;
    nummesa:integer;
    cantvotos:integer;
  end;
  arch=file of informacion;
procedure leer(var m:arch;var r:informacion);
begin
  if (not eof(m)) then
     read(m,r)
  else begin
    r.codprov:=valoralto;
  end;
end;

var
  mae:arch;
  reg:informacion;
  codpactual:integer;
  codlactual:integer;
  totalvotosloc:integer;
  totalvotosprov:integer;
begin
  assign(mae,'arch.dat');
  reset(mae);
  leer(mae,reg);
  while(reg.codprov<>valoralto) do begin
      codpactual:=reg.codprov;
      write('Codigo de provincia: ');
      writeln(codpactual);
      writeln('Codigo localidad  Total de votos');
      totalvotosprov:=0;
      while (codpactual=reg.codprov) do begin
          codlactual:=reg.codlocalidad;
          totalvotosloc:=0
          while ((codlactual=reg.codlocalidad) and (codlactual=reg.codlocalidad)) do begin
              totalvotosloc:=totalvotosloc+reg.cantvotos;
              leer(mae,reg);
          end;
          writeln(codlactual,totalvotosloc);
          totalvotosprov:=totalvotosprov+totalvotosloc;
      end;
      write('Total de votos por provincia: ');
      writeln(totalvotosprov);
  end;
  close(mae);
end.

