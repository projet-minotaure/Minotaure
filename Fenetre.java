import java.awt.Color; 
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Fenetre extends JFrame {
  public Fenetre(){             
    this.setTitle("Minotaure - Trouvez la sortie");
    this.setSize(800, 600);
    this.setLocationRelativeTo(null);               
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    this.setContentPane(new Panneau()); 
    this.setVisible(true);
  }       
}

