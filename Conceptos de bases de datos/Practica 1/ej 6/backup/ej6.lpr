program ej6;
type
  libror=record
     ISBN:longInt;
     titulo:String[255];
     genero:String[255];
     editorial:String[255];
     ano:integer;
  end;
  flibro=file of libror;
var
  archb:flibro;
  tlibro:text;
  nombrebin:String;
  l:libror;
  opcion:integer;
  isbn1:longInt;
begin
  writeln('Escribir nombre del archivo binario:');
  readln(nombrebin);
  assign(archb,nombrebin);
  rewrite(archb);
  assign(tlibro,'libros.txt');
  Reset(tlibro);
  while(not eof(tlibro)) do begin
    read(tlibro,l.isbn,l.titulo);
    readln(tlibro,l.ano,l.editorial);
    readln(tlibro,l.genero);
    write(archb,l);
  end;
  writeln('Escriba 1 si se quiere agregar un libro, 2 si se quiere modificar un libro, cualquier otro numero de no querer hacer nada:');
  readln(opcion);
  if (opcion=1) then begin
    writeln('escriba isbn del libro seguido de titulo, del año, de la editorial y para finalizar genero');
    with l do readln(isbn,titulo,ano,editorial,genero);
    write(archb,l);
    readln
  end
  else
      if (opcion=2) then begin
        writeln('escriba isbn a buscar:');
        readln(isbn1);
        reset(archb);
        while ((not eof(archb)) or (isbn1<>l.isbn)) do begin
           read(archb,l);
        end;
        if (not eof(archb))then begin
           seek(archb,filepos(archb)-1);
           writeln('escriba titulo del libro a modificar seguido del año, de la editorial y para finalizar genero');
           with l do readln(isbn,titulo,ano,editorial,genero);
        end;
      end;
end.

