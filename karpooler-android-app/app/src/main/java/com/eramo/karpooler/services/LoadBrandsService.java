package com.eramo.karpooler.services;

import android.app.Application;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.eramo.karpooler.application.MyApplication;
import com.eramo.karpooler.models.dtos.BrandDTO;
import com.eramo.karpooler.models.dtos.ErrorDTO;
import com.eramo.karpooler.services.callbacks.ServiceErrorCallback;
import com.eramo.karpooler.services.callbacks.ServiceSuccessCallback;

import java.io.IOException;
import java.io.InputStream;
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

        for (int i = 1; i <= 8; i++){

            BrandDTO brandDTO = new BrandDTO();
            brandDTO.setBrandId(i);

            switch (i){
                case 1:
                    brandDTO.setBrandName("Aston Martin");
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/fiat.png"));
                    break;
                case 2:
                    brandDTO.setBrandName("Audi");
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/fiat.png"));
                    break;
                case 3:
                    brandDTO.setBrandName("Brand " + i);
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/fiat.png"));
                    break;
                case 4:
                    brandDTO.setBrandName("Brand " + i);
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/fiat.png"));
                    break;
                case 5:
                    brandDTO.setBrandName("Brand " + i);
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/fiat.png"));
                    break;
                case 6:
                    brandDTO.setBrandName("Brand " + i);
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/fiat.png"));
                    break;
                case 7:
                    brandDTO.setBrandName("Brand " + i);
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/fiat.png"));
                    break;
                case 8:
                    brandDTO.setBrandName("Brand " + i);
                    brandDTO.setBrandImage(getBitmapFromAsset("brands/fiat.png"));
                    break;
            }


            brandDTOList.add(brandDTO);
        }

        successCallback.onSuccess(brandDTOList);
    }

    private Bitmap getBitmapFromAsset(String strName)
    {
        AssetManager assetManager = MyApplication.getInstance().getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(strName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }

}
