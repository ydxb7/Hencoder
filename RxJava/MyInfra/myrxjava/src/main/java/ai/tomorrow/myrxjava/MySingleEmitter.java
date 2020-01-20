package ai.tomorrow.myrxjava;

public interface MySingleEmitter<T> {
  void onSuccess(T t);

  void onError(Throwable t);

  void setDisposable(MyDisposable d);

  void setCancellable(MyCancellable c);

  boolean isDisposed();

  boolean tryOnError(Throwable t);
}
