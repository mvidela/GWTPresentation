package com.teracode.client.slides;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.teracode.client.model.Presentable;

public class FirstPage extends Widget implements Presentable {

	private static FirstPageUiBinder uiBinder = GWT.create(FirstPageUiBinder.class);

	interface FirstPageUiBinder extends UiBinder<Element, FirstPage> {
	}

	public FirstPage() {
		setElement(uiBinder.createAndBindUi(this));
	}

	@Override
	public Widget asWidget() {
		return this;
	}

}
