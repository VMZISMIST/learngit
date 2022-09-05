package 学生管理系统;
import java.util.*;
import java.io.*;
public class Demo {
static List<Students> Stu= new ArrayList<Students>();
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int line=0;
	Boolean flag=true;
	try {
		inint();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	while (flag) {
		do {
         //用输出语句完成主界面编写
         System.out.println("——————欢迎来到学生管理系统——————");
         System.out.println("1 显示学生信息");
         System.out.println("2 添加学生信息");
         System.out.println("3 修改学生信息");
         System.out.println("4 删除学生信息");
         System.out.println("5 保存学生信息");
         System.out.println("0 退出学生信息");
         System.out.println("请输入你的选择：");
         line = sc.nextInt();
		}while(line < 0);
         switch (line) {
		case 1:
			show();
			continue;
		case 2:
			add();
			continue;
		case 3:
			update();
			continue;
		case 4:
			delate();
			continue;
		case 5:
			save();
			System.out.println("已保存");
			continue;
		case 0:
			flag=false;
			System.out.print("已退出");
		}
		}
	}

private static void inint() throws IOException{
	// TODO Auto-generated method stub
	String name;
	String number;
	String sex;
	String Eng;
	String java;
	String math;
	String total;
	RandomAccessFile raf = new RandomAccessFile("data.txt", "rw");
	raf.seek(0);
	while((name=raf.readLine())!=null) {
		number=raf.readLine();
		sex=raf.readLine();
		Eng=raf.readLine();
		math=raf.readLine();
		java=raf.readLine();
		total=raf.readLine();
		Students stu=new Students();
		stu.setName(name);
		stu.setSex(sex);
		stu.setNumber(number);
		stu.setEng(Integer.valueOf(Eng));
		stu.setJava(Integer.valueOf(java));
		stu.setMath(Integer.valueOf(math));
		stu.setTotal(Integer.valueOf(total));
		Stu.add(stu);
	}
			
}
private static void save() {
	// TODO Auto-generated method stub
	try {
		RandomAccessFile raf = new RandomAccessFile("data.txt", "rw");
		Stu.forEach(i->{
			try {
				raf.writeBytes(i.getName()+"\n");
				raf.writeBytes(i.getNumber()+"\n");
			    raf.writeBytes(i.getSex()+"\n");
				raf.writeBytes(i.getEng()+"\n");
			    raf.writeBytes(i.getMath()+"\n");
				raf.writeBytes(i.getJava()+"\n");
				raf.writeBytes(i.getTotal()+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		raf.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

private static void delate() {
	// TODO Auto-generated method stub
	System.out.println("请输入需要修改信息的学生姓名");
	Scanner del = new Scanner(System.in);
	String delName=del.nextLine();
	for(int i=0;i<Stu.size();i++) {
		Students stu= Stu.get(i);
		if(delName.equals(stu.getName())) {
			Stu.remove(i);
			System.out.println("已删除");
		}
}
}

private static void update() {
	// TODO Auto-generated method stub
	int number;
	Scanner np = new Scanner(System.in);
	System.out.println("请输入需要修改信息的学生姓名");
	String upName=np.nextLine();
	for(int i=0;i<Stu.size();i++) {
		Students stu= Stu.get(i);
		if(upName.equals(stu.getName())) {
			Scanner ep = new Scanner(System.in);
			System.out.println("确有此人，请选择需要修改的信息：");
			System.out.println("1.姓名 2.性别 3.学号"
							+ "4.高数 5.java 6.大英");
			number=ep.nextInt();
			Scanner up = new Scanner(System.in);
			switch (number) {
			case 1:
				System.out.print("请输入修改后的姓名：");
				String upname = up.nextLine();
				stu.setName(upname);
				break;
			case 2:
				System.out.print("请输入修改后的性别：");
				String sex = up.nextLine();
				stu.setSex(sex);
				break;
			case 3:
				System.out.print("请输入修改后的学号：");
				String num = up.nextLine();
				stu.setNumber(num);;
				break;
			case 4:
				System.out.print("请输入修改后的高数成绩：");
				int math = up.nextInt();
				stu.setMath(math);
				break;
			case 5:
				System.out.print("请输入修改后的java成绩：");
				int java1 = up.nextInt();
				stu.setJava(java1);;
				break;
			case 6:
				System.out.print("请输入修改后的姓名大学英语成绩：");
				int eng = up.nextInt();
				stu.setEng(eng);
				break;
			}
		}
		
	}
}

private static void show() {
	// TODO Auto-generated method stub
	if(Stu.size()==0) {
		System.out.println("暂未录入学生信息");
	}else {
		Stu.forEach(i->System.out.println(i));
	}
	
}

private static void add() {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	System.out.print("请输入录入学生人数");
	int num = sc.nextInt();
	for(int i=0;i < num;i++) {
		System.out.println("----录入基本信息----");
		Scanner sc1 = new Scanner(System.in);
		System.out.println("姓名：");
		String name=sc1.nextLine();
		System.out.println("学号：");
		String number=sc1.nextLine();
		System.out.println("性别");
		String sex=sc1.nextLine();
		System.out.println("----录入成绩---");
		List<Integer> scoreList=new ArrayList<Integer>();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("高等数学:");
		int math=sc2.nextInt();
		System.out.println("大学英语:");
		int Eng=sc2.nextInt();
		System.out.println("java:");
		int javaScore=sc2.nextInt();
		Stu.add(new Students(name,number,sex,Eng,javaScore,math));
		System.out.println();
	}
	Stu.sort((Object o1,Object o2)->{
		 Students s1 = (Students) o1;
	        Students s2 = (Students) o2;
	        if (s1.getTotal()>s2.getTotal()) {
	            return 1;
	        } else if (s1.getTotal()==s2.getTotal()) {
	            return 0;
	        }
	        return -1;
	});
}
}
