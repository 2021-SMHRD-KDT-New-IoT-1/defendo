package Member;

public class GPSVO {

	
	float latitude; //위도
	float longitude; // 경도
	String hm_id; // 근로자 이름
	public float getLatitude() {
		return latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public String getHm_id() {
		return hm_id;
	}
	public GPSVO(float latitude, float longitude, String hm_id) {
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.hm_id = hm_id;
	}
	
	
	
	
	
	
	
	
	
}
