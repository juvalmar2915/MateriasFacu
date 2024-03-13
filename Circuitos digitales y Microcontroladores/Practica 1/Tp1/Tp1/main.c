/*
 * Tp1.c
 *
 * Created: 21/3/2022 16:35:57
 * Author : Barcala
 */ 

/* Inclusión de cabeceras de bibliotecas de código */
#include <avr/io.h> // Definición de Registros del microcontrolador
#define F_CPU 16000000UL // Especifico la frecuencia de reloj del MCU en 8MHz
#include <util/delay.h> // Retardos por software – Macros: depende de F_CPU
/* Función main */
int main (void)
{
	/* Setup */
	DDRC &=~(1<<PORTC0); // Limpia el bit 0 del DDRC
	PORTC |= (1<<PORTC0); // Pone en 1 el bit 0 del PortC
	DDRB = 0xFF; // Declara como salida DDRB
	/* Loop */
	while(1)
	{
		if (PINC & (1<<PINC0)) //chequea si el bit0 esta en alto
		{
			PORTB = 0b10101010; //
			_delay_ms(100); //
			PORTB = 0x00; //
			_delay_ms(100); //
		}
		else
		{
			PORTB = 0b01010101; //
			_delay_ms(100); //
			PORTB = 0x00; //
		_delay_ms(100); // 
		}
	}
	/* Punto de finalización del programa (NO se debe llegar a este lugar) */
	return 0;
}



