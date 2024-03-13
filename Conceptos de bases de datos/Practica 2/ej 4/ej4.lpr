program ej4;
Uses sysutils;
const
  valoralto=9999;
  n=20;
type
  cine=record
    codigo:integer;
    nombre:string[255];
    genero:string[255];
    director:string[255];
    duracion:integer;
    fecha:longint;
    cantasist:integer;
  end;
  archmaeydet=file of cine;
  cadenacine=array [1..20] of cine;
  archscine=array [1..20] of archmaeydet;
procedure leer(var archivo: archmaeydet; var dato: cine);
begin
  if(not eof(archivo)) then
    read(archivo, dato)
  else
    dato.codigo:= 9999;
end;
procedure calcularMinimo(var calzadosv: cadenacine; var indice_min:integer);
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
  end;
end;
procedure generarMae(var dets: archscine; rutamae:String);
var
  mae:archmaeydet;
  x:integer;
  vcine:cadenacine;
  minindice:integer;
  min:cine;
  totalasist:integer;
  aux:integer;
begin
  assign(mae,rutamae);
  rewrite(mae);
  for x:=1 to n do begin
    leer(dets[x],vcine[x]);
  end;
  calcularminimo(vcine,minindice);
  min:=vcine[minindice];
  while (min.codigo <> valoralto) do begin
    totalasist:=0;
    aux:=min.codigo;
    while (min.codigo = aux) do begin
      totalasist:=totalasist+min.cantasist;
      calcularminimo(vcine,minindice);
      min:=vcine[minindice];
      leer(dets[minindice],vcine[minindice]);
    end;
    min.fecha:=0;//hago que no haya una fecha en particular ya que es a lo largo de la semana
    min.cantasist:=totalasist;
    write(mae,min);
  end;
  close(mae);
end;

var
arreglodets:archscine;
ruta:String;
i:integer;
begin
  writeln('escriba la  ruta del archivo maestro: ');
  readln(ruta);
  for i:=1 to n do begin
    assign(arreglodets[i],concat('cine', IntToStr(i),'.dat'));
    reset(arreglodets[i]);
  end;
  generarMae(arreglodets,ruta);
  for i:=1 to n do begin
    close(arreglodets[i]);
  end;
end.

