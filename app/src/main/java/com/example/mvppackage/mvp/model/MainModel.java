package com.example.mvppackage.mvp.model;


import com.example.mvppackage.api.ApiEngine;
import com.example.mvppackage.bean.Gank;
import com.example.mvppackage.mvp.contract.MainContract;
import com.example.mvppackage.rx.RxSchedulers;

import rx.Observable;

/**
 * Created by Nicholas on 2016/10/30.
 */

public class MainModel implements MainContract.Model {

    @Override
    public Observable<Gank> getGank() {
        return ApiEngine.getInstance().getApiService()
                .getGank("1")
                .compose(RxSchedulers.<Gank>switchThread());
    }
}
