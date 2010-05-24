package com.teracode.client.slides;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.teracode.client.model.Presentable;

public class Slide3 extends Widget implements Presentable {

	private static Slide3UiBinder uiBinder = GWT.create(Slide3UiBinder.class);

	interface Slide3UiBinder extends UiBinder<Element, Slide3> {
	}

	public Slide3() {
		setElement(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget() {
		return this;
	}

}
