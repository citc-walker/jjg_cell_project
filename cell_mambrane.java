package cell;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class cell_mambrane {
	public static void main(String[] args) { //세포벽의 본체
		prints("무엇을 하시겠습니까? (read/write)");
		@SuppressWarnings("resource")
		Scanner ans = new Scanner(System.in); 
		String Ans = ans.nextLine();
		System.out.println(Ans);
		if (Ans.equals("read")) {
			System.out.println("read 선택");
			String DATA_DIRECTORY = "c:\\Users\\yoosi\\Desktop\\codon"; //filename.codon이 있는 위치
			File dir = new File(DATA_DIRECTORY);//파일 리스트 불러오는 부분
			String[] filenames = dir.list();
			for (String filename : filenames) {
				prints("filename : " + filename);
			}
			ReadAndWrite.read();
		} else if (Ans.equals("write")) {
			System.out.println("write 선택");
			ReadAndWrite.writer();
		} else {
			System.out.println("오류 - read/write중 하나로 정확히 입력해 주세요.");
			cell_mambrane.main(null);
		}
	}	
public static class ReadAndWrite { //read와 writer 매소드를 출력하는 클래스
	public static void read() { 
		prints("파일의 이름을 입력해 주세요.");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		try {
			Reader(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writer() {
		prints("파일의 이름을 입력하세요.");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		File file = new File("C:\\Users\\yoosi\\Desktop\\codon\\"+name+".codon");//codon파일이 저장될 위치 지정
		try {
			if(file.createNewFile()) {
				prints(name+"파일을 생성했습니다.");
				
			} else {
				prints("파일이 이미 존재합니다.");
				System.out.println("파일의 내용:");
				Reader(name);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		prints("내용을 적어주세요.");
		@SuppressWarnings("resource")
		Scanner brabra = new Scanner(System.in);
		String mas = brabra.nextLine();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(mas);
			writer.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("쓰기 완료!");
		prints("처음 화면으로 돌아갑니다.");
		cell_mambrane.main(null);
	}
}
	public static void Reader(String Name) throws IOException { //코돈 내용을 읽는 부분
		String url = "C:\\\\Users\\\\yoosi\\\\Desktop\\\\codon\\\\"+Name+".codon"; //codon이 저장된곳으로 지정
		String str = Files.readString(Paths.get(url));
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println(str);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		prints("처음 화면으로 돌아갑니다.");
		cell_mambrane.main(null);

	}
	public static void prints(String mas) { //우리 모두가 알고있는 바로 그 구문
		char[] ca = mas.toCharArray();
		 for(int i = 0; i < ca.length; i++) {
			 try {
				 System.out.print(ca[i]);
				 Thread.sleep(40);
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
		 System.out.print("\n");
	}
}