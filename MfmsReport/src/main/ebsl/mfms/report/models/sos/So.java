package ebsl.mfms.report.models.sos;

import java.util.Date;

public interface So {
	public Date getCreateDateTimeFrom();
	public void setCreateDateTimeFrom(Date createDateTimeFrom);
	
	public Date getCreateDateTimeTo();
	public void setCreateDateTimeTo(Date createDateTimeTo);
	
	public Date getLastModifyDateTimeFrom();
	public void setLastModifyDateTimeFrom(Date lastModifyDateTimeFrom);
	
	public Date getLastModifyDateTimeTo();
	public void setLastModifyDateTimeTo(Date lastModifyDateTimeTo);
}
