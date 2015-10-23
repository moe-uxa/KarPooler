package com.eramo.karpooler.services.callbacks;

/**
 * Created by Mohamed.Gaber on 10/20/2015.
 */

/** Callback interface for delivering error responses. */
public interface ServiceErrorCallback<T> {

    /** Called when an error occurred. */
    void onError(T errorResponse);

}
