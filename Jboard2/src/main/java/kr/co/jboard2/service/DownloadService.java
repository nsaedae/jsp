package kr.co.jboard2.service;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.ArticleDao;
import kr.co.jboard2.vo.FileVo;

public class DownloadService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String seq = req.getParameter("seq");
		
		ArticleDao dao = ArticleDao.getInstance();
		FileVo vo = dao.selectFile(seq);
		dao.updateFileDownload(seq);
		
		return "file:"+vo.getOldName();
	}

}










