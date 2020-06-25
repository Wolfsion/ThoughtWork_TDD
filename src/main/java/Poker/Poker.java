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
    	jer.judge();
    	Integer ret = jer.getRet();
        return ret;  // 输入错误返回-1
    }

    public String compare(String blackCard, String whiteCard) {

    	String winStr = null;
    	int win = 0;
    	
    	Card cadB = new Card();
    	cadB.setter(blackCard);
    	Judger jerB = new Judger(cadB.getNum(),cadB.getSuit());
		jerB.judge();
    	int retB = jerB.getRet();
    	
    	Card cadW = new Card();
    	cadW.setter(whiteCard);
    	Judger jerW = new Judger(cadW.getNum(),cadW.getSuit());
    	jerW.judge();
    	int retW = jerW.getRet();
    	
    	if(retB < retW)
    		win = 1;
    	else if(retB == retW) {
    		if(retB != 1 && retB != 2 && retB != 3) {
				for(int i=0;i<Card.Size;i++) {
					int maxB = jerB.getMaxNum(i);
					int maxW = jerW.getMaxNum(i);
					if(maxB < maxW) {
						win = 1;
						break;
					}

					else if(maxB == maxW) {
						win = 2;
						break;
					}
				}
			}
			else {
				int[] arrB = cadB.getNum();
				int[] arrW = cadW.getNum();

				if(retB == 1 || retB == 3) {
					if( arrB[jerB.pairOne] < arrW[jerW.pairOne] ) {
						win = 1;
					}
					else if( arrB[jerB.pairOne] == arrW[jerW.pairOne] )
					{
						win = 2;
						for(int i=0;i<Card.Size;i++) {
							int maxB = jerB.getMaxNum(i);
							int maxW = jerW.getMaxNum(i);

							if(maxB < maxW) {
								win = 1;
								break;
							}
							else if(maxB > maxW) {
								win = 0;
								break;
							}
						}
					}
				}
				else if(retB == 2) {
					if( arrB[jerB.pairOne] < arrW[jerW.pairOne] ) {
						win = 1;
					}
					else if( arrB[jerB.pairOne] == arrW[jerW.pairOne] )
					{
						if( arrB[jerB.pairTwo] < arrW[jerW.pairTwo] ) {
							win = 1;
						}
						else if( arrB[jerB.pairTwo] == arrW[jerW.pairTwo] )
						{
							win = 2;
							for(int i=0;i<Card.Size;i++) {
								int maxB = jerB.getMaxNum(i);
								int maxW = jerW.getMaxNum(i);

								if(maxB < maxW) {
									win = 1;
									break;
								}
								else if(maxB > maxW) {
									win = 0;
									break;
								}
							}
						}

					}
				}
			}
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
