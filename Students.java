package 学生管理系统;
import java.util.*;
public class Students {
	private String name;
	private String number;
	private String sex;
	private int Eng;
	private int java;
	private int math;
	private int total;
	public int getEng() {
		return Eng;
	}

	public void setEng(int eng) {
		Eng = eng;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}


	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Students(String name,String number,String sex,
						int Eng,int java,int math) {
		this.name=name;
		this.number=number;
		this.sex=sex;
		this.Eng=Eng;
		this.java=java;
		this.math=math;
		this.total=this.math+this.java+this.Eng;
	}
	
	public Students() {
		
	}
	public String toString(){
		return "姓名:"+this.name+","+"性别:"+this.sex+","+"学号:"+this.number+","+
				"java:"+this.java+","+"大学英语"+this.Eng+","+"高等数学"+this.math+","
				+"总分:"+this.total;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getNumber(){
		return this.number;
	}
	public String getSex() {
		return this.sex;
	}

	

	

	

}
