package com.eramo.karpooler.services;

import com.eramo.karpooler.models.dtos.BrandDTO;
import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class LoadBrandsService extends BaseService {

    // single instance
    private static LoadBrandsService instance = null;

    private LoadBrandsService(){

    }

    /**
     * get service single instance
     * @return single instance service
     */
    public static LoadBrandsService getInstance() {

        if(instance == null) {
            instance = new LoadBrandsService();
        }

        return instance;
    }

    public void loadBrands (ServiceSuccessCallback<List<BrandDTO>> successCallback, ServiceErrorCallback<ErrorDTO> errorCallback){

        List<BrandDTO> brandDTOList = new ArrayList<>();

        for (int i = 1; i <= 5; i++){

            BrandDTO brandDTO = new BrandDTO();
            brandDTO.setBrandId(i);
            brandDTO.setBrandName("Brand "+i);

            brandDTOList.add(brandDTO);
        }

        successCallback.onSuccess(brandDTOList);
    }

}
