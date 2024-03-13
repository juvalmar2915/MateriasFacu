/*
 * terminal.c
 *
 * Created: 13/7/2022 11:29:50
 *  Author: PALA
 */ 

#include "terminal.h"
#include <avr/io.h>
extern RX_Buffer;
extern bufferRX[10];
extern cant;
extern nuevoComando;
int Terminal_leerComando(char *s){
	if (s[0]=='R'){
		if (s[1]=='\n'){
			return 1; 
		}
		else{
			return 5;
		}
	}
	else{
		if(s[0]=='V'){
			if (s[1]=='\n'){
				return 2;
			}
			else{
				return 5;
			}
		}
		else{
			if (s[0]=='A'){
				if (s[1]=='\n'){
					return 3;
				}
				else{
					return 5;
				}
			}
			else{
				if (s[0]=='S'){
					if (s[1]=='\n'){
						return 4;
					}
					else{
						return 5;
					}
				}
			}
		}
	}
}

uint8_t Terminal_leerPotenciometro(){
	ADCSRA |= (1<<ADSC);//start conversion
	while((ADCSRA&(1<<ADIF))==0);//wait for conversion to finish
	ADCSRA |= (1<<ADIF); //borrar flag
	return ADCH;
}

void Terminal_configurarRegs(void){
	DDRB = (1<<PORTB1) | (1<<PORTB2)| (1<<PORTB5);                               //pines pwm como salida
	TCCR1A = (1<<COM1A0) | (1<<COM1A1) | (1<<COM1B0) | (1<<COM1B1) | (1<<WGM10); //pwm no invertido en PB1 y PB2
	TCCR1B = (1<<CS10)| (1<<CS12) | (1<<WGM12);                                  //Modos fast pwm 8-bits con prescaler 1024
	
	TCCR0A = (1<<WGM01);            //Modo CTC timer 0
	TCCR0B = (1<<CS02) | (1<<CS00); //prescaler 1024
	
	DIDR0 = (1<<ADC3D); //make ADC3 pin an input analog pin
	ADCSRA= 0x87;//make ADC enable and select ck/128
	ADMUX= (1 << ADLAR) | (1 << MUX1) | (1 << MUX0);// Vref=AVCC, left-justified, ADC3 pin
	
}

ISR(USART_RX_vect){
	RX_Buffer=SerialPort_Recive_Data();
	if(RX_Buffer!='\r'){
		bufferRX[cant]=RX_Buffer;
		cant++;
		}else{
		bufferRX[cant]='\n';
		nuevoComando=1;
		cant=0;
	}
}