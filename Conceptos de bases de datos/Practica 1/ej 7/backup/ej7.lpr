program ej7;
type
  facultadalumno=record
    DNI:integer;
    legajo:integer;
    nombre:String[255];
    apellido:String[255];
    direccion:String[255];
    ano:integer;
    fechanac:longInt;
  end;
  arch=file of facultadalumno;
var
  option:integer;
  alumtxt:text;
  creararch:arch;
  nombrea:String;
  alum:facultadalumno;
  aux:integer;
  terminacion:String;
  arch2texto:text;
  x:integer;
begin
     aux:=0;
     writeLn('elija una opcion');
     writeLn('0. Terminar el Programa');
     writeLn('1. Crear un archivo de alumnos de la facultad de ingenieria');
     writeLn('2. mostrar nombres con alguna terminacion');
     writeln('3. volcar en un archivo de nombre alumnosaEgresar todos los alumnos que cursan 5to año');
     writeln('4. añadir alumnos al archivo de registros');
     writeln('5. modificar la fecha de un alumno dado');
     readln(option);
     while (option <> 0) do begin
       case option of
          1:begin
            writeln('escriba nombre del archivo con alumnos: ');
             readln(nombrea);
             assign(creararch,nombrea);
             rewrite(creararch);
             assign(alumtxt,'alumnos.txt');
             reset(alumtxt);
             while(not eof(alumtxt)) do begin
                with alum do readln(alumtxt,DNI,legajo,nombre,apellido,direccion,ano,fechanac);
                write(creararch,alum);
             end;
             aux:=1;
             close(creararch);
             close(alumtxt);
          end;
          2:begin
             if (aux=1) then begin
               writeln('inserte una terminacion a buscar');
               readln(terminacion);
               reset(creararch);
               while (not eof(creararch))do begin
                 read(creararch,alum);
                 if (pos(alum.nombre,terminacion)<> 0) then
                    writeln(alum.dni,alum.nombre,alum.apellido,alum.ano,alum.direccion,alum.fechanac,alum.legajo);
               end;
               close(creararch);
             end
             else
                 writeln('todavia no se creo el archivo binario');
             end;
          3:begin
             if (aux=1) then begin
                assign(arch2texto,'alumnosAEgresar.txt');
                rewrite(arch2texto);
                reset(creararch);
                while (not eof(creararch))do begin
                      read(creararch,alum);
                      if (alum.ano=5) then
                         with alum do writeln(arch2texto,DNI,legajo,nombre,apellido,direccion,ano,fechanac);
                end;
                close(creararch);
                close(arch2texto);
             end
             else
                 writeln('todavia no se creo el archivo binario');
             end;
          4:begin
            if (aux=1) then begin
               reset(creararch);
               seek(creararch,FileSize(creararch));
               writeln('ingrese cuantos alumnos quiere agregar');
               readln(x);
               while (x <> 0) do begin
                 writeln('escriba dni legajo nombre apellido direccion año y fecha del alumno en ese orden');
                 with alum do readln(alumtxt,DNI,legajo,nombre,apellido,direccion,ano,fechanac);
                 x:=x-1;
               end;
               close(creararch);
            end
            else
              writeln('todavia no se creo el archivo binario');
          end;
          5:begin
            if (aux=1) then begin
               reset(creararch);
               writeln('ingrese alumno a buscar (a partir de un legajo)');
               readln(x);
               read(creararch,alum);
               while ((x <> alum.legajo) or (not eof(creararch))) do begin
                 read(creararch,alum);
               end;
               if (not eof(creararch)) then begin
                  seek(creararch,filepos(creararch)-1);
                  writeln('escriba fecha a modificar');
                  readln(alum.fechanac);
                  write(creararch,alum);
               end
               else
                   writeln('no se encontro el alumno')
               close(creararch);
            end
            else
              writeln('todavia no se creo el archivo binario');
          end;
       end;
       writeLn('elija una opcion');
       writeLn('0. Terminar el Programa');
       writeLn('1. Crear un archivo de alumnos de la facultad de ingenieria');
       writeLn('2. mostrar nombres con alguna terminacion');
       writeln('3. volcar en un archivo de nombre alumnosaEgresar todos los alumnos que cursan 5to año');
       writeln('4. añadir alumnos al archivo de registros');
       writeln('5. modificar la fecha de un alumno dado');
       readln(option);
     end;

end.

