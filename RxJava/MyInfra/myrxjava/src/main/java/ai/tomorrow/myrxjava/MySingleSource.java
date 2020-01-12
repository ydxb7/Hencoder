package ai.tomorrow.myrxjava;

public interface MySingleSource<T> {
    void subscribe(MySingleObserver<? super T> observer);
}
