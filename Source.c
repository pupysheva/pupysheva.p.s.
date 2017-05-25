#include<stdio.h> 
#include<stdlib.h> 
#include<conio.h>
#include<time.h>

struct Data{
	unsigned long int time;
	double value;
};

//Prototype.
//Reading data from the beginning of the file, writing them to an array. Malloc is used.
struct Data * GETTING_DATA_FROM_FILE(FILE * fp, size_t * count);

//Finding quantity of elements SEARCH found in the FP file from the beginning.
size_t SEARCH_FOR_QUANTITY(FILE * fp, char search);

//Swap of structures.
void SWAP(struct Data *x, struct Data *y);

//QuickSort.
void QUICK_SORT(struct Data * ReadData, size_t left, size_t right);

int main(void) {
	unsigned int i, imin = 0, imax = 0;
	unsigned long int min_time, max_time;
	float T;
	double number=1.0;
	struct tm m_time;
	size_t count = 0;
	FILE *fp = NULL;
	fp = fopen("laba1_1.csv", "r");
	struct Data * ReadData = GETTING_DATA_FROM_FILE(fp, &count);

	//Calculation of the sorting time.
	T = clock();
	QUICK_SORT(ReadData, 0, count-1);
	T = (clock()-T)/ CLOCKS_PER_SEC;

	//Output the time of sorting.
	if (T != 0) printf("TIME OF SORT (quicksort):  %.3f sec\n", T);
	else printf("TIME OF SORT (quicksort): <0.001 sec\n");
												 
	//Output of sorted array.
	for (i = 0; i < count; i++) 
		printf("%lu %.9lf\n", ReadData[i].time, ReadData[i].value);
	
	//Translation of the January 1, 1980 date into the unix timestamp format.
	m_time.tm_sec = 0; m_time.tm_min = 0; m_time.tm_hour = 0;
	m_time.tm_mday = 1; m_time.tm_mon = 0; m_time.tm_year = 80;
	min_time = mktime(&m_time);

	//Translation of the December 31, 1984 date into the unix timestamp format.
	m_time.tm_sec = 0; m_time.tm_min = 0; m_time.tm_hour = 0;
	m_time.tm_mday = 31; m_time.tm_mon = 11; m_time.tm_year = 84;
	max_time = mktime(&m_time);

	printf("the January 1, 1980 -> %lu; the December 31, 1984 -> %lu\n", min_time, max_time);

	//Search for the minimum value of the measured value for the period from January 1, 1980 to December 31, 1984.
	for (i = 0; i < count; i++) {
		if (ReadData[i].time > min_time) {
			imin = i;
			number = ReadData[imin].value;
			break;
		}
	}
	for (i = 0; i < count; i++) 
		if (ReadData[i].time<max_time)
			imax = i;
		else break;
	
	for (i = imin; i<=imax; i++) 
		if (ReadData[i].value<=number) number = ReadData[i].value;
	printf("The smallest number between 1 Jan 1980 and 31 Dec 1984 is %.9lf\n", number);

	fclose(fp);
	getch();
}

//Reading data from the beginning of the file, writing them to an array. Malloc is used.
struct Data * GETTING_DATA_FROM_FILE(FILE * fp, size_t * count)
{
	unsigned int i = 0;
	struct Data * output = NULL;
	*count = SEARCH_FOR_QUANTITY(fp, '\n');
	output = (struct Data *) malloc(*count * sizeof(struct Data));
	for (i = 0; i < *count; i++)
	{
		fscanf(fp,"%lf,%lu", &output[i].value, &output[i].time);
	}
	return output;
}

//Finding quantity of elements SEARCH found in the FP file from the beginning.
size_t SEARCH_FOR_QUANTITY(FILE * fp, char search)
{
	size_t count;
	fseek(fp, 0l, SEEK_SET); 
	count = 0;
	while (!feof(fp))
	{
		if (fgetc(fp) == search)
			count++;
	}
	fseek(fp, 0l, SEEK_SET);
	return count;
}

//Swap of structures.
void SWAP(struct Data *x, struct Data *y) {
	struct Data tmp;
	tmp = *x;
	*x = *y;
	*y = tmp;
}

//QuickSort.
void QUICK_SORT(struct Data * ReadData, size_t left, size_t right) {
	
	int i, last;
	if (left >= right)
		return;
	SWAP(&ReadData[left], &ReadData[(left + right) / 2]);
	last = left;
	for (i = left + 1; i <= right; i++)
		if (ReadData[i].time < ReadData[left].time) {
			SWAP(&ReadData[++last], &ReadData[i]);
		}
	SWAP(&ReadData[left], &ReadData[last]);
	if(last > 0) QUICK_SORT(ReadData, left, last - 1);
	QUICK_SORT(ReadData, last + 1, right);
	return;
}
