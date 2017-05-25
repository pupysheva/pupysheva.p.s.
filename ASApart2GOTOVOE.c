#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<time.h>
#include<string.h>

struct Data {
	double value;
	unsigned long int time;
};

typedef struct Node{
	struct Data data;
	struct Node *left;
	struct Node *right;
} tnode;

//Creating a copy of an array of structures using malloc.
struct Data * CopyDataArrayMalloc(const struct Data * ReadData, size_t count);

//Copying an array of structures.
void CopyDataArray(const struct Data * From, struct Data * To, size_t count);

//Reading the data from the keyboard.
struct Data * ReadArrayDataFromKeyboard(size_t * count);

//Asks the user what array to create and creates an array.
struct Data * CreateRandomArrayInterface(size_t * count);

//Sorted array output.
void PrintArray(struct Data * arr, size_t count);

//Creating a random array.
struct Data * CreateRandomArray(size_t count);

//Swapping of structs.
void SWAP(struct Data *x, struct Data *y);

//Sorts and searches.
void QuickSort(struct Data * ReadData, size_t left, size_t right, unsigned long int * c_sw, unsigned long int * c_if);
void BubbleSort(struct Data * ReadData, size_t SizeofStruct, unsigned long int * c_sw, unsigned long int * c_if);
void LinearInsertion(struct Data * ReadData, size_t SizeofStruct, unsigned long int * c_sw, unsigned long int * c_if);
int LinearSearch(double number, struct Data * SFF, int count, unsigned long int * c_if);
int BinarySearch(struct Data * ReadData, size_t count, unsigned long int numtofind, unsigned long int * c_if);
int Interpolationsearch(struct Data * ReadData, size_t count, unsigned long int numtofind, unsigned long int * c_if);

//Tree sort.
tnode* ADDING_TREE_NODE(tnode * tree, struct Data elem, unsigned long int * c_sw, unsigned long int * c_if);
void TREE_ARRAY_SCAN(struct Data * mas, tnode * tree, int lflag, unsigned long int * c_sw, unsigned long int * c_if);
void DELETE_TREE(tnode *tree);
int SORT_TREE(struct Data *mas, int count, unsigned long int * c_sw, unsigned long int * c_if);

