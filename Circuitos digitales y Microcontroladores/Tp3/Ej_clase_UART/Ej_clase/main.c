
 
 //1-transmitir G. Ver silulador as7, tregistros uart y tiempo que tarda en transmitir un caracter.

 #include <avr/io.h>

 int main(void)
 {
	 //initialize the USART
	 UCSR0B = (1<<TXEN0);
	 UCSR0C = (1<<UCSZ01)|(1<<UCSZ00);
	 UBRR0L = 103;						 //baud rate = 9600bps@16MHz
	 while(1) {
		 while (! (UCSR0A & (1<<UDRE0))); //wait until UDR0 is empty
		 UDR0 = 'G';						 //transmit �G� letter
	 }
	 return 0;
 }
 
 /*
 //2-LOOPBACK con polling 
 #include <avr/io.h>

 int main(void)
 {
	 volatile unsigned char dato;
	 //initialize the USART
	 UCSR0B = (1<<TXEN0)|(1<<RXEN0);
	 UCSR0C = (1<<UCSZ01)|(1<<UCSZ00);
	 UBRR0L = 103;						 //baud rate = 9600bps@16MHz
	 while(1) {
		 while (! (UCSR0A & (1<<UDRE0))); //wait until UDR0 is empty
		 UDR0 = 'G';						 //transmit �G� letter
		 while (! (UCSR0A & (1<<RXC0))); //wait until new data
		 dato = UDR0;
	 }
	 return 0;
 }
 //3-eco de caracter con polling (no se puede simular en as7 la recepcion)

 #include <avr/io.h>

 int main(void)
 {
	 volatile unsigned char dato;
	 DDRB=0xFF;
	 //initialize the USART
	 UCSR0B = (1<<TXEN0)|(1<<RXEN0);
	 UCSR0C = (1<<UCSZ01)|(1<<UCSZ00);
	 UBRR0L = 103;						 //baud rate = 9600bps@16MHz
	 while(1) {
		 while (! (UCSR0A & (1<<RXC0))); //wait until new data
		 dato = UDR0;
		 while (! (UCSR0A & (1<<UDRE0))); //wait until UDR0 is empty
		 UDR0 = dato;						 //transmit dato
		 PORTB= dato;
	 }
	 return 0;
 }

 //4- transmitir cadenas +  eco

 #include "main.h"
 #include "serialPort.h"

 #define BR9600 (0x67)	// 0x67=103 configura BAUDRATE=9600@16MHz

 //mensajes de bienvenida y despedida
 char msg1[] = "Hola Mundo, si presiona 's' termina el programa, por favor ingrese una tecla:\n\r";
 char msg2[] = "\n\rHasta luego!";

 int main(void)
 {
	 volatile char dato = 0;
	 
	 SerialPort_Init(BR9600); 		// Inicializo formato 8N1 y BAUDRATE = 9600bps
	 SerialPort_TX_Enable();			// Activo el Transmisor del Puerto Serie
	 SerialPort_RX_Enable();			// Activo el Receptor del Puerto Serie
	 SerialPort_Send_String(msg1);   // Env�o el mensaje de Bienvenida

	 while(1)
	 {
		 SerialPort_Wait_Until_New_Data();	  // Pooling - Bloqueante, puede durar indefinidamente.
		 dato = SerialPort_Recive_Data();

		 // Si presionan 's' se termina el programa
		 if( dato == 's')
		 {
			 SerialPort_Send_String(msg2);  // Env�o el string de despedida
			 while(1);
		 }
		 else
		 {	// Eco:
			 SerialPort_Wait_For_TX_Buffer_Free(); // Espero a que el canal de transmisi�n este libre (bloqueante)
			 SerialPort_Send_Data(dato);			  // Env�o el dato recibido
		 }
	 }
	 return 0;
 }

 //4- transmitir cadenas +  eco usando interrupci�n Rx
 #include <avr/io.h>
 #include <avr/interrupt.h>
 #include "serialPort.h"

 #define BR9600 (0x67)	// 0x67=103 configura BAUDRATE=9600@16MHz

 //mensajes de bienvenida y despedida
 char msg1[] = "Uso de interrup RXC, si presiona 's' termina el programa, por favor ingrese una tecla:\n\r";
 char msg2[] = "\n\rHasta luego!";

 //comunicaci�n con la ISR
 volatile char RX_Buffer=0;

 int main(void)
 {
	 volatile char dato = 0;
	 
	 SerialPort_Init(BR9600); 		// Inicializo formato 8N1 y BAUDRATE = 9600bps
	 SerialPort_TX_Enable();			// Activo el Transmisor del Puerto Serie
	 SerialPort_RX_Enable();			// Activo el Receptor del Puerto Serie
	 SerialPort_Send_String(msg1);   // Env�o el mensaje de Bienvenida
	 SerialPort_RX_Interrupt_Enable();	// Activo Interrupci�n de recepcion.
	 sei();								// Activo la mascara global de interrupciones (Bit I del SREG en 1)

	 while(1)
	 {
		 if(RX_Buffer){ // recepci�n NO Bloqueante
			 // Si presionan 's' se termina el programa
			 if(RX_Buffer == 's'){
				 SerialPort_Send_String(msg2);  // Env�o el string de despedida
				 while(1);
			 }
			 else{	// Eco:
				 SerialPort_Wait_For_TX_Buffer_Free(); // Espero a que el canal de transmisi�n este libre (bloqueante)
				 SerialPort_Send_Data(RX_Buffer);			  // Env�o el dato recibido
			 }
			 RX_Buffer=0;
		 }
		 //otra tarea
	 }
	 return 0;
 }

 // Rutina de Servicio de Interrupci�n de Byte Recibido
 ISR(USART_RX_vect){
	 RX_Buffer = UDR0; //la lectura del UDR borra flag RXC
 }
*/
 