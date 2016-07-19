package com.example.administrator.my_maf_request.view;


import com.nd.android.okhttp.Response;
import com.example.administrator.my_maf_request.bean.Subject;
import java.util.List;


public interface ISubjectView {
    void refreshList(List<Subject> subjectCategoryList);

    void getDataFailed(Response response);
}
