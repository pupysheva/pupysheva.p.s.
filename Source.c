#include<stdio.h> 
#include<stdlib.h> 
#include<conio.h>
#include<time.h>

struct Data{
	double value;
	unsigned long int time;
};

//Prototype.
//Reading data from the beginning of the file, writing them to an array. Malloc is used.
struct Data * GetFileData(FILE * fp, size_t * count);

//Finding quantity of elements SEARCH found in the FP file from the beginning.
size_t SearchInFile(FILE * fp, char search);

//Swap of structures.
void SWAP(struct Data *a, struct Data *b);

//QuickSort.
void QuickSort(struct Data * SFF, size_t left, size_t right);

int main(void) {
	float T;
	unsigned int i, imin=0, imax=0;
	double number=1.0;
	struct tm m_time;
	unsigned long int datemin, datemax;
	size_t count = 0;
	FILE *fp = NULL;
	fp = fopen("laba1_1.csv", "r");
	struct Data * SFF = GetFileData(fp, &count);

	//Calculation of the sorting time.
	T = clock();
	QuickSort(SFF, 0, count-1);
	T = (clock()-T)/ CLOCKS_PER_SEC;

	//Output the time of sorting.
	if (T != 0) printf("Estimated time to quicksort:  %.3f sec\n", T);
	else printf("Estimated time to quicksort: <0.001 sec\n");
												 
	//Output of sorted array.
	for (i = 0; i < count; i++) 
		printf("%lu %.9lf\n", SFF[i].time, SFF[i].value);
	
	//Translation of the January 1, 1980 date into the unix timestamp format.
	m_time.tm_sec = 0; m_time.tm_min = 0; m_time.tm_hour = 0;
	m_time.tm_mday = 1; m_time.tm_mon = 0; m_time.tm_year = 80;
	datemin = mktime(&m_time);

	//Translation of the January 31, 1984 date into the unix timestamp format.
	m_time.tm_sec = 0; m_time.tm_min = 0; m_time.tm_hour = 0;
	m_time.tm_mday = 31; m_time.tm_mon = 11; m_time.tm_year = 84;
	datemax = mktime(&m_time);

	printf("the January 1, 1980 -> %lu, the January 31, 1984 -> %lu\n", datemin, datemax);

	//Search for the minimum value of the measured value for the period from January 1, 1980 to December 31, 1984.
	for (i = 0; i < count; i++) {
		if (SFF[i].time > datemin) {
			imin = i;
			number = SFF[imin].value;
			break;
		}
	}
	for (i = 0; i < count; i++) 
		if (SFF[i].time<datemax)
			imax = i;
		else break;
	
	for (i = imin; i<=imax; i++) 
		if (SFF[i].value<=number) number = SFF[i].value;
	printf("The smallest number between 1 Jan 1980 and 31 Dec 1984 is %.9lf\n", number);

	fclose(fp);
	getch();
}

//Reading data from the beginning of the file, writing them to an array. Malloc is used.
struct Data * GetFileData(FILE * fp, size_t * count)
{
	unsigned int i = 0;
	struct Data * output = NULL;
	*count = SearchInFile(fp, '\n');
	output = (struct Data *) malloc(*count * sizeof(struct Data));
	for (i = 0; i < *count; i++)
	{
		fscanf(fp,"%lf,%lu", &output[i].value, &output[i].time);
	}
	return output;
}

//Finding quantity of elements SEARCH found in the FP file from the beginning.
size_t SearchInFile(FILE * fp, char search)
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
void SWAP(struct Data *a, struct Data *b) {
	struct Data tmp;
	tmp = *a;
	*a = *b;
	*b = tmp;
}

//QuickSort.
void QuickSort(struct Data * SFF, size_t left, size_t right) {
	
	int i, last;
	if (left >= right)
		return;
	SWAP(&SFF[left], &SFF[(left + right) / 2]);
	last = left;
	for (i = left + 1; i <= right; i++)
		if (SFF[i].time < SFF[left].time) {
			SWAP(&SFF[++last], &SFF[i]);
		}
	SWAP(&SFF[left], &SFF[last]);
	if(last > 0) QuickSort(SFF, left, last - 1);
	QuickSort(SFF, last + 1, right);
	return;
}
