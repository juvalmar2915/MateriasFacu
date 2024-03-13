program Recursion;

var 
  num, maximo: integer;

function digitoMaximo(n: integer; max: integer):integer;
var
  dig: integer;
begin
  dig:= n mod 10;
  if ( dig > max ) then
    max:= dig;
  n:= n div 10;
  if (n <> 0) then        // act 4b: caso base cuando n es igual a 0
    max:= digitoMaximo(n, max);
  digitoMaximo:=max;
    // act 4b: se acerca al caso base dividiendo al entero positivo de 10 en 10
  writeln ('max: ', max); // act 5c: se muestra el ultimo maximo obtenido al igual que en el programa principal
end;                      // act 6c: se muestra el valor de cada maximo empezando por el mas grande, el programa principal mostrara -1 ya que max no esta pasado por referencia

Begin
  maximo := -1;
  writeln( 'Ingrese un entero no negativo:');
  readln (num);
  writeln ( 'El digito maximo del numero ', num, ' es: ', digitoMaximo (num, maximo));
  readln;
End.

