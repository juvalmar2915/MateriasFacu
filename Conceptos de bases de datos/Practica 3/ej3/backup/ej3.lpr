program ej3;
Type
    Indumentaria= Record
      codigo:integer;
      nombre: String[255];
      descripcion:String[255];
      stock:integer;
    end;
    Archivocrear = File of Indumentaria;
Procedure crearbin (var arch: text); //a)
var
  acrear:Archivocrear;
  r:Indumentaria;
begin
  assign(acrear,'indumentarias.dat');
  rewrite(acrear);
  While not (eof(arch)) do begin
       with r do readln(arch,codigo,nombre,descripcion,stock);
       write(acrear,r);
  end;
  writeln('se genero el archivo indumentarias.dat');
  close(acrear);
end;

Procedure crearbin2 (var arch: text); //f)
var
  acrear:Archivocrear;
  r:Indumentaria;
begin
  assign(acrear,'indumentarias.dat');
  rewrite(acrear);
  r.stock:=-1;
  write(acrear,r);
  While not (eof(arch)) do begin
       with r do readln(arch,codigo,nombre,descripcion,stock);
       write(acrear,r);
  end;
  writeln('se genero el archivo indumentarias.dat');
  close(acrear);
end;

Procedure bajalogica (codo: integer); //b)
var
  arch:Archivocrear;
  i:Indumentaria;
  nLibre:integer;
Begin
  assign(arch,'indumentarias.dat');
  Reset(arch);
  Read(arch, i);
  While not ((i.codigo=codo) or EoF(arch)) do begin
     Read(arch, i);
  end;
  if (i.codigo=codo) then begin
     nLibre:=FilePos(arch)-1;
     Seek(arch, nLibre);
     i.stock:=-1;
     Write(arch, i);
  end
  else Begin
     WriteLn('No existe esa indumentaria.');
  end;
  Close(arch);
end;

Procedure bajalogica2 (codo: integer); //d)
var
  nlibre:integer;
  slibre:Indumentaria;
  r:indumentaria;
  a:Archivocrear;
begin
  assign(a,'indumentarias.dat');
  Reset(a);
  Read(a, sLibre);
  Read(a, r);
  While (not((r.codigo=codo) or EoF(a))) do begin
     Read(a, r);
  end;
  If (r.codigo=codo) then begin {se encuentra la raza}
    nlibre:=FilePos(a)-1;
    Seek(a, nlibre);
    Write(a, slibre);
    slibre.stock:=nlibre;
    Seek(a, 0);
    Write(a, sLibre);
  end
  else Begin {no se encuentra la raza}
    WriteLn('No existe esa indumentaria.');
  end;
  Close(a);
end;

Procedure alta (ind: Indumentaria); //c)
var
  arch:Archivocrear;
  i:Indumentaria;
  nLibre:integer;
Begin
  assign(arch,'indumentarias.dat');
  Reset(arch);
  Read(arch, i);
  While not ((i.stock=-1) or EoF(arch)) do begin
     Read(arch, i);
  end;
  if (i.stock=-1) then begin
     nLibre:=FilePos(arch)-1;
     Seek(arch, nLibre);
  end;
  Write(arch, ind);
  Close(arch);
end;

Procedure alta2 (ind: Indumentaria); //e)
var
  a:Archivocrear;
  nlibre:integer;
  slibre:Indumentaria;
  r:indumentaria;
begin
  assign(a,'indumentarias.dat');
  Reset(a);
  Read(a, sLibre);
  nlibre:=sLibre.stock;
  If (nLibre= -1) then
    Seek(a, FileSize(a))
  else begin
    Seek(a, nLibre);
    Read(a, sLibre);
    Seek(a, 0);
    Write(a, sLibre);
    Seek(a, nLibre);
  end;
  Write(a, ind); {Guarda la raza}
  Close(a);
end;

var
  arch:text;
  nombre:string;
  codobsoleto:integer;
  ind:Indumentaria;
begin
  writeln('indique el nombre del archivo de texto con indumentarias: ');
  read(nombre);
  assign(arch,nombre);
  reset(arch);
  crearbin(arch);
  writeln('inserte cod obsoleto a eliminar:');
  read(codobsoleto);
  while (codobsoleto <> -1) do begin
        bajalogica(codobsoleto);
        writeln('inserte cod obsoleto a eliminar: (si desea finalizar ponga codigo -1)');
        read(codobsoleto);
  end;
  writeln('escriba stock, nombre, descripcion y codigo de producto');
  with ind do read(stock,nombre,descripcion,codigo);
  alta(ind);
  //g) para las bajas da igual usar o no lista invertida en cambio en altas se realiza acceso directo para lista invertida y secuencial en caso de no usarla
end.


