package ej3;

public class StringDemo {
	public static void main(String[] args) {
	String str1="Leones y Tigres y Osos!"; //va a parar a la memoria Stack en caso de haber otro declarado igual la informacion se comparte
	String str2="Leones y Tigres y Osos!";
	String str3=str2;
	String str4=new String("Leones y Tigres y Osos!");//va a parar a la memoria Heap
	String str5=" Y yo!";
	String str6="Leones y Tigres y Osos! Y yo!";
	String str7= str1 + str5;
	System.out.println(str1==str2);//true ya que al no hacer new() el objeto que le asigna al str2 es el mismo que le asigno a str1 porque busca la cadena de caracteres que coincida
	System.out.println(str1==str3);//true ya que se hizo str3=str2 por lo que str3 apunta al mismo objeto que str2
	System.out.println(str1==str4);//false ya que al hacerle el new() le asignas un objeto string por lo que tiene otro espacio de memoria asignado
	System.out.println(str2==str3);//true ya que se hizo str3=str2 por lo que str3 apunta al mismo objeto que str2
	System.out.println(str2==str4);//false ya que al hacerle el new() le asignas un objeto string por lo que tiene otro espacio de memoria asignado
	System.out.println(str3==str4);//false ya que al hacerle el new() le asignas un objeto string por lo que tiene otro espacio de memoria asignado
	System.out.println(str6==str7);//false ya que str7 esta apuntando al espacio de str1 y str5 en la cache mientras que str6 es un solo espacio en cache
	System.out.println(str1.equals(str4));//true compara el contenido de la cadena str1 con el de str4
	System.out.println(str6.equals(str7));//true compara el contenido de la cadena str6 con el de str7
	}
}
//b) compara el contenido de las cadenas de caracteres
//c)i) se suele implementar el override para comparar determinados atributos ya sea dni nombre apellido etc dependiendo de para que se va a utilizar el mismo.
//ii) en caso de no sobreescribirse compara las direcciones de memoria del objeto
//d)