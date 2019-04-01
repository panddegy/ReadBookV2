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

	public String uploadFile(MultipartFile multipartFile) {
		
		String realPath=servletContext.getRealPath("/files/");
		String saveName=UUID.randomUUID()+multipartFile.getOriginalFilename();
		
		File dir=new File(realPath);
		if(!dir.exists()) dir.mkdir();
		
		File file=new File(realPath, saveName);
		try {
			multipartFile.transferTo(file);
			return saveName;
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int insert(BookVO bookVO, MultipartHttpServletRequest request) {
		// TODO Auto-generated method stub
		
		MultipartFile multipartFile=request.getFile("b_realfile");
		if(multipartFile!=null) {
			bookVO.setB_file(this.uploadFile(multipartFile));
		}
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sd=new SimpleDateFormat("HH:mm:ss");
		Date d=new Date();
		String today = sf.format(d);
		String time = sd.format(d);
		
		bookVO.setB_date(today);
		bookVO.setB_time(time);
		
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

	public int update(BookVO bookVO, MultipartHttpServletRequest request) {
		// TODO Auto-generated method stub
		
		if(bookVO.getB_realfile()!=null) {
			MultipartFile multipartFile=request.getFile("b_realfile");
			bookVO.setB_file(this.uploadFile(multipartFile));
		}
		
		return bookMapper.update(bookVO);
	}

	public int delete(long b_id) {
		// TODO Auto-generated method stub
		
		return bookMapper.delete(b_id);
	}
	
}