int main(void) {
	int proverka, result1;
	unsigned int i, iminLEANER;
	float T;
	double number1;
	unsigned long int Minb, numtofind;
	size_t count = 0;
	srand(time(NULL));
	struct Data * ReadData;
	switch (Change("Choose a way of specifying an array of structures:\nEntering data from the keyboard - 1\nGenerating a random array of structures - 2\n", 1, 2))
	{
	case 1:
		ReadData = ReadArrayDataFromKeyboard(&count);
		break;
	case 2:
		ReadData = CreateRandomArrayInterface(&count);
		break;
	}
	unsigned long int c_if = 0, c_sw = 0; //Quantity of comparisons and permutations
	struct Data * b = CopyDataArrayMalloc(ReadData, count);


	//-------------------------Linear search-------------------------------
	printf("Enter time for seaches: ");
	scanf("%lu", &numtofind);
	T = clock();
	result1 = LinearSearch(numtofind, ReadData, count, &c_if);
	T = (clock() - T) / CLOCKS_PER_SEC;
	if (T != 0) printf("\nSEARCH! time LinearSearch:  %.3f sec\t \t", T);
	else printf("\nSEARCH! time LinearSearch: <0.001 sec\t \t");

	if(result1==1)
		printf("Number found\t");
	else printf("Number not found\t");

	printf("if: %lu\n", c_if);
	c_sw = 0, c_if = 0;
	printf("\n");



	//--------------------------Quick sort---------------------------
	T = clock();
	QuickSort(b, 0, count - 1, &c_sw, &c_if);
	T = (clock() - T) / CLOCKS_PER_SEC;
	if (T != 0) printf("\nSORT! time QuickSort:  %.3f sec\t\t", T);
	else printf("\nSORT! time QuickSort: <0.001 sec\t\t");
	printf("swap: %lu\t\tif: %lu\n", c_sw, c_if);
	c_sw = 0, c_if = 0;
	printf("\n");
	
	//PrintArray(b, count);

	//-------------------------Binary search-------------------------
	T = clock();
	proverka = BinarySearch(b, count, numtofind, &c_if);
	T = (clock() - T) / CLOCKS_PER_SEC;
	if (T != 0) printf("\nSEARCH! time BinarySearch:  %.3f sec\t\t", T);
	else printf("\nSEARCH! time BinarySearch: <0.001 sec\t\t");
	if (proverka == 1)
		printf("Number found\t");
	else printf("Number not found\t");
	printf("if: %lu\n", c_if);
	c_if = 0;
	proverka = 0;
	printf("\n");



	//------------------------Interpolation search----------------------
	T = clock();
	proverka = Interpolationsearch(b, count, numtofind, &c_if);
	T = (clock() - T) / CLOCKS_PER_SEC;
	if (T != 0) printf("\nSEARCH! time InterpolationSearch:  %.3f sec\t", T);
	else printf("\nSEARCH! time InterpolationSearch: <0.001 sec\t");
	if (proverka == 1)
		printf("Number found\t");
	else printf("Number not found\t");
	printf("if: %lu\n", c_if);
	c_if = 0;
	printf("\n");



	//----------------------------Bubble sort----------------------------------------
	CopyDataArray(ReadData, b, count);
	T = clock();
	BubbleSort(b, count, &c_sw, &c_if);
	T = (clock() - T) / CLOCKS_PER_SEC;
	if (T != 0) printf("\nSORT! time BubbleSort:  %.3f sec\t\t", T);
	else printf("\nSORT! time BubbleSort: <0.001 sec\t\t");
	printf("swap: %lu\t\tif: %lu\n", c_sw, c_if);
	c_sw = 0, c_if = 0;
	printf("\n");



	//----------------------------Insertion sort-------------------------------------
	CopyDataArray(ReadData, b, count);
	T = clock();
	LinearInsertion(b, count, &c_sw, &c_if);
	T = (clock() - T) / CLOCKS_PER_SEC;
	if (T != 0) printf("\nSORT! time LinearInsertion:  %.3f sec\t\t", T);
	else printf("\nSORT! time LinearInsertion: <0.001 sec\t\t");
	printf("swap: %lu\t\tif: %lu\n", c_sw, c_if);
	c_sw = 0, c_if = 0;
	printf("\n");



	//-----------------------------Sort_tree-----------------------------------------
	CopyDataArray(ReadData, b, count);
	T = clock();
	SORT_TREE(b, count, &c_sw, &c_if);
	T = (clock() - T) / CLOCKS_PER_SEC;
	if (T != 0) printf("\nSORT! time SortTree:  %.3f sec\t\t\t", T);
	else printf("\nSORT! time SortTree: <0.001 sec\t\t\t");
	printf("swap: %lu\t\tif: %lu\n", c_sw, c_if);
	c_sw = 0, c_if = 0;
	printf("\n");

	//PrintArray(b, count);

	free(b);
	free(ReadData);
	getch();
}


//Sorted array output.
void PrintArray(struct Data * arr, size_t count){
	size_t i;
	for (i = 0; i < count; i++){
		printf("time: %9lu,\tvalue: %lf\n", arr[i].time, arr[i].value);
	}
}

//Swapping of structs.
void SWAP(struct Data *x, struct Data *y) {
	struct Data tmp;
	tmp = *x;
	*x = *y;
	*y = tmp;
}

