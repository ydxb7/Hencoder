package ai.tomorrow.myrxjava;

public final class MySingleMap<T, R> extends MySingle<R>{

    final MySingleSource<? extends T> source;
    final MyFunction<? super T, ? extends R> mapper;

    public MySingleMap(MySingleSource<? extends T> source, MyFunction<? super T, ? extends R> mapper) {
        this.source = source;
        this.mapper = mapper;
    }

    @Override
    protected void subscribeActual(final MySingleObserver<? super R> observer) {
        source.subscribe(new MyMapSingleObserver<T, R>(observer, mapper));
    }

    static final class MyMapSingleObserver<T, R> implements MySingleObserver<T>{

        final MySingleObserver<? super R> observer;
        final MyFunction<? super T, ? extends R> mapper;

        public MyMapSingleObserver(MySingleObserver<? super R> observer, MyFunction<? super T, ? extends R> mapper) {
            this.observer = observer;
            this.mapper = mapper;
        }

        @Override
        public void onSubscribe(MyDisposable disposable) {
            observer.onSubscribe(disposable);
        }

        @Override
        public void onSuccess(T t) {
            R v;
            try {
                v = mapper.apply(t);
            } catch (Throwable e){
                onError(e);
                return;
            }
            observer.onSuccess(v);
        }

        @Override
        public void onError(Throwable e) {
            observer.onError(e);
        }
    }
}
