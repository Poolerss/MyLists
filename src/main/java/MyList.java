public interface MyList {
void addToHead (Object object);
Object getFirst();
Object getAndDeleteFirst();
void addToTail(Object object);
Object getLast();
Object getAndDeleteLast();
boolean checkToValue(Object object);
boolean isEmpty();
void deleteValue(Object object);
void print();
}
