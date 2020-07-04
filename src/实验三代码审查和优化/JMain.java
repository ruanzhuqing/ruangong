package 实验三代码审查和优化;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class JMain extends JFrame {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					@SuppressWarnings("unused")
					JMain jf = new JMain();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
    GridLayout layout = new GridLayout(50, 50);            //网格布局
    JPanel panel_game=new JPanel(layout);
    JButton bt[]=new JButton[2500];                         //长度为400的一维数组按钮（游戏格子
    public volatile boolean flag=true;
    
	public JMain() {
		JFrame jf = new JFrame("生命游戏");
        jf.setSize(400,500);   
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        
        final String start="开始";
        final String up="重置";
        
//        Box vBox = Box.createVerticalBox();                  //垂直箱子
        JPanel panel=new JPanel(null);


        for(int n=0;n<2500;n++) {
        	bt[n]=new JButton("");
        	bt[n].setBackground(Color.white);
        	bt[n].setEnabled(false);
        	bt[n].setBorderPainted(false);
            panel_game.add(bt[n]);
        }
             
        panel_game.setSize(366, 385);
        panel_game.setLocation(10, 10);


        JPanel panel1=new JPanel(null);                            //panel1(操作面板）
        JButton bstart=new JButton("开始");                    //“开始、重置”按钮
        JButton bup=new JButton("重置");               
        
        bstart.setLocation(21, 10);
        bup.setLocation(265, 12);
        bstart.setSize(70, 33);
        bup.setSize(70, 28);        
        panel1.add(bstart);
        panel1.add(bup);
        
        panel1.setSize(365, 53);
        panel1.setLocation(11,400);

        //事件监听
        
        bstart.setActionCommand(start);    
        bup.setActionCommand(up);
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	final Map c=new Map();
            	
            	String command = e.getActionCommand();            	           		
                Runnable runnable=new Runnable() {
            		@Override
            		public void run() {
            			
        				while(flag) {
            			try {
            				   for(int i=0;i<50;i++) {          //活的细胞变黑
            					   for(int j=0;j<50;j++) {          				
            						   if(c.world[i][j]==1)   			
            							   bt[(i*50)+j].setBackground(Color.black);            					
//            						   panel_game.add(bt[(i*50)+j]);
            					    }
            				    }
            					Thread.sleep(500L);
            					c.neighbor();
            					c.world=c.nextworld();            					
            			        for(int n=0;n<2500;n++) {               //重置新地图
            			        	bt[n].setBackground(Color.white);
            			        }
            			}catch (InterruptedException e) {
            				e.printStackTrace();
            			}
        				}
            		}           		    
            	};
            	Thread tr=new Thread(runnable);
                if(start.equals(command)) {                 //点击“开始”
                	c.newworld(); 
                	flag=true;
            		tr.start();
            	}
            	            	
            	if(up.equals(command)) {                     //点击“重置”
            		flag=false;
            		c.chongzhi();
            		panel_game.removeAll();
            		panel_game.repaint();
            		for(int n=0;n<2500;n++) {  
            	        	bt[n].setBackground(Color.white);
            	        	panel_game.add(bt[n]);
            			}
            		panel_game.revalidate();
            	}
            }   
        };            
        bstart.addActionListener(listener);
        bup.addActionListener(listener);
        
        panel.add(panel_game);                               //将两个区面板垂直放入箱子
        panel.add(panel1);
        
        jf.setContentPane(panel);
        jf.setVisible(true);
	}

}
