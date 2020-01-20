package ai.tomorrow.myrxjava;

public abstract class MySingle<T> implements MySingleSource<T> {
  public static <T> MySingle<T> just(final T item) {
    return new MySingleJust<>(item);
  }

  public final void subscribe(MySingleObserver<? super T> observer) {
    subscribeActual(observer);
  }

  protected abstract void subscribeActual(MySingleObserver<? super T> observer); // todo super

  public final <R> MySingle<R> map(MyFunction<? super T, ? extends R> mapper) {
    return new MySingleMap<T, R>(this, mapper);
  }
}
