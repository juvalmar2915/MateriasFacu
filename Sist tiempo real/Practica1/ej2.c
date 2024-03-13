// Cabecera del microcontrolador (no es el Atmega)
#include <htc.h>

// Frecuencia de operacion
#define _XTAL_FREQ 1000000

// Prototipos de funciones privadas
static void RELOJ_Init();
static void encenderAmbos();

int main(){
    
    // Configurar RA0 y RA1 como entrada (1)
    TRISA |= (1<<0)|(1<<1);
    
    // Configurar RB4 y RB5 como salida (0)
    TRISB &= ~((1<<4)|(1<<5));
    
    // Encender ambos leds
    encenderAmbos();
    
    // Esperar a que se presione un pulsador (activos en bajo)
    while (RA0 == 1 && RA1 == 1);
    
    // Inicializar Timer
    RELOJ_Init();

    // Loop
    while(1);
    
    return 0;
}

static void RELOJ_Init(){
    // El reloj de sistema es de 1 MHz (1 ciclo cada 1 us)
    // OJO: en este micro debemos considerar el tiempo de instrucción (4 us)
    // Revisar pag. 9 del apunte
    
    // Establecer reloj interno (T0CS = 0)
    T0CS = 0;
    
    // Selecciono prescaler de 256 (PS2:0 = 7)
    PS2 = 1;
    PS1 = 1;
    PS0 = 1;
    
    // Indicar que prescaler se utilizará para Timer 0 (no WDT, PSA = 0)
    PSA = 0;
    
    // Habilitar interrupción
    T0IE = 1;           // Interrupción de Timer 0 Overflow
    GIE = 1;            // Interrupciones generales (sei?)
    
    // Establecer valor de inicio para interrumpir a los 250 ms (aprox)
    // En este caso: 256 - 244 = 12, ya que 4 us * 256 * 244 us = 249 856 us
    TMR0 = 12;
}

static void encenderAmbos(){
    RB4 = 1;
    RB5 = 1;
}

// Rutina de interrupcion
void interrupt manejador(void){
    
    // Alternar ambos leds
    RB4 = RB4 ? 0 : 1;
    RB5 = RB5 ? 0 : 1;
    
    // Limpiar flag
    T0IF = 0;
    
    // Reiniciar contador
    TMR0 = 12;
}
