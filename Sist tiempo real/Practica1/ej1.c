// Cabecera del microcontrolador (no es el Atmega)
#include <htc.h>

// Frecuencia de operacion
#define _XTAL_FREQ 1000000

// Prototipos de funciones privadas
static void encenderAmbos();
static void alternarAmbos();

int main(){

    // Configurar RA0 y RA1 como entrada (1)
    TRISA |= (1<<0)|(1<<1);
    
    // Configurar RB4 y RB5 como salida (0)
    TRISB &= ~((1<<4)|(1<<5));

    // Encender ambos leds
    encenderAmbos();
    
    // Esperar hasta que se presione un pulsador
    while (RA0 == 1 && RA1 == 1);
    
    // Loop
    while(1){
        alternarAmbos();
        __delay_ms(250);
    }
    
    return 0;
}

static void encenderAmbos(){
    RB4 = 1;
    RB5 = 1;
}

static void alternarAmbos(){
    RB4 = RB4 ? 0 : 1;
    RB5 = RB5 ? 0 : 1;
}