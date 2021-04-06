package kr.co.jboard2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.UserDao;
import kr.co.jboard2.service.CommonService;
import kr.co.jboard2.vo.TermsVo;

public class TermsService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			TermsVo vo = UserDao.getInstance().selectTerms();
			
			// View에서 vo객체를 참조하기 위해 Controller-Service-View에서 공유되는 request객체를 이용
			req.setAttribute("vo", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/user/terms.jsp";
	}

}













