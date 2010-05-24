package com.teracode.client.slides;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.teracode.client.model.Presentable;

public class Slide13 extends Widget implements Presentable {

	private static Slide2UiBinder uiBinder = GWT.create(Slide2UiBinder.class);

	interface Slide2UiBinder extends UiBinder<Element, Slide13> {
	}

	public Slide13() {
		setElement(uiBinder.createAndBindUi(this));
	}

	public Widget asWidget() {
		return this;
	}
}
