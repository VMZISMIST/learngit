package ѧ������ϵͳ;
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
         //������������������д
         System.out.println("��������������ӭ����ѧ������ϵͳ������������");
         System.out.println("1 ��ʾѧ����Ϣ");
         System.out.println("2 ���ѧ����Ϣ");
         System.out.println("3 �޸�ѧ����Ϣ");
         System.out.println("4 ɾ��ѧ����Ϣ");
         System.out.println("5 ����ѧ����Ϣ");
         System.out.println("0 �˳�ѧ����Ϣ");
         System.out.println("���������ѡ��");
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
			System.out.println("�ѱ���");
			continue;
		case 0:
			flag=false;
			System.out.print("���˳�");
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
	System.out.println("��������Ҫ�޸���Ϣ��ѧ������");
	Scanner del = new Scanner(System.in);
	String delName=del.nextLine();
	for(int i=0;i<Stu.size();i++) {
		Students stu= Stu.get(i);
		if(delName.equals(stu.getName())) {
			Stu.remove(i);
			System.out.println("��ɾ��");
		}
}
}

private static void update() {
	// TODO Auto-generated method stub
	int number;
	Scanner np = new Scanner(System.in);
	System.out.println("��������Ҫ�޸���Ϣ��ѧ������");
	String upName=np.nextLine();
	for(int i=0;i<Stu.size();i++) {
		Students stu= Stu.get(i);
		if(upName.equals(stu.getName())) {
			Scanner ep = new Scanner(System.in);
			System.out.println("ȷ�д��ˣ���ѡ����Ҫ�޸ĵ���Ϣ��");
			System.out.println("1.���� 2.�Ա� 3.ѧ��"
							+ "4.���� 5.java 6.��Ӣ");
			number=ep.nextInt();
			Scanner up = new Scanner(System.in);
			switch (number) {
			case 1:
				System.out.print("�������޸ĺ��������");
				String upname = up.nextLine();
				stu.setName(upname);
				break;
			case 2:
				System.out.print("�������޸ĺ���Ա�");
				String sex = up.nextLine();
				stu.setSex(sex);
				break;
			case 3:
				System.out.print("�������޸ĺ��ѧ�ţ�");
				String num = up.nextLine();
				stu.setNumber(num);;
				break;
			case 4:
				System.out.print("�������޸ĺ�ĸ����ɼ���");
				int math = up.nextInt();
				stu.setMath(math);
				break;
			case 5:
				System.out.print("�������޸ĺ��java�ɼ���");
				int java1 = up.nextInt();
				stu.setJava(java1);;
				break;
			case 6:
				System.out.print("�������޸ĺ��������ѧӢ��ɼ���");
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
		System.out.println("��δ¼��ѧ����Ϣ");
	}else {
		Stu.forEach(i->System.out.println(i));
	}
	
}

private static void add() {
	// TODO Auto-generated method stub
	Scanner sc = new Scanner(System.in);
	System.out.print("������¼��ѧ������");
	int num = sc.nextInt();
	for(int i=0;i < num;i++) {
		System.out.println("----¼�������Ϣ----");
		Scanner sc1 = new Scanner(System.in);
		System.out.println("������");
		String name=sc1.nextLine();
		System.out.println("ѧ�ţ�");
		String number=sc1.nextLine();
		System.out.println("�Ա�");
		String sex=sc1.nextLine();
		System.out.println("----¼��ɼ�---");
		List<Integer> scoreList=new ArrayList<Integer>();
		Scanner sc2 = new Scanner(System.in);
		System.out.println("�ߵ���ѧ:");
		int math=sc2.nextInt();
		System.out.println("��ѧӢ��:");
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
