program ej1;
type
  empleado=record
    num:integer;
    fecha:String[255];
    horas:integer;
  end;
  detalle=file of empleado;
  arrd=array [1..3] of empleado;
  detalles=array [1..3] of detalle;
  empleadomae=record
    num:integer;
    sueldo:integer;
    monto:integer;
  end;
  maestro=file of empleadomae;
  emparchnuev=record
    num:integer;
    sueld:integer;
  end;
  nuevo=file of emparchnuev;
procedure leer(var det: detalle; var dato: empleado);
begin
  if(not(eof(det))) then
    read(det, dato)
  else
    dato.num:= 9999;
end;
var
  m:maestro;
  d:detalles;
  rm:empleadomae;
  r:arrd;
  i:integer;
  nom:String;
  nuev:nuevo;
  min:integer;
  menor:empleado;
  numact:integer;
  nuevoreg:emparchnuev;
  t:text;
  horasextra:integer;
  liqui:LongInt;
begin
  assign(t,'informe.txt');
  rewrite(t);
  read(nom);
  assign(m,nom);
  reset(m);
  for i:=1 to 3 do begin
     write('escriba nombres de los archivos');
     read(nom);
     assign(d[i],nom);
     reset(d[i]);
  end;
  assign(nuev,'nuevo');
  rewrite(nuev);
  for i:=1 to 3 do begin
     leer(d[i],r[i]);
  end;
  min:=9999;
  for i:=1 to 3 do begin
     if (r[i].num<min) then begin
        min:=r[i].num;
        menor:=r[i];
     end;
  end;
  while (menor.num<>9999) do begin
     horasextra:=0;
     numact:=menor.num;
     read(m,rm);
     while (menor.num<>rm.num) do begin
        read(m,rm);
     end;
     nuevoreg.num:=numact;
     nuevoreg.sueld:=rm.sueldo;
     while (menor.num=numact) do begin
        nuevoreg.sueld:=nuevoreg.sueld+menor.horas*rm.monto;
        horasextra:=horasextra+menor.horas;
        for i:=1 to 3 do begin
           leer(d[i],r[i]);
        end;
        for i:=1 to 3 do begin
           if (r[i].num<min) then begin
              min:=r[i].num;
              menor:=r[i];
           end;
        end;
     end;
     if (rm.sueldo>2500) then begin
        nuevoreg.sueld:=nuevoreg.sueld-nuevoreg.sueld*3/100;
     end
     else begin
        write(t,nuevoreg.num);
        write(t,horasextra);
        writeln(t,nuevoreg.sueld);
     end;
     write(nuev,nuevoreg);
  end;
  close(nuev);
  close(m);
  for i:=1 to 3 do begin
     close(d[i]);
  end;
end.

