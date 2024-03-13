program ej1;
const
  valoralto=9999;
type
   viviendamaestro=record
     tipo:String[255];
     codpartido:integer;
     cantidad:integer;
   end;
   viviendadetalle=record
     tipo:String[255];
     codpartido:integer;
   end;
   fmae=file of viviendamaestro;
   fdet=file of viviendadetalle;
procedure leer(var d:fdet;var r:viviendadetalle);
begin
  if (not (eof(d))) then
     read(d,r)
  else
    r.codpartido:=valoralto;
end;
procedure compactar(var det:fdet);
var
  codact:integer;
  vivact:String;
  mae:fmae;
  vdet:viviendadetalle;
  vmae:viviendamaestro;
  mayorpartido:integer;
  cantidadmax:integer;
  cantact:integer;
begin
   reset(det);
   assign(mae,'act.dat');
   rewrite(mae);
   leer(det,vdet);
   mayorpartido:=-1;
   cantidadmax:=0;
   while(vdet.codpartido<>valoralto) do begin
     codact:=vdet.codpartido;
     vmae.codpartido:=vdet.codpartido;
     cantact:=0;
     while((vdet.codpartido=codact)and(vdet.codpartido<>valoralto)) do begin
       vivact:=vdet.tipo;
       vmae.tipo:=vdet.tipo;
       vmae.cantidad:=0;
       while((vdet.tipo=vivact) and (vdet.codpartido=codact) and (vdet.codpartido<>valoralto)) do begin
         vmae.cantidad:=vmae.cantidad+1;
         leer(det,vdet);
       end;
       write(mae,vmae);
       cantact:=cantact+vmae.cantidad;
     end;
     if(cantidadmax<cantact) then begin
       cantidadmax:=cantact;
       mayorpartido:=vmae.codpartido;
     end;
   end;
   write('partido maximo: ',mayorpartido);
   write(' con',cantidadmax);
   write(' de viviendas');
   close(mae);
   close(det);
end;
begin
end.

