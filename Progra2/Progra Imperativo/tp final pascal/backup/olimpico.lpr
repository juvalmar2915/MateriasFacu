Program olimpico;
Uses
	sysutils;
Type
	sub = 1..4;

	disciplina = record
		cod: integer;
		codDisciplina: integer;
		nombreDisciplina: string;
		puesto: sub;
		nombreAtleta: string;
		pais: string;
	end;

	listaDisciplinas = ^nodoLista;
	nodoLista = record
		dato: disciplina;
		sig: listaDisciplinas;
	end;
    listapaises=^nodopaises;
    nodopaises=record
        dato:string;
        sig:listapaises;
    end;
    arboldisciplinas = ^nodoarbol;
    nodoarbol = record
      cod:integer;
      nombre:string;
      Atletas:integer;
      paises:listapaises;
      HI,HD:arboldisciplinas;
    end;

{-----------------------------------------------------------------------------
AgregarOrdenado - Agrega ordenado en l}
Procedure agregarOrdenado(var l: listaDisciplinas; d: disciplina);
var
   nuevo, anterior, actual: listaDisciplinas;
begin
	new (nuevo);
	nuevo^.dato:= d;
	nuevo^.sig := nil;

	actual := l;
	anterior := l;
	while (actual<>nil) and (actual^.dato.pais < nuevo^.dato.pais) do begin
	   anterior := actual;
	   actual:= actual^.sig;
	end;
	if (anterior = actual) then
	   l := nuevo
	else
	   anterior^.sig := nuevo;
	nuevo^.sig := actual;
end;

{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista }
procedure crearLista(var l: listaDisciplinas);
var
  aux: integer;
  d: disciplina;
begin
  l:= nil;
  d.cod := random (100);

  while (d.cod <> 0) do Begin
        aux:=random(193)+1;
        if(aux<10)then
            d.pais:= Concat('Pais00',IntToStr(aux))
        else
            if(aux<100)then
                d.pais:= Concat('Pais0',IntToStr(aux))
	    else
                d.pais:= Concat('Pais',IntToStr(aux));
	d.codDisciplina:= random (299)+1;
	d.nombreDisciplina:= Concat('Disciplina', IntToStr(d.codDisciplina));
	d.puesto:= random (3)+1;
	d.nombreAtleta:= Concat('Atleta', IntToStr(random(5000)));
	agregarOrdenado(l,d);
	d.cod := random (100);
  end;
end;

Procedure imprimir(d:disciplina);
begin
  writeln(' ', d.coddisciplina);
  writeln(' ', d.nombredisciplina);
  //write(' ', d.puesto);
  //write(' ', d.nombreatleta);
  //write(' ', d.pais);
end;

{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: listaDisciplinas);
begin
  while (l <> nil) do begin
   imprimir(l^.dato); //Completar el algoritmo para validar
   l:= l^.sig;
  end;
end;

procedure crear_lista_Paises (var l:listapaises; p:string);
var
    nue:listapaises;
begin
    new(nue);
    nue^.dato:=p;
    nue^.sig:=l;
    l:=nue;
    end;

procedure crear_arbol (var a:arboldisciplinas; d:disciplina); {Genera el arbol}
begin
 if (a = nil) then begin
   new(a);
   a^.cod:= d.coddisciplina;
   a^.nombre:=d.nombredisciplina;
   a^.HD:= nil;
   a^.HI:= nil;
   a^.atletas:=0;
   a^.atletas:= a^.atletas + 1;
   a^.paises:=nil;
   crear_lista_paises (a^.paises,d.pais);
 end
 else
   if (a^.cod > d.cod) then begin
     crear_arbol (a^.HI,d)
   end
   else
     if (a^.cod < d.cod) then begin
       crear_arbol (a^.HD,d)
     end
     else begin
       if (a^.cod = d.cod) then begin
         a^.atletas:= a^.atletas + 1;
         if (a^.paises^.dato<>d.pais) then
           crear_lista_paises(a^.paises,d.pais);
       end;
     end;
 end;

procedure reco_lista (var a:arboldisciplinas;l:listadisciplinas);
begin
    while (l <> nil) do begin
        crear_arbol(a,l^.dato);
        l:=l^.sig;
    end;
end;

procedure reco_arbol (a:arboldisciplinas); {Recorro el arbol para informar los atletas con codigo 100 y 200}
begin
 if (a <> nil) then begin
  if (a^.cod > 100) then begin
   if (a^.cod < 200) then  begin
     writeln('la cantidad de atletas del codigo ',a^.cod, ' es de: ',a^.atletas);
     reco_arbol (a^.HI);
     reco_arbol (a^.HD);
     end
   else
       reco_arbol(a^.HI);
  end
  else
      reco_arbol(a^.HD);
   end;
end;

Procedure atletas100a200 (a:arboldisciplinas);
begin
  if (a<>nil) then begin
    if (a^.atletas>2) and (a^.atletas<4) then
       writeln('la disciplina es: ',a^.nombre, 'con cantidad de atletas de: ',a^.atletas);
    atletas100a200 (a^.HI);
    atletas100a200 (a^.HD);
  end;
end;


Var

 l: listaDisciplinas;
 a:arboldisciplinas;
begin
 Randomize;

 crearLista(l);
 writeln ('Lista generada: ');
 imprimirLista(l);
 a:=nil;
 writeln('Fin del programa');
 reco_lista(a,l);
 reco_arbol(a);
 atletas100a200(a);
 readln;
end.
