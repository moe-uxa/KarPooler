package com.eramo.karpooler.apis;

import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.services.LoginService;
import com.facebook.login.LoginResult;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class LoginAPI extends BaseAPI {

    public void login (LoginResult faceBookLoginResult, ResponseListener<Void> responseListener, ErrorResponseListener<ErrorDTO> errorResponseListener){

        // call login service
        LoginService.getInstance().login(faceBookLoginResult, responseListener, errorResponseListener);
    }

}
