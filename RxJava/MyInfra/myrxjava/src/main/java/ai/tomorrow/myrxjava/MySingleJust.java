package ai.tomorrow.myrxjava;

public final class MySingleJust<T> extends MySingle<T> {

    final T value;

    MySingleJust(T value){
        this.value = value;
    }

    @Override
    protected void subscribeActual(MySingleObserver<? super T> observer) {
        observer.onSubscribe(MyDisposables.disposed());
        observer.onSuccess(value);
    }
}