//QuickSort
void QuickSort(struct Data * ReadData, size_t left, size_t right, unsigned long int * c_sw, unsigned long int * c_if) {
	long int i, last;
	if (left >= right)
		return;
	SWAP(&ReadData[left], &ReadData[(left + right) / 2]);
	(*c_sw)++;
	last = left;
	for (i = left + 1; i <= right; i++){
		(*c_if)++;
		if (ReadData[i].time < ReadData[left].time) {
			SWAP(&ReadData[++last], &ReadData[i]);
			(*c_sw)++;
		}
	}
	SWAP(&ReadData[left], &ReadData[last]);
	(*c_sw)++;
	if (last>0) QuickSort(ReadData, left, last - 1, c_sw, c_if);
	QuickSort(ReadData, last + 1, right, c_sw, c_if);
	return;
}

//Creating a copy of an array of structures using malloc.
struct Data * CopyDataArrayMalloc(const struct Data * ReadData, size_t count) {
	struct Data* Output = (struct Data *)malloc(count * sizeof(struct Data));
	if (Output == NULL) return NULL;
	memcpy(Output, ReadData, count * sizeof(struct Data));
	return Output;
}

//Copying an array of structures.
void CopyDataArray(const struct Data * From, struct Data * To, size_t count){
	memcpy(To, From, count * sizeof(struct Data));
}


//Generating random arrays of structures
void GenArray(struct Data * input, size_t count){
	for (size_t i = 0; i < count; ++i){
		input[i].time = rand() % 379837 * 5531 + 1;
		input[i].value = rand() % 9679 * 0.000049237 + 0.00000021613004;
	}
}

//Creating a random array.
struct Data * CreateRandomArray(size_t count){
	struct Data * output = (struct Data *) malloc(count * sizeof(struct Data));
	if (output == NULL) return NULL;
	GenArray(output, count);
	return output;
}

//Asks the user what array to create and creates an array.
struct Data * CreateRandomArrayInterface(size_t * count){
	*count = 0;
	printf("Enter the quantity of data: ");
	while (scanf("%u", count) <= 0 && *count <= 0);
	struct Data * output = CreateRandomArray(*count);
	return output;
}

//Read one structure from the keyboard
struct Data ReadDataFromKeyboard(){
	struct Data output = { 0 };
	printf("Enter time: ");
	while (scanf("%lu", &output.time) != 1);
	printf("Enter value: ");
	while (scanf("%lf", &output.value) != 1);
	return output;
}

//Reading the data from the keyboard.
struct Data * ReadArrayDataFromKeyboard(size_t * count){
	struct Data * output;
	size_t i = 0;
	*count = 0;
	printf("Enter the quantity of data: ");
	while (scanf("%u", count) <= 0 && *count <= 0);
	output = (struct Data*)malloc(*count * sizeof(struct Data));
	for (i = 0; i < *count; i++)
	{
		output[i] = ReadDataFromKeyboard();
	}
	return output;
}

int Change(char * text, int min, int max){
	int read = 0;
	printf("%s", text);
	while (scanf("%d", &read) <= 0 && read >= min && read <= max);
	return read;
}

//BubbleSort
void BubbleSort(struct Data * ReadData, size_t SizeofStruct, unsigned long int * c_sw, unsigned long int * c_if) {
	long int i, j;
	for (i = 0; i < SizeofStruct - 1; i++)
		for (j = SizeofStruct - 2; j >= i; j--) {
			(*c_if)++;
			if (ReadData[j].time > ReadData[j + 1].time) {
				(*c_sw)++;
				SWAP(&ReadData[j], &ReadData[j + 1]);
			}
		}
}

//LinearInsertion
void LinearInsertion(struct Data * ReadData, size_t SizeofStruct, unsigned long int * c_sw, unsigned long int * c_if) {
	long int i, j;
	for (i = 0; i < SizeofStruct; i++) {
		for (j = i; (j > 0) && (ReadData[j - 1].time > ReadData[j].time); j--) {
			(*c_if)++;
			(*c_sw)++;
			SWAP(&ReadData[j], &ReadData[j - 1]);
		}
		if (j>0) (*c_if)++;
	}
}

