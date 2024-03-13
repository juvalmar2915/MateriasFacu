program ej5y6;
Type
    artdepor= Record
      nro:integer;
      descripcion: String[255];
      color:String[255];
      talle:real;
      stock:integer;
      precio:real;
    end;
    Archivo = File of artdepor;

Procedure bajalogica (nrob: integer; var arch:Archivo; var arch2:text);
var
  dep:artdepor;
  nLibre:integer;
Begin
  Read(arch, dep);
  While not ((dep.nro=nrob) or EoF(arch)) do begin
     Read(arch, dep);
  end;
  if (dep.nro=nrob) then begin
     with dep do writeln(arch2,nro,descripcion,color,talle,stock,precio);
     nLibre:=FilePos(arch)-1;
     Seek(arch, nLibre);
     dep.nro:=-1;
     Write(arch, dep);
  end
  else Begin
     WriteLn('No existe ese articulo.');
     seek(arch,0);
  end;
end;

Procedure compactar (var arch:Archivo;nombre:String);
var
  archaux:Archivo;
  dep:artdepor;
begin
  assign(archaux,'depaux.dat');
  rewrite(archaux);
  While not (EoF(arch)) do begin
     Read(arch, dep);
     if (dep.nro<>-1) then begin
       write(archaux,dep);
     end;
  end;
  close(archaux);
  close(arch);
  erase(arch);
  rename(archaux,nombre);
end;

var
  arch:Archivo;
  arch2:text;
  nombre:string;
  nroeliminar:integer;
begin
  writeln('indique el nombre del archivo de texto con indumentarias: ');
  read(nombre);
  assign(arch,nombre);
  reset(arch);
  assign(arch2,'deportes.txt');
  rewrite(arch2);
  writeln('inserte nro de articulo a eliminar:');
  read(nroeliminar);
  while (nroeliminar <> -1) do begin
        bajalogica(nroeliminar,arch,arch2);
        writeln('inserte nro de articulo a eliminar: (si desea finalizar ponga nro -1)');
        read(nroeliminar);
  end;
  close(arch2);
  compactar(arch,nombre);
end.


