program BlancoValentinArchivos;
const
  valoralto=9999;
type
    votos=record
      coduni:integer;
      codfacu:integer;
      codclaustro:integer;
      nummesa:integer;
      cantvotos:integer;
    end;
    maestro=file of votos;
procedure leer(var arch: maestro;var dato: votos);
begin
  if(not(eof(arch))) then
    read(arch, dato)
  else
    dato.coduni:= valoralto;
end;
var
  mae:maestro;
  nombre:String;
  voto:votos;
  coduniact:integer;
  codfacuact:integer;
  codclaustroact:integer;
  cantvotosclaustro:integer;
  cantvotosfacultad:integer;
  cantvotosuniversidad:integer;
begin
  writeln('inserte nombre del archivo: ');
  readln(nombre);
  assign(mae,nombre);
  reset(mae);
  leer(mae,voto);
  while (voto.coduni <> valoralto) do begin
    coduniact:=voto.coduni;
    cantvotosuniversidad:=0;
    writeln('Código de Universidad:',coduniact);
    while ((voto.coduni=coduniact)) do begin
      codfacuact:=voto.codfacu;
      cantvotosfacultad:=0;
      writeln('Código de Facultad:',codfacuact);
      while ((voto.codfacu=codfacuact) and (voto.coduni=coduniact)) do begin
        codclaustroact:=voto.codclaustro;
        cantvotosclaustro:=0;
        write('Codigo de Claustro: ',voto.codclaustro);
        while ((voto.codclaustro=codclaustroact) and (voto.codfacu=codfacuact) and (voto.coduni=coduniact)) do begin
          cantvotosclaustro:=cantvotosclaustro+voto.cantvotos;
          leer(mae,voto);
        end;
        writeln('-Total de votos del Claustro: ',cantvotosclaustro);
        cantvotosfacultad:=cantvotosfacultad+cantvotosclaustro;
      end;
      writeln('Total de votos en Facultad: ',cantvotosfacultad);
      cantvotosuniversidad:=cantvotosuniversidad+cantvotosfacultad;
    end;
    write('Total de votos en Universidad:',cantvotosuniversidad);
  end;
  readln();
  close(mae);
end.
             