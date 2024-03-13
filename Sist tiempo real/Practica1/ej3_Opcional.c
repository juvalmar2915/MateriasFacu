// Cabecera del microcontrolador (no es el Atmega)
#include <htc.h>

// Frecuencia de operacion
#define _XTAL_FREQ 1000000

// Prototipos de funciones privadas
static void ADC_Init();

int main()
{

    // Setup
    ADC_Init();     // Inicialización del ADC

    // Salidas (0)
    TRISB = 0;
    TRISD &= ~((1<<6)|(1<<7));

    // Iniciar primera conversion
    GO = 1;

    // Loop
    while(1);

    return 0;
}

static void ADC_Init()
{
    // Configuro AN0 como entrada analógica (1)
    TRISA |= (1<<0);

    // Configuración de ADC
    // Elijo AN0 como único canal, con VREF = VDD
    // PCFG3:0 = 14 = 1110 (binario)
    PCFG3 = 1;
    PCFG2 = 1;
    PCFG1 = 1;
    PCFG0 = 0;

    // Habilito ADC
    ADON = 1;

    // Justificación de bits a derecha
    ADFM = 1;
    
    // Habilito interrupción
    ADIE = 1;

	// Habilito interrupciones de periféricos
	PEIE = 1;

	// Habilito interrupción general
	GIE = 1;
}

void interrupt manejador(void){

	// Leer resultado (parte alta)
        	char result_alto = ADRESH;
		char result_bajo = ADRESL;

        	PORTB = result_bajo;

        	RD6 = 1;
        	RD6 = 0;

		PORTB = result_alto;
		RD7 = 1;
		RD7 = 0;

		// Permitir nueva interrupción
		ADIF = 0;

		// Iniciar nueva conversion
		GO = 1;
}