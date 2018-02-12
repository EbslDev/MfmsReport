package ebsl.mfms.report.models.vos;

import java.util.Date;
import java.util.List; 

public class ExportPatrolInspectionRoutineVo extends VoBase{
	
	private Date patrolDate;
	private String routeName;
	private String locationName;
	private String remark;
	private List<String> photoPaths;
	
	
	public Date getPatrolDate() {
		return patrolDate;
	}
	public void setPatrolDate(Date patrolDate) {
		this.patrolDate= patrolDate;
	}
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName= routeName;
	}

	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark= remark;
	}
	
	public List<String> getPhotoPaths() {
		return photoPaths;
	}
	public void setLocationName(List<String> photoPaths) {
		this.photoPaths = photoPaths;
	}
	
	
	
}
