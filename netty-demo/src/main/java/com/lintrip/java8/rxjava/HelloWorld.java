package com.lintrip.java8.rxjava;

import rx.Observable;
import rx.Subscriber;

/**
 * @author gyt
 * @date 2022/10/21 18:37
 */
public class HelloWorld {

    public static void main(String[] args) {
        Observable<String> sender = Observable.create(new Observable.OnSubscribe<String>(){
            @Override
            public void call(Subscriber<? super String> subscriber) {

            }
        });
        Observer<String> receiver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        sender.subscribe(receiver);
    }

}
