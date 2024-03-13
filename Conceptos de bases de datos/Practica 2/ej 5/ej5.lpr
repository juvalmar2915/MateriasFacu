program ej5;
const
  valoralto='zzz';
type
  municipio=record
    partido:String[255];
    localidad:String[255];
    barrio:String[255];
    ninios:integer;
    adultos:integer;
  end;
  archm=file of municipio;
procedure leer(var archivo: archm; var dato: municipio);
begin
  if(not eof(archivo)) then
    read(archivo, dato)
  else
    dato.partido:= 'zzz';
end;
var
  arch:archm;
  nombre:String;
  m:municipio;
  partidoact:String;
  localidadact:String;
  i:integer;
  cantninloc:integer;
  cantadultloc:integer;
  totalnin:integer;
  totaladult:integer;
begin
  write('inserte nombre del archivo:');
  read(nombre);
  assign(arch,nombre);
  reset(arch);
  leer(arch, m);
  i:=1;
  while (m.partido <> valoralto) do begin
    partidoact:=m.partido;
    writeln('Partido:');
    totalnin:=0;
    totaladult:=0;
    while (m.partido = partidoact) do begin
      localidadact:=m.localidad;
      writeln('Localidad',i,':');
      cantninloc:=0;
      cantadultloc:=0;
      while (m.localidad = localidadact) and (m.partido = partidoact)do begin
        cantninloc:=cantninloc+m.ninios;
        cantadultloc:=cantadultloc+m.adultos;
        writeln('nombre del Barrio: ',m.barrio,' Cantidad niños: ',m.ninios,' Cantidad adultos: ',m.adultos);
        leer(arch,m);
      end;
      writeln('Total niños localidad ',i,':',cantninloc,'Total adultos localidad ',i,':',cantadultloc);
      totalnin:=totalnin+cantninloc;
      totaladult:=totaladult+cantadultloc;
      i:=i+1;
    end;
    writeln('Total niños Partido:',totalnin,'Total adultos Partido:',totaladult);
  end;
  close(arch);
end.

