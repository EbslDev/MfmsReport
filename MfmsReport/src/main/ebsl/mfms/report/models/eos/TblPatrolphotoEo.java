package ebsl.mfms.report.models.eos;

import java.util.Date;

public class TblPatrolphotoEo {
	protected Integer ppKey;
	protected Integer ppSiteKey;
	protected Integer ppRouteDefKey;
	protected Integer ppPatrolResultKey;
	protected String ppPhotoPath;
	protected Integer ppLocationKey;
	protected String ppRemark;
	protected Integer ppCreateBy;
	protected Date ppCreateTime;
	protected Integer ppLastModifyBy;
	protected Date ppLastModifyTime;
	protected String ppDeleted;
	protected Date ppLastModifyTimeForSync;

	public Integer getPpKey() {
		return ppKey;
	}

	public void setPpKey(Integer ppKey) {
		this.ppKey = ppKey;
	}

	public Integer getPpSiteKey() {
		return ppSiteKey;
	}

	public void setPpSiteKey(Integer ppSiteKey) {
		this.ppSiteKey = ppSiteKey;
	}

	public Integer getPpRouteDefKey() {
		return ppRouteDefKey;
	}

	public void setPpRouteDefKey(Integer ppRouteDefKey) {
		this.ppRouteDefKey = ppRouteDefKey;
	}

	public Integer getPpPatrolResultKey() {
		return ppPatrolResultKey;
	}

	public void setPpPatrolResultKey(Integer ppPatrolResultKey) {
		this.ppPatrolResultKey = ppPatrolResultKey;
	}

	public String getPpPhotoPath() {
		return ppPhotoPath;
	}

	public void setPpPhotoPath(String ppPhotoPath) {
		this.ppPhotoPath = ppPhotoPath;
	}

	public Integer getPpLocationKey() {
		return ppLocationKey;
	}

	public void setPpLocationKey(Integer ppLocationKey) {
		this.ppLocationKey = ppLocationKey;
	}

	public String getPpRemark() {
		return ppRemark;
	}

	public void setPpRemark(String ppRemark) {
		this.ppRemark = ppRemark;
	}

	public Integer getPpCreateBy() {
		return ppCreateBy;
	}

	public void setPpCreateBy(Integer ppCreateBy) {
		this.ppCreateBy = ppCreateBy;
	}

	public Date getPpCreateTime() {
		return ppCreateTime;
	}

	public void setPpCreateTime(Date ppCreateTime) {
		this.ppCreateTime = ppCreateTime;
	}

	public Integer getPpLastModifyBy() {
		return ppLastModifyBy;
	}

	public void setPpLastModifyBy(Integer ppLastModifyBy) {
		this.ppLastModifyBy = ppLastModifyBy;
	}

	public Date getPpLastModifyTime() {
		return ppLastModifyTime;
	}

	public void setPpLastModifyTime(Date ppLastModifyTime) {
		this.ppLastModifyTime = ppLastModifyTime;
	}

	public String getPpDeleted() {
		return ppDeleted;
	}

	public void setPpDeleted(String ppDeleted) {
		this.ppDeleted = ppDeleted;
	}

	public Date getPpLastModifyTimeForSync() {
		return ppLastModifyTimeForSync;
	}

	public void setPpLastModifyTimeForSync(Date ppLastModifyTimeForSync) {
		this.ppLastModifyTimeForSync = ppLastModifyTimeForSync;
	}

}
