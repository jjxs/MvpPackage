package com.example.mvppackage.mvp.presenter;

import com.example.mvppackage.bean.Gank;
import com.example.mvppackage.mvp.contract.MainContract;
import com.example.mvppackage.mvp.model.MainModel;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by Fangzheng on 2017/9/21.
 */

public class MainPresenter extends MainContract.Presenter {
    public MainPresenter(MainContract.View view) {
        mView = view;
        mModel = new MainModel();
    }

    @Override
    public void getGank() {

        Subscription subscribe = mModel.getGank()
                .subscribe(new Subscriber<Gank>() {

                    @Override
                    public void onStart() {
                        mView.showDialog();
                    }

                    @Override
                    public void onCompleted() {
                        mView.hideDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onFail(e.getMessage());
                        onCompleted();
                    }

                    @Override
                    public void onNext(Gank gank) {
                        mView.onSucceed(gank);
                    }
                });


        addSubscribe(subscribe);
    }
}
