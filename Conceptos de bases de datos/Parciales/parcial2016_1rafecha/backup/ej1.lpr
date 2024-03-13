program ej1;
type
  producto=record
    cod:integer;  //utilizado para lista invertida
    nombre:String[255];
    descripcion:String[255];
    stock:integer; //utilizado para marca logica
  end;
  maestro=file of producto;
procedure leerDesdeTexto(var archT:text; var reg:producto);
begin
  read(archT, reg.cod);
  read(archT, reg.stock);
  readln(archT, reg.nombre);
  readln(archT, reg.descripcion);
end;
procedure generar(var det:text);
var
  mae:maestro;
  p:producto;
begin
  reset(det);
  assign(mae,'mae.dat');
  rewrite(mae);
  while (not eof(det)) do begin
    leerDesdeTexto(det,p);
    write(mae,p);
  end;
  close(det);
  close(mae);
end;
procedure bajalogica(var maes:maestro);
var
  codigoe:integer;
  nlibre:integer;
  slibre:producto;
  product:producto;
begin
  write('ingrese codigo distinto de -1: ');
  read(codigoe);
  reset(maes);
  while (codigoe<>-1) do begin
    read(maes,slibre);
    read(maes,product);
    while((not (eof(maes))) and (product.cod<>codigoe)) do begin
      read(maes,product);
    end;
    if (product.cod=codigoe) then begin
       nlibre:=FilePos(mae)-1;
       seek(mae,nlibre);
       product.cod:=nlibre;
       product.stock:=-1;
       write(mae,slibre);
       seek(mae,0);
       write(mae,product);
    end
    else begin
      write('no se encontro el registro vuelva a ingresar para continuar');
    end;
    write('ingrese codigo distinto de -1: ');
    read(codigoe);
    reset(mae);
  end;
  close(mae);
end;

var
  detalle:text;
  maest:maestro;
begin
end.

