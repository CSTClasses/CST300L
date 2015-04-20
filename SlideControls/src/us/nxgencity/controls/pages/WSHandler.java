package us.nxgencity.controls.pages;

import us.nxgencity.controls.elements.SlideListings;
import us.nxgencity.map.events.LoadSlideEvent;
import com.synload.eventsystem.EventPublisher;
import com.synload.eventsystem.events.RequestEvent;
import com.synload.framework.modules.annotations.Event;
import com.synload.framework.modules.annotations.Event.Type;

public class WSHandler {
	@Event(name="getSlideControls",description="Slide controls",trigger={"set","slide"},type=Type.WEBSOCKET)
	public void getSlideControls(RequestEvent event){
		String slideId = event.getRequest().getData().get("slideId");
		LoadSlideEvent lse = new LoadSlideEvent(slideId);
		EventPublisher.raiseEvent(lse, true, null);
	}
	@Event(name="getSlides",description="get slides",trigger={"get","control"},type=Type.WEBSOCKET)
	public void getSlides(RequestEvent event){
		String presenter = event.getRequest().getData().get("presenter");
		SlideListings slidelist = new SlideListings(
			event.getSession(),
			event.getRequest().getTemplateCache(),
			presenter
		);
		event.getSession().send(slidelist);
	}
}
