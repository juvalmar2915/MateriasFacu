program ej1a;
type
  especie=record
    codigo:integer;
    nombrev:string[255];
    nombrec:string[255];
    altura:integer;
    descripcion:string[255];
    zona:string[255];
  end;
  arche=file of especie;
var
  a:arche;
  e:especie;
  cod:integer;
  posborrar:integer;
  a2:arche;
begin
   assign(a,'esp.dat');
   reset(a);
   writeln('escriba codigo de especies a borrar: ');
   read(cod);
   while (cod <> 100000) do begin
     while (not eof(a)) do begin
       read(a,e);
       if (e.codigo=cod) then begin
         posborrar:=filepos(a)-1;
         e.altura:=-1;
         seek(a, posborrar);
         write(a, e);
       end;
     end;
     writeln('escriba codigo de especies a borrar: ');
     read(cod);
     reset(a); //cuando se pone codigo -1 igualmente se resetea por lo que se procede a compactar
   end;
   assign(a2,'plantas.dat');
   rewrite(a2);
   while (not eof(a)) do begin
     read(a,e);
     if (e.altura<>-1) then begin
        write(a2,e);
     end;
   end;
   writeln('se genero el archivo compacto plantas.dat');
   close(a2);
   close(a);
   erase(a);
end.

