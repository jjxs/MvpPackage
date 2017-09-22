package com.example.mvppackage.mvp.contract;


import com.example.mvppackage.base.BaseModel;
import com.example.mvppackage.base.BasePresenter;
import com.example.mvppackage.base.BaseView;
import com.example.mvppackage.bean.Gank;

import rx.Observable;

/**
 * Created by Nicholas on 2016/10/30.
 */

public interface MainContract {

    interface View extends BaseView {

        void showDialog();

        void onSucceed(Gank data);

        void onFail(String err);

        void hideDialog();

    }

    interface Model extends BaseModel {
        Observable<Gank> getGank();
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void getGank();
    }
}
