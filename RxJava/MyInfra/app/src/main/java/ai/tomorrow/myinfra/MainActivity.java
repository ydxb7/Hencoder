package ai.tomorrow.myinfra;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ai.tomorrow.myrxjava.MyDisposable;
import ai.tomorrow.myrxjava.MyFunction;
import ai.tomorrow.myrxjava.MySingle;
import ai.tomorrow.myrxjava.MySingleObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        setup();
    }

    private void setup() {
//        Single.just(1)
//                .map(new Function<Integer, String>() {
//                    @Override
//                    public String apply(Integer integer) throws Exception {
//                        return String.valueOf(integer);
//                    }
//                })
//                .subscribe(new SingleObserver<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(String s) {
//                        textView.setText(s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//                });

        MySingle.just(1)
                .map(new MyFunction<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return String.valueOf(integer);
                    }
                })
                .subscribe(new MySingleObserver<String>() {
                    @Override
                    public void onSubscribe(MyDisposable disposable) {

                    }

                    @Override
                    public void onSuccess(String s) {
                        textView.setText(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
