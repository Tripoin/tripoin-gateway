package com.tripoin.util.ui.geo.shared;

import com.vaadin.shared.communication.ClientRpc;

public interface GeolocatorClientRpc extends ClientRpc {

    public void detectCurrentPosition(int callbackid);

}
