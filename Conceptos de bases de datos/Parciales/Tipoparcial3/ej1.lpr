program ej1;
type
  arch=file of String[255];
procedure agregrar(var m:arch;str:string);
var
   slibre:string[255];
   sigpos:integer;
   validar:integer;
   aux:string[255];
begin
  reset(m);
  read(m,slibre);
  val(slibre,sigpos);
  if (sigpos>0) and (sigpos<filesize(m)) then begin
    seek(m,sigpos);
    read(m,aux);
    seek(m,0);
    write(m,aux);
    seek(m,sigpos);
  end
  else
    seek(m,filesize(m));
  write(m,str);
  close(m);
end;

procedure eliminar(var m:arch;str:string);
var
  reg:string[255];
  slibre:string[255];
  i:integer;
begin
  reset(m);
  read(m,slibre);
  read(m,reg);
  while(str<>reg) do begin
    read(m,reg);
  end;
  if (str<>reg) then begin
     write('no se encontro reg a eliminar');
  end
  else begin
    seek(m,filepos(m)-1);
    write(m,slibre);
    i:=filepos(m);
    str(i,slibre);
    seek(m,0);
    write(m,slibre);
  end;
  close(m);
end;

procedure crear(var m:arch);
var
   nombre:string;
begin
  rewrite(m);
  read(nombre);
  while (nombre<>'') do begin
    write(m,nombre);
    read(nombre);
  end;
  close(m);
end;
begin
end.

