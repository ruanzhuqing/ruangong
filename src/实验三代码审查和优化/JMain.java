package ʵ�������������Ż�;

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
	
    GridLayout layout = new GridLayout(50, 50);            //���񲼾�
    JPanel panel_game=new JPanel(layout);
    JButton bt[]=new JButton[2500];                         //����Ϊ400��һά���鰴ť����Ϸ����
    public volatile boolean flag=true;
    
	public JMain() {
		JFrame jf = new JFrame("������Ϸ");
        jf.setSize(400,500);   
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        
        final String start="��ʼ";
        final String up="����";
        
//        Box vBox = Box.createVerticalBox();                  //��ֱ����
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


        JPanel panel1=new JPanel(null);                            //panel1(������壩
        JButton bstart=new JButton("��ʼ");                    //����ʼ�����á���ť
        JButton bup=new JButton("����");               
        
        bstart.setLocation(21, 10);
        bup.setLocation(265, 12);
        bstart.setSize(70, 33);
        bup.setSize(70, 28);        
        panel1.add(bstart);
        panel1.add(bup);
        
        panel1.setSize(365, 53);
        panel1.setLocation(11,400);

        //�¼�����
        
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
            				   for(int i=0;i<50;i++) {          //���ϸ�����
            					   for(int j=0;j<50;j++) {          				
            						   if(c.world[i][j]==1)   			
            							   bt[(i*50)+j].setBackground(Color.black);            					
//            						   panel_game.add(bt[(i*50)+j]);
            					    }
            				    }
            					Thread.sleep(500L);
            					c.neighbor();
            					c.world=c.nextworld();            					
            			        for(int n=0;n<2500;n++) {               //�����µ�ͼ
            			        	bt[n].setBackground(Color.white);
            			        }
            			}catch (InterruptedException e) {
            				e.printStackTrace();
            			}
        				}
            		}           		    
            	};
            	Thread tr=new Thread(runnable);
                if(start.equals(command)) {                 //�������ʼ��
                	c.newworld(); 
                	flag=true;
            		tr.start();
            	}
            	            	
            	if(up.equals(command)) {                     //��������á�
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
        
        panel.add(panel_game);                               //����������崹ֱ��������
        panel.add(panel1);
        
        jf.setContentPane(panel);
        jf.setVisible(true);
	}

}
