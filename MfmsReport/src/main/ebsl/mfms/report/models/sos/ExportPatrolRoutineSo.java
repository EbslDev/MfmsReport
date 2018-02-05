package ebsl.mfms.report.models.sos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExportPatrolRoutineSo {
	protected Integer siteKey;
	protected Date resultStartDate;
	protected Date resultEndDate;
	protected List<String> routeKeyList;
	protected List<String> routeLocationKeyList;
	public Integer getSiteKey() {
		return siteKey;
	}
	public void setSiteKey(Integer siteKey) {
		this.siteKey = siteKey;
	}
	public Date getResultStartDate() {
		return resultStartDate;
	}
	public void setResultStartDate(Date resultStartDate) {
		this.resultStartDate = resultStartDate;
	}
	public Date getResultEndDate() {
		return resultEndDate;
	}
	public void setResultEndDate(Date resultEndDate) {
		this.resultEndDate = resultEndDate;
	}
	public void addRouteKey(String routeKey) {
		if (routeKeyList == null) {
			routeKeyList = new ArrayList<String>();
		}
		routeKeyList.add(routeKey);
	}
	public List<String> getRouteKeyList() {
		return routeKeyList;
	}
	public void setRouteKeyList(List<String> routeKeyList) {
		this.routeKeyList = routeKeyList;
	}
	public List<String> getRouteLocationKeyList() {
		return routeLocationKeyList;
	}
	public void setRouteLocationKeyList(List<String> routeLocationKeyList) {
		this.routeLocationKeyList = routeLocationKeyList;
	}
	public void addRouteLocationKey(String routeLocationKey) {
		if (routeLocationKeyList == null) {
			routeLocationKeyList = new ArrayList<String>();
		}
		routeLocationKeyList.add(routeLocationKey);
	}

	
}
