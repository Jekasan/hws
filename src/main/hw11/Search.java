package hw11;

import java.util.List;

public interface Search<T> {
    T find(T numbers);
    List getSortedList();
}
