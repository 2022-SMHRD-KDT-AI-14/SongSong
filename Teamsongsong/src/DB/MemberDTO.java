package DB;

public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private float score;
	
	
	public MemberDTO(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	//로그아웃 메소드
	public void signOut() {
		if(id != null) {
			id = null;
			pw = null;
			name = null;
			System.out.println("로그아웃 되었습니다.");
		}else {
			System.out.println("로그인이 필요합니다.");
		}
	}
	
	
	//생성자 오버로딩
	public MemberDTO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	
}
