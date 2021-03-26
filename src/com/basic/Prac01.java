package com.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;


public class Prac01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prac01 p = new Prac01();
		try {
			ArrayList<Data> list = p.makeData();
			Integer answer = p.solveOne(list);
			p.writeAnswer(answer, 1);
			answer = p.solveTwo(list);
			p.writeAnswer(answer, 2);
			answer = p.solveThree(list);
			p.writeAnswer(answer, 3);
			answer = p.solveFour(list);
			p.writeAnswer(answer, 4);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeAnswer(Integer ans,int number) throws FileNotFoundException {
		File file = new File("data/ans"+number+".txt");
		PrintWriter out = new PrintWriter(file);
		out.println(ans);
		out.close();
	}
	
	public Integer solveTwo(ArrayList<Data> list) {
		Integer i = null;
		ArrayList<Data> p2 = new ArrayList<Data>();
		for (Data record : list) {
			if (record.getLocalCode().equals("B")) {
				p2.add(record);
			}
		}
		Data max = p2.get(0);
		for (Data data : p2) {
			if (max.getKor()+max.getEng()<data.getKor()+data.getEng()) {
				max = data;
			}
		}
		i = max.getStdNo();
		return i;
	}
	
	public Integer solveThree(ArrayList<Data> list) {
		Integer i = 0;
		//ArrayList<Data> p3 = new ArrayList<Data>();
		for (Data record : list) {
			int total = record.getEng()+record.getMath();
			if (total>=120) {
				if(record.getMgrCode().equals("A")) {
					i += (total + 5);
				} else if(record.getMgrCode().equals("B")) {
					i += (total + 15);
				} else if(record.getMgrCode().equals("C")) {
					i += (total + 20);
				}
			}
		}
		return i;
	}
	
	public Integer solveFour(ArrayList<Data> list) {
		Integer i = 0;
		HashMap<String, Integer> point = new HashMap<String, Integer>();
		point.put("A", 5);
		point.put("B", 10);
		point.put("C", 15);
		for (Data record : list) {
			boolean flag = record.getAcc().equals("A") || record.getAcc().equals("B");
			if (flag) {
				if(record.getKor()+point.get(record.getLocalCode()) >=50) {
					i ++;
				} 
			}
		}
		return i;
	}
	public Integer solveOne(ArrayList<Data> list) {
		Integer i = null;
		ArrayList<Data> p1 = new ArrayList<Data>();
		for (Data record : list) {
			if (record.getLocalCode().equals("B")) {
				p1.add(record);
			}
		}
		System.out.println(p1.size());
		RecordComparator rc = new RecordComparator();
		Collections.sort(p1, rc);
		//ArrayList<Data> r = 
		//this.printList(p1);
		i = p1.get(4).getStdNo();
		return i;
	}
	public void printList(ArrayList<Data> list) {
		for (int i=0;i<list.size();i++) {
			if (i==20) { break; }
			System.out.println(list.get(i));
		}
	}
	public ArrayList<Data> makeData() throws IOException{
		ArrayList<Data> data = null;
		File file = new File("data/Abc1115.csv");
		if(file.exists()) {
			data = new ArrayList<Data>();
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			StringBuffer sb = null;
			Data item = null;
			while((line = br.readLine())!=null) {
				String[] temp = line.split(",");
				item = new Data(Integer.parseInt(temp[0].toString()),temp[1].trim());
				item.setKor(Integer.parseInt(temp[2].trim()));
				item.setEng(Integer.parseInt(temp[3].trim()));
				item.setMath(Integer.parseInt(temp[4].trim()));
				item.setSci(Integer.parseInt(temp[5].trim()));
				item.setHist(Integer.parseInt(temp[6].trim()));
				item.setTotal(Integer.parseInt(temp[7].trim()));
				item.setMgrCode(temp[8].trim());
				item.setAcc(temp[8].trim());
				item.setLocalCode(temp[10].trim());
				data.add(item);
			}
			
			br.close();
			fr.close();
		} 
		
		return data;
	}
	public void test2() throws Exception {
		File file = new File("data/Abc1115.txt");
		File outFile = new File("data/Abc1115.csv");
		if(file.exists()) {
			System.out.println(file.length());
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			//FileWriter fw = new FileWriter(outFile);
			PrintWriter pw = new PrintWriter(outFile);
			String line = null;
			StringBuffer sb = null;
			while((line = br.readLine())!=null) {
				System.out.println(line);
				//line = line.replace(" ", ",");
				sb = new StringBuffer(line);
				sb.insert(6, ",");
				sb.insert(11, ",");
				sb.insert(15, ",");
				sb.insert(19, ",");
				sb.insert(23, ",");
				sb.insert(27, ",");
				sb.insert(31, ",");
				sb.insert(35, ",");
				sb.insert(37, ",");
				sb.insert(39, ",");
				//
				System.out.println(sb.toString());
				pw.println(sb.toString());
				//break;
			}
			
			br.close();
			fr.close();
			pw.close();
		} else {
			System.out.println("file not found "+file.toString());
			FileWriter fw = new FileWriter(file);
			fw.write("hi");
			fw.close();
		}
	}

}
