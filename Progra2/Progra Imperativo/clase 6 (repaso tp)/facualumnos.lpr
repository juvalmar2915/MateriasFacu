program facualumnos;
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
        writeln ('  ',Promedio (a^.l):0:2);
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

procedure crearlista(var l:listafacu);
var
  vec:array[1..5] of string;
  veccod:array[1..5] of integer;
  i,int:integer;
  nodo:listafacu;
begin
  Randomize;
  while (random(100)<>0) do begin
    i:=random(2000)+10000;
    vec[1]:='Jose';
    vec[2]:='Carlos';
    vec[3]:='Pedro';
    vec[4]:='Valentin';
    vec[5]:='Pascu';
    veccod[1]:=10928;
    veccod[2]:=10883;
    veccod[3]:=11000;
    veccod[4]:=10233;
    veccod[5]:=10001;
    new(nodo);
    int:=random(5);
    nodo^.dato.nombreAlumno:=vec[int+1];
    nodo^.dato.codigoAlumno:=veccod[int+1];
    nodo^.dato.CodigoMateria:=random(20);
    nodo^.dato.Fechafinal.dia:=random(30)+1;
    nodo^.dato.Fechafinal.mes:=random(12)+1;
    nodo^.dato.Fechafinal.ano:=random(100)+1950;
    nodo^.dato.Notafinal:=random(10)+1;
    if (l=nil) then begin
      l:=nodo;
      l^.sig:=nil
    end
    else begin
      nodo^.sig:=l;
      l:=nodo;
    end;
  end;
end;

procedure contar(a:arbol; var i:integer);
begin
  if (a<>nil) then begin
    contar(a^.HI,i);
    contar(a^.HD,i);
    i:=i+1;
  end;
end;

var
 l:listafacu;
 a:arbol;
 i:integer;
begin
  crearlista(l);
  generarnuevaestructura(l,a);
  recorrerarbol(a);
  i:=0;
  contar(a,i);
  writeln(i);
  readln;
end.
