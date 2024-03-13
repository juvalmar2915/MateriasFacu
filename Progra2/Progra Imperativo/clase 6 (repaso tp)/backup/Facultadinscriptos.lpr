program Facultadinscriptos;
Type
  fecha=record
    dia:1..31;
    mes:1..12;
    ano:integer;
  end;
  Alumno = record
    codigoAlumno: integer;
    nombreAlumno: string;
    CodigoMateria: integer;
    Fechafinal: fecha;
    Notafinal:real;
  end;
  listafacu=^nodofacu;
  nodofacu=record
    dato:alumno;
    sig:listafacu;
  end;
  nota=record
    notafinal:real;
    fechafinal:fecha;
    codigomateria:integer;
  end;
  listanotas=^nodonotas;
  nodonotas=record
    dato:nota;
    sig:listanotas;
  end;
  alumnoconcodigo=record
    codigo:integer;
    nombre:string;
  end;
  arbol=^nodoarbol;
  nodoarbol=record
    dato:alumnoconcodigo;
    l:listanotas;
    hi:arbol;
    hd:arbol;
  end;

Procedure generararbol (var a:arbol; al:alumno);
var
  nue:listanotas;
begin
 if (a=nil) then begin
   new (a);
   a^.dato.codigo:=al.codigoalumno;
   a^.dato.nombre:=al.nombrealumno;
   new (a^.l);
   a^.l^.dato.notafinal:=al.notafinal;
   a^.l^.dato.codigomateria:=al.codigomateria;
   a^.l^.dato.fechafinal:=al.fechafinal;
   a^.hi:=nil;
   a^.hd:=nil;
   a^.l^.sig:=nil;
 end
 else begin
     if (a^.dato.codigo>al.codigoalumno) then
        generararbol(a^.hi,al)
     else begin
        if (a^.dato.codigo<al.codigoalumno) then
           generararbol(a^.hd,al)
        else begin
            new (nue);
            nue^.dato.notafinal:=al.notafinal;
            nue^.dato.codigomateria:=al.codigomateria;
            nue^.dato.fechafinal:=al.fechafinal;
            nue^.sig:=a^.l;
            a^.l:=nue;
          end;
     end;
 end;
 end;

Procedure generarnuevaestructura(l:listafacu;var a:arbol);
begin
  while l<>nil do begin
    generararbol(a,l^.dato);
    l:=l^.sig;
  end;
end;

function promedio(l:listanotas):real;
var
  notas:real;
  total:real;
begin
  notas:=0;
  total:=0;
  while (l<>nil) do begin
    notas:=notas+l^.dato.notafinal;
    total:=total+1;
    l:=l^.sig;
  end;
  promedio:=notas/total;
end;

procedure recorrerArbol(a:arbol);
begin
  if (a<>nil) then begin
    if (a^.dato.codigo >= 10000) then begin
      if (a^.dato.codigo <= 11000) then begin
        write(a^.dato.nombre);
        write ('  ',Promedio (a^.l));
        if (a^.dato.codigo=10000) then
           recorrerArbol (a^.hd)
        else begin
          if (a^.dato.codigo=11000) then
             recorrerArbol (a^.hi)
          else begin
	    recorrerArbol (a^.hi);
	    recorrerArbol (a^.hd);
          end;
        end;
      end
      else
        recorrerArbol (a^.hi)
    end
    else
      recorrerArbol (a^.hd);
  end;
end;

function contar(a:arbol):integer;
var
  int:integer;
begin
 if (a<>nil) then begin
   contar:=contar(a^.hi);
   contar:=contar(a^.hd);
   int:=int+1;
 end;
end;

var
 l:listafacu;
 a:arbol;
 i:integer;
begin
  generarnuevaestructura(l,a);
  recorrerarbol(a);
  i:=contar(a);
  writeln(i);
  readln;
end.

