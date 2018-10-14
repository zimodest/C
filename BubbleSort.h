#pragma once

#include<stdio.h>

void Swap(int *a, int *b) {
	int t = *a;
	*a = *b;
	*b = t;
}

void PrintArray(int array[], int size) {
	int i;
	for (i = 0; i < size; i++) {
		printf("%d ", array[i]);
	}

	printf("\n");
}

void BubbleSort(int array[], int size) {
	int i, j;
	for (i = 0; i < size-1; i++) {
		for (j = 0; j < size - 1 - i; j++) {
			if (array[j] > array[j + 1]) {
				Swap(array + j, array + j + 1);
			}
		}
	}
}
