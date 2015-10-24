package com.eramo.karpooler.services;

import com.eramo.karpooler.models.dtos.BrandDTO;
import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.models.dtos.ModelDTO;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class GetBrandModelsService extends BaseService {

    // single instance
    private static GetBrandModelsService instance = null;

    private GetBrandModelsService(){

    }

    /**
     * get service single instance
     * @return single instance service
     */
    public static GetBrandModelsService getInstance() {

        if(instance == null) {
            instance = new GetBrandModelsService();
        }

        return instance;
    }

    public void getBrandModels (BrandDTO brandDTO,ServiceSuccessCallback<List<ModelDTO>> successCallback, ServiceErrorCallback<ErrorDTO> errorCallback){

    }
}
