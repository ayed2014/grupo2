#include <stdio.h>
#include <stdlib.h>

int longitud(char name[]);

int main()
{
    char name[100];
    printf("Enter a name to check its length: ");
    gets(name);
    int length = longitud(name);
    while(length != 0){
        printf("The name has a length of %d", length);
        char name2[100];
        printf("\nEnter a name to check its length: ");
        gets(name2);
        length = longitud(name2);
    }
    return 0;
}

int longitud(char name[])
{
    int length = 0;
    int i = 0;
    while(name[i] != '\0'){
        if(name[i] == ' '){
            i++;
        } else {
            length++;
            i++;
        }
    }
    return length;
}
