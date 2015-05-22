package asia.sejong.web.eazimemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import asia.sejong.web.eazimemo.domain.SimpleBoard;

public interface SimpleBoardMapper {

	public List<SimpleBoard> selectAllSimpleBoard();

	public int insertSimpleBoard(SimpleBoard simpleBoard);

	@Select("SELECT * FROM SimpleBoard")
	public List<SimpleBoard> selectAllSimpleBoard2();

	@Select("SELECT * FROM SimpleBoard WHERE id = #{id}")
	public SimpleBoard selectSimpleBoard(@Param("idx") int idx);

}
