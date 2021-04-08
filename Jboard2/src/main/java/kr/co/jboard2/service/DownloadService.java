package kr.co.jboard2.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.ArticleDao;
import kr.co.jboard2.vo.FileVo;

public class DownloadService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		String seq = req.getParameter("seq");
		
		ArticleDao dao = ArticleDao.getInstance();
		
		// �������� SELECT 
		FileVo vo = dao.selectFile(seq);
		
		// ���� �ٿ�ε� Ƚ�� 1����
		dao.updateFileDownload(seq);
		
		// Controller���� �����ϱ� ���� ����
		req.setAttribute("fileVo", vo);
		
		return "file:"+vo.getOldName();
	}

}










