program ej4;

type
  cd=record
    cod:integer;
    nombre:string[255];
    genero:string[255];
    artista:string[255];
    anio:integer;
    cant:integer;
  end;
  arch=file of cd;
procedure modificar(var a:arch);
var
  busqueda:cd;
  cod:integer;
begin
  reset(a);
  write('inserte codigos');
  read(cod);
  while (cod<>-1) do begin
    seek(a,0);
    read(a,busqueda);
    while(not eof(a)) and (cod<>busqueda.cod) do begin
      read(a,busqueda);
    end;
    if(cod=busqueda.cod) then begin
      writeln(busqueda.nombre);
      seek(a,filepos(a)-1);
      busqueda.cant:=0;
      write(a,busqueda);
    end
    else begin
      write('no se encontro reg');
    end;
  end;
  close(a);
end;
procedure compactar(var a:arch);
var
  r:cd;
  estoy:integer;
  aux:cd;
begin
  reset(a);
  read(a,r);
  repeat
    if(r.cant=0) then begin
      estoy:=filepos(a)-1;
      seek(a,filesize(a)-1);
      read(a,aux);
      seek(a,estoy);
      write(a,aux);
      seek(a,filesize(a)-1);
      truncate(a);
      seek(a,estoy);
    end;
    read(a,r);
  until(not(eof(a)));
  close(a);
end;


begin
end.

