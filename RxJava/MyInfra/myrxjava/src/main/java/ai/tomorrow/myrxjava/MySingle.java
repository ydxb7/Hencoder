package ai.tomorrow.myrxjava;

public abstract class MySingle<T> {
    public static <T> MySingle<T> just(final T item){
        return new MySingleJust<>(item);
    }

    public final void subscribe(MySingleObserver<? super T> observer) {
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(MySingleObserver<? super T> observer); // todo super
}
