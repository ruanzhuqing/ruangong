package ʵ�������������Ż�;

import java.util.Random;

public class Map {
	public	int [][] world=new int[50][50];     //������(0��������1�Ǵ��)
	public  Cell [][] cell=new Cell[50][50];
	
	Map() {
		int i=0;
		int j=0;
		for(i=0;i<50;i++) {
			for(j=0;j<50;j++) {
				cell[i][j]=new Cell();
			}
		}
	}
	
	public void newworld() {              //�����ʼ��
		int i=0;
		int j=0;
		Random r=new Random();
		for(i=0;i<50;i++) {
			for(j=0;j<50;j++) {
				cell[i][j].status=r.nextInt(2);
				world[i][j]=cell[i][j].status;
			}
		}
//		cell[0][48].status=1;      //�����
//		cell[1][47].status=1;
//		cell[2][47].status=1;
//		cell[2][48].status=1;
//		cell[2][49].status=1;
//		cell[25][25].status=1;       //�̶�ͼ��
//		cell[25][26].status=1;
//		cell[26][25].status=1;
//		cell[26][26].status=1;
//		world[0][48]=1;      //�����
//		world[1][47]=1;
//		world[2][47]=1;
//		world[2][48]=1;
//		world[2][49]=1;
//		world[25][25]=1;       //�̶�ͼ��
//		world[25][26]=1;
//		world[26][25]=1;
//		world[26][26]=1;
	}
	public void neighbor() {              //�ж��ھ���neighbor[����][����]
		int i=0;
		int j=0;
		for(i=0;i<50;i++) {
			for(j=0;j<50;j++) {
				if(i-1>=0&&j-1>=0&&world[i-1][j-1]==1) cell[i][j].neighbor++;
				if(i-1>=0&&world[i-1][j]==1) cell[i][j].neighbor++; 
				if(i-1>=0&&j+1<=49&&world[i-1][j+1]==1) cell[i][j].neighbor++;
				if(j-1>=0&&world[i][j-1]==1) cell[i][j].neighbor++;
				if(j+1<=49&&world[i][j+1]==1) cell[i][j].neighbor++;
				if(i+1<=49&&j-1>=0&&world[i+1][j-1]==1) cell[i][j].neighbor++;
				if(i+1<=49&&world[i+1][j]==1) cell[i][j].neighbor++;
				if(i+1<=49&&j+1<=49&&world[i+1][j+1]==1) cell[i][j].neighbor++;
			}
		}
	}
	public int[][] nextworld() {
		int i=0,j=0;
	    for(i=0;i<50;i++)
		   for(j=0;j<50;j++) {
			   cell[i][j].rule();
			   world[i][j]=cell[i][j].status;	
			   cell[i][j].neighbor=0;;
		   }
	    return world;
	}
	
	public void chongzhi() {
		int i,j;
		for(i=0;i<50;i++)
			for(j=0;j<50;j++) {
				world[i][j]=0;
				cell[i][j].clear();
			}
	}
}
