package asia.sejong.web.eazimemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import asia.sejong.web.eazimemo.domain.SimpleBoard;

public interface SimpleBoardMapper {

	public int insertSimpleBoard(SimpleBoard simpleBoard);

	public int updateSimpleBoard(SimpleBoard simpleBoard);

	@Select("SELECT * FROM SimpleBoard")
	public List<SimpleBoard> selectAllSimpleBoard();

	@Select("SELECT * FROM SimpleBoard WHERE idx = #{idx}")
	public SimpleBoard selectSimpleBoard(@Param("idx") int idx);


}
