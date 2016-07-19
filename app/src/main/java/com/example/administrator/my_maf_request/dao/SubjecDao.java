package com.example.administrator.my_maf_request.dao;

import  com.example.administrator.my_maf_request.bean.SubjectSum;
import com.nd.smartcan.core.restful.ClientResource;
import com.nd.smartcan.core.restful.ResourceException;
import com.nd.smartcan.frame.dao.RestDao;
import com.nd.smartcan.frame.exception.DaoException;

import java.util.Map;


public class SubjecDao extends RestDao<SubjectSum> {
    String languageName;

    public SubjecDao(String languageName) {
        this.languageName = languageName;
    }

    @Override
    protected String getResourceUri() {
        return "http://esp-lifecycle.pre1.web.nd/v0.6/categories/$S/datas?words&limit=(0,1000)";
    }

    @Override
    protected <R> R get(String uri, Map<String, Object> param, Class<R> returnClass) throws DaoException {
        ClientResource cr = new ClientResource(uri);
        cr.addHeader("Accept-Language", languageName);
        cr.bindArgument(param);
        try {
            return cr.get(returnClass);
        } catch (ResourceException e) {
            throw new DaoException(e);
        }
    }
}
