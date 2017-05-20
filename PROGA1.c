#include<stdio.h> 
#include<stdlib.h> 
#include <conio.h> 
struct paket {
	int a;
	char c[256];
	float b;
};
int main(int argc, char **argv) {
	struct paket d;
	char name[128];
	FILE *fp = NULL;
	if (argc >= 2) fp = fopen(argv[1], "rb");
	while (fp == NULL) {
		printf("the file was unable to access\n");
		printf("enter file name\n");
		gets(name);
		fp = fopen(name, "rb");
	}
	while (fread(&d, sizeof(struct paket), 1, fp)) {
		printf("%2d %s %f\n", d.a, d.c, d.b);
	}
	fseek(fp, 0, SEEK_END); //Move to the end of the file 
	long size = ftell(fp); //Get the byte number
	fseek(fp, 0, SEEK_SET); //Move to the beginning of the file 
	printf("file size= %ld (byte)", size);//displays the size of the file in bytes
	fclose(fp);
	getch();
}