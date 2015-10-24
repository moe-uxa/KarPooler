package com.eramo.karpooler.services;

import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.models.dtos.ModelDTO;
import com.eramo.karpooler.models.dtos.ModelYearDTO;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class GetModelYearsService  extends  BaseService{

    // single instance
    private static GetModelYearsService instance = null;

    private GetModelYearsService(){

    }

    /**
     * get service single instance
     * @return single instance service
     */
    public static GetModelYearsService getInstance() {

        if(instance == null) {
            instance = new GetModelYearsService();
        }

        return instance;
    }

    public void getModelYears (ModelDTO modelDTO, ServiceSuccessCallback<List<ModelYearDTO>> successCallback, ServiceErrorCallback<ErrorDTO> errorCallback){

    }


}
