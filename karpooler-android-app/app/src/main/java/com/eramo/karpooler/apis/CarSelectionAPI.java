package com.eramo.karpooler.apis;


import com.eramo.karpooler.models.dtos.BrandDTO;
import com.eramo.karpooler.models.dtos.CarDTO;
import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.models.dtos.ModelDTO;
import com.eramo.karpooler.models.dtos.ModelYearDTO;
import com.eramo.karpooler.models.dtos.PlateTypeDTO;
import com.eramo.karpooler.services.GetBrandModelsService;
import com.eramo.karpooler.services.GetModelYearsService;
import com.eramo.karpooler.services.LoadBrandsService;
import com.eramo.karpooler.services.LoadPlateTypesService;
import com.eramo.karpooler.services.SaveCarSelectionService;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;

import java.util.List;

/**
 * Created by Mohamed.Gaber on 10/24/2015.
 */
public class CarSelectionAPI extends BaseAPI {

    public void loadBrands (ServiceSuccessCallback<List<BrandDTO>> successCallback, ServiceErrorCallback<ErrorDTO> errorCallback){

        LoadBrandsService.getInstance().loadBrands(successCallback, errorCallback);
    }

    public void getBrandModels (BrandDTO brandDTO,ServiceSuccessCallback<List<ModelDTO>> successCallback, ServiceErrorCallback<ErrorDTO> errorCallback){

        GetBrandModelsService.getInstance().getBrandModels(brandDTO, successCallback, errorCallback);
    }

    public void getModelYears (ModelDTO modelDTO, ServiceSuccessCallback<List<ModelYearDTO>> successCallback, ServiceErrorCallback<ErrorDTO> errorCallback){

        GetModelYearsService.getInstance().getModelYears(modelDTO, successCallback, errorCallback);
    }

    public void loadPlateTypes (ServiceSuccessCallback<List<PlateTypeDTO>> successCallback, ServiceErrorCallback<ErrorDTO> errorCallback){

        LoadPlateTypesService.getInstance().loadPlateTypes(successCallback, errorCallback);
    }

    public void saveCarSelection(CarDTO carDTO, ServiceSuccessCallback successCallback, ServiceErrorCallback<ErrorDTO> errorCallback){

        SaveCarSelectionService.getInstance().saveCarSelection(carDTO, successCallback, errorCallback);
    }

}
