package ebsl.mfms.report.models.vos;

import java.util.Date;

public class ExportPatrolRoutineVo extends VoBase{
	private String routeCode;
	private Date collectionDateTime;
	private String collectionDateTimeString;
	public String getCollectionDateTimeString() {
		return collectionDateTimeString;
	}
	public void setCollectionDateTimeString(String collectionDateTimeString) {
		this.collectionDateTimeString = collectionDateTimeString;
	}
	private String locationCode;
	private String locationName;
	private Integer readingResult;
	public String getRouteCode() {
		return routeCode;
	}
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}
	public Date getCollectionDateTime() {
		return collectionDateTime;
	}
	public void setCollectionDateTime(Date collectionDateTime) {
		this.collectionDateTime = collectionDateTime;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public Integer getReadingResult() {
		return readingResult;
	}
	public void setReadingResult(Integer readingResult) {
		this.readingResult = readingResult;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
	
}
