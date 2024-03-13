program ej1b;
type
  especie = record
    codigo: integer;
    nomV: string[50];
    nomC: string[50];
    altura: real;
    desc: string[100];
    zona: string[100];
  end;
  archivo = file of especie;
var
  sLibre: especie;
  nLibre: Word;
  a:archivo;
  e: especie;
  cod:integer;
begin
     assign(a, 'plantas.dat');
     reset(a);
     writeln('Ingrese codigo de planta a eliminar');
     readln(cod);
     while(cod <> 100000) do begin
       read(a, slibre);
       e:=slibre;
       while not ((e.codigo = cod) or eof(a)) do begin
         read(a, e);
       end;
       if(e.codigo = cod) then begin
         nLibre:= filepos(a) - 1;
         seek(a, nLibre);
         write(a, sLibre);
         str(nLibre, sLibre.nomv);
         seek(a, 0);
         write(a, sLibre)//Marca de baja logica
       end
       else begin
         writeln('No se encontro la planta');
       end;
       writeln('Ingrese codigo de planta a eliminar');
       readln(cod);
       reset(a)
     end;
     close(a);
end.

