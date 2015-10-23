package com.eramo.karpooler.services;

import android.util.Log;

import com.eramo.karpooler.apis.ErrorResponseListener;
import com.eramo.karpooler.apis.ResponseListener;
import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.facebook.login.LoginResult;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class LoginService extends BaseService {

    // single instance
    private static LoginService instance = null;

    private LoginService(){

    }

    /**
     * get service single instance
     * @return single instance service
     */
    public static LoginService getInstance() {

        if(instance == null) {
            instance = new LoginService();
        }

        return instance;
    }

    /**
     * use this method to store any info of access token in sql database or your server database.
     * to get access token use the method faceBookLoginResult.getAccessToken()
     * @param faceBookLoginResult
     * @param responseListener
     * @param errorResponseListener
     */
    public void login (LoginResult faceBookLoginResult, ResponseListener<Void> responseListener, ErrorResponseListener<ErrorDTO> errorResponseListener){


    }

}
