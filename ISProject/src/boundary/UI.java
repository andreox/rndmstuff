package boundary;

import javax.swing.* ;

import controller.Controller;

import java.awt.event.* ;

public class UI implements ActionListener {
	
	static JFrame f ;
	static JPanel p ;
	static JButton b ;
	static JLabel l1 ;
	static JLabel l2 ;
	static JTextField f1 ;
	static JTextField f2 ;
	
	public static void main( String argv[]) {
		
		
		f = new JFrame("Richiesta Attrezzatura") ;
		p = new JPanel() ;
		b = new JButton("Richiedi Attrezzatura") ;
		l1 = new JLabel("Inserisci Codice Badge") ;
		l2 = new JLabel("Inserisci Tipo Attrezzatura") ;
		f1 = new JTextField(5) ;
		f2 = new JTextField(25) ;
		
		UI u = new UI() ;
		
		f1.setColumns(11) ;
		f2.setColumns(10) ;
		b.addActionListener(u) ;
		
		p.add(l1) ;
		p.add(f1) ;
		p.add(l2) ;
		p.add(f2) ;
		p.add(b) ;
		f.add(p) ;
		
		f.setSize(400,400);
		f.show();
	}
	//ActionListener è un'interfaccia, actionPerformed un metodo astratto
	public void actionPerformed(ActionEvent e ) {
		
		String s = e.getActionCommand() ;

		if ( s.contentEquals("Richiedi Attrezzatura")) {
			
			Controller c = new Controller() ;
			int ret_val = c.richiediAttrezzo( f2.getText(), f1.getText());
			
			if ( ret_val == -1 ) {
				JOptionPane.showMessageDialog(f,
					    "Socio Non Iscritto",
					    "ERRORE",
					    JOptionPane.ERROR_MESSAGE);
	
			}
			
			else if ( ret_val == -2 ) {
				JOptionPane.showMessageDialog(f,
					    "Socio non ha effettuato l'accesso",
					    "ERRORE",
					    JOptionPane.ERROR_MESSAGE);
	
			}
			
			else if ( ret_val == -3 ) {
				JOptionPane.showMessageDialog(f,
					    "Il Socio sta già utilizzando un'altra attrezzatura",
					    "ERRORE",
					    JOptionPane.ERROR_MESSAGE);
	
			}
			
			else if ( ret_val == -4 ) {
				JOptionPane.showMessageDialog(f,
					    "Tutte le attrezzature della tipologia sono occupate",
					    "ERRORE",
					    JOptionPane.ERROR_MESSAGE);
	
			}
			
			else {
				JOptionPane.showMessageDialog(f,
					    "Attrezzatura assegnata!");
	
			}
		}
	}
	
}
