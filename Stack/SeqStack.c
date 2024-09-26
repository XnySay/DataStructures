#include<stdio.h>
#include <stdbool.h>
#define MaxSize 50

typedef struct{
    int data[MaxSize];
    int top;

} SeqStack;

void InitStack(SeqStack *S){
    S->top = -1;
}

bool StackEmpty(SeqStack *S){
    if (S->top == -1)
        return true;
    else
        return false;
}

bool Push(SeqStack *S,int x){

    if(S->top == MaxSize -1)
        return false;

    S->data[++S->top] = x;
    return true;

}

bool Pop(SeqStack *S){

    if(S->top == -1)
        return false;

    int x = S->data[S->top--];
    printf("弹出：%d\n",x);
    return true;

}

int GetTop(SeqStack *S){

    if(S->top == -1)
        return false;
    printf("栈顶元素是：%d\n",S->data[S->top]);
    return S->data[S->top];

}

int main(){


    SeqStack stack;
    InitStack(&stack);
    StackEmpty(&stack);
    Push(&stack,1);
    Push(&stack,2);
    Push(&stack,3);
    Pop(&stack);
    GetTop(&stack);

    return 0;
}
