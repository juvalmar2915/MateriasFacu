program ej3;
var
  carga: Text;
  dino: string;
  nombreArch: string;
begin
  writeln('Ingresar nombre del archivo');
  readln(nombreArch);
  Assign(carga, nombreArch);
  rewrite(carga);
  writeln('Ingrese dinosaurio');
  readln(dino);
  while(dino <> 'zzz') do begin
    writeln(carga, dino);
    writeln('Ingrese dinosaurio');
    readln(dino);
  end;
  close(carga);
end.
