package ebsl.mfms.report.models.eos;

import java.util.Date;

public class TblLocationEo {
	protected Integer lKey;
	protected Integer lSiteKey;
	protected String lCode;
	protected String lName;
	protected String lDesc;
	protected String lTagID;
	protected Integer lParentKey;
	protected Integer lLevelKey;
	protected String lChain;
	protected Integer lCreateBy;
	protected Date lCreateDateTime;
	protected Integer lLastModifyBy;
	protected Date lLastModifyDateTime;
	protected String lDeleted;
	protected Date lLastModifyTimeForSync;
	public Integer getlKey() {
		return lKey;
	}
	public void setlKey(Integer lKey) {
		this.lKey = lKey;
	}
	public Integer getlSiteKey() {
		return lSiteKey;
	}
	public void setlSiteKey(Integer lSiteKey) {
		this.lSiteKey = lSiteKey;
	}
	public String getlCode() {
		return lCode;
	}
	public void setlCode(String lCode) {
		this.lCode = lCode;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getlDesc() {
		return lDesc;
	}
	public void setlDesc(String lDesc) {
		this.lDesc = lDesc;
	}
	public String getlTagID() {
		return lTagID;
	}
	public void setlTagID(String lTagID) {
		this.lTagID = lTagID;
	}
	public Integer getlParentKey() {
		return lParentKey;
	}
	public void setlParentKey(Integer lParentKey) {
		this.lParentKey = lParentKey;
	}
	public Integer getlLevelKey() {
		return lLevelKey;
	}
	public void setlLevelKey(Integer lLevelKey) {
		this.lLevelKey = lLevelKey;
	}
	public String getlChain() {
		return lChain;
	}
	public void setlChain(String lChain) {
		this.lChain = lChain;
	}
	public Integer getlCreateBy() {
		return lCreateBy;
	}
	public void setlCreateBy(Integer lCreateBy) {
		this.lCreateBy = lCreateBy;
	}
	public Date getlCreateDateTime() {
		return lCreateDateTime;
	}
	public void setlCreateDateTime(Date lCreateDateTime) {
		this.lCreateDateTime = lCreateDateTime;
	}
	public Integer getlLastModifyBy() {
		return lLastModifyBy;
	}
	public void setlLastModifyBy(Integer lLastModifyBy) {
		this.lLastModifyBy = lLastModifyBy;
	}
	public Date getlLastModifyDateTime() {
		return lLastModifyDateTime;
	}
	public void setlLastModifyDateTime(Date lLastModifyDateTime) {
		this.lLastModifyDateTime = lLastModifyDateTime;
	}
	public String getlDeleted() {
		return lDeleted;
	}
	public void setlDeleted(String lDeleted) {
		this.lDeleted = lDeleted;
	}
	public Date getlLastModifyTimeForSync() {
		return lLastModifyTimeForSync;
	}
	public void setlLastModifyTimeForSync(Date lLastModifyTimeForSync) {
		this.lLastModifyTimeForSync = lLastModifyTimeForSync;
	}

}
