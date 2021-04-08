package kr.co.jboard2.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.jboard2.dao.ArticleDao;
import kr.co.jboard2.vo.ArticleVo;

public class WriteService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("POST")) {

			String path = req.getServletContext().getRealPath("/file");
			int maxSize = 1024 * 1024 * 10;
			
			MultipartRequest mRequest = null;
			
			try {
				mRequest = new MultipartRequest(req, path, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			String title   = mRequest.getParameter("title");
			String content = mRequest.getParameter("content");
			String uid = mRequest.getParameter("uid");
			String file    = mRequest.getFilesystemName("file");
			String regip   = req.getRemoteAddr();
			
			ArticleVo vo = new ArticleVo();
			vo.setTitle(title);
			vo.setContent(content);
			vo.setUid(uid);
			vo.setRegip(regip);
			
			int seq = ArticleDao.getInstance().insertArticle(vo);
			
			return "redirect:/Jboard2/list.do";
			
		}else {
			return "/write.jsp";	
		}
	}

}
