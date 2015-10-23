package com.eramo.karpooler.services.callbacks;

/**
 * Created by Mohamed.Gaber on 10/20/2015.
 */

/** Callback interface for delivering service responses. */
public interface ServiceSuccessCallback<T> {

        /** Called when a success response is received. */
        void onSuccess(T response);

}
