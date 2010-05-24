package com.teracode.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.GWT.UncaughtExceptionHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.teracode.client.model.Presentable;
import com.teracode.client.slides.FirstPage;
import com.teracode.client.slides.Slide10;
import com.teracode.client.slides.Slide11;
import com.teracode.client.slides.Slide12;
import com.teracode.client.slides.Slide13;
import com.teracode.client.slides.Slide14;
import com.teracode.client.slides.Slide15;
import com.teracode.client.slides.Slide16;
import com.teracode.client.slides.Slide17;
import com.teracode.client.slides.Slide18;
import com.teracode.client.slides.Slide2;
import com.teracode.client.slides.Slide4;
import com.teracode.client.slides.Slide5;
import com.teracode.client.slides.Slide6;
import com.teracode.client.slides.Slide7;
import com.teracode.client.slides.Slide8;
import com.teracode.client.slides.Slide9;

public class SlideViewer implements EntryPoint, ValueChangeHandler<String> {

	public static final String TOKEN_PREFIX = "slide";
	
	private Presentation presentation;
	/** Liste des slides */
	List<Presentable> slides;

	public SlideViewer(){
		GWT.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			public void onUncaughtException(Throwable e) {
				if (!GWT.isScript())
					e.printStackTrace();
					Window.alert("Exception : " + e.getMessage());
			}
		});
		
	}
	
	public void onModuleLoad() {
		//To ensure the uncaughtexceptionhandler is registered, loading must be done in a deferred command
		DeferredCommand.addCommand(new Command() {
			public void execute() {
				doModuleLoad();
			}
		});
		
		GWT.setUncaughtExceptionHandler( new UncaughtExceptionHandler() { 
			
			public void onUncaughtException(Throwable e) {
				e.printStackTrace();
			}
		});
	}

	private void doModuleLoad() {
		initSlides();
		presentation = new Presentation(slides);
		RootPanel.get().add(presentation);
		initializeHistory();
		registerDocumentEvent(presentation);
	}
	
	private void initializeHistory(){
		History.addValueChangeHandler(this);
		if ("".equals(History.getToken())) {
			History.newItem(TOKEN_PREFIX + 1);
		} else {
			History.fireCurrentHistoryState();
		}
	}
	
	public native void registerDocumentEvent(Presentation presentation) /*-{
		var handleBodyKeyDown = function(event) {
			switch (event.keyCode) {
			case 37: // left arrow
				presentation.@com.teracode.client.Presentation::displayPreviousSlide()();
				break;
			case 39: // right arrow
				presentation.@com.teracode.client.Presentation::displayNextSlide()();
				break;
//			case 50: // 2
//				presentation.@com.teracode.client.Presentation::showNotes()();          
//				break;
			case 51: // 3
				presentation.@com.teracode.client.Presentation::switch3D()();          
				break;
			}
		}
		$doc.addEventListener('keydown', handleBodyKeyDown, false);
		$doc.touchStartX = 0;
		$doc.addEventListener('touchstart', function(e) {
            $doc.touchStartX = e.touches[0].pageX;
          }, false);
        $doc.addEventListener('touchend', function(e) {
            var pixelsMoved = $doc.touchStartX - e.changedTouches[0].pageX;
            var SWIPE_SIZE = 150;
            if (pixelsMoved > SWIPE_SIZE) {
              presentation.@com.teracode.client.Presentation::displayNextSlide()();
            }
            else if (pixelsMoved < -SWIPE_SIZE) {
              presentation.@com.teracode.client.Presentation::displayPreviousSlide()();
            }
          }, false);
	}-*/;

	/**
	 * TODO: delete this mock
	 */
	private void initSlides() {
		slides = new ArrayList<Presentable>();
		slides.add(new FirstPage());
//		slides.add(new InfoPage());
		slides.add(new Slide2());
//		slides.add(new Slide3());
		slides.add(new Slide4());
		slides.add(new Slide5());
		slides.add(new Slide6());
		slides.add(new Slide7());
		slides.add(new Slide8());
		slides.add(new Slide9());
		slides.add(new Slide10());				
		slides.add(new Slide11());
		slides.add(new Slide12());
		slides.add(new Slide13());
		slides.add(new Slide14());
		slides.add(new Slide15());
		slides.add(new Slide16());
		slides.add(new Slide17());
		slides.add(new Slide18());
//		slides.add(new Slide19());
//		slides.add(new Slide20());
//		slides.add(new Slide21());
//		slides.add(new Slide22());
//		slides.add(new Slide26());
//		slides.add(new Slide27());
//		slides.add(new Slide28());
//		slides.add(new Slide29());
//		slides.add(new Slide30());
//		slides.add(new Slide31());
//		slides.add(new Slide32());
//		slides.add(new Slide33());
//		slides.add(new Slide34());
//		slides.add(new Slide35());
//		slides.add(new Slide36());
//		slides.add(new Slide37());
//		slides.add(new Slide38());
//		slides.add(new Slide39());
//		slides.add(new Slide40());
//		slides.add(new Slide41());
//		slides.add(new Slide42());
//		slides.add(new Slide43());
//		slides.add(new Slide44());
//		slides.add(new Slide45());
//		slides.add(new Slide46());
	}

	public void onValueChange(ValueChangeEvent<String> event) {
		String token = event.getValue();
		int slideNumber = parseSlideNumber(token);
		presentation.displaySlide(slideNumber);
	}

	protected static int parseSlideNumber(String token) {
		try {
			String number = token.substring(TOKEN_PREFIX.length());
			return Integer.parseInt(number);
		} catch (Exception e) {
			//If parsing fails, go to first slide
			return 1;
		}
	}

}
