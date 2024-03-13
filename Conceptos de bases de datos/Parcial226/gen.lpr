program gen;
type
    votos=record
      coduni:integer;
      codfacu:integer;
      codclaustro:integer;
      nummesa:integer;
      cantvotos:integer;
    end;
    maestro=file of votos;
var
  vot:votos;
  a:maestro;
begin
  assign(a,'hola.dat');
  rewrite(a);
  write('coduni,codfacu,codclaustro,cantvotos');
  readln(vot.coduni);
  while (vot.coduni<>-1) do begin
    readln(vot.codfacu);
    readln(vot.codclaustro);
    vot.nummesa:=0;
    readln(vot.cantvotos);
    write(a,vot);
    write('coduni,codfacu,codclaustro,cantvotos');
    readln(vot.coduni);
  end;
  reset(a);
  while(not eof(a)) do begin
    read(a,vot);
    writeln(vot.coduni);
    writeln(vot.codfacu);
    writeln(vot.codclaustro);
    writeln(vot.cantvotos);
  end;
  readln();
  close(a);
end.

