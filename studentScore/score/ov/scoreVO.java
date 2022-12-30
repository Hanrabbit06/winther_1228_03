package score.ov;

public class ScoreVO {
	
	private int grade; //학년
	private int group; //반
	private int studentNum; //학생번호
	private String studentName; //학생이름
	private int kor; //국
	private int eng; //영
	private int mat; //수
	private int sci; //과
	private int total; //총점
	private double average; //평균
	
	public ScoreVO() {
		
	}
	
	public ScoreVO(int studentNum, String studentName, int grade, int group, int kor, int eng, int mat, int sci,
			int total, double average) {
		super();
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.grade = grade;
		this.group = group;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.sci = sci;
		this.total = total;
		this.average = average;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public int getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getSci() {
		return sci;
	}
	public void setSci(int sci) {
		this.sci = sci;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal() {
		this.total = kor+eng+mat+sci;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage() {
		this.average = total/4.0;
	}
	@Override
	public String toString() {
		return "scoreVO [studentNum=" + studentNum + ", studentName=" + studentName + ", grade=" + grade + ", group="
				+ group + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", sci=" + sci + ", total=" + total
				+ ", average=" + average + "]";
	}
	
	
	

}
