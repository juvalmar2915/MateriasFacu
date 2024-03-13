program ej8;
const
  valoralto=9999;
type
  zona=record
    cod:integer;
    nombre:string[255];
    descripcion:string[255];
    fecha:LongInt;
    metrosconstruidos:integer;
  end;
  detalle=file of zona;
  detalles=array [1..15] of detalle;
  zonas=array [1..15] of zona;
  zonamae=record
    cod:integer;
    nombre:string[255];
    metrosconstruidos:integer;
  end;
  maestro=file of zonamae;
procedure leer(var det:detalle;var zon:zona);
begin
     if(not eof(det)) then begin
       read(det,zon);
     end
     else begin
       zon.cod:=valoralto;
     end;
end;
procedure minimo(var vectorR: zonas; var indice_min: integer);
var
  i: integer;
  valorMin: integer;
begin
  valorMin:= vectorR[1].cod;
  indice_min:= 1;
  for i:=1 to 30 do begin
    if(vectorR[i].cod < valorMin) then begin
      valorMin:= vectorR[i].cod;
      indice_min:= i;
    end;
  end;
end;
procedure generarmae(var detas:detalles);
var
  t:text;
  m:maestro;
  i:integer;
  min:zona;
  ind:integer;
  regs:zonas;
  metrosact:integer;
  zonact:zonamae;
begin
  for i:=1 to 15 do begin
    reset(detas[i]);
  end;
  assign(m,'mae.dat');
  rewrite(m);
  assign(t,'informe');
  rewrite(t);
  for i:=1 to 15 do begin
    leer(detas[i],regs[i]);
  end;
  minimo(regs,ind);
  min:=regs[ind];
  leer(detas[ind],regs[ind]);
  while(min.cod<>valoralto) do begin
    zonact.cod:=min.cod;
    zonact.nombre:=min.nombre;
    metrosact:=0;
    write(t,'para la zona: ',min.cod,min.nombre,min.descripcion);
    while (min.cod=zonact.cod) do begin
      metrosact:=metrosact+min.metrosconstruidos;
      minimo(regs,ind);
      min:=regs[ind];
      leer(detas[ind],regs[ind]);
    end;
    zonact.metrosconstruidos:=metrosact;
    write(m,zonact);
    writeln(t,'metros construidos: ',metrosact);
  end;
  for i:=1 to 15 do begin
    close(detas[i]);
  end;
  close(m);
  close(t);
end;

begin
end.

