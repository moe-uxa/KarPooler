package com.eramo.karpooler.apis;

import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.services.LoginService;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;
import com.facebook.login.LoginResult;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class LoginAPI extends BaseAPI {

    public void login (LoginResult faceBookLoginResult, ServiceSuccessCallback serviceSuccessCallback, ServiceErrorCallback<ErrorDTO> serviceErrorCallback){

        // call login service
        LoginService.getInstance().login(faceBookLoginResult, serviceSuccessCallback, serviceErrorCallback);
    }

}
