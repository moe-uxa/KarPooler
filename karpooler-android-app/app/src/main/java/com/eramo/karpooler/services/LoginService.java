package com.eramo.karpooler.services;

import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;
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
     * @param serviceSuccessCallback
     * @param serviceErrorCallback
     */
    public void login (LoginResult faceBookLoginResult, ServiceSuccessCallback serviceSuccessCallback, ServiceErrorCallback<ErrorDTO> serviceErrorCallback){

        serviceSuccessCallback.onSuccess(null);
    }

}
