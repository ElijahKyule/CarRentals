/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elly;

/**
 *
 * @author elijah
 */
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.awt.geom.GeneralPath;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import java.util.Random;
  
class CarRentalView 
    extends JFrame
       implements ActionListener 
{ 
    //variables and jcomponents declaration
    private Container container; 
    private JLabel title; 
    private JLabel daysRented; 
    private JTextField itsDaysRented; 
    private JLabel baseCost; 
    private static final double PRICE_PER_DAY = 30.00;
    private String vehicleType, vehicleFeature, customerName,
            debitCard, startingDate, finalDate;
    private int daysrented;
    private double rentingCost;
    //variables to hold ranges of random numbers
    private static double a = 0.0, b = (1.0/10.0), c = 2*b, d = 3*b,
            f = 4*b, g = 5*b, h = 6*b, i = 7*b, j = 8*b, k = 9*b,
            l = 10*b;
    //dimensions of the cars
    private static int m = 110, n = 80, o = 225, p = 40, q = 200,
            r = 255, s = 170, t = 290, u = 145, v = 100;
    private JTextField itsBaseCost;
    private JLabel custName;
    private JTextField itsCustomerName;
    private JLabel creditCard;
    private JTextField itsCreditCard;
    private JLabel startingPeriod;
    private JComboBox itsStartMonth; 
    private static String[] months = {"January", "February", "March", "April",
   "May", "June", "July", "August","September", "October", "November", "December"};
    private JComboBox itsStartDay; 
    private static String[] days = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
   "11", "12", "13", "14","15", "16", "17", "18", "19", "20", "21", "22", "23","24", "25", "26",
    "27", "28", "29", "30", "31"};
    private JComboBox  itsStartHour;
    private static String[] hours = {"7am", "8am", "9am", "10am","11am", "noon", "1pm", "2pm", "3pm",
   "4pm", "5pm"};
    private JLabel endingPeriod;
    private JComboBox itsEndMonth;
    private JComboBox itsEndDay;
    private JComboBox itsEndHour;
    private JLabel check;
    private ButtonGroup checker; 
    private JCheckBox itsManual; 
    private JCheckBox itsAir; 
    private JCheckBox itsCD; 
    private JLabel choose; 
    private ButtonGroup chooser; 
    private JRadioButton compact; 
    private JRadioButton full_size; 
    private JRadioButton luxury; 
    private JRadioButton SUV; 
    private JButton submit; 
    private JButton reset; 
    private JTextArea output; 
    private JLabel res; 
    private JTextArea resadd;
    private JPanel displayCar;
  
    //constructor
    public CarRentalView() 
    { 
        setTitle("Elly Car Rentals"); 
        setBounds(200, 90, 1040, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        container = getContentPane(); 
        container.setLayout(null); 
        
        title = new JLabel("Elly Car Rentals"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(400, 30); 
        container.add(title); 
  
        daysRented = new JLabel("Enter days rented: "); 
        daysRented.setFont(new Font("Arial", Font.PLAIN, 15)); 
        daysRented.setSize(200, 20); 
        daysRented.setLocation(100, 100); 
        container.add(daysRented); 
  
        itsDaysRented = new JTextField("1"); 
        itsDaysRented.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsDaysRented.setSize(200, 20); 
        itsDaysRented.setLocation(300, 100); 
        container.add(itsDaysRented); 
  
        baseCost = new JLabel("The base cost is: "); 
        baseCost.setFont(new Font("Arial", Font.PLAIN, 15)); 
        baseCost.setSize(200, 20); 
        baseCost.setLocation(100, 140); 
        container.add(baseCost); 
  
        itsBaseCost = new JTextField("" + PRICE_PER_DAY); 
        itsBaseCost.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsBaseCost.setSize(200, 20); 
        itsBaseCost.setLocation(300, 140); 
        container.add(itsBaseCost); 
        
        custName = new JLabel("Customer Name: "); 
        custName.setFont(new Font("Arial", Font.PLAIN, 15)); 
        custName.setSize(200, 20); 
        custName.setLocation(100, 180); 
        container.add(custName); 
  
        itsCustomerName = new JTextField(18); 
        itsCustomerName.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsCustomerName.setSize(200, 20); 
        itsCustomerName.setLocation(300, 180); 
        container.add(itsCustomerName); 
        
        creditCard = new JLabel("Credit Card: "); 
        creditCard.setFont(new Font("Arial", Font.PLAIN, 15)); 
        creditCard.setSize(200, 20); 
        creditCard.setLocation(100, 220); 
        container.add(creditCard);  
  
        itsCreditCard = new JTextField(18); 
        itsCreditCard.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsCreditCard.setSize(200, 20); 
        itsCreditCard.setLocation(300, 220); 
        container.add(itsCreditCard); 
        
        startingPeriod = new JLabel("Starting month/day/hour:"); 
        startingPeriod.setFont(new Font("Arial", Font.PLAIN, 15)); 
        startingPeriod.setSize(300, 20);
        startingPeriod.setLocation(100, 260); 
        container.add(startingPeriod);
        
  
        itsStartMonth = new JComboBox(months); 
        itsStartMonth.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsStartMonth.setSize(80, 20); 
        itsStartMonth.setLocation(300, 260); 
        container.add(itsStartMonth); 
  
        itsStartDay = new JComboBox(days); 
        itsStartDay.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsStartDay.setSize(50, 20); 
        itsStartDay.setLocation(380, 260); 
        container.add(itsStartDay);
        
        itsStartHour = new JComboBox(hours); 
        itsStartHour.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsStartHour.setSize(70, 20); 
        itsStartHour.setLocation(430, 260); 
        container.add(itsStartHour); 
        
        endingPeriod = new JLabel("Ending month/day/hour:"); 
        endingPeriod.setFont(new Font("Arial", Font.PLAIN, 15)); 
        endingPeriod.setSize(300, 20);
        endingPeriod.setLocation(100, 300); 
        container.add(endingPeriod);
        
  
        itsEndMonth = new JComboBox(months); 
        itsEndMonth.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsEndMonth.setSize(80, 20); 
        itsEndMonth.setLocation(300, 300); 
        container.add(itsEndMonth); 
  
        itsEndDay = new JComboBox(days); 
        itsEndDay.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsEndDay.setSize(50, 20); 
        itsEndDay.setLocation(380, 300); 
        container.add(itsEndDay);
        
        itsEndHour = new JComboBox(hours); 
        itsEndHour.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsEndHour.setSize(70, 20); 
        itsEndHour.setLocation(430, 300); 
        container.add(itsEndHour);
        
        check = new JLabel("Check: "); 
        check.setFont(new Font("Arial", Font.PLAIN, 15)); 
        check.setSize(100, 20);
        check.setLocation(100, 340); 
        container.add(check);
        
        itsManual = new JCheckBox("manual", false); 
        itsManual.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsManual.setSize(80, 20); 
        itsManual.setLocation(250, 340); 
        container.add(itsManual); 
  
        itsAir = new JCheckBox("Air cond", true); 
        itsAir.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsAir.setSize(80, 20); 
        itsAir.setLocation(330, 340); 
        container.add(itsAir);
        
        itsCD = new JCheckBox("CD Player", true); 
        itsCD.setFont(new Font("Arial", Font.PLAIN, 15)); 
        itsCD.setSize(100, 20); 
        itsCD.setLocation(410, 340); 
        container.add(itsCD);
        
        //button group for check boxes
        checker = new ButtonGroup(); 
        checker.add(itsManual); 
        checker.add(itsAir);
        checker.add(itsCD);
        
        choose = new JLabel("Choose one: "); 
        choose.setFont(new Font("Arial", Font.PLAIN, 15)); 
        choose.setSize(95, 20);
        choose.setLocation(100, 380); 
        container.add(choose);
        
        compact = new JRadioButton ("compact", true); 
        compact.setFont(new Font("Arial", Font.PLAIN, 15)); 
        compact.setSize(85, 20); 
        compact.setLocation(195, 380); 
        container.add(compact); 
  
        full_size = new JRadioButton ("Full Size", false); 
        full_size.setFont(new Font("Arial", Font.PLAIN, 15)); 
        full_size.setSize(90, 20); 
        full_size.setLocation(280, 380); 
        container.add(full_size);
        
        luxury = new JRadioButton ("Luxury", false); 
        luxury.setFont(new Font("Arial", Font.PLAIN, 15)); 
        luxury.setSize(70, 20); 
        luxury.setLocation(370, 380); 
        container.add(luxury);
        
        SUV = new JRadioButton ("SUV", false); 
        SUV.setFont(new Font("Arial", Font.PLAIN, 15)); 
        SUV.setSize(60, 20); 
        SUV.setLocation(440, 380); 
        container.add(SUV);
        
        //button group for radio buttons
        chooser = new ButtonGroup(); 
        chooser.add(compact); 
        chooser.add(full_size);
        chooser.add(luxury);
        chooser.add(SUV);
  
        submit = new JButton("Submit"); 
        submit.setFont(new Font("Arial", Font.PLAIN, 15)); 
        submit.setSize(100, 25); 
        submit.setLocation(150, 420); 
        submit.addActionListener(this); 
        container.add(submit); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 25); 
        reset.setLocation(270, 420); 
        reset.addActionListener(this); 
        container.add(reset); 
        
        //display area for text ouput
        output = new JTextArea(); 
        output.setFont(new Font("Arial", Font.PLAIN, 15)); 
        output.setSize(450, 160); 
        output.setLocation(540, 100); 
        output.setLineWrap(true); 
        output.setEditable(false); 
        container.add(output); 
        
        //display area for car
        displayCar = new JPanel();
        displayCar.setSize(450, 185);
        displayCar.setLocation(540, 260);
        output.setLineWrap(true); 
        output.setEditable(false); 
        displayCar.setBackground(Color.white);
        container.add(displayCar);
        
        setVisible(true); 
    }  
    
    public void actionPerformed(ActionEvent e) 
    { 
        //submit button clicked
        if (e.getSource() == submit) 
        { 
            //a graphic "clear" to reset the previous car
            Graphics clear = displayCar.getGraphics();
            clear.setColor(Color.white);
            clear.fillRect(0,0,450,185);
            //retrieving checked buttons
            if(itsManual.isSelected())
            {
               vehicleType = " *Vehicle Model:* Manual \n";
            }
            if(itsAir.isSelected())
            {
               vehicleType = " *Vehicle Model:* Air Cond \n";
            }
            if(itsCD.isSelected())
            {
               vehicleType = " *Vehicle Model:* CD Player \n";
            }
            if(compact.isSelected())
            {
               vehicleFeature = " *Vehicle Feature:* Compact \n";
            }
            if(full_size.isSelected())
            {
               vehicleFeature = " *Vehicle Feature:* Full Size \n";
            }
            if(luxury.isSelected())
            {
               vehicleFeature = " *Vehicle Feature:* Luxury \n";
            }
            if(SUV.isSelected())
            {
                vehicleFeature = " *Vehicle Feature:* SUV \n";
            }
            customerName = " *Customer Name:* " + itsCustomerName.getText() + "\n";
            debitCard = " *Credit Card:* " + itsCreditCard.getText() + "\n";
            daysrented = Integer.parseInt (itsDaysRented.getText());
            //calculating renting cost for the given days
            rentingCost = (double)daysrented * PRICE_PER_DAY;
            startingDate  = " *Starting Date:* " +(String)itsStartMonth.getSelectedItem() 
                + "/" + (String)itsStartDay.getSelectedItem() 
                + "/" + (String)itsStartHour.getSelectedItem()+";"; 
            finalDate  = " *Final Date:* " + (String)itsEndMonth.getSelectedItem() 
                + "/" + (String)itsEndDay.getSelectedItem() 
                + "/" + (String)itsEndHour.getSelectedItem() + ".\n";
            output.setText(customerName + debitCard + vehicleType + vehicleFeature
                      + startingDate + finalDate + " *Renting Cost:* " + rentingCost +"\n\n" 
                    + "                                        VEHICLE IMAGE: \n");
             
            //code to draw the car
            Graphics graphic = displayCar.getGraphics();
            double Picker = Math.random();
            double scale = 0; //a scale to determine the size of a car
            //car dimensions and color determined from random number "Picker"
            if ((Picker>=a)&&(Picker<b)) 
            {
               graphic.setColor(Color.red);
               scale = 0.0;
            }
            else if ((Picker>=b)&&(Picker<c)) 
            {
               graphic.setColor(Color.black);
               scale = 0.05;
            }
            else if ((Picker>=c)&&(Picker<d)) 
            {
                graphic.setColor(Color.blue);
                scale = 0.1;
            }
            else if ((Picker>=d)&&(Picker < f)) 
            {
                graphic.setColor(Color.cyan);
                scale = 0.15;
            }
            else if ((Picker>=f)&&(Picker<g)) 
            {
                graphic.setColor(Color.orange);
                scale = 0.2;
            }
            else if ((Picker>=g)&&(Picker<h)) 
            {
               graphic.setColor(Color.pink);
               scale = 0.25;
            }
            else if ((Picker>=h)&&(Picker<i)) 
            {
               graphic.setColor(Color.darkGray);
               scale = -0.1;
            }
            else if ((Picker>=i)&&(Picker<j)) 
            {
               graphic.setColor(Color.magenta);
               scale = -0.2;
            }
            else if ((Picker>=j)&&(Picker<k)) 
            {
               graphic.setColor(Color.lightGray);
               scale = -0.35;
            }
            else if ((Picker>=k)&&(Picker<l)) 
            {
               graphic.setColor(Color.yellow);
               scale = -0.5;
            }
            //drawing the car
            graphic.fillRect(m+(int)(scale*m),n+(int)(scale*n),o+(int)(scale*o),p+(int)(scale*p));
            graphic.drawLine(q+(int)(scale*q),p+(int)(scale*p),r+(int)(scale*r),p+(int)(scale*p));
            graphic.drawLine(s+(int)(scale*s),n+(int)(scale*n),q+(int)(scale*q),p+(int)(scale*p));
            graphic.drawLine(t+(int)(scale*t),n+(int)(scale*n),r+(int)(scale*r),p+(int)(scale*p));
            graphic.drawLine(o+(int)(scale*o),n+(int)(scale*n),o+(int)(scale*o),p+(int)(scale*p));
            graphic.setColor(Color.black);
            graphic.fillOval(u+(int)(scale*u),v+(int)(scale*v),p+(int)(scale*p),p+(int)(scale*p));
            graphic.setColor(Color.black);
            graphic.fillOval(r+(int)(scale*r),v+(int)(scale*v),p+(int)(scale*p),p+(int)(scale*p));
            output.setEditable(false);        
        } 
        //reseting buttton
        else if (e.getSource() == reset) 
        { 
            String def = ""; 
            itsCustomerName.setText(def); 
            itsCreditCard.setText(def); 
            output.setText(def); 
            itsStartMonth.setSelectedIndex(0); 
            itsStartDay.setSelectedIndex(0); 
            itsStartHour.setSelectedIndex(0);
            itsEndMonth.setSelectedIndex(0); 
            itsEndDay.setSelectedIndex(0); 
            itsEndHour.setSelectedIndex(0);
            //a graphic "clear" to reset the previous car
            Graphics res = displayCar.getGraphics();
            res.setColor(Color.white);
            res.fillRect(0,0,450,185);
        } 
    } 
} 
  
// Driver Code with the main method. 
class Registration { 
  
    public static void main(String[] args) throws Exception 
    { 
        CarRentalView f = new CarRentalView();
    } 
} 