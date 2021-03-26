package com.basic;

import java.util.Comparator;

public class RecordComparator implements Comparator<Data> {

	@Override
	public int compare(Data o1, Data o2) {
		// TODO Auto-generated method stub
		int score1 = o1.getKor()+o1.getEng();
		int score2 = o2.getKor()+o2.getEng();
		int result = score2 - score1;
		if (result == 0) {
			result = o2.getStdNo() - o1.getStdNo();
			//result = o2.getEmail().compareTo(o1.getEmail());
		}
		return result;
	}

}
