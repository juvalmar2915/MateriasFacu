/*
 * Ej13.c
 *
 * Created: 29/4/2022 19:50:04
 * Author : valen
 */ 


#include <avr/io.h>
#include <avr/interrupt.h>
#include <avr/sleep.h>
#include "lcd.h"

static char not_leap(void);
static void init(void);

typedef struct{
	unsigned char second;
	unsigned char minute;
	unsigned char hour;
	unsigned char date;
	unsigned char month;
	unsigned char year;
	}time;
	
volatile time t={10,29,14,19,4,21};
volatile uint8_t FlagLCD=0;

int main(void)
{
    init();	//Initialize registers and configure RTC.
	LCDinit();
	while(1)
	{
	//	sleep_mode();										//Enter sleep mode. (Will wake up from timer overflow interrupt)
	//	TCCR2B=(1<<CS20)|(1<<CS22);							//Write dummy value to control register
	//	while(ASSR&((1<<TCN2UB)|(1<<OCR2AUB)|(1<<TCR2AUB)));	//Wait until TC0 is updated
	PORTC=~PORTC;
	if(FlagLCD==1){
		FlagLCD=0;
		LCDGotoXY(4,0);
		LCDescribeDato(t.date,2);
		LCDsendChar('/');
		LCDescribeDato(t.month,2);
		LCDsendChar('/');
		LCDescribeDato(t.year,2);
		LCDGotoXY(4,1);
		LCDescribeDato(t.hour,2);
		LCDsendChar(':');
		LCDescribeDato(t.minute,2);
		LCDsendChar(':');
		LCDescribeDato(t.second,2);
	 }
	}
}

static void init(void)
{
	DDRC = 0xFF;											//Configure all eight pins of port C as outputs
	TIMSK2 &= ~((1<<TOIE2)|(1<<OCIE2A));						//Make sure all TC0 interrupts are disabled
	ASSR |= (1<<AS2);										//set Timer/counter0 to be asynchronous from the CPU clock
															//with a second external clock (32,768kHz)driving it.								
	TCNT2 =0;												//Reset timer
	TCCR2B =(1<<CS20)|(1<<CS22);								//Prescale the timer to be clock source/128 to make it
															//exactly 1 second for every overflow to occur
	while (ASSR & ((1<<TCN2UB)|(1<<OCR2AUB)|(1<<TCR2AUB)))	//Wait until TC0 is updated
	{}
	TIMSK2 |= (1<<TOIE2);									//Set 8-bit Timer/Counter0 Overflow Interrupt Enable
	sei();													//Set the Global Interrupt Enable Bit
//	set_sleep_mode(SLEEP_MODE_PWR_SAVE);					//Selecting power save mode as the sleep mode to be used
//	sleep_enable();											//Enabling sleep mode
}

ISR(TIMER2_OVF_vect)
{
	if (++t.second==60)        //keep track of time, date, month, and year
	{
		t.second=0;
		if (++t.minute==60)
		{
			t.minute=0;
			if (++t.hour==24)
			{
				t.hour=0;
				if (++t.date==32)
				{
					t.month++;
					t.date=1;
				}
				else if (t.date==31)
				{
					if ((t.month==4) || (t.month==6) || (t.month==9) || (t.month==11))
					{
						t.month++;
						t.date=1;
					}
				}
				else if (t.date==30)
				{
					if(t.month==2)
					{
						t.month++;
						t.date=1;
					}
				}
				else if (t.date==29)
				{
					if((t.month==2) && (not_leap()))
					{
						t.month++;
						t.date=1;
					}
				}
				if (t.month==13)
				{
					t.month=1;
					t.year++;
				}
			}
		}
	}
	PORTC=~(((t.second&0x01)|t.minute<<1)|t.hour<<7);
	FlagLCD=1;
}

static char not_leap(void)      //check for leap year
{
	if (!(t.year%100))
	{
		return (char)(t.year%400);
	}
	else
	{
		return (char)(t.year%4);
	}
}