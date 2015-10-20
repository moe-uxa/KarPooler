package com.eramo.karpooler.apis;

/**
 * Created by Mohamed.Gaber on 10/20/2015.
 */

/** Callback interface for delivering response. */
public interface ResponseListener<T> {

        /** Called when a response is received. */
        void onResponse(T response);
}
