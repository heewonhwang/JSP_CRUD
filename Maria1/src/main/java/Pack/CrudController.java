package Pack;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class CrudController {
	private final CrudEntityRepository crudEntityRepository;
	
	// controller에서 매니저를 가져온다음 
	@PersistenceContext
	private EntityManager entityManager;
	
	@GetMapping("searchParam")
	public String searchParamMember(@RequestParam(value = "index") String index) {
	List resultList = entityManager.createQuery("select * from lib_eng ")
//	                               .setParameter("age", age)
                                   .getResultList();
       return resultList.toString();
    }

//    @GetMapping("searchParamRepo")
//    public String searchParamRepoMember(@RequestParam(value = "name") String name) {
//	        return crudEntityRepository.searchParamRepo(name).toString();
//    }

	@GetMapping("insert")
	public String insertCandidate(
			@RequestParam(value ="index") String index, @RequestParam(value ="lib_name") String lib_name
			, @RequestParam(value ="code") String code, @RequestParam(value ="ad_name") String ad_name
			, @RequestParam(value ="address") String address, @RequestParam(value ="phone") String phone
			, @RequestParam(value ="url") String url, @RequestParam(value ="time") String time
			, @RequestParam(value ="holiday") String holiday, @RequestParam(value ="devision") String devision
			, @RequestParam(value ="dev_name") String dev_name, @RequestParam(value ="lat") String lat
			, @RequestParam(value ="longtitude") String longtitude) {
		if(crudEntityRepository.findById(index).isPresent()) {
			return "동일한 인덱스가 있습니다.";
		}else {
			CrudEntity crudEntity = (CrudEntity.builder().index(index).lib_name(lib_name).code(code)
					.ad_name(ad_name).address(address).phone(phone).url(url)
					.time(time).holiday(holiday).devision(devision)
					.dev_name(dev_name).lat(lat).longtitude(longtitude).build());
			crudEntityRepository.save(crudEntity);
			//return "이름 : " + name + "나이" + age + "으로 추가 되었습니다.";
			return "추가 되었습니다.";
		}
	}
	@GetMapping("delete")
    public String deleteMember(@RequestParam(value = "index") String index) {
        if(crudEntityRepository.findById(index).isEmpty()) { // 값 존재여부 확인
            return "입력한 " + index + "가 존재하지 않습니다";
        } else {
            crudEntityRepository.delete(CrudEntity.builder().index(index).build());
            return index + "목록 삭제 완료";
        }
    }
	@GetMapping("update")
    public String updateMember(@RequestParam(value = "index") String index, @RequestParam(value = "phone") String phone) {
        if(crudEntityRepository.findById(index).isEmpty()) { // 값 존재여부 확인
            return "입력한 " + index + "이 존재하지 않습니다";
        } else {
            crudEntityRepository.save(CrudEntity.builder().index(index).phone(phone).build());
            //return name + "의 나이를 " + age + "로 변경 완료";
            return "갱신 완료";
        }
    }
}
