program ProgramaVectorOrdenado;

const
    dimF = 8;  {Dimensión física del vector}

type

    vector = array [1..dimF] of integer;

    dim = 0..dimF;

{-----------------------------------------------------------------------------
CARGARVECTORORDENADO - Carga ordenadamente nros aleatorios entre 0 y 100 en el
vector hasta que llegue el nro 99 o hasta que se complete el vector}

Procedure cargarVectorOrdenado ( var vec: vector; var dimL: dim);
var
   d, pos, j: integer;
begin
    Randomize;  { Inicializa la secuencia de random a partir de una semilla}
    dimL := 0;
    d:= random(100);
    while (d <> 99)  and ( dimL < dimF ) do begin
       pos:= 1;
       while (pos <= dimL) and (vec[pos]< d) do pos:= pos + 1;
       for  j:= dimL downto pos do vec[j+1]:= vec[j] ;
       vec[pos]:= d;
       dimL := dimL + 1;
       d:= random(100)
     end;
end;

{-----------------------------------------------------------------------------
IMPRIMIRVECTOR - Imprime todos los nros del vector }

Procedure imprimirVector ( var vec: vector; var dimL: dim );
var
   i: dim;
begin
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     write (' ');
     for i:= 1 to dimL do begin
        if(vec[i] < 9)then
            write ('0');
        write(vec[i], ' | ');
     end;
     writeln;
     for i:= 1 to dimL do
         write ('-----');
     writeln;
     writeln;
End;

Procedure Busqueda (vec:vector; num:integer; DimL:integer; dimi:integer);
var
   diml1:integer;
begin
    Diml1:=dimi+diml div 2;
    if (dimi+diml=0) then
      writeln('no se encontro, vector vacio')
    else
      if (num=vec[diml1]) then
         writeln('se encontro')
      else
        if (diml-dimi=1) and (num<>vec[diml1]) then
          writeln('no se encontro')
        else
          if (num<vec[diml1]) then
            Busqueda(vec, num, diml1, dimi)
          else
            Busqueda(vec, num, diml, diml1+1);
end;

{PROGRAMA PRINCIPAL}
var
   v: vector;
   dimL : dim;
   num:integer;
   dimi : integer;
begin

     cargarVectorOrdenado(v,dimL);

     writeln('Nros almacenados: ');
     imprimirVector(v, dimL);
     writeln ('Ingresar numero a buscar');
     readln (num);
     dimi:=0;
     busqueda(v,num,dimL,dimi);

     readln;
end.
