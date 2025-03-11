package dataStructure.List;

public interface MyList<T> {

    void add(T param);

    T get(int index);

    T update(int index, T param);

    T delete(int index);

    int size();

}
