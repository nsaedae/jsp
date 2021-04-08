package kr.co.jboard2.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.ArticleDao;

public class CommentService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("POST")) {
			// ´ñ±Û ÀÔ·Â
			String parent  = req.getParameter("parent");
			String comment = req.getParameter("comment");
			String uid     = req.getParameter("uid");
			String regip   = req.getRemoteAddr();

			ArticleDao dao = ArticleDao.getInstance();
			
			dao.insertComment(parent, comment, uid, regip);			
			dao.updateArticleCommentInc(parent);
			
			return "redirect:/Jboard2/view.do?seq="+parent;
			
		}else {
			// ´ñ±Û Á¶È¸
			return null;
		}
		
	}

}
