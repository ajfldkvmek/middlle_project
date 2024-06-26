//package lecture.comm.controller;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedOutputStream;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.net.URLEncoder;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import lecture.comm.service.AtchFileServiceImpl;
//import lecture.comm.service.IAtchFileService;
//import lecture.comm.vo.AtchFileVO;
//
//
//@WebServlet("/lecture.fileDownload.do")
//public class DownloadController extends HttpServlet{
//
//	
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		long atchFileId = req.getParameter("fileId") == null ? 0 : Long.parseLong(req.getParameter("fileId"));
//		int fileSn = req.getParameter("fileSn") == null? 0 : Integer.parseInt(req.getParameter("fileSn"));
//		
//		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
//		
//		AtchFileVO atchFileVO = new AtchFileVO();
//		atchFileVO.setAtchFileId(atchFileId);;
//		atchFileVO.setFileSn(fileSn);
//		
//		atchFileVO = fileService.getAtchFileDetail(atchFileVO);
//		
//		/*
//		  	Content-Disposition 헤더에 대하여..
//		  	
//		  	Response 헤더에서 사용되는 경우 .. ex) 파일 다운로드
//		  	
//		  	Content-Disposition: inline (default)
//		  	Content-disposition: attachment,
//		  	Content-disposition: attachment; filename="filename.jpg"
//		 */
//		
//			resp.setContentType("application/octet-stream");
//			
//
//			// 인코딩 처리를 해야 한글이 깨지지 않음
//			resp.setHeader("Content-disposition", "attachment; filename=\"" 
//			+ URLEncoder.encode(atchFileVO.getOrignlFileNm(), "UTF-8")
//			.replaceAll("\\+", "%20")+ "\"");
//			resp.setHeader("Content-disposition", "attachment; filename=\""+ URLEncoder.encode(atchFileVO.getOrignlFileNm(), "UTF-8").replaceAll("\\+", "%20")+ "\"");
//			// URL에는 공백문자를 포함할 수 없다. URLEncoding을 이용하여 인코딩 작업을 하면 공백은
//			// +로 표시되기 때문에 +문자를 공백문자인 %20으로 일괄적으로 바꿔준다.
//	
//			
//			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(atchFileVO.getFileStreCours()));
//			
//			BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
//			
//			int data = 0;
//			while((data = bis.read()) != -1) {
//				bos.write(data);
//			}
//				
//			bis.close();
//			bos.close();
//		
//	
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		doGet(req, resp);
//	}
//	
//	
//}
