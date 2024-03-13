program ej5;
type
    articulo=record
      nro:integer;
      desc:string[255];
      color:string[255];
      talle:integer;
      stock:integer;
      precio:integer;
    end;
    arch=file of articulo;
procedure bajalogica(var f:arch);
var
  eliminar:integer;
  t:text;
  art:articulo;
  aux:integer;
begin
  assign(t,'tucson');
  rewrite(t);
  read(eliminar);
  while(eliminar<>-1) do begin
    read(f,art);
    while(not eof(f)) and (art.nro<>eliminar) do begin
      read(f,art);
    end;
    if (art.nro=eliminar) then begin
      seek(f,filepos(f)-1);
      with art do writeln(t,nro,color,desc,precio,stock,talle);
      art.nro:=-1;
      write(f,art);
    end
    else begin
      write('no existe ese art');
    end;
    aux:=eliminar;
    read(eliminar);
    if(eliminar<aux)then begin
      seek(f,0);
    end;
  end;
  close(t);
end;

var
  a:arch;
begin
  assign(a,'arch');
  reset(a);
  bajalogica(a);
  close(a);
end.

