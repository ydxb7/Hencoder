package ai.tomorrow.myrxjava;

import java.util.concurrent.atomic.AtomicReference;

public final class MySingleCreate<T> extends MySingle<T> {
  final MySingleOnSubscribe<T> source;

  public MySingleCreate(MySingleOnSubscribe<T> source) {
    this.source = source;
  }

  @Override
  protected void subscribeActual(MySingleObserver<? super T> observer) {
    MyEmitter<T> parent = new MyEmitter<T>(observer);
    observer.onSubscribe(parent);
    source.subscribe(parent);
  }

  static final class MyEmitter<T>
      extends AtomicReference<MyDisposable> implements MySingleEmitter<T>, MyDisposable {

    private static final long serialVersionUID = -2467358622224974244L;

    final MySingleObserver<? super T> downstream;

    MyEmitter(MySingleObserver<? super T> downstream) {
      this.downstream = downstream;
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onSuccess(T value) {
      downstream.onSuccess(value);
    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void setDisposable(MyDisposable d) {

    }

    @Override
    public void setCancellable(MyCancellable c) {

    }

    @Override
    public boolean isDisposed() {
      return false;
    }

    @Override
    public boolean tryOnError(Throwable t) {
      return false;
    }
  }
}
