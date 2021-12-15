package SensorsController;

public class impact_sensorVO {
	
	private int impact_sensor;
	private String hm_id;
	
	public impact_sensorVO(int impact_sensor, String hm_id) {
		
		this.impact_sensor = impact_sensor;
		this.hm_id = hm_id;
	}

	public int getImpact_sensor() {
		return impact_sensor;
	}

	public void setImpact_sensor(int impact_sensor) {
		this.impact_sensor = impact_sensor;
	}

	public String getHm_id() {
		return hm_id;
	}

	public void setHm_id(String hm_id) {
		this.hm_id = hm_id;
	}
	
	
	
	

}
