package com.eramo.karpooler.apis;

/**
 * Created by Mohamed.Gaber on 10/20/2015.
 */

/** Callback interface for delivering error responses. */
public interface  ErrorResponseListener {

    /**
     * Callback method that an error has been occurred with the
     */
    void onErrorResponse(Exception error);

}
