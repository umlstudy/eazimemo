package asia.sejong.web.eazimemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asia.sejong.web.eazimemo.domain.SimpleBoard;
import asia.sejong.web.eazimemo.mapper.SimpleBoardMapper;

@Service("asia.sejong.web.eazimemo.service.SimpleBoardService")
public class SimpleBoardService {

	@Autowired
	private SimpleBoardMapper simpleBoardMapper;

	public List<SimpleBoard> selectAllSimpleBoard() {
		return simpleBoardMapper.selectAllSimpleBoard();
	}

	public SimpleBoard selectSimpleBoard(int id) {
		return simpleBoardMapper.selectSimpleBoard(id);
	}
	
	public int updateSimpleBoard(SimpleBoard simpleBoard) {
		return simpleBoardMapper.updateSimpleBoard(simpleBoard);
	}

	public int insertSimpleBoard(SimpleBoard simpleBoard) {
		return simpleBoardMapper.insertSimpleBoard(simpleBoard);
	}
}
