package com.example.mvppackage.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvppackage.R;
import com.example.mvppackage.base.BaseActivity;
import com.example.mvppackage.base.BasePresenter;
import com.example.mvppackage.bean.Gank;
import com.example.mvppackage.mvp.contract.MainContract;
import com.example.mvppackage.mvp.presenter.MainPresenter;

import java.util.List;
import java.util.Random;

public class MainActivity extends BaseActivity<MainPresenter> implements
        MainContract.View{

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView textContent;
    private ProgressDialog mDialog;
    private Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textContent = (TextView) findViewById(R.id.text_content);
        btnClick = (Button) findViewById(R.id.btn_click);

        mDialog = new ProgressDialog(this);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setCancelable(false);
        mDialog.setMessage("正在加载...");

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getGank();
            }
        });
    }

    @Override
    protected MainPresenter onCreatePresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showDialog() {
        mDialog.show();
    }

    @Override
    public void onSucceed(Gank data) {
        Toast.makeText(this, "请求成功", Toast.LENGTH_SHORT).show();
        List<Gank.Result> results = data.getResults();
        textContent.setText(results.get(new Random().nextInt(10)).toString());

        for (Gank.Result result : results) {
            Log.e(TAG, result.toString());
        }
    }

    @Override
    public void onFail(String err) {
        Log.e(TAG, err);
        Toast.makeText(this, "请求失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideDialog() {
        mDialog.dismiss();
    }


}
