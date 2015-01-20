/**
 * PhoneGap is available under *either* the terms of the modified BSD license *or* the
 * MIT License (2008). See http://opensource.org/licenses/alphabetical for full text.
 *
 * Copyright (c) Matt Kane 2010
 * Copyright (c) 2011, IBM Corporation
 * Copyright (c) 2013, Maciej Nux Jaros
 */
package br.com.trier.cameraplugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;

public class CameraPlugin extends CordovaPlugin {
    private static final String VERIFY_AUTO_FOCUS = "verify.auto.focus";
    private static final String LOG_TAG = "CameraPlugin";

    private CallbackContext callbackContext;

    /**
     * Constructor.
     */
    public CameraPlugin() {
    }

    /**
     * Executes the request.
     *
     * This method is called from the WebView thread. To do a non-trivial amount of work, use:
     *     cordova.getThreadPool().execute(runnable);
     *
     * To run on the UI thread, use:
     *     cordova.getActivity().runOnUiThread(runnable);
     *
     * @param action          The action to execute.
     * @param args            The exec() arguments.
     * @param callbackContext The callback context used when calling back into JavaScript.
     * @return                Whether the action was valid.
     *
     * @sa https://github.com/apache/cordova-android/blob/master/framework/src/org/apache/cordova/CordovaPlugin.java
     */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) {
        this.callbackContext = callbackContext;

        if (action.equals(VERIFY_AUTO_FOCUS)) {
			PluginResult result = new PluginResult(PluginResult.Status.OK, getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_AUTOFOCUS));
            this.callbackContext.sendPluginResult(result);
            return true;
        }

        // Returning false results in a "MethodNotFound" error.
        return true;
    }
}