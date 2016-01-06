package com.example.marcieltorres.nfcproject_serverapp.controllers;

import com.example.marcieltorres.nfcproject_serverapp.helpers.WebserviceHelper;

import org.json.JSONException;
import org.json.JSONStringer;

/**
 * Created by Marciel Torres on 08/11/2015.
 */
public final class WebserviceController {

    private static String URI = "http://52.32.142.242/NFCProject/";

    public static String ConfirmPresence(String _event, String _mail) throws JSONException {

        JSONStringer model = new JSONStringer().object().key("Model").object().key("ID").value("").key("EventID").value(_event).key("SubscriberMail").value(_mail).endObject().endObject();

        // Array de String que recebe o JSON do Web Service
        String[] json = new WebserviceHelper().post(URI + "services/presences/Presence.svc/ConfirmPresence", model.toString());

        return json[1];
    }
}
