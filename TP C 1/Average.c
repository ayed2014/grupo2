#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Enter ten numbers:\n");
    int i;
    float sum = 0;
    float current;
    for(i=0; i<10; i++){
        scanf("%f", &current);
        sum = sum + current;
    }
    float average = sum / 10;
    printf("The average is %f", average);

    return 0;
}

