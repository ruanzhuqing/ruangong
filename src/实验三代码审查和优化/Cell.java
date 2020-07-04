package 实验三代码审查和优化;


public class Cell {

	public	int  neighbor;      //邻居数
	public  int  status;                            //(0是死亡，1是存活)
	
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