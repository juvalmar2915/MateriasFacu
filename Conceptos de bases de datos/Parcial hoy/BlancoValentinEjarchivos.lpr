program BlancoValentinEjarchivos;
type
  articulo = record
    cod: longInt;
    desc: string[255];
    precio: real;
  end;
  archArt= file of articulo;
{Agrega un artículo el cual se recibe como parámetro y debe utilizar la política descripta anteriormente.}
Procedure agregar (var arch: archArt; art: articulo);
var
  slibre:articulo;
  nlibre:LongInt;
begin
     reset(arch);
     read(arch,slibre);
     if(slibre.cod=0) then begin
        seek(arch,FileSize(arch));
        write(arch,art);
     end
     else begin
          nlibre:=0-slibre.cod;
          seek(arch,nlibre);
          read(arch,slibre);
          seek(arch,0);
          write(arch,slibre);
          seek(arch,nlibre);
          write(arch,art);
     end;
end;
{Crear archivo manteniendo la política descripta anteriormente y carga los artículos que se leen desde teclado hasta recibir el código 000}
Procedure crearycargar(var arch: archArt);
var
  artic:articulo;
begin
     rewrite(arch);
     artic.cod:=0;
     artic.desc:='';
     artic.precio:=0;
     write(arch,artic); //escribo encabezado
     writeln('escriba parametros del articulo, Primero el precio, luego la descripcion y por ultimo el codigo');
     readln(artic.precio);
     readln(artic.desc);
     readln(artic.cod);
     while (artic.cod<>000) do begin
           agregar(arch,artic);
           write('escriba parametros del articulo, Primero el precio, luego la descripcion y por ultimo el codigo');
           readln(artic.precio);
           readln(artic.desc);
           readln(artic.cod);
     end;
     close(arch);
end;
var
  arch1:archArt;
  a:articulo;
begin
  assign(arch1,'datos.dat');
  crearycargar(arch1);
  reset(arch1);
  repeat
     read(arch1,a);
     writeln(a.cod);
     writeln(a.desc);
     writeln(a.precio);
  until (eof(arch1));
  ReadLn;
end.
