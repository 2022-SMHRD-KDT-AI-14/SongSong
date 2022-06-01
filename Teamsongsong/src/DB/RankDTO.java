package DB;

public class RankDTO {
	
	private String id;
	private int rank; // 출력창에 index로 표현하면 될듯.불필요
	private String score;
	private String update;
	
	
	
	public void setId(String id) {
		this.id = id;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public void setUpdate(String update) {
		this.update = update;
	}
	public String getId() {
		return id;
	}
	public int getRank() {
		return rank;
	}
	public String getScore() {
		return score;
	}
	public String getUpdate() {
		return update;
	}
	
	
	
}
