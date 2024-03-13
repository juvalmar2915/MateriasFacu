/*
 * Ej10.c
 *
 * Created: 25/4/2022 20:54:09
 * Author : valen
 */ 

#include <avr/io.h>
#include <avr\interrupt.h>
#define F_CPU 16000000UL
#include <util/delay.h>


int main(void){
	TCCR0A = 0x00;
	TCCR0B = 0x05;
	TCNT0 = 100;
	TIMSK0 |= (1<<TOIE0);
	sei();
	DDRB |= (1<<PORTB0);
	PORTB |= (1<<PORTB0);

	while (1) {

	}
}


ISR (TIMER0_OVF_vect){
	static int pulsos=0;
	TCNT0 = 100;
	if(++pulsos == 5){
		PORTB ^= (1<<PORTB0);
		pulsos=0;
	}
}