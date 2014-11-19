import java.awt.*;

import java.awt.event.*;

class MenuItemAction extends Frame implements ActionListener

{

MenuBar mb;

Menu m;

MenuItem exit;



    public MenuItemAction()

    {

        createAndShowGUI();

    }

    

    private void createAndShowGUI()

    {

        setTitle("ActionListener for MenuItem");

       

        // Create MenuBar, Menu, MenuItem

        mb=new MenuBar();

        m=new Menu("Menu");

        exit=new MenuItem("Exit");

       

        // Add ActionListener

        exit.addActionListener(this);

       

        // Add exit to menu and menu to menubar

        m.add(exit);

        mb.add(m);

       

        // Set menu bar to frame

        setMenuBar(mb);

       

        setSize(400,400);

        setVisible(true);

    }

    

    public void actionPerformed(ActionEvent ae)

    {

        System.exit(0);

    }

    

    public static void main(String args[])

    {

        new MenuItemAction();

    }

}
