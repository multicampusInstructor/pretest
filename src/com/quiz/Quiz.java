package com.quiz;

public class Quiz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Quiz q = new Quiz();
		q.test3();
	}
	
	public void test1() {
		double x = 5.0;
		double y = 0.0;
		double z = x/y;
		
		if (new Double(z).isInfinite()) {
			System.out.println("isnan");
		} else {
			System.out.println(z);
		}
		
	}
	
	public void test2() {
		int value = 356;
		//System.out.print(value/100*100);
		//int y = 0
		for(int i=1;i<11;i++) {
			for(int j=1;j<11;j++) {
				if((4*i)+(5*j) == 60) {
					System.out.println(String.format("(%d,%d)",i,j));
				}
				
			}
		}
	}
	
	public void test3() {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("hi");
				
			}
		});
		t.start();
		
		new Thread() {
			public void run() {
				System.out.println("hello");
			}
		}.start();
	}

}