//BinarySearch
int BinarySearch(struct Data * ReadData, size_t count, unsigned long int numtofind, unsigned long int * c_if) {
	size_t low, mid, high;
	low = 0;
	high = count - 1;
	while (low <= high) {
		mid = (low + high) / 2;
		(*c_if)++;
		if (numtofind < ReadData[mid].time){
			if (mid > 0)
				high = mid - 1;
			else return -1;
		}
		else{
			(*c_if)++;
			if (numtofind > ReadData[mid].time){
				if (mid < count - 1)
					low = mid + 1;
				else return -1;
			}
			else return 1;
		}
	}
	return -1;
}

//Interpolationsearch
int Interpolationsearch(struct Data * ReadData, size_t count, unsigned long int numtofind, unsigned long int * c_if) {
	size_t left = 0, right = count - 1, mid;
	while (ReadData[left].time < numtofind && numtofind < ReadData[right].time) {
		(*c_if) += 2;
		mid = left + (numtofind - ReadData[left].time) * (right - left) / (ReadData[right].time - ReadData[left].time);
		(*c_if)++;
		if (ReadData[mid].time < numtofind)
			left = mid + 1;
		else {
			(*c_if)++;
			if (ReadData[mid].time > numtofind)
				right = mid - 1;
			else
				return 1;
		}
	}
	if (ReadData[left].time >= numtofind || numtofind >= ReadData[right].time)(*c_if)++;
	else (*c_if) += 2;
	(*c_if)++;
	if (ReadData[left].time == numtofind) return 1;
	else {
		(*c_if)++;
		if (ReadData[right].time == numtofind) return 1;
		else
			return -1;
	}
}

//LinearSearch
int LinearSearch(double number, struct Data * ReadData, int count, unsigned long int * c_if) {
	int i;
	for (i = 0; i < count; i++) {
		(*c_if)++;
		if (number == ReadData[i].time)
			return 1;
	}
	return -1;
}

//TreeSort
int SORT_TREE(struct Data *mas, int count, unsigned long int * c_sw, unsigned long int * c_if) {
	int i;
	tnode *tree;
	tree = 0;
	for (i = 0; i<count; ++i)
		tree = ADDING_TREE_NODE(tree, mas[i], c_sw, c_if);
	TREE_ARRAY_SCAN(mas, tree, 1, c_sw, c_if);
	DELETE_TREE(tree);
	return 0;
}

void TREE_ARRAY_SCAN(struct Data * mas, tnode * tree, int lflag, unsigned long int * c_sw, unsigned long int * c_if) {
	static int i;
	if (tree) {
		if (tree->left) {
			TREE_ARRAY_SCAN(mas, tree->left, 0, c_sw, c_if);
		}
		mas[i++] = tree->data;
		if (tree->right) {
			TREE_ARRAY_SCAN(mas, tree->right, 0, c_sw, c_if);
		}
	}
	if (lflag) i = 0;
}

tnode* ADDING_TREE_NODE(tnode * tree, struct Data elem, unsigned long int * c_sw, unsigned long int * c_if) {
	if (tree) {
		if ((elem.time)<((tree->data).time)) {
			++(*c_if);
			tree->left = ADDING_TREE_NODE(tree->left, elem, c_sw, c_if);
		}
		else {
			++(*c_if);
			tree->right = ADDING_TREE_NODE(tree->right, elem, c_sw, c_if);
		}
	}
	else {
		++(*c_sw);
		tree = (tnode*)malloc(sizeof(tnode));
		tree->data = elem;
		tree->left = 0;
		tree->right = 0;
	}
	return (tree);
}

void DELETE_TREE(tnode *tree) {
	if (tree) {
		DELETE_TREE(tree->left);
		DELETE_TREE(tree->right);
		free(tree);
	}
}