package com.teracode.client.util;

public class Maps {
	public static native boolean isLoaded() /*-{
		return $wnd.google.maps !== undefined;
	}-*/;
}
