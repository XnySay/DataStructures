#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Contact {
    char name[50];
    char phone[20];
    char student_id[20];
    char birthdate[11]; // 格式 YYYY-MM-DD
    struct Contact *next;
} Contact;

Contact *createContact(const char *name, const char *phone, const char *student_id, const char *birthdate) {
    Contact *newContact = (Contact *)malloc(sizeof(Contact));
    if (newContact) {
        strcpy(newContact->name, name);
        strcpy(newContact->phone, phone);
        strcpy(newContact->student_id, student_id);
        strcpy(newContact->birthdate, birthdate);
        newContact->next = NULL;
    }
    return newContact;
}

void addContact(Contact **head, const char *name, const char *phone, const char *student_id, const char *birthdate) {
    Contact *newContact = createContact(name, phone, student_id, birthdate);
    if (*head == NULL) {
        *head = newContact;
    } else {
        Contact *current = *head;
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = newContact;
    }
}

void printContacts(Contact *head) {
    Contact *current = head;
    while (current != NULL) {
        printf("Name: %s\n", current->name);
        printf("Phone: %s\n", current->phone);
        printf("Student ID: %s\n", current->student_id);
        printf("Birthdate: %s\n", current->birthdate);
        printf("\n");
        current = current->next;
    }
}

int main() {
    printf("你好");
}

