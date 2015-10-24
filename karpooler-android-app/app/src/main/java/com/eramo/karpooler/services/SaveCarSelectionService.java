package com.eramo.karpooler.services;

import com.eramo.karpooler.models.dtos.CarDTO;
import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class SaveCarSelectionService {

    // single instance
    private static SaveCarSelectionService instance = null;

    private SaveCarSelectionService(){

    }

    /**
     * get service single instance
     * @return single instance service
     */
    public static SaveCarSelectionService getInstance() {

        if(instance == null) {
            instance = new SaveCarSelectionService();
        }

        return instance;
    }

    public void saveCarSelection(CarDTO carDTO, ServiceSuccessCallback successCallback, ServiceErrorCallback<ErrorDTO> errorCallback){


    }

}


