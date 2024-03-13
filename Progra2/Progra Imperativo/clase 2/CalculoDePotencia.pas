program CalculoDePotencia;
{PROGRAMA PRINCIPAL}
function potencia(x,n:integer):integer;
begin
     if (n=0) then
        potencia:=1
     else
        potencia:=x*potencia(x,n-1);
end;
function potencia1(x,n: integer):integer;
begin
     potencia1:=x*potencia1(x,n-1);  //error bucle
end;
function potencia2(x,n:integer):integer;
begin
     if(n=0) then
        potencia2:=1
     else
        potencia2:=x*potencia2(x,n);  //error bucle
end;

var
   n, x: integer;
begin
     write ('Ingrese base: ');
     Readln (n);
     write ('Ingrese exponente: ');
     Readln (x);
     write(potencia(x,n));
     readln;
end.
