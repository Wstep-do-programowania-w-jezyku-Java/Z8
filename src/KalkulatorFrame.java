import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class KalkulatorFrame extends JFrame implements Runnable {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new KalkulatorFrame("Kalkulator"));
	}
	private JMenuBar mbMenuGlowne;
	private JMenu mPlik,mObliczanie;
	private JMenuItem miZamknij,miOblicz,miWyczysc;
	private CloseAction ca=new CloseAction();
	private ComputeAction co=new ComputeAction();
	private ClearAction cl=new ClearAction();
	private String[] CoToUS= {"kg->lb","cm->in","Celcjusz->Fahrenheit","l->ga"}, 
			USToCo= {"lb->kg","in->cm","Fahrenheit->Celcjusz","ga->l"};
	private JComboBox<String> cbJednostki;
	private JRadioButton rbCoToUS,rbUSToCo;
	private ButtonGroup bg;
	private JTextField tfDane;
	private JLabel lWynik;
	private JButton bOblicz;
	
	
	public KalkulatorFrame(String title) {
		super(title);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		setSize(new Dimension(dim.width/2, dim.height/2));
		setLocationByPlatform(true);
		addWindowListener(new WindowClosingAdapter());
		setContentPane(new JPanel());
		mbMenuGlowne=new JMenuBar();
		setJMenuBar(mbMenuGlowne);
		mPlik=new JMenu("Plik");
		mObliczanie=new JMenu("Obliczanie");
		miZamknij=new JMenuItem(ca);
		miOblicz=new JMenuItem(co);
		miWyczysc=new JMenuItem(cl);
		mbMenuGlowne.add(mPlik);
		mbMenuGlowne.add(mObliczanie);
		
		mPlik.add(miZamknij);
		mObliczanie.add(miOblicz);
		mObliczanie.add(miWyczysc);
		rbCoToUS=new JRadioButton("Continental to US");
		rbUSToCo=new JRadioButton("US to Continental");
		bg=new ButtonGroup();
		bg.add(rbCoToUS);
		bg.add(rbUSToCo);
		add(rbCoToUS);
		add(rbUSToCo);
		rbCoToUS.setSelected(true);
		DefaultComboBoxModel<String> dcbm=new DefaultComboBoxModel<>(CoToUS);
		cbJednostki=new JComboBox<>(dcbm);
		add(cbJednostki);
		
		tfDane=new JTextField(4);
		lWynik=new JLabel("   ");
		bOblicz=new JButton(co);
		add(tfDane);
		add(lWynik);
		add(bOblicz);
	}

	@Override
	public void run() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	class WindowClosingAdapter extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			if(JOptionPane.showOptionDialog(e.getWindow(),"Czy chcesz zamknąć aplikację ?","Potwierdzenie",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,new String[] {"Tak","Nie"},"Nie")==0)
				System.exit(0);
		}
	}
	
	class CloseAction extends AbstractAction{
		public CloseAction() {
			putValue(Action.NAME, "Zamknij");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl Z"));
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		}
		
	}
	
	class ComputeAction extends AbstractAction{

		public ComputeAction() {
			putValue(Action.NAME, "Oblicz");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl O"));
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class ClearAction extends AbstractAction{

		public ClearAction() {
			putValue(Action.NAME, "Wyczyść");
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl W"));
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
