#include <stdio.h>
#include <stdlib.h>

int biggest(int num1, int num2, int num3);

int main()
{
    int num1, num2, num3;

    printf("Enter three numbers:\n");
    scanf("%d%d%d", &num1, &num2, &num3);

    printf("The biggest number is %d", biggest(num1, num2, num3));

    return 0;
}

int biggest(int num1, int num2, int num3)
{
    int max;

    if(num1 > num2) max = num1;
    else max = num2;
    if(num3 > max) max = num3;

    return max;
}

