program ejexamencbd;
type
  venta=record
    codigo:integer;
    nombre:String[255];
    descripcion:String[255];
    cant:integer;
  end;
  mae=file of venta;
procedure generarb(var det:text);
var
  m:mae;
  v:venta;
  total:integer;
  codact:integer;
  excursionact:venta;
begin
  assign(m,'arch.dat');
  rewrite(m);
  repeat
    total:=0;
    with v do readln(det,codigo,nombre,descripcion,cant);
    codact:=v.codigo;
    excursionact:=v;
    while(codact=v.codigo) do begin
         total:=total+v.cant;
         with v do readln(det,codigo,nombre,descripcion,cant);
    end;
    excursionact.cant:=total;
    write(m,excursionact);
  until(eof(det));
  close(m);
end;
begin
end;
