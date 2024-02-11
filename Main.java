import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Main extends JFrame{
    final int FRAME_WIDTH = 300;//creates the sizing for the gui
    final int FRAME_HEIGHT = 510;

    public Main(){
        setSize(FRAME_WIDTH,FRAME_HEIGHT);//sets the size and ends the code when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the color for the bar and creates a panel

        Color line = new Color(158, 143, 82);
        JPanel titleBar = new JPanel();
        titleBar.setPreferredSize(new Dimension(FRAME_WIDTH, 30));
        titleBar.setBackground(line);

        //creates the heading for gui
        JLabel heading = new JLabel("BigY Store", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel title = new JLabel("Make your pizza here!!", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 14));
        JLabel size = new JLabel("--What size do you want--", SwingConstants.CENTER);
        size.setFont(new Font("Arial", Font.BOLD, 12));
        JLabel topping = new JLabel("--What toppings do you want--", SwingConstants.CENTER);
        topping.setFont(new Font("Arial", Font.BOLD, 12));

        //creates check boxes for the pizza sizes
        JCheckBox small = new JCheckBox("Small ($5)");
        JCheckBox medium = new JCheckBox("Medium ($10)");
        JCheckBox large = new JCheckBox("Large ($15)");
        JCheckBox superSize = new JCheckBox("Super ($20)");

        // creates checkboxes for selecting toppings
        JCheckBox pepperoni = new JCheckBox("Pepperoni ($0.50)");
        JCheckBox ham = new JCheckBox("Ham ($0.50)");
        JCheckBox pineapple = new JCheckBox("Pineapple ($0.50)");
        JCheckBox bellPepper = new JCheckBox("Bell Pepper ($0.50)");
        JCheckBox extraCheese = new JCheckBox("Extra Cheese (Free)");
        JCheckBox sausage = new JCheckBox("Sausage ($0.50)");

        // Create a button for confirming the purchase
        JButton button = new JButton("Confirm Purchase");

        // Adds action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int numSize = 0;// Counter for selected pizza sizes,toppings, and the amount of cash for pizza size and toppings
                int numTop = 0;
                double sizecash = 0;
                double topcash = 0;
                DecimalFormat df = new DecimalFormat("0.00");// Decimal formatter for currency

                String message = "Your order is:\n";//creates a string for items to be added

                if (small.isSelected()) {//detects if the small size is selected and adds the price and adds to the amount to sizes enabled
                    message += " - Small Pizza ($5)\n";
                    numSize += 1;
                    sizecash += 5;
                }
                if (medium.isSelected()) {//detects if the medium size is selected and adds the price and adds to the amount to sizes enabled
                    message += " - Medium Pizza ($10)\n";
                    numSize += 1;
                    sizecash += 10;
                }
                if (large.isSelected()) {//detects if the large size is selected and adds the price and adds to the amount to sizes enabled
                    message += " - Large Pizza ($15)\n";
                    numSize += 1;
                    sizecash += 15;
                }
                if (superSize.isSelected()) {//detects if the superSize size is selected and adds the price and adds to the amount to sizes enabled
                    message += " - Super Size Pizza ($20)\n";
                    numSize += 1;
                    sizecash += 20;
                }

                message += "Toppings:\n";

                if (pepperoni.isSelected()) {//detects if the pepperoni is selected and adds the price and adds to the amount to topings enabled
                    message += " - Pepperoni ($0.50)\n";//add item to message list to be added to receipt
                    numTop += 1;
                    topcash += .5;
                }
                if (ham.isSelected()) {//detects if the ham is selected and adds the price and adds to the amount to topings enabled
                    message += " - Ham ($0.50)\n";//add item to message list to be added to receipt
                    numTop += 1;
                    topcash += .5;
                }
                if (pineapple.isSelected()) {//detects if the pineapple is selected and adds the price and adds to the amount to topings enabled
                    double selfcash = .50;
                    numTop += 1;
                    topcash += .5;
                    if (topcash == 1.5) {//finds out whether three toppings are bought and weather to add the deal
                        topcash -= .25;
                        selfcash = .25;
                    }
                    message += " - Sausage ($" + df.format(selfcash) + ")\n";//add item to message list to be added to receipt, and it changes depending on weather or not there is a deal
                }
                if (bellPepper.isSelected()) {//detects if the bellPepper is selected and adds the price and adds to the amount to topings enabled
                    double selfcash = .50;
                    numTop += 1;
                    topcash += .5;
                    if (topcash == 1.5) {//finds out whether three toppings are bought and weather to add the deal
                        topcash -= .25;
                        selfcash = .25;
                    }
                    message += " - Bell Pepper ($" + df.format(selfcash) + ")\n";//add item to message list to be added to receipt, and it changes depending on weather or not there is a deal
                }
                if (extraCheese.isSelected()) {//detects if the extraCheese is selected and adds the price and adds to the amount to topings enabled
                    message += " - Extra Cheese (Free)\n";//add item to message list to be added to receipt
                    numTop += 1;
                }
                if (sausage.isSelected()) {//detects if the sausage is selected and adds the price and adds to the amount to topings enabled
                    double selfcash = .50;
                    numTop += 1;
                    topcash += .5;
                    if (topcash == 1.5) {//finds out whether three toppings are bought and weather to add the deal
                        topcash -= .25;
                        selfcash = .25;
                    }
                    message += " - Sausage ($" + df.format(selfcash) + ")\n";//add item to message list to be added to receipt, and it changes depending on weather or not there is a deal
                }
                if (numSize != 1) {
                    JOptionPane.showMessageDialog(null, "You have to have one size selected");//displays the error for the wrong amount of sizes selected
                }
                if (numTop > 3) {
                    JOptionPane.showMessageDialog(null, "You have more than three toppings selected!");//displays the error for the wrong amount of toppings selected
                }
                if (numSize == 1 && numTop <= 3) {
                    double cash = topcash + sizecash;//adds both cash types
                    message += "Subtotal: $" + df.format(cash) + "\n";//adds the total amount excluding tax
                    message += "Tax: $" + df.format(cash * 0.0625) + "\n";//adds the total amount of tax
                    message += "Total: $" + df.format(cash * (1 + 0.0625));//adds the total amount of tax and food
                    JOptionPane.showMessageDialog(null, message);//displays the receipt
                }
            }
        });
        JPanel grid = new JPanel();//adds all the components to the gui in a grid format
        grid.setLayout(new GridLayout(0, 1));
        grid.add(titleBar);
        grid.add(heading);
        grid.add(title);
        grid.add(size);
        grid.add(small);
        grid.add(medium);
        grid.add(large);
        grid.add(superSize);
        grid.add(topping);
        grid.add(pepperoni);
        grid.add(ham);
        grid.add(pineapple);
        grid.add(bellPepper);
        grid.add(extraCheese);
        grid.add(sausage);
        grid.add(button);
        getContentPane().add(grid);// Add the grid panel to the content pane
    }
    public static void main(String[] args) {//Makes the gui visible on start
        Main example = new Main();
        example.setVisible(true);
    }
}