package ebsl.mfms.report.models.sos;

import java.util.Date;

public abstract class SoBase {
	protected Date createDateTimeFrom;
	protected Date createDateTimeTo;
	protected Date lastModifyDateTimeFrom;
	protected Date lastModifyDateTimeTo;
	public Date getCreateDateTimeFrom() {
		return createDateTimeFrom;
	}
	public void setCreateDateTimeFrom(Date createDateTimeFrom) {
		this.createDateTimeFrom = createDateTimeFrom;
	}
	public Date getCreateDateTimeTo() {
		return createDateTimeTo;
	}
	public void setCreateDateTimeTo(Date createDateTimeTo) {
		this.createDateTimeTo = createDateTimeTo;
	}
	public Date getLastModifyDateTimeFrom() {
		return lastModifyDateTimeFrom;
	}
	public void setLastModifyDateTimeFrom(Date lastModifyDateTimeFrom) {
		this.lastModifyDateTimeFrom = lastModifyDateTimeFrom;
	}
	public Date getLastModifyDateTimeTo() {
		return lastModifyDateTimeTo;
	}
	public void setLastModifyDateTimeTo(Date lastModifyDateTimeTo) {
		this.lastModifyDateTimeTo = lastModifyDateTimeTo;
	}
	
}
