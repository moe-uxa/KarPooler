package com.eramo.karpooler.services;

import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.models.dtos.PlateTypeDTO;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class LoadPlateTypesService extends BaseService {

    // single instance
    private static LoadPlateTypesService instance = null;

    private LoadPlateTypesService(){

    }

    /**
     * get service single instance
     * @return single instance service
     */
    public static LoadPlateTypesService getInstance() {

        if(instance == null) {
            instance = new LoadPlateTypesService();
        }

        return instance;
    }

    public void loadPlateTypes (ServiceSuccessCallback<List<PlateTypeDTO>> successCallback, ServiceErrorCallback<ErrorDTO> errorCallback){

    }
}
