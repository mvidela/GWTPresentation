package com.teracode.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.teracode.client.model.Presentable;

public class Presentation extends Composite {

	private static final String THREE_D_STYLE = "three-d";
	private static PresentationUiBinder uiBinder = GWT.create(PresentationUiBinder.class);

	interface PresentationUiBinder extends UiBinder<Widget, Presentation> {
	}

	/** Slides from the presentation */
	private List<Presentable> slides;
	/** Index of the displayed slide */
	private int index;

	@UiField
	FlowPanel presentation;
	@UiField
	FlowPanel slidesPanel;

	public Presentation(List<Presentable> slides) {
		initWidget(uiBinder.createAndBindUi(this));
		if (slides != null && slides.size() > 0) {
			this.index = 1;
			this.slides = slides;
			for (Presentable presentable : slides) {
				slidesPanel.add(presentable.asWidget());
			}
		}
	}

	/**
	 * Display the previous slide Nothing done if the actual is the first one
	 */
	public void displayPreviousSlide() {
		if (!isFirstPage()) {
			displaySlide(index - 1);
		}
	}

	/**
	 * Display the next slide Nothing done if the actual is the last one
	 */
	public void displayNextSlide() {
		if (!isLastPage()) {
			displaySlide(index + 1);
		}
	}

	/**
	 * Display the slide from it's index
	 * 
	 * @param index
	 */
	public void displaySlide(int index) {
		this.index = index;
		changeSlideClass(getSlide(index - 2), "far-past");
		changeSlideClass(getSlide(index - 1), "past");
		changeSlideClass(getSlide(index), "current");
		changeSlideClass(getSlide(index + 1), "future");
		changeSlideClass(getSlide(index + 2), "far-future");
		History.newItem(SlideViewer.TOKEN_PREFIX + index, false);
	}

	/**
	 * Is the slide displayed currently the first of the presentation
	 * 
	 * @return
	 */
	private boolean isFirstPage() {
		return index <= 1;
	}

	/**
	 * Is the slide displayed currently the last of the presentation
	 * 
	 * @return
	 */
	private boolean isLastPage() {
		return index >= slides.size();
	}

	private Presentable getSlide(int slideNumber) {
		if (slideNumber > 0) {
			return slides.get(slideNumber - 1);
		} else {
			return null;
		}
	}

	private void changeSlideClass(Presentable slide, String styleName) {
		if (slide != null) {
			slide.asWidget().setStyleName("slide");
			slide.asWidget().addStyleName(styleName);
		}
	}
	
	public void switch3D(){
		if(RootPanel.get().getStyleName().contains(THREE_D_STYLE)){
			RootPanel.get().removeStyleName(THREE_D_STYLE);
		} else{
			RootPanel.get().addStyleName(THREE_D_STYLE);
		}
	}
}
