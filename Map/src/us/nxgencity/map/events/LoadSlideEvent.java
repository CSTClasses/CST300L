package us.nxgencity.map.events;

import com.synload.eventsystem.EventClass;

public class LoadSlideEvent extends EventClass {
	public String entryId;
	public LoadSlideEvent(String entryId){
		this.entryId = entryId;
	}
	public LoadSlideEvent(long entryId){
		this.entryId = String.valueOf(entryId);
	}
	public String getEntryId() {
		return entryId;
	}
	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}
}
