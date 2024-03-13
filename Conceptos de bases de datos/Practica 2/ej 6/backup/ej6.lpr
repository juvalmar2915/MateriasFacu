program ej6;
const
  valoralto=9999;
type
  mozo=record
    cod:integer;
    fecha:longint;
    monto:integer;
  end;
  arch=file of mozo;
procedure leer(var detalle:arch; var mo:mozo);
begin
  if (not eof(detalle)) then
     read(detalle,mo)
  else
     mo.cod:=valoralto;
end;
procedure compactararch(var d:arch);
var
  m:mozo;
  aux:integer;
  totmonto:integer;
  mant:mozo;
  mae:arch;
begin
  assign(mae,'maestro.dat');
  rewrite(mae);
  leer(d,m);
  while (m.cod <> valoralto) do begin
    aux:=m.cod;
    totmonto:=0;
    while(m.cod=aux) do begin
      totmonto:=totmonto+m.monto;
      mant:=m;
      leer(d,m);
    end;
    mant.monto:=totmonto;//guardo a cada mozo con el ultimo monto de servicio (ultima fecha con dicho monto)
    write(mae,mant);
  end;
  close(mae);
end;
var
  det:arch;
  nombre:String;
begin
  writeln('escriba nombre del archivo: ');
  read(nombre);
  assign(det,nombre);
  reset(det);
  compactararch(det);
  close(det);


end.

