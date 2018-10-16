#pragma once
#include<stdlib.h>
#include<assert.h>
typedef int Key;

typedef enum 
{
	Empty, //�յ�
	Exist, //�����ݵ�
	Delete //��ɾ����
}State;

typedef struct Element
{
	Key key;
	State state;
}Element;

typedef int(*HashfuncType)(Key key,int capacity );  //HashfuncType��һ��typedef��ĺ�������

typedef struct HashTable
{
	Element* table;
	int size;      //���ݵĸ���
	int capacity;  //����
	HashfuncType hashFunc; //��ϣ����
}HashTable;

//��ʼ��/����
void HashInit(HashTable* pHT,int capacity,HashfuncType hashFunc)
{
	int i = 0;
	pHT->table = (Element*)malloc(sizeof(Element)*capacity);
	assert(pHT->table);
	pHT->size = 0;
	pHT->capacity = capacity;
	pHT->hashFunc = hashFunc;
	for(i =0;i<capacity;i++)
	{
		pHT->table[i].state = Empty;
	}
}

void HashDestroy(HashTable* pHT)
{
	free(pHT->table);
}

//-
//����
int HashSearch(HashTable* pHT,Key key)
{
	int index = pHT->hashFunc(key,pHT->capacity);  //��ʱhashFuncʵ��ָ�����mod������hashFuncֻ���ڴ˺����е��β�
	while (pHT->table[index].state != Empty)
	{
		if(pHT->table[index].key == key)
		{
			return index;  //�ҵ��ˣ�ֱ�ӷ���
		}
		//�����ϣ������ˣ����������ѭ��
		//����ϣ�������
#if 0 
		index = index+1;
		if(index == pHT->capacity)
		{
			index = 0;
		}
		else
			index = (index+1)%pHT->capacity;
	}
#endif
}
//û�ҵ�
return -1;
}

int HashInsert(HashTable* pHT,Key key);

void ExpandIfRequired(HashTable* pHT)
{
	int i=0;
	HashTable newHT;
	//������
	if(pHT->size*10/pHT->capacity < 7)
	{
		return;
	}
#if 0  //���ݰ���̫�鷳
	int newCapacity = pHT->capacity * 2;
	Element *newTable = (Element*)malloc(sizeof(Element)*newCapacity);
	assert(newTable);
	//newTable��״̬����Ϊempty	
	for(int i=0;i<newCapacity;i++)
	{
		newTable[i].state = EMPTY;
	}
	//���ϵ����ݰ����
	free(pHT->table);
	pHT->table=newTable;
	pHT->capacity = newCapacity;
#endif

	HashInit(&newHT,pHT->capacity*2,pHT->hashFunc);
	for(i=0;i< pHT->capacity;i++)
	{
		if(pHT->table[i].state ==Exist)
		{
			HashInsert(&newHT,pHT->table[i].key);
		}
	}
	free(pHT->table);
	pHT->table = newHT.table;
	pHT->capacity = newHT.capacity; 
}

//����
//Key�������ظ�
//0��ʾ����ɹ���-1��ʾ����ʧ��
int HashInsert(HashTable* pHT,Key key)
{
	int index;
	ExpandIfRequired(pHT);
	index = pHT->hashFunc(key,pHT->capacity);
	while(1)
	{
		if(pHT->table[index].key == key && pHT->table[index].state == Exist)
		{
			return -1;
		}
		if(pHT->table[index].state != Exist)
		{
			pHT->table[index].key = key;
			pHT->table[index].state = Exist;
			pHT->size++;
			return 0;
		}
		index = (index+1)%pHT->capacity;
	}
}

//ɾ��
//�ɹ�����0��ʧ�ܷ���-1
int HashRemove(HashTable* pHT,Key key)
{
	int index = pHT->hashFunc(key,pHT->capacity);
	while(pHT->table[index].state != Empty)
	{
		if(pHT->table[index].key == key && pHT->table[index].state ==Exist)
		{
			pHT->table[index].state = Delete;
			return 0;
		}
		index = (index+1)%pHT->capacity;
	}
	return -1;
}

int mod(Key key,int capacity)
{
	return key%capacity;
}
#include<stdio.h>
int main()
{
	HashTable ht;
	HashInit(&ht,10,mod);

	HashInsert(&ht,1);
	HashInsert(&ht,11);
	HashInsert(&ht,21);
	HashInsert(&ht,31);
	HashInsert(&ht,41);
	HashInsert(&ht,51);
	HashInsert(&ht,61);

	HashDestroy(&ht);
	return 0;
}
