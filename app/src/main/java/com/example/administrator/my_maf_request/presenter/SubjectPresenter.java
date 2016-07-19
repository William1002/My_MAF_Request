package com.example.administrator.my_maf_request.presenter;

import android.content.Context;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.administrator.my_maf_request.view.ISubjectView;
import com.example.administrator.my_maf_request.util.http.MAFHttpManager;
import com.example.administrator.my_maf_request.util.CommonUtils;
import com.example.administrator.my_maf_request.command.SubjectCommand;
import com.example.administrator.my_maf_request.bean.SubjectSum;

import com.nd.android.okhttp.Callback;
import com.nd.android.okhttp.Request;
import com.nd.android.okhttp.Response;
import com.nd.smartcan.frame.command.CommandCallback;

import java.io.IOException;

public class SubjectPresenter {
    ISubjectView subjectCategoryView;
    String subjectCategory_url = "http://esp-lifecycle.pre1.web.nd/v0.6/" +
            "categories/$S/datas?words&limit=(0,1000)";
    Context context;

    public SubjectPresenter(ISubjectView subjectCategoryView, Context context) {
        this.subjectCategoryView = subjectCategoryView;
        this.context = context;
    }

    public void getSubjectCategoryList() {
        MAFHttpManager.getSingleton().getSubjectCategoryData(CommonUtils.getSysLanguage(context),
                subjectCategory_url, new Callback() {
                    @Override
                    public void onFailure(Request request, IOException e) {
                        e.printStackTrace();

                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        ObjectMapper objectMapper = new ObjectMapper();
                        try {
                            SubjectSum resultData = objectMapper.readValue(response.body().string(), SubjectSum.class);
                            subjectCategoryView.refreshList(resultData.getItems());
                        } catch (JsonParseException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (JsonMappingException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                    }
                });
    }

    public void getSubjectCategoryListCommand() {
        new SubjectCommand(CommonUtils.getSysLanguage(context)).post(new CommandCallback<SubjectSum>() {
            @Override
            public void onSuccess(SubjectSum result) {
                subjectCategoryView.refreshList(result.getItems());
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }
}
