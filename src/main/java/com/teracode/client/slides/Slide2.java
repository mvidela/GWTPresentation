package com.teracode.client.slides;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.teracode.client.model.Presentable;

public class Slide2 extends Widget implements Presentable {

	private static Slide2UiBinder uiBinder = GWT.create(Slide2UiBinder.class);

	interface Slide2UiBinder extends UiBinder<Element, Slide2> {
	}

	public Slide2() {
		setElement(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget() {
		return this;
	}
}
