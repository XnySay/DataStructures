#include <stdio.h>
#include <stdlib.h>

#define MAX_SIZE 100  // 定义顺序表的最大长度

typedef struct {
    int data[MAX_SIZE];  // 存储空间
    int length;          // 当前长度
} SeqList;

void initSeqList(SeqList *list) {
    list->length = 0;
}

int insertSeqList(SeqList *list, int index, int element) {
    if (index < 0 || index > list->length || list->length == MAX_SIZE) {
        return 0;  // 插入位置不合法或表满
    }
    for (int i = list->length; i > index; i--) {
        list->data[i] = list->data[i - 1];  // 后移元素
    }
    list->data[index] = element;  // 插入元素
    list->length++;
    return 1;
}

int deleteSeqList(SeqList *list, int index, int *element) {
    if (index < 0 || index >= list->length) {
        return 0;  // 删除位置不合法
    }
    *element = list->data[index];  // 保存被删除元素
    for (int i = index; i < list->length - 1; i++) {
        list->data[i] = list->data[i + 1];  // 前移元素
    }
    list->length--;
    return 1;
}

int getElement(SeqList *list, int index, int *element) {
    if (index < 0 || index >= list->length) {
        return 0;  // 索引不合法
    }
    *element = list->data[index];
    return 1;
}

void printSeqList(SeqList *list) {
    for (int i = 0; i < list->length; i++) {
        printf("%d ", list->data[i]);
    }
    printf("\n");
}

int main() {

    int x = 10;
    int *a = &x;
    printf("%d\n",x);
    printf("%d\n",&x);
    printf("%d\n",*a);
    printf("%d\n",a);



//    SeqList list;
//    initSeqList(&list);
//    insertSeqList(&list,0,1);
//    insertSeqList(&list,1,2);
//    insertSeqList(&list,2,3);
//    insertSeqList(&list,1,9);
//    printSeqList(&list);

    return 0;
}