program ej5;
type
  flor=record
    nro:integer;
    altura:real;
    nombrec:String[255];
    nombrev:String[255];
    color:String[255];
  end;
  farch=File Of flor;

var
 f:flor;
 totalespecies:integer;
 minalt:real;
 maxalt:real;
 especiemax:String;
 especiemin:String;
 lectura:farch;
 carga:text;
 nombrearch:String;
 presiono:integer;
begin
  totalespecies:=0;
  minalt:=999;
  maxalt:=0;
  presiono:=0;
  writeln('ingresar nombre archivo: ');
  readln(nombrearch);
  assign(lectura,nombrearch);
  assign(carga,'flores.txt');
  rewrite(lectura);
  rewrite(carga);
  writeln('ingresar numero especie: ');
  readln(f.nro);
  writeln('ingresar altura maxima: ');
  readln(f.altura);
  writeln('ingresar nombre cientifico: ');
  readln(f.nombrec);
  writeln('ingresar nombre vulgar: ');
  readln(f.nombrev);
  writeln('ingresar color: ');
  readln(f.color);
  while(f.nombrec <> 'zzz') do begin
     totalespecies:=totalespecies+1;
     if (f.altura>maxalt) then begin
        maxalt:=f.altura;
        especiemax:=f.nombrec;
     end;
     if (f.altura<minalt) then begin
        minalt:=f.altura;
        especiemin:=f.nombrec;
     end;
     if (f.nombrec='Victoria amazonia') then begin
        f.nombrec:='Victoria amazonica';
     end;
     write(lectura,f);
     writeln(f.nro,' ',f.altura:0:2,' ',f.color,' ',f.nombrec,' ',f.nombrev);
     writeln(carga,f.nro,f.altura,f.color,f.nombrec,f.nombrev);
     writeln('ingresar numero especie: ');
     readln(f.nro);
     writeln('ingresar altura maxima: ');
     readln(f.altura);
     writeln('ingresar nombre cientifico: ');
     readln(f.nombrec);
     writeln('ingresar nombre vulgar: ');
     readln(f.nombrev);
     writeln('ingresar color: ');
     readln(f.color);
  end;
  write('presione 1 si quiere seguir cargando especies');
  if (presiono=1) then begin
     seek(lectura,filesize(lectura)-1);
     writeln('ingresar numero especie: ');
     readln(f.nro);
     writeln('ingresar altura maxima: ');
     readln(f.altura);
     writeln('ingresar nombre cientifico: ');
     readln(f.nombrec);
     writeln('ingresar nombre vulgar: ');
     readln(f.nombrev);
     writeln('ingresar color: ');
     readln(f.color);
     while (f.nombrec <> 'zzz') do begin
           write(lectura,f);
           writeln(f.nro,' ',f.altura:0:2,' ',f.color,' ',f.nombrec,' ',f.nombrev);
           writeln('ingresar numero especie: ');
           readln(f.nro);
           writeln('ingresar altura maxima: ');
           readln(f.altura);
           writeln('ingresar nombre cientifico: ');
           readln(f.nombrec);
           writeln('ingresar nombre vulgar: ');
           readln(f.nombrev);
           writeln('ingresar color: ');
           readln(f.color);
           end;
  end;
  close(lectura);
  close(carga);
end.

