
package avscience.desktop;
import java.awt.*;
import java.awt.event.*;


public class SendDialog extends Dialog
{
    public SendDialog(Frame parent, boolean modal)
    {
        super(parent, modal);

        //Keep a local reference to the invoking frame
        frame = (Frame) parent;
        
        //{{INIT_CONTROLS
        setLayout(null);
        setSize(337,135);
        setVisible(false);
        
        Label l = new Label("Sending Data ..");
        l.setFont(new Font("Dialog", Font.BOLD, 12));
        l.setBounds(120,60,160,24);
        add(l);
        
//        okButton.setLabel("  OK  ");
     //   add(okButton);
       // okButton.setFont(new Font("Dialog", Font.BOLD, 12));
       // okButton.setBounds(120,60,79,24);
        
        setTitle("Sending Data - please wait.");
        //}}

        //{{REGISTER_LISTENERS
        SymWindow aSymWindow = new SymWindow();
        this.addWindowListener(aSymWindow);
        SymAction lSymAction = new SymAction();
       // okButton.addActionListener(lSymAction);
        
        //}}
    }

    public void addNotify()
    {
        // Record the size of the window prior to calling parents addNotify.
        Dimension d = getSize();
        
        super.addNotify();

        if (fComponentsAdjusted)
            return;

        // Adjust components according to the insets
        setSize(getInsets().left + getInsets().right + d.width, getInsets().top + getInsets().bottom + d.height);
        Component components[] = getComponents();
        for (int i = 0; i < components.length; i++)
        {
            Point p = components[i].getLocation();
            p.translate(getInsets().left, getInsets().top);
            components[i].setLocation(p);
        }
        fComponentsAdjusted = true;
    }

    public SendDialog(Frame parent, String title, boolean modal)
    {
        this(parent, modal);
        setTitle(title);
    }

    /**
     * Shows or hides the component depending on the boolean flag b.
     * @param b  if true, show the component; otherwise, hide the component.
     * @see java.awt.Component#isVisible
     */
    public void setVisible(boolean b)
    {
        if(b)
        {
            Rectangle bounds = getParent().getBounds();
            Rectangle abounds = getBounds();
    
            setLocation(bounds.x + (bounds.width - abounds.width)/ 2,
                 bounds.y + (bounds.height - abounds.height)/2);
            Toolkit.getDefaultToolkit().beep();
        }
        super.setVisible(b);
    }

    // Used for addNotify check.
    boolean fComponentsAdjusted = false;
    // Invoking frame
    Frame frame = null;

    //{{DECLARE_CONTROLS
    
    //java.awt.Button okButton = new java.awt.Button();
  
    //}}

    class SymAction implements java.awt.event.ActionListener
    {
        public void actionPerformed(java.awt.event.ActionEvent event)
        {
            Object object = event.getSource();
         //   if (object == okButton)
           //     okButton_ActionPerformed(event);
            
        }
    }

    

    void okButton_ActionPerformed(java.awt.event.ActionEvent event)
    {
        this.dispose();
    }

    class SymWindow extends java.awt.event.WindowAdapter
    {
        public void windowClosing(java.awt.event.WindowEvent event)
        {
            Object object = event.getSource();
            if (object == SendDialog.this)
            OKDialog_WindowClosing(event);
        }
    }

    void OKDialog_WindowClosing(java.awt.event.WindowEvent event)
    {
        this.dispose();
    }

}
