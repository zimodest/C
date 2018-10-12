#pragma once

#include<stdio.h>

void PrintArray(int array[], int size) {
	int i; 
	for (i = 0; i < size; i++) {
		printf("%d", array[i]);
	}

	printf("\n");
}

void Swap(int *a, int *b) {
	int t = *a;
	*a = *b;
	*a = t;
}
//� o(n^2) ��� o(1��
//��������
//��ǰ������
//���������ȶ�
void InsertSort(int array[], int size) {
	int i, j;
	int key;
	for (i = 0; i < size; i++) {
		key = array[i];
		for (j = i - 1; j >= 0; j--) {
			if (key < array[j]) {
				array[j + 1] = array[j];
			}else {
				break;
			}
		}
		array[j + 1] = key;

	}
}

void InsertSort2(int array[], int size) {
	int i, j;
	int key;
	int left, right;
	int mid;
	for (i = 0; i < size; i++) {
		key = array[i];
		left = 0;
		right = i-1;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (array[mid] <= key) {
				left = mid + 1;
			}
			else {
				break;
			}
		}
		for (j = i; j > left; j--) {
			array[j] = array[j - 1];
		}
		array[left] = key;
	}
}
void ShellSort(int array[], int size) {
	int gap = size;
	int i, j, g;
	int key;
	//��gap��Ϊ1ʱ����Ԥ���򣬵�gapΪ1ʱ���������һ�β���
	while(1){
		gap = gap / 3 + 1;
		//һ���� gap ��
		for (g = 0; g < gap; g++) {
			//�ֱ�����в���
			for (i = g + gap; i < size; i += gap) {
				 key = array[i];
				for (j = i - gap; j >= 0; j -= gap) {
					if (key < array[j]) {
						array[j + gap] = array[j];
					}
					else {
						break;
					}
				}
				array[j + gap] = key;
			}
		}
		if (gap == 1) {
			break;
		}
	}
}

void TestShellSort() {
	int array[] = { 3,5,1,4,2,9,7,6,8,0 };
	int size = sizeof(array) / sizeof(array[0]);
	//ShellSort(array, size);
	InsertSort2(array, size);
	PrintArray(array, size);
}