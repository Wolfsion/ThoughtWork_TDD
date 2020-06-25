package Poker;

public class Poker {
	static private final String win1 = "Black wins";
	static private final String win2 = "White wins";
	static private final String win3 = "Tie";
	
    public Integer cardPower(String str) {
        // 按照 同花顺＞同花＞顺子＞三条＞两对＞对子＞散牌 的顺序，分别输出 6，5，4，3，2，1，0 。
    	Card cad = new Card();
    	cad.setter(str);
    	Judger jer = new Judger(cad.getNum(),cad.getSuit());
    	int ret = jer.getRet();
        return ret;  // 输入错误返回-1
    }

    public String compare(String blackCard, String whiteCard) {
        // 题目要求的测试用例
    	String winStr = null;
    	int win = 0;
    	
    	Card cadB = new Card();
    	cadB.setter(blackCard);
    	Judger jerB = new Judger(cadB.getNum(),cadB.getSuit());
    	int retB = jerB.getRet();
    	
    	Card cadW = new Card();
    	cadW.setter(blackCard);
    	Judger jerW = new Judger(cadW.getNum(),cadW.getSuit());
    	int retW = jerW.getRet();
    	
    	if(retB < retW)
    		win = 1;
    	else if(retB == retW) {
    		int maxB = jerB.getMaxNum();
    		int maxW = jerW.getMaxNum();
    		if(maxB < maxW)
    			win = 1;
    		else if(maxB == maxW)
    			win = 2;
    	}

    	switch(win) {
    		case 0:
    			winStr = win1;
    			break;
    		case 1:
    			winStr = win2;
    			break;
    		case 2:
    			winStr = win3;
    			break;
    	}
        return winStr;
    }

}
