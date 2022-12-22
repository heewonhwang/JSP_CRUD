package Pack;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

// sgl사용 시 파라미터에 값을 쉽게 넣어주기 위함
// 객체의 값을 확인하기 위함
// 생성자를 자동완성시켜줌(lombok 필요)
// 해당 class에 지정할 테이블명을 입력 
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="lib_eng")
public class CrudEntity {
	// 테이블에 들어있는 칼럼을 Entity안에 넣어줌
	
	//pk에 해당하는 컬럼에 id넣어준다
	@Id
	@Column(nullable = false, unique = true)
	private String index;
	@Column(nullable = false)
	private String lib_name;
	@Column(nullable = false)
	private String code;
	@Column(nullable = false)
	private String ad_name;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String url;
	@Column(nullable = false)
	private String time;
	@Column(nullable = false)
	private String holiday;
	@Column(nullable = false)
	private String devision;
	@Column(nullable = false)
	private String dev_name;
	@Column(nullable = false)
	private String lat;
	@Column(nullable = false)
	private String longtitude;
	

	
}
