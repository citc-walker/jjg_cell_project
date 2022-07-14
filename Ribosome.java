package jjg.cellproject.citcwalker;

public class Ribosome {//리보솜 클래스
	private String[] codon;
	private String index;
	private final char[] CHO_C =  {'ㄱ','ㄲ','ㄴ','ㄷ','ㄸ','ㄹ','ㅁ','ㅂ','ㅃ',
			'ㅅ','ㅆ','ㅇ','ㅈ','ㅉ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
	private final char[] JOONG_C = {'ㅏ','ㅐ','ㅑ','ㅒ','ㅓ','ㅔ','ㅕ','ㅖ','ㅗ','ㅘ',
			'ㅙ','ㅚ','ㅛ','ㅜ','ㅝ','ㅞ','ㅟ','ㅠ','ㅡ','ㅢ','ㅣ'};
	private final char[] JONG_C = {'`','ㄱ','ㄲ','ㄳ','ㄴ','ㄵ','ㄶ','ㄷ','ㄹ'
			,'ㅁ','ㅂ','ㅅ','ㅆ','ㅇ','ㅈ','ㅊ','ㅋ','ㅌ','ㅍ','ㅎ'};
	private final String[] JONG = {"","ㄱ","ㄲ","ㄳ","ㄴ","ㄵ","ㄶ","ㄷ","ㄹ","ㄺ","ㄻ","ㄼ",
			"ㄽ","ㄾ","ㄿ","ㅀ","ㅁ","ㅂ","ㅄ","ㅅ","ㅆ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
	private final String[][] CODON = {{"AAC"}, {"AAG"}, {"AAU", "AAA"}, {"CAC"}, {"CAG"}, 
			{"CAU", "CAA"}, {"UAA", "UAC"}, {"UAU"}, {"UAG"}, {"GAC"}, {"GAG"}, {"GAA", "GAU"},
			{"ACU"}, {"ACA"}, {"ACC"}, {"CCU"}, {"CCA"}, {"UCC"}, {"UCA"}, {"GCA"}, {"GCC"},{"GCU"},
			{"GCG"}, {"AUA"}, {"AUC"}, {"AUU"}, {"AUG"}, {"CUA"}, {"CUC"}, {"CCC"}, {"CCG"}, {"CUU"},
			{"UUA"}, {"UUC"}, {"UCG"}, {"UCU"}, {"UUU", "UUG"}, {"GUA"}, {"ACG"}, {"GUU"}, {"GUG"},
			{"AGA"}, {"AGC"}, {"AGU"}, {"AGG"}, {"CGA", "CGC"}, {"CGU", "CGG"}, {"UGC", "GGC"},
			{"UGG"}, {"UGU"}, {"GGA"}, {"GGG"}, {"UGA"}, {"GGU"}};
	private final String[] data = {"ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ",
			"ㅏ", "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅘ", "ㅙ", "ㅚ", "ㅛ", "ㅜ", "ㅝ", "ㅞ", "ㅟ", "ㅠ", "ㅡ", "ㅢ", "ㅣ",
		"`", ".", ",", "!", "?", " ", "(", ")", "~", "-", "@", "#", "$", "%"};
	private final char[] data_c = {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ',
			'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ',
		'`', '.', ',', '!', '?', ' ', '(', ')', '~', '-', '@', '#', '$', '%'};
	public Ribosome() {
		
	}
	public Ribosome(String codon) {//리보솜 객체가 선언됐을때 ㅗ ㅘ ㅙ ㅚ
		this.codon = codon.split("(?<=\\G...)");
		this.index = interpret(this.codon);
	}
	public String interpret(String codonl) {//코돈을 한글로
		String[] codonlist = codonl.split("(?<=\\G...)");
		String result="", sent = "";
		for(int i = 0; i < codonlist.length; i++) {//어떤 글자인지 검출
			for(int j = 0; j < CODON.length; j++) {
				for(int k = 0; k < CODON[j].length; k++) {
					if(CODON[j][k].equals(codonlist[i])) {
						result += data[j]+"";
					}
				}
			}
		}//유니코드 산출 공식 (int to String) (초성 * 21 + 중성) * 28 + 종성 + 0xAC00
		String[] k = result.split("(?<=\\G...)");
		for(int i = 0; i < k.length; i++) {
			char[] t = k[i].toCharArray();
			int cho, jun, jong;
			cho = findIndex(CHO_C, t[0]);
			System.out.println(t[0]);
			jun = findIndex(JOONG_C, t[1]);
//			jong = findIndex(JONG_C, t[2]);
			sent += (char)((cho * 21 + jun) * 28 /*+ jong */+ 0xAC00);
		}
		return sent;
	}
	public String interpret(String[] codonlist) {//코돈을 한글로
		String result="", sent = "";
		for(int i = 0; i < codonlist.length; i++) {//어떤 글자인지 검출
			for(int j = 0; j < CODON.length; j++) {
				for(int k = 0; k < CODON[j].length; k++) {
					if(CODON[j][k].equals(codonlist[i])) {
						result += data[j]+"";
					}
				}
			}
		}//유니코드 산출 공식 (int to String) (초성 * 21 + 중성) * 28 + 종성 + 0xAC00
		String[] k = result.split("(?<=\\G...)");
		for(int i = 0; i < k.length; i++) {
			char[] t = k[i].toCharArray();
			int cho, jun, jong;
			cho = findIndex(CHO_C, t[0]);
			jun = findIndex(JOONG_C, t[1]);
			jong = findIndex(JONG_C, t[2]);
			sent += (char)((cho * 21 + jun) * 28 + jong + 0xAC00);
		}
		return sent;
	}
	public String getCodon() {
		return this.index;
	}
	private int findIndex(char[] array, char c) { //리스트에서 몇번째에 있는지 찾아줌
		int t = -1;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == c) {
				t = i;
			}
		}
		return t;
	}
	private int findIndex(String[] array, String c) { //리스트에서 몇번째에 있는지 찾아줌
		int t = -1;
		for(int i = 0; i < array.length; i++) {
			if(array[i].equals(c)) {
				t = i;
			}
		}
		return t;
	}
	public String translate(String sentence) { //한글을 코돈으로
		String result = "";
		char[] s_c = sentence.toCharArray();
		for(int i = 0; i < s_c.length; i++) {
			char cho = CHO_C[(int)((String.valueOf(s_c[i]).charAt(0)-0xAC00)/28/21)];
			char jung = JOONG_C[(int)((String.valueOf(s_c[i]).charAt(0)-0xAC00)/28%21)];
//			String jong = "";
//			System.out.println((char)((s_c[i]-0xAC00)%28)+1);
//			if(String.valueOf((s_c[i]-0xAC00)%28) == null) {
//				jong = data[40];
//			}else {
//				jong= JONG[((s_c[i]-0xAC00)%28)];
//			}
//			String j;
//			if(jong == JONG[0]) {
//				j = "";
//			}else {
//				j = String.valueOf(jong);
//			}
			result+=CODON[findIndex(data_c, cho)][0];
			result+=CODON[findIndex(data_c, jung)][0];
//			result+=CODON[findIndex(JONG, j)][0];
		}
		return result;
	}
}
