/*
 * main.h
 *
 * Created: 19/7/2022 15:48:50
 *  Author: valen
 */ 


#ifndef MAIN_H_
#define MAIN_H_
#define F_CPU 16000000UL
#include <avr/io.h>
#include <util/delay.h>
#include "serialPort.h"
#define BR9600 (0x67)    // 0x67=103 configura BAUDRATE=9600@16MHz

uint8_t* descomponer(uint8_t);

volatile char RX_Buffer=0;
volatile uint8_t bufferRX[10];
volatile uint8_t nuevoComando=0;
volatile uint8_t flag_r=0;
volatile uint8_t flag_v=0;
volatile uint8_t flag_a=0;
volatile uint8_t cant=0;




#endif /* MAIN_H_ */