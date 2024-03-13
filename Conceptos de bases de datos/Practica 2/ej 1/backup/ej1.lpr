program ej1;
Uses sysutils;
const
  valoralto=9999;
  n=10;
type
   empleadodet=record
     codigo:integer;
     fecha:longint;
     diaslic:integer;
   end;
   empleadomaestro=record
     codigo:integer;
     nombre:String[255];
     apellido:String[255];
     fecha:longint;
     direccion:String[255];
     cantidadhijos:integer;
     telefono:longint;
     vacaciones:integer;
   end;
   detallearch=file of empleadodet;
   maestroarch=file of empleadomaestro;
   vectorD=array [1..10] of empleadodet;
procedure leer(var archivo: detallearch; var dato: empleadodet);
begin
  if(not(EOF(archivo))) then
    read(archivo, dato)
  else
    dato.codigo := 9999;
end;
procedure calcularMinimo(var empdet: vectorD; var indice_min:integer);
var
  i: integer;
  min: integer;
begin
  min:= 9999;
  for i:=1 to n do begin
    if(empdet[i].codigo < min) then begin
      min:= empdet[i].codigo;
      indice_min:= i;
    end;
  end;
end;
var
   det:array [1..10] of detallearch;
   mae:maestroarch;
   empdet:vectorD;
   empmae:empleadomaestro;
   vacasarch:text;
   aux:integer;
   lic:integer;
   i:integer;
   indicemin:integer;
   min:empleadodet;
begin
  aux:=0;
  assign(mae, 'maestro');
  for i:=1 to n do begin
      assign(det[i],concat('detalle',IntToStr(i),'.dat'));
      reset(det[i]);
      leer(det[i],empdet[i]);
  end;
  calcularMinimo(empdet, indicemin);
  min:= empdet[indicemin];
  reset(mae);
  assign(vacasarch,'textovacas.txt');
  rewrite(vacasarch);
  read(mae, empmae);
  while(aux <> valoralto) do begin
    aux := empdet[i].codigo;
    lic:=0;
    while (aux=min.codigo) do begin
      lic:=lic+min.diaslic;
      calcularMinimo(empdet, indicemin);
      min:= empdet[indicemin];
      leer(det[i],empdet[i]);
    end;
    while(empmae.codigo <> aux) do begin
        read(mae, empmae);
    end;
    if ((empmae.vacaciones-lic) < 0) then begin
      with empmae do writeln(vacasarch,codigo,nombre,apellido,vacaciones);
      write(vacasarch,lic);
    end
    else begin
      empmae.vacaciones:=empmae.vacaciones-lic;
      seek(mae,filepos(mae)-1);
      write(mae,empmae);
    end;
    if (not eof(mae))then
      read(mae,empmae);
  end;
  close(mae);
  for i:=1 to n do begin
      close(det[i]);
  end;
  close(vacasarch);
end.

