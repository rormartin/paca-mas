package PACA.agents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class lanzador {

	static Runtime hebra = Runtime.getRuntime();
	static JFrame ventana = new JFrame();
	static JPanel panel = new JPanel();
	static JPanel panel2 = new JPanel();
	static List listaThreads = new List();
	static JComboBox caja = new JComboBox();
	static int numero = 20;
	static JButton botonLanza = new JButton("Numero de Agentes"); 
	static JButton botonTermina = new JButton("Termina Thread");
	static JButton botonTerminaTodos = new JButton("Termina Todos");
	static boolean terminado = false;

	static void GeneraRetardo(int ret){
		try {
			Thread.sleep(ret);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for (int i = 1; i <= numero; i++) {
			caja.addItem(Integer.toString(i));
		}

		panel.add(caja);
		panel.add(botonLanza);
		panel2.add(listaThreads);
		panel2.add(botonTermina);
		panel2.add(botonTerminaTodos);

		ventana.setSize(new Dimension(600, 300));	

		ventana.setDefaultCloseOperation(ventana.EXIT_ON_CLOSE);
		ventana.setLayout(new BorderLayout());
		ventana.getContentPane().add(panel, BorderLayout.NORTH);
		ventana.getContentPane().add(panel2, BorderLayout.SOUTH);
		ventana.setTitle("Lanzador de Agentes");
		ventana.pack();
		ventana.setVisible(true);






		//Selecciona el numero de Agentes a lanzar
		botonLanza.addMouseListener( new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				//la propiedad getselecteditem() regresa un objeto
				String numero  =  (String) caja.getSelectedItem();
				System.out.println("Agentes para lanzar: "+numero);

				Thread[] hilos = new Thread[Integer.valueOf(numero)];

				Thread t1;

				for (int i = 0; i < Integer.valueOf(numero); i++) {
					//try {
					Runtime rt = Runtime.getRuntime();
					System.out.println("Intentamos lanzar el comando");
					//rt.exec("java PACA.agents.lanzaSwing2");
					//try {
						//rt.exec("java PACA.agents.SimulaAgentes");
						//rt.exec("java PACA.agents.lanzaSwing2");
					//} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					//}

					t1 = new Thread(new SimulaAgentes());
					//new Thread(new SimulaAgentes()).start();
					//SimulaAgentes sim1 = new SimulaAgentes();
					//pool.execute(sim1);
					//t1 = new SimulaAgentes();

					//t1.start();
					listaThreads.add(t1.getName());
					hilos[i] = t1;
					

				}
				
				listaThreads.setMultipleMode(true);
				panel2.add(listaThreads);
				panel2.add(botonTermina);
				panel2.add(botonTerminaTodos);
				ventana.getContentPane().add(panel2, BorderLayout.SOUTH);
				ventana.validate();

				//GeneraRetardo(2000);
				

				System.out.println("Lanzamos!!!");


				for (int i = 0; i < hilos.length; i++) {
					hilos[i].start();
					GeneraRetardo(2000);

					System.out.println("Lanzamos!!!!"+((Thread) hilos[i]).getName());
				}


			}
		} );
		
		
		
//		Selecciona el numero de Agentes a lanzar
		botonTermina.addMouseListener( new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				//la propiedad getselecteditem() regresa un objeto
				String [] lThreads  =  (String []) listaThreads.getSelectedItems();
				System.out.println(lThreads.length);
				Thread [] listaT = new Thread[lThreads.length];
				

				for (int i = 0; i < lThreads.length; i++) {
					String nombre = lThreads[i].toString();
					System.out.println("Nombre: "+nombre);
					Thread tAux = new Thread();
					tAux.setName(nombre);
					listaT[i]=tAux;
					listaThreads.remove(nombre);
				}
				
				
				
				for (int i = 0; i < listaT.length; i++) {
					try {
						if (listaT[i].isAlive()){
							System.out.println("Esta viva!!");
							listaT[i].join();
							System.out.println("Ya no lo esta... ");
						}else{
							System.out.println("No vive... ");
						}
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				listaThreads.setMultipleMode(true);
				panel2.add(listaThreads);
				panel2.add(botonTermina);
				panel2.add(botonTerminaTodos);
				ventana.getContentPane().add(panel2, BorderLayout.SOUTH);
				ventana.validate();
			}
		} );
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
