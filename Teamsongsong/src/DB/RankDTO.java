package DB;

public class RankDTO {
	
	private String id;
	private int rank; // ���â�� index�� ǥ���ϸ� �ɵ�.���ʿ�
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
