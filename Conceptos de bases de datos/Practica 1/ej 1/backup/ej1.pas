program ej1;
type
  fmat=File of String[255];
var
  carga:fmat;
  material:String;
  nombre:String;
begin
  writeln('ingrese nombre de archivo');
  Readln(nombre);
  Assign(carga,nombre);
  Rewrite(carga);
  Writeln('ingrese material');
  Readln(material);
  while (material<>'cemento') do begin
    write(carga,material);
    writeln('ingrese material');
    readln(material);
  end;
  writeln(carga,material);
  close(carga);
end.

