package Pack;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// jpa의 대부분의 자동 쿼리 기능을 수행할 수 있다.
@Repository
public interface CrudEntityRepository extends JpaRepository<CrudEntity, String>{
	// 쿼리를 사용할 수 있다 :name같이 파라미터를 지정할 수 도 있다
	// 메소드 호출시 @Param("파라미터") 데이터타입 데이터명
//	@Query(value = "select lib_name, time, holiday from lib_eng ",nativeQuery=true) 
//	List<CrudEntity> searchParamRepo(@Param("name") String name);
	 
	
}
