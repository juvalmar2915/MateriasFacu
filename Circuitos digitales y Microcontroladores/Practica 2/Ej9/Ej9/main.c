/*
 * Ej9.c
 *
 * Created: 25/4/2022 20:56:43
 * Author : valen
 */ 

#define F_CPU 16000000ul
#include <avr/io.h>
#include <util/delay.h>
#include <stdint.h>
#include "lcd.h"

uint8_t KEYPAD_Scan(uint8_t *);
void Chequear_Car(uint8_t *);

int main(void)
{
	uint8_t tecla;
	DDRB|=(1<<PORTB0) | (1<<PORTB3) | (1<<PORTB4);
	DDRD|=(1<<PORTD7);
	DDRD &= ~(1<<PORTD3) | ~(1<<PORTD5) | ~(1<<PORTD4) | ~(1<<PORTD2);

	_delay_ms(1000);
	LCDinit();
	//LCDclr();
	LCDGotoXY(0, 0);
	LCDstring("Tecla: ",7);



	while (1) {
		LCDGotoXY(7, 0);
		if (KEYPAD_Scan(&tecla)){
			Chequear_Car(&tecla);
			LCDsendChar(tecla);
		};
		_delay_ms(10);
	}
}


uint8_t KEYPAD_Scan(uint8_t *key){
	int c, f;

	for (f=0;f<4;f++){
		PORTB|=(1<<PORTB0) | (1<<PORTB3) | (1<<PORTB4);
		PORTD|=(1<<PORTD7);
		PORTD |= (1<<PORTD3) | (1<<PORTD5) | (1<<PORTD4) | (1<<PORTD2);
		switch(f)
		{
			case 0:
			PORTB &= ~(1<<PORTB4);
			break;

			case 1:
			PORTB &= ~(1<<PORTB3);
			break;

			case 2:
			PORTB &= ~(1<<PORTB0);
			break;

			case 3:
			PORTD &= ~(1<<PORTD7);
			break;
		}

		_delay_ms(5);

		for(c=0;c<4;c++){
			switch(c)
			{
				case 0:
				if (!(PIND & (1<<PIND3))){
					*key=(f*4+c);
					return 1;
				}
				break;

				case 1:
				if (!(PIND & (1<<PIND5))){
					*key=(f*4+c);
					return 1;
				}
				break;

				case 2:
				if (!(PIND & (1<<PIND4))){
					*key=(f*4+c);
					return 1;
				}
				break;

				case 3:
				if (!(PIND & (1<<PIND2))){
					*key=(f*4+c);
					return 1;
				}
				break;
			}
		}
	}
	return 0;
};


void Chequear_Car(uint8_t *c){
	switch(*c)
	{
		case 0:
		*c=(int)'1';
		break;
		case 1:
		*c=(int)'2';
		break;
		case 2:
		*c=(int)'3';
		break;
		case 3:
		*c=(int)'A';
		break;
		case 4:
		*c=(int)'4';
		break;
		case 5:
		*c=(int)'5';
		break;
		case 6:
		*c=(int)'6';
		break;
		case 7:
		*c=(int)'B';
		break;
		case 8:
		*c=(int)'7';
		break;
		case 9:
		*c=(int)'8';
		break;
		case 10:
		*c=(int)'9';
		break;
		case 11:
		*c=(int)'C';
		break;
		case 12:
		*c=(int)'*';
		break;
		case 13:
		*c=(int)'0';
		break;
		case 14:
		*c=(int)'#';
		break;
		case 15:
		*c=(int)'D';
		break;
	}
};
