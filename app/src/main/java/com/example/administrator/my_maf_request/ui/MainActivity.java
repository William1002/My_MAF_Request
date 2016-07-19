package com.example.administrator.my_maf_request.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.administrator.my_maf_request.R;
import com.example.administrator.my_maf_request.adapter.MyListAdapter;
import com.example.administrator.my_maf_request.bean.Subject;
import com.example.administrator.my_maf_request.presenter.SubjectPresenter;
import com.example.administrator.my_maf_request.view.ISubjectView;
import com.nd.android.okhttp.Response;
import com.sina.weibo.sdk.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ISubjectView {
    SubjectPresenter subjectPresenter;
    @BindView(R.id.btn_get_subject_data)
    Button btnGetSubjectData;
    MyListAdapter myListAdapter;
    @BindView(R.id.lis_subject)
    ListView lisSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        subjectPresenter = new SubjectPresenter(this, this);
        initViews();
    }

    void initViews() {
        btnGetSubjectData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjectPresenter.getSubjectCategoryListCommand();
            }
        });
        myListAdapter = new MyListAdapter(new ArrayList<Subject>(),this);
        lisSubject.setAdapter(myListAdapter);
    }

    @Override
    public void refreshList(List<Subject> subjectList) {
        LogUtil.e("MainActivity", "subjectList:" + subjectList.size());
        myListAdapter.setDataList(subjectList);
    }

    @Override
    public void getDataFailed(Response response) {

    }
}
