package com.biz.book.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.biz.book.model.BookVO;

public interface BookMapper {

	@Select(" select * from tbl_books_v2 order by b_date desc, b_time desc ")
	public List<BookVO> selectAll();
	
	@Select(" select * from tbl_books_v2 where b_id=#{b_id} ")
	public BookVO findByID(long b_id);
	
	@Insert(" insert into tbl_books_v2 values(seq_book_v2.nextval, #{b_auth}, #{b_pass}, #{b_date}, #{b_time}, "
			+ " #{b_subject,jdbcType=NVARCHAR}, #{b_text,jdbcType=NVARCHAR}, #{b_file,jdbcType=NVARCHAR} ) ")
	public int insert(BookVO bookVO);
	
	@Update(" update tbl_books_v2 set b_text=#{b_text} where b_id=#{b_id} ")
	public int update(BookVO bookVO);
	
	@Delete(" delete from tbl_books_v2 where b_id=#{b_id} ")
	public int delete(long b_id);
	
}
