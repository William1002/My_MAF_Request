package com.example.administrator.my_maf_request.command;


import com.example.administrator.my_maf_request.bean.SubjectSum;
import com.example.administrator.my_maf_request.dao.SubjecDao;
import com.nd.smartcan.frame.command.RequestCommand;


public class SubjectCommand extends RequestCommand<SubjectSum> {
    String languageName;

    public SubjectCommand(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public SubjectSum execute() throws Exception {

        return new SubjecDao(languageName).get(null);
    }
}
