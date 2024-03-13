Program twitter;
Uses
	sysutils;
Type
	tweet = record
		codigoUsuario: integer;
		nombreUsuario: string;
		mensaje: string;
		esRetweet: boolean;
	end;

	listaTweets = ^nodoLista;
	nodoLista = record
		dato: tweet;
		sig: listaTweets;
	end;


        usuario=record
            codigo:integer;
            nombre:string;
          end;
        mensaje=record
            m:string;
            esrt:boolean;
        end;
        listamensaje=^nodomensaje;
        nodomensaje=record
            dato:mensaje;
            sig:listamensaje;
          end;
        arbol=^nodoarbol;
	nodoarbol=record
          dato:usuario;
          l:listamensaje;
          hi:arbol;
          hd:arbol;
        end;


{-----------------------------------------------------------------------------
AgregarAdelante - Agrega nro adelante de l}

Procedure agregarAdelante(var l: listaTweets; t: tweet);
var
  aux: listaTweets;
begin
  new(aux);
  aux^.dato := t;
  aux^.sig := l;
  l:= aux;
end;



{-----------------------------------------------------------------------------
CREARLISTA - Genera una lista con tweets aleatorios }
procedure crearLista(var l: listaTweets);
var
  t: tweet;
  texto: string;
  v : array [1..10] of string;
begin

 v[1]:= 'juan';
 v[2]:= 'pedro';
 v[3]:= 'carlos';
 v[4]:= 'julia';
 v[5]:= 'mariana';
 v[6]:= 'gonzalo';
 v[7]:='alejandra';
 v[8]:= 'silvana';
 v[9]:= 'angie';
 v[10]:= 'hernan';

 l:= nil;
 t.codigoUsuario := random (1000);

 while (t.codigoUsuario <> 0) do Begin
   texto:= Concat(v[(t.codigoUsuario mod 10)], '-mensaje-', IntToStr(random (100)));
   t.nombreUsuario := v[(t.codigoUsuario mod 10)];
   t.mensaje := texto;
   t.esRetweet := (random (1) = 0);
   agregarAdelante(l, t);
   t.codigoUsuario := random (1000);
 End;
end;


{-----------------------------------------------------------------------------
IMPRIMIRLISTA - Muestra en pantalla la lista l }
procedure imprimirLista(l: listaTweets);
begin
 While (l <> nil) do begin
   write(' ',l^.dato.codigousuario,' ');
   {write('Nombre usuario',l^.dato.nombreUsuario);
   write('Tweet',l^.dato.mensaje);
   write('Es retweet',l^.dato.esRetweet);}
   l:= l^.sig;
 End;
end;

{-----------------------------------------------------------------------------
AGREGARELEMENTO - Resuelve la inserci�n de la estructura de la ACTIVIDAD 1}
procedure agregarElemento ( VAR a:arbol; l:listatweets);
var
  nue:listamensaje;
begin
 if (a=nil) then begin
   new (a);
   a^.dato.codigo:=l^.dato.codigousuario;
   a^.dato.nombre:=l^.dato.nombreusuario;
   new (a^.l);
   a^.l^.dato.m:=l^.dato.mensaje;
   a^.l^.dato.esrt:=l^.dato.esRetweet;
   a^.hi:=nil;
   a^.hd:=nil;
   a^.l^.sig:=nil;
 end
 else begin
     if (a^.dato.codigo>l^.dato.codigousuario) then
        agregarelemento(a^.hi,l)
     else begin
        if (a^.dato.codigo<l^.dato.codigousuario) then
           agregarelemento(a^.hd,l)
        else begin
            new (nue);
            nue^.dato.m:=l^.dato.mensaje;
            nue^.dato.esrt:=l^.dato.esRetweet;
            nue^.sig:=a^.l;
            a^.l:=nue;
          end;
     end;
 end;
 end;
{-----------------------------------------------------------------------------
GENERARNUEVAESTRUCTURA - Resuelve la generaci�n de la ACTIVIDAD 1}
procedure generarNuevaEstructura (l:listatweets; VAR a:arbol);
begin
  while (l<>nil) do begin
    agregarElemento (a, l);
    l:=l^.sig;
  end;
end;

{-----------------------------------------------------------------------------
CANTIDADTWEETS - Resuelve la cuenta de elementos de la ACTIVIDAD 2   }
Function cantidadTweets (l:listamensaje):integer;
var
 int:integer;
begin
  int:=0;
  while (l<>nil) do begin
    int:=int+1;
    l:=l^.sig;
  end;
  cantidadTweets:=int;
end;

{-----------------------------------------------------------------------------
RECORRERARBOL - Resuelve el recorrido de la ACTIVIDAD 2}
procedure recorrerArbol(a:arbol);
begin
  if (a<>nil) then begin
    if (a^.dato.codigo >= 200) then begin
      if (a^.dato.codigo <= 700) then begin
        write ('  ',cantidadTweets (a^.l));
        if (a^.dato.codigo=200) then
           recorrerArbol (a^.hd)
        else begin
          if (a^.dato.codigo=700) then
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



Var
 a: arbol;
 l: listaTweets;
 {Completar agregando variables}

begin
 Randomize;

 crearLista(l);
 writeln ('Lista generada: ');
 imprimirLista(l);
 generarNuevaEstructura(l,a);
 {Completar el programa}

 writeln('Fin del programa');
 recorrerArbol(a);
 readln;
end.
