package ʵ�������������Ż�;


public class Cell {

	public	int  neighbor;      //�ھ���
	public  int  status;                            //(0��������1�Ǵ��)
	
	public Cell(){
		status=0;
		neighbor=0;
	}
	
	public int getStatus() {
		return status;
	}
	
	public int getNeighbor() {
		return neighbor;
	}
	
	public void setStatus(int s) {
		status=s;
	}
	
	public void rule() {
		if(neighbor==3) this.setStatus(1);
		else if(neighbor==2) ;
		else  this.setStatus(0); 
	}
	
	public void clear() {
		neighbor=0;
		status=0;
	}

}