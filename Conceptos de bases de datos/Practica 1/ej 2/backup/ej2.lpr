program ej2;
type
  tint= File Of integer;
var
  lectura: tint;
  votos: integer;
  nombreArch: string;
  total: integer;
  total2: integer;
  min: integer;
begin
  total:=0;
  total2:=0;
  min:=9999;
  writeln('Ingresar nombre del archivo');
  readln(nombreArch);
  Assign(lectura, nombreArch);
  reset(lectura,votos);
  read(lectura,votos);
  while(not EoF(lectura)) do begin
    writeln('votos:',votos);
    total2:=total2+1;
    total:=total+votos;
    read(lectura, votos);
    if (votos<min) then begin
       min:=votos;
    end;
  end;
  writeln('promedio votos:', total/total2);
  writeln('min votos:', min);
  close(lectura);
end.
