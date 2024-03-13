program ej1;
const
  valoralto=9999;
type
  productodet=record
    numticket:integer;
    codigo:integer;
    cantidad:integer;
  end;
  productomae=record
    codigo:integer;
    descripcion:integer;
    cantidad:integer;
    precio:real;
  end;
  detalle=file of productodet;
  detalles=array [1..30] of detalle;
  registros=array [1..30] of productodet;
  maestro=file of productomae;
procedure leer(var deta: detalle; var dato: productodet);
begin
  if(not(eof(deta))) then
    read(deta, dato)
  else
    dato.codigo:= valoralto;
end;
procedure minimo(var rd: registros;var ind:integer);
var
  i:integer;
  min:integer;
begin
  min:=9999;
  for i:=1 to 30 do begin
      if(min>rd[i].codigo) then begin
        min:=rd[i].codigo;
        ind:=i;
      end;
  end;
end;
procedure actualizar(var m:maestro; var d:detalles);
var
regsd:registros;
regm:productomae;
i:integer;
minreg:productodet;
min:integer;
codact:integer;
cantact:integer;
canttotal:integer;
begin
  reset(m);
  for i:=1 to 30 do begin
      reset(d[i]);
  end;
  for i:=1 to 30 do begin
      leer(d[i],regsd[i]);
  end;
  minimo(regsd,min);
  minreg:=regsd[min];
  leer(d[min],regsd[min]);
  canttotal:=0;
  while(minreg.codigo<>valoralto) do begin
      codact:=minreg.codigo;
      cantact:=0;
      read(m,regm);
      while(regm.codigo<>codact) do begin
          read(m,regm);
      end;
      while(minreg.codigo=codact) do begin
          cantact:=cantact+minreg.cantidad;
          minimo(regsd,min);
          minreg:=regsd[min];
          leer(d[min],regsd[min]);
      end;
      canttotal:=canttotal+cantact;
      if ((cantact=0) and (regm.cantidad>0)) then begin
        write('el producto de codigo: ');
        write(regm.codigo);
        write('no vendio ni un producto');
      end
      else begin
          if(cantact>=(regm.cantidad*20/100)) then begin
            write('el producto de codigo: ');
            write(regm.codigo);
            writeln('supero al 20% del total del suministro');
          end;
          regm.cantidad:=regm.cantidad-cantact;
          seek(m,filepos(m)-1);
          write(m,regm);
      end;

  end;
  write('la cant total vendida fue de: ');
  writeln(canttotal);
  close(m);
  for i:=1 to 30 do begin
      close(d[i]);
  end;
end;
begin
end.

