#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Enter five names:\n");
    char names[5][50];
    int i;
    for(i=0; i<5; i++){
        gets(&names[i]);
    }
    printf("\nThe names are: ");
    for(i=0; i<5; i++){
        printf("\n%s", names[i]);
    }

    return 0;
}
