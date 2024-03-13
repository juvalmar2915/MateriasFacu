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

    // Reiniciar puerto B
    /*
    RB0 = 0;
    RB1 = 0;
    RB2 = 0;
    RB3 = 0;
    RB4 = 0;
    RB5 = 0;
    RB6 = 0;
    RB7 = 0;
    */

    // Loop
    while(1) {

        // Esperar fin de conversión
        while(GO == 1);

        // Leer resultado (parte alta)
        char result_alto = ADRESH;
	char result_bajo = ADRESL;

        PORTB = result_bajo;

        RD6 = 1;
        RD6 = 0;

        __delay_ms(1000);

	PORTB = result_alto;
	RD7 = 1;
	RD7 = 0;

        GO = 1;
    }

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

    // Justificación de bits a izquierda
    ADFM = 1;
    
}