package ai.tomorrow.myrxjava;

public interface MySingleOnSubscribe<T> {
  void subscribe(MySingleEmitter<T> emitter);
}
