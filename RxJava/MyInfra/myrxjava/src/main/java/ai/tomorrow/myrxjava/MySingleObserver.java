package ai.tomorrow.myrxjava;

public interface MySingleObserver<T> {
    void onSubscribe(MyDisposable disposable);
    void onSuccess(T t);
    void onError(Throwable e);
}
