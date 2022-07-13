package cell;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class cell_mambrane {
	public static void main(String[] args) { //세포벽의 메인 메소드
		prints("무엇을 하시겠습니까? (read/write/folder)");
		@SuppressWarnings("resource")
		Scanner main_sc = new Scanner(System.in); 
		String Ans = main_sc.nextLine();
		System.out.println(Ans);
		if (Ans.equals("read")) {
			System.out.println("read 선택");
			list(); //codon 폴더안의 파일 출력
			ReadAndWrite.read();
		} else if (Ans.equals("write")) {
			System.out.println("write 선택");
			ReadAndWrite.writer();
		} else if (Ans.equals("folder")) {
			directoryCreated(); //codon 폴더가 없을때 codon파일 생성자
		}
		else {
			System.out.println("오류 - read/write중 하나로 정확히 입력해 주세요.");
			cell_mambrane.main(null);
		}
	}	
public static class ReadAndWrite { //read와 writer 매소드를 출력하는 클래스
	public static void read() { 
		prints("파일의 이름을 입력해 주세요.");
		@SuppressWarnings("resource")
		Scanner read_sc = new Scanner(System.in);
		String read_name = read_sc.next();
		try {
			Reader(read_name);
		} catch (IOException e) {
			prints("오류 - 파일이 존재하지 않습니다. "
				+ "먼저 쓰기를 하거나 folder을 통해 폴더를 생성해주세요.");
			cell_mambrane.main(null);
		}
	}
	public static void writer() {
		prints("파일의 이름을 입력하세요.");
		@SuppressWarnings("resource")
		Scanner writer_sc = new Scanner(System.in);
		String writer_name = writer_sc.nextLine();
		File file = new File(".\\codon\\"+writer_name+".codon");//writer_name 이라는 codon파일 생성
		try {
			if(file.createNewFile()) {
				prints(writer_name+"파일을 생성했습니다.");
			} else {
				prints("파일이 이미 존재합니다.");
				System.out.println("파일의 내용:");
				Reader(writer_name);
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		prints("내용을 적어주세요.");
		@SuppressWarnings("resource")
		Scanner Contents_sc = new Scanner(System.in);
		String Contents = Contents_sc.nextLine();
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file)); //내용 작성
			writer.write(Contents); 
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
		String url = ".\\\\codon\\\\"+Name+".codon"; //codon이 저장된곳으로 지정
		String str = Files.readString(Paths.get(url));
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println(str);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		prints("처음 화면으로 돌아갑니다.");
		cell_mambrane.main(null);

	}
	public static void prints(String mas) { //우리 모두가 알고있는 바로 그 구문.
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
	public static void directoryCreated() { //디렉토리 생성
		File dc = new File("./codon");
		boolean directoryCreated = dc.mkdir();
		System.err.println(directoryCreated);
	}
	public static void list() { //codon 폴더의 파일들을 리스트화 해서 출력
		String DATA_DIRECTORY = "./codon"; //filename.codon이 있는 위치
		File dir = new File(DATA_DIRECTORY);//파일 리스트 불러오는 부분
		String[] filenames = dir.list();
		for (String filename : filenames) {
			prints("filename : " + filename);
		}
	}
}
