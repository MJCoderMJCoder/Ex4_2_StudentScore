package com.studentscore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

public class StudenScore {
	public static void main(String[] args) throws IOException {
		int k, count = 5;		//countΪѧ���ĸ���
		double score [] = new double[count];	//ѧ���ĳɼ���������������
		boolean contiGo = true;
		String str;
		
		/*System.in��InputStream�������ֽ�����BufferedReader�����ַ������� */
		//InputStreamReader���ֽ���ͨ���ַ�������������ʹ��ָ������Ĭ�ϣ����ַ�����ȡ�ֽڲ��������Ϊ�ַ�
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		for(k = 0; k < count; k++) {
			while(contiGo) {
				System.out.print("�������" + (k + 1) + "��ѧ���ĳɼ���");
				
				/*��ȡһ���ı��У��������С��س���ֱ�Ӹ��Ż�����Ϊĳ������ֹ������ѵ�����ĩβ���򷵻�null*/
				str = buf.readLine();
				try {	//�����������ֵ���ݻ����������0
					score [k] = Double.parseDouble(str);
					if(0 > score[k] || 100 < score[k]) {
						JOptionPane.showMessageDialog(null, "����������ɼ�", "���棺�ɼ��������", 
								JOptionPane.QUESTION_MESSAGE);
					} else 
						break;	//break�������ǿ����ֹѭ������ִ�У�����ѭ����breakֻ���������ڲ�
				} catch (Exception ne) {
					JOptionPane.showMessageDialog(null, "����������ɼ�", "��ʾ��Ϣ", 
							JOptionPane.QUESTION_MESSAGE);
				}
			}
		}
		/*����ð�ݷ����Գɼ�����*/
		double[] scoreCopy = new double[count + 1];		//����������scoreCopy[]����
		double temp = 0;
		
		/*
		 * System.arraycopy(src, srcPos, dest, destPos, length);
		 * �÷�������src��Դ�����дӡ�srcPos����ʼ��������length����Ԫ�ظ��Ƶ���dest������Ĵӡ�destPos����ʼλ��
		 * �ҡ�src���͡�dest������ָ��ͬ���ڴ�ռ�
		 */
		System.arraycopy(score, 0, scoreCopy, 1, score.length);
		
/*****************************************************************************************************/
		for(k = 1; k < count; k++)		//ʹ��ð�ݷ�����
			//k=1ʱ��ɸѡ����һ������ֵ��k=2ʱ��ɸѡ���ڶ�������ֵ
			
			/*ÿһ��ѭ�������ܴ���ɸѡ��������ֵ */
			for(int m = 1; m <= count - k; m++)
				if(scoreCopy[m] > scoreCopy[m+1]) {
					temp = scoreCopy[m];	//temp����ʱ��Ա��
					scoreCopy[m] = scoreCopy[m+1];
					scoreCopy[m+1] = temp;
				}
/*****************************************************************************************************/
		
		System.out.println("��" + score.length + "��ͬѧ�ĳɼ����£�");
		for(int j = 0; j < score.length; j++)
			System.out.print(score[j] + "\t");
		System.out.println("\n��" + score.length + "��ͬѧ�ĳɼ��ӵ͵����������£�");
		for(int j = 1; j < scoreCopy.length; j++)
			System.out.print(scoreCopy[j] + "\t");
	}
}
