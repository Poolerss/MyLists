import java.util.function.Consumer;
import java.util.function.Predicate;

public interface MyList <T> extends Iterable <T> {
void addToHead (T object);
T getFirst();
T getAndDeleteFirst();
void addToTail(T object);
T getLast();
T getAndDeleteLast();
boolean checkToValue(T object);
boolean isEmpty();
void deleteValue(T object);
void print();


}
