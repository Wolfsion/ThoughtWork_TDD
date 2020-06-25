package Poker;

public class Judger {
	private int[] nums;
    private char[] suits;
    private int result = 1;
    private int maxNum = 0;
    static final int ExtendSize = 3;
    static final int PairIndex = 2;
    private int[] extend = new int[ExtendSize];      

    public Judger(int[] pokerNum, char[] pokerSuits) {
        this.nums = pokerNum;
        this.suits = pokerSuits;
    }

    //同花�?
    private boolean straightFlush() {
    	boolean flag = false;
    	if(flush() && straight()) {
    		flag = true;
    	}
    	return flag;
    }
    
    //同花
    private boolean flush() {
    	boolean flag = false;
    	char first = suits[0];
    	int temp;
    	for(temp = 1; temp < Card.Size; temp++) {
    		if(first != suits[temp]) 
    			break;		
    	}
    	if(temp == Card.Size)
    		flag = true;
    	return flag;
    }

    //顺子
    private boolean straight() {
    	boolean flag = false;
    	int first = nums[0];
    	int temp;
    	for(temp = 1; temp < Card.Size; temp++) {
    		if(nums[temp] != ++first) 
    			break;		
    	}
    	if(temp == Card.Size)
    		flag = true;
    	return flag;
    }

    //三条
    private boolean tris() {
    	boolean flag = false;
    	for(int temp = 0; temp < Card.Size - 2; temp++) {
    		int numPresent = nums[temp];
    		int cnt = 0;
    		for(int cmp = temp+1; cmp < Card.Size; cmp++) {
    			if(nums[cmp] != numPresent)
    				break;
    			cnt++;
    		}
    		if(cnt >= 2) {
    			flag = true;
    			break;
    		}					
    	}
    	return flag;
    }

    //两�??
    private boolean twoPairs() {
    	boolean flag = false;
    	if(pair()) {
    		int index = 0;
    		while(nums[index] <= extend[PairIndex]) {
    			index++;
    		}
    		for(int temp = index; temp < Card.Size - 1; temp++) {
        		int numPresent = nums[temp];
        		int cnt = 0;
        		for(int cmp = temp+1; cmp < Card.Size; cmp++) {
        			if(nums[cmp] != numPresent)
        				break;
        			cnt++;
        		}
        		if(cnt >= 1) {
        			flag = true;
        			break;
        		}					
        	}
    	}
    	return flag;
    }

    //对子
    private boolean pair() {
    	boolean flag = false;
    	for(int temp = 0; temp < Card.Size - 1; temp++) {
    		int numPresent = nums[temp];
    		int cnt = 0;
    		for(int cmp = temp+1; cmp < Card.Size; cmp++) {
    			if(nums[cmp] != numPresent)
    				break;
    			cnt++;
    		}
    		if(cnt >= 1) {
    			flag = true;
    			extend[PairIndex] = numPresent;
    			break;
    		}					
    	}
    	return flag;
    }

    public void judge() {
    	if(this.straightFlush()) {
    		result = 6;
    		return;
    	}
    	if(this.flush()) {
    		result = 5;
    		return;
    	}
        if(this.straight()) {
    		result = 4;
    		return;
    	} 
        if(this.tris()) {
    		result = 3;
    		return;
    	} 
        if(this.twoPairs()) {
    		result = 2;
    		return;
    	} 
        if(this.pair()) {
    		result = 1;
    		return;
    	} 
        
        //high Card 散牌
    	result = 0;
    	return;
  	     
    }

    public int getRet() {
        return this.result;
    }

    public int getMaxNum() {
    	maxNum = nums[Card.Size - 1];
        return maxNum;
    }
    
}
