/*
 * ej10b.c
 *
 * Created: 25/4/2022 21:33:51
 * Author : valen
 */ 

#include <avr/io.h>
#include <avr\interrupt.h>
#define F_CPU 16000000UL
#include <util/delay.h>

void retardoBloqueante(uint8_t);
void retardoUnMs();

int main(void){
	DDRB |= (1<<PORTB0);
	PORTB |= (1<<PORTB0);
	uint8_t delay=10;
	while (1) {
		retardoBloqueante(delay);
		PORTB ^= (1<<PORTB0);
	}
}

void retardoBloqueante(uint8_t milisegundos){
	uint8_t i;
	for(i=0; i<milisegundos; i++){
		retardoUnMs();
	}
}

void retardoUnMs(){
	TCNT0=6;
	TCCR0A=0x00;
	TCCR0B=0x03;
	while ((TIFR0 & (1<<TOV0)) == 0);
	TCCR0B=0x00;
	TIFR0 |= (1<<TOV0);
}