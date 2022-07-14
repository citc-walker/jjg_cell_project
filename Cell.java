package jjg.cellproject.citcwalker;

public class Cell {//세포 메인 클래스 (지금은 테스트용으로 사용중)
	/*
	 * String[] CHO = {"ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ",
			"ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
	 * String[] JOONG = {"ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ","ㅗ","ㅘ",
			"ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ","ㅟ","ㅠ","ㅡ","ㅢ","ㅣ"};
	 * String[] JONG = {"","ㄱ","ㄲ","ㄳ","ㄴ","ㄵ","ㄶ","ㄷ","ㄹ","ㄺ","ㄻ","ㄼ",
			"ㄽ","ㄾ","ㄿ","ㅀ","ㅁ","ㅂ","ㅄ","ㅅ","ㅆ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
	 * 유니코드 산출 공식 (int to String) (초성 * 21 + 중성) * 28 + 종성 + 0xAC00
	 * char uniVal = "글자".charAt(0);
	 * 초성 산출 공식 (char)((uniVal-0xAC00)/28/21);
	 * 중성 산출 공식 (char)((uniVal-0xAC00)/28%21);
	 * 종성 산출 공식 (char)((uniVal-0xAC00)%28);
	 * */
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
//		String c = "1234567890";
//		String[] codon = c.split("(?<=\\G...)");
//		System.out.println(codon[2]);
		
		Cell_membrane cm = new Cell_membrane();
		cm.CMmain();
//		Ribosome rb = new Ribosome();
//		System.out.println(rb.translate("강예"));
		
		
	}
}
