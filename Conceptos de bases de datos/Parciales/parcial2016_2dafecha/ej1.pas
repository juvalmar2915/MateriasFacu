program ej1;
const
  valoralto=9999;
type
  productodet=record
    cod:integer;
    ventas:integer;
  end;
  productomae=record
    cod:integer;
    nombre:String[255];
    descripcion:String[255];
    stock:integer;
  end;
  detalle=file of productodet;
  maestro=file of productomae;
  deta=array [1..50] of detalle;
  pdet=array [1..50] of productodet;
procedure leer(var detalle1:detalle;var pd:productodet);
begin
  if (not eof(detalle1)) then
     read(detalle1,pd)
  else
    pd.cod:=valoralto;
end;
procedure calcularmin(pd:pdet;var indice:integer);
var
  j:integer;
  min:integer;
begin
  min:=9999;
  for j:=1 to 50 do begin
     if (pd[j].cod<min) then begin
        min:=pd[j].cod;
        indice:=j;
     end;
  end;
end;
procedure actualizarmae(var mae:maestro;var det:deta);
var
  x:integer;
  pmae:productomae;
  pdetalle:pdet;
  pdaux:productodet;
  totventas:integer;
  indmin:integer;
  codact:integer;
begin
  reset(mae);
  for x:=1 to 50 do begin
    reset(det[x]);
  end;
  read(mae,pmae);
  for x:=1 to 50 do begin
    leer(det[x],pdetalle[x]);
  end;
  calcularmin(pdetalle,indmin);
  pdaux:=pdetalle[indmin];
  leer(det[indmin],pdetalle[indmin]);
  while (pdaux.cod<>valoralto) do begin
    totventas:=0;
    codact:=pdaux.cod;
    while(pmae.cod<>pdaux.cod) do begin
      read(mae,pmae);
    end;
    while(codact=pdaux.cod) do begin
      totventas:=totventas+pdaux.ventas;
      calcularmin(pdetalle,indmin);
      pdaux:=pdetalle[indmin];
      read(det[indmin],pdetalle[indmin]);
    end;
    pdaux.ventas:=totventas;
    if(pmae.stock<pdaux.ventas) then begin
       pmae.stock:=0;
    end
    else
      pmae.stock:=pmae.stock-pdaux.ventas;
    seek(mae,FilePos(mae)-1);
    write(mae,pmae);
  end;
  for x:=1 to 50 do begin
     close(det[x]);
  end;
  close(mae);
end;
var
  maest:maestro;
  detall:deta;
  nombrem:string;
  nombred:string;
  i:integer;
begin
  read(nombrem);
  assign(maest,nombrem);
  for i:=1 to 50 do begin
    read(nombred);
    assign(detall[i],nombred);
  end;
  actualizarmae(maest,detall);
end.

