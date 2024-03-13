/*
 * Tp4.c
 *
 * Created: 11/7/2022 19:38:01
 * Author : PALA
 */ 

#include "main.h"

int main(void){
	SerialPort_Init(BR9600);
	SerialPort_TX_Enable(); 
	SerialPort_RX_Enable();            // Activo el Receptor del Puerto Serie
	SerialPort_RX_Interrupt_Enable();    // Activo Interrupción de recepcion.
	sei();                                // Activo la mascara global de interrupciones (Bit I del SREG en 1)
	
	uint8_t c;
	uint8_t rojo=100;
	uint8_t verde=100;
	uint8_t azul=100;
	
	flag_r=1;
	flag_v=1;
	flag_a=1;
	
	Terminal_configurarRegs();
	SerialPort_Send_String("Ingrese R para modificar rojo, V para verde, A para azul, S para para confirmar cambios \r\n");
	
    while (1){
		if(nuevoComando){
			c = Terminal_leerComando(bufferRX);
			if(c==1){//modificar rojo 
				while(c==1){
					_delay_ms(1000);
					rojo = Terminal_leerPotenciometro();
					SerialPort_Send_uint8_t(rojo);
					SerialPort_Send_String("\r\n");
					if(nuevoComando){
						c = Terminal_leerComando(bufferRX);
						if(c!=4) c=1;
					}
				}
				flag_r=1;
				SerialPort_Send_String("Ingrese R para modificar rojo, V para verde, A para azul, S para para confirmar cambios \r\n");
			}
			else if(c==2){//modificar verde
				while(c==2){
					_delay_ms(1000);
					verde = Terminal_leerPotenciometro();
					SerialPort_Send_uint8_t(verde);
					SerialPort_Send_String("\r\n");
					if(nuevoComando){
						c = Terminal_leerComando(bufferRX);
						if(c!=4) c=2;
					}
				}
				flag_v=1;
				SerialPort_Send_String("Ingrese R para modificar rojo, V para verde, A para azul, S para para confirmar cambios \r\n");
			}
			else if(c==3){//modificar azul
				while(c==3){
					_delay_ms(1000);
					azul = Terminal_leerPotenciometro();
					SerialPort_Send_uint8_t(azul);
					SerialPort_Send_String("\r\n");
					if(nuevoComando){
						c = Terminal_leerComando(bufferRX);
						if(c!=4) c=3;
					}
				}
				flag_a=1;
				SerialPort_Send_String("Ingrese R para modificar rojo, V para verde, A para azul, S para para confirmar cambios \r\n");
			}
		}
		if(flag_r){
			OCR1A = rojo;
			flag_r=0;
		}
		if(flag_v){
			OCR1B = verde;
			flag_v=0;
		}
		if(flag_a){
			if(azul==255) azul=254;
			else if (azul==0) azul=1;
			flag_a=0;
		}
		
		//Pongo en bajo PB5 el tiempo necesario para cumplir con el ciclo de trabajo
		PORTB &= ~(1<<PORTB5);
		OCR0A = azul;
		TCNT0 = 0;
		while((TIFR0&(1<<OCF0A))==0);
		TIFR0 |= (1<<OCF0A);
		
		//Pongo en alto PB5 el tiempo necesario para completar el periodo
		PORTB |= (1<<PORTB5);
		OCR0A = 255-azul;
		TCNT0 = 0;
		while((TIFR0&(1<<OCF0A))==0);
		TIFR0 |= (1<<OCF0A);	
	
    }
}



