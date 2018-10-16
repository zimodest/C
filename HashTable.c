#pragma once
#include<stdlib.h>
#include<assert.h>
typedef int Key;

typedef enum 
{
	Empty, //空的
	Exist, //有数据的
	Delete //被删除的
}State;

typedef struct Element
{
	Key key;
	State state;
}Element;

typedef int(*HashfuncType)(Key key,int capacity );  //HashfuncType是一个typedef后的函数类型

typedef struct HashTable
{
	Element* table;
	int size;      //数据的个数
	int capacity;  //容量
	HashfuncType hashFunc; //哈希函数
}HashTable;

//初始化/销毁
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
//查找
int HashSearch(HashTable* pHT,Key key)
{
	int index = pHT->hashFunc(key,pHT->capacity);  //此时hashFunc实际指向的是mod函数，hashFunc只是在此函数中的形参
	while (pHT->table[index].state != Empty)
	{
		if(pHT->table[index].key == key)
		{
			return index;  //找到了，直接返回
		}
		//如果哈希表存满了，则会陷入死循环
		//但哈希表不会存满
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
//没找到
return -1;
}

int HashInsert(HashTable* pHT,Key key);

void ExpandIfRequired(HashTable* pHT)
{
	int i=0;
	HashTable newHT;
	//不扩容
	if(pHT->size*10/pHT->capacity < 7)
	{
		return;
	}
#if 0  //数据搬移太麻烦
	int newCapacity = pHT->capacity * 2;
	Element *newTable = (Element*)malloc(sizeof(Element)*newCapacity);
	assert(newTable);
	//newTable的状态都置为empty	
	for(int i=0;i<newCapacity;i++)
	{
		newTable[i].state = EMPTY;
	}
	//把老的数据搬过来
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

//插入
//Key不允许重复
//0表示插入成功，-1表示插入失败
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

//删除
//成功返回0，失败返回-1
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
