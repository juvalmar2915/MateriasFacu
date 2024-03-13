/*
 * Ej2tp3.c
 *
 * Created: 30/5/2022 14:16:20
 * Author : Barcala
 */ 

#include <avr/io.h>
#include <stdint.h>
#define F_CPU 16000000UL
#include <util/delay.h>


int main(void)
{
	uint16_t note[12] =
	{
		//C C# D D# E F F# G G# A A# B
		262, 277, 294, 311, 330, 349, 370, 392, 415, 440, 466, 494 //4th octave
	};
	uint16_t valores[12] =
	{
		//C C# D D# E F F# G G# A A# B
		119, 111, 105, 99, 93, 88, 83, 78, 74, 70, 66, 62 //4th octave
	};
	DDRB=(1<<PORTB1);
	TCCR1A=(1<<COM1A0);
	TCCR1B=(1<<WGM12) | (1<<CS12);//256 preescaler modo ctc 4
	int i;
    while (1) 
    {
		for (i=0;i<12;i++){
			OCR1A=(int)(16000000/(int)(2*256*note[i]))-1;
			//OCR1A=valores[i];
			 _delay_ms(2000);
		}
    }
}

