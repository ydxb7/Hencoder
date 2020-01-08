package ai.tomorrow.myrxjava;

public enum MyEmptyDisposable implements MyDisposable {
    INSTANCE, NEVER;

    @Override
    public void dispose() { }

    @Override
    public boolean isDisposed() {
        return this == INSTANCE;
    }
}
