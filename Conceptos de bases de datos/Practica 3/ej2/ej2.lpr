program ej2;
Type
    tVehiculo= Record
      codigoVehiculo:integer;
      patente: String[255];
      motor:String[255];
      cantidadPuertas: integer;
      precio:real;
      descripcion:String[255];
    end;
    tArchivo = File of tVehiculo;
Procedure agregar (var arch: tArchivo; vehiculo: tVehiculo);
var
  sLibre:tVehiculo;
  cod:integer;
  nLibre:integer;
begin
  Reset(arch);
  Read(arch, sLibre);
  Val(sLibre.descripcion, nLibre,cod);
  If (nLibre= -1) then
     Seek(arch, FileSize(arch))
  else begin
  Seek(arch, nLibre);
  Read(arch, sLibre);
  Seek(arch, 0);
  Write(arch, sLibre);
  Seek(arch, nLibre);
  end;
  Write(arch, vehiculo);
  Close(arch);
end;
Procedure eliminar (var arch: tArchivo; codigoVehiculo: integer);
var
  sLibre:tVehiculo;
  nLibre:integer;
  v:tVehiculo;
Begin
  Reset(arch);
  Read(arch, sLibre);
  v:=sLibre;
  While not ((v.codigoVehiculo=codigoVehiculo) or EoF(arch)) do begin
     Read(arch, v);
  end;
  if (v.codigoVehiculo=codigoVehiculo) then begin
     nLibre:=FilePos(arch)-1;
     Seek(arch, nLibre);
     Write(arch, sLibre);
     Str(nLibre, sLibre.descripcion);
     Seek(arch, 0);
     Write(arch, sLibre);
  end
  else Begin
     WriteLn('No existe ese vehiculo.');
  end;
  Close(arch);
end;

begin
end.

