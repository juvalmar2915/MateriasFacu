/*
 * terminal.h
 *
 * Created: 13/7/2022 11:30:06
 *  Author: PALA
 */ 

#include <stdint.h>

#ifndef TERMINAL_H_
#define TERMINAL_H_

int Terminal_leerComando(char *);
uint8_t Terminal_leerPotenciometro(void);
void Terminal_configurarRegs(void);

#endif /* TERMINAL_H_ */