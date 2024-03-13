program ej4;
type
  tint= File Of integer;
  procedure generararch(var lect:tint);
  var
    votos: integer;
    nomb: String;
    archn: text;
  begin;
    writeln('ingrese nombre del nuevo archivo');
    readln(nomb);
    assign(archn,nomb);
    rewrite(archn);
    read(lect,votos);
    while(not EoF(lect)) do begin
      write(archn,votos);
      read(lect,votos);
    end;
    close(archn);
  end;
var
  lectura: tint;
  nombreArch: String;
begin
  nombreArch:='Numeros';
  Assign(lectura, nombreArch);
  reset(lectura);
  generararch(lectura);
  close(lectura);
end.
