package com.biz.book.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.book.mapper.BookMapper;
import com.biz.book.model.BookFormVO;
import com.biz.book.model.BookVO;

@Service
public class BookService {

	@Autowired
	BookMapper bookMapper;
	
	@Autowired
	ServletContext servletContext;

	public int insert(BookFormVO bookFormVO, MultipartHttpServletRequest request) {
		// TODO Auto-generated method stub
		
		BookVO bookVO=new BookVO();
		
		MultipartFile multipartFile=request.getFile("f_file");
		
		String realPath=servletContext.getRealPath("/files/");
		String saveName=UUID.randomUUID()+multipartFile.getOriginalFilename();
		
		File dir=new File(realPath);
		if(!dir.exists()) {
			dir.mkdir();
		} else {
			File file=new File(realPath, saveName);
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sd=new SimpleDateFormat("HH:mm:ss");
		Date d=new Date();
		String today = sf.format(d);
		String time = sd.format(d);
		
		bookVO.setB_auth(bookFormVO.getF_auth());
		bookVO.setB_pass(bookFormVO.getF_pass());
		bookVO.setB_date(today);
		bookVO.setB_time(time);
		bookVO.setB_subject(bookFormVO.getF_subject());
		bookVO.setB_text(bookFormVO.getF_text());
		bookVO.setB_file(saveName);
		
		
		return bookMapper.insert(bookVO);
	}

	public List<BookVO> selectAll() {
		// TODO Auto-generated method stub
		return bookMapper.selectAll();
	}

	public BookVO findByID(long b_id) {
		// TODO Auto-generated method stub
		return bookMapper.findByID(b_id);
	}
	
	public BookVO mainPage() {
		
		List<BookVO> bookList=bookMapper.selectAll();
		return bookList.get(0);
	}
	
}























