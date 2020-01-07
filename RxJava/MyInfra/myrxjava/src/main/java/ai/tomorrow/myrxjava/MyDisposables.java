package ai.tomorrow.myrxjava;

public final class MyDisposables {
    public static MyDisposable disposed() {
        return MyEmptyDisposable.INSTANCE;
    }
}
