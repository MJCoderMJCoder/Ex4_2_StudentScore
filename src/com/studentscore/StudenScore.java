package com.studentscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class StudenScore {
	public static void main(String[] args) throws IOException {
		int k, count = 5;		//count为学生的个数
		double score [] = new double[count];	//学生的成绩数组声明并创建
		boolean contiGo = true;
		String str;
		
		/*System.in是InputStream流，是字节流，BufferedReader还是字符缓冲流 */
		//InputStreamReader是字节流通向字符流的桥梁，它使用指定（或默认）的字符集读取字节并将其解码为字符
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		for(k = 0; k < count; k++) {
			while(contiGo) {
				System.out.print("请输入第" + (k + 1) + "个学生的成绩：");
				
				/*读取一个文本行，遇到换行、回车后直接跟着换行认为某行已终止。如果已到达流末尾，则返回null*/
				str = buf.readLine();
				try {	//处理输入非数值数据或输入的数是0
					score [k] = Double.parseDouble(str);
					if(0 > score[k] || 100 < score[k]) {
						JOptionPane.showMessageDialog(null, "请重新输入成绩", "警告：成绩输入错误", 
								JOptionPane.QUESTION_MESSAGE);
					} else 
						break;	//break语句用来强行终止循环语句的执行，结束循环。break只是跳出所在层
				} catch (Exception ne) {
					JOptionPane.showMessageDialog(null, "请重新输入成绩", "提示信息", 
							JOptionPane.QUESTION_MESSAGE);
				}
			}
		}
		/*采用冒泡法，对成绩排序*/
		double[] scoreCopy = new double[count + 1];		//声明并创建scoreCopy[]数组
		double temp = 0;
		
		/*
		 * System.arraycopy(src, srcPos, dest, destPos, length);
		 * 该方法将“src”源数组中从“srcPos”开始的连续“length”个元素复制到“dest”数组的从“destPos”开始位置
		 * 且“src”和“dest”数组指向不同的内存空间
		 */
		System.arraycopy(score, 0, scoreCopy, 1, score.length);
		
/*****************************************************************************************************/
		for(k = 1; k < count; k++)		//使用冒泡法排序；
			//k=1时，筛选出第一个最大的值；k=2时，筛选出第二个最大的值
			
			/*每一次循环，都能从中筛选出个最大的值 */
			for(int m = 1; m <= count - k; m++)
				if(scoreCopy[m] > scoreCopy[m+1]) {
					temp = scoreCopy[m];	//temp：临时雇员；
					scoreCopy[m] = scoreCopy[m+1];
					scoreCopy[m+1] = temp;
				}
/*****************************************************************************************************/
		
		System.out.println("这" + score.length + "个同学的成绩如下：");
		for(int j = 0; j < score.length; j++)
			System.out.print(score[j] + "\t");
		System.out.println("\n这" + score.length + "个同学的成绩从低到高排序如下：");
		for(int j = 1; j < scoreCopy.length; j++)
			System.out.print(scoreCopy[j] + "\t");
	}
}
