#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare(const void* f, const void* s) {
	int *a = (int*)f;
	int *b = (int*)s;

	if(*a > *b)
		return 1;
	else
		return -1;
}

int lower_bound(int *card, int key, int size) {
	int mid, start = 0, end = size - 1;

	while(start < end) {
		mid = (start + end) / 2;
		if(key <= card[mid])
			end = mid;
		else
			start = mid + 1;
	}
	return end;
}

int upper_bound(int *card, int key, int size) {
	int mid, start = 0, end = size - 1;

	while(start < end) {
		mid = (start + end) / 2;
		if(key < card[mid])
			end = mid;
		else
			start = mid + 1;
	}
	if(card[end] == key)
		return end + 1;
	return end;
}

int main(void) {
	int n, m, lower, upper;
	int *card, *s;

	scanf("%d", &n);
	card = (int*)malloc(sizeof(int)*n);
	for(int i=0; i<n; i++) {
		scanf("%d", &card[i]);
	}
	qsort(card, n, sizeof(card[0]), compare);
	
	scanf("%d", &m);
	s = (int*)malloc(sizeof(int)*m);
	for(int i=0; i<m; i++) {
		scanf("%d", &s[i]);
	}

	for(int i=0; i<m; i++) {
		lower = lower_bound(card, s[i], n);
		upper = upper_bound(card, s[i], n);
		printf("%d ", upper-lower);
	}
	
	
	
	return 0;
}

