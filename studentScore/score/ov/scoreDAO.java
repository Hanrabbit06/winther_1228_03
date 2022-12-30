package score.ov;

import java.util.ArrayList;

public class ScoreDAO {
	ArrayList<ScoreVO> svoList = new ArrayList<ScoreVO>();
	
	public void insert(ScoreVO svo) {
		svoList.add(svo);
	}

	public ArrayList<ScoreVO> select() {
		return svoList;
	}

	public void delete(int row) {
		svoList.remove(row);
	}

}
