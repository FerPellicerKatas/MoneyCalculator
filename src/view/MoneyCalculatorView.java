package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import model.Currency;
import model.ExchangeRateSet;

public class MoneyCalculatorView extends javax.swing.JFrame {
    
    private final ArrayList<Currency> currencies;
    private final ExchangeRateSet rates;
    private javax.swing.JButton calcular;
    private javax.swing.JComboBox<String> currencyOneComboBox;
    private javax.swing.JComboBox<String> currencyTwoComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField textOne;
    private javax.swing.JTextField textTwo;
    

    public MoneyCalculatorView(ArrayList<Currency> currencies, 
            ExchangeRateSet rates) {
        initComponents();
        componentLocation();
        setActionListener();
        this.setTitle("Money Calculator");
        this.currencies = currencies;
        this.rates = rates;
        this.setVisible(true);
        this.setLocation(500, 250);
        this.setSize(400, 300);
        this.textTwo.setEditable(false);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        fillComboBoxes();
        this.setLayout(new GridLayout(3, 1));
        currencyOneComboBox.setSelectedIndex(0);
        currencyTwoComboBox.setSelectedIndex(0);
        
    }
    
    private void initComponents() {
        textOne = new javax.swing.JTextField(15);
        currencyOneComboBox = new javax.swing.JComboBox<>();
        currencyTwoComboBox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        textTwo = new javax.swing.JTextField(15);
        calcular = new javax.swing.JButton("Calcular");
        jLabel1 = new javax.swing.JLabel("Intercambio de divisas");
    }
    
    private void setActionListener(){
        
        currencyOneComboBox.addActionListener(
                (java.awt.event.ActionEvent evt) -> {
            String texto1 = currencies.get(currencyOneComboBox
                    .getSelectedIndex()).getSymbol();
        });

        currencyTwoComboBox.addActionListener(
                (java.awt.event.ActionEvent evt) -> {
            String texto1 = currencies.get(currencyTwoComboBox
                    .getSelectedIndex()).getSymbol();
        });

        calcular.addActionListener((java.awt.event.ActionEvent evt) -> {
            calcularCambio();
        });
    }
    
    
    private void componentLocation(){
               
        FlowLayout title = new FlowLayout();
        GridLayout form = new GridLayout(2, 1);
        FlowLayout form1 = new FlowLayout();
        FlowLayout form2 = new FlowLayout();
        FlowLayout button = new FlowLayout();
       
        jPanel2.add(jPanel4);
        jPanel2.add(jPanel5);
        
        jPanel1.setLayout(title);
        jLabel1.setFont(jLabel1.getFont().deriveFont(20.0f));
        jPanel1.add(jLabel1);
        
        jPanel4.setLayout(form1);
        jPanel4.add(textOne);
        jPanel4.add(currencyOneComboBox);
        
        jPanel5.setLayout(form2);
        jPanel5.add(textTwo);
        jPanel5.add(currencyTwoComboBox);
        
        jPanel3.setLayout(button);
        jPanel3.add(calcular);
        
        this.add(jPanel1);
        this.add(jPanel2);
        this.add(jPanel3);
    }
    
    

    private void calcularCambio() {
        double money = Double.parseDouble(textOne.getText());
            
            double rate = rates.getRate(currencies.get(currencyOneComboBox.
                    getSelectedIndex()),
                currencies.get(currencyTwoComboBox.getSelectedIndex()));
        
            textTwo.setText(String.valueOf(money * rate));
            
    }

    private void fillComboBoxes() {
        
        currencies.stream().map((currency) -> {
            currencyOneComboBox.addItem(currency.getName());
            return currency;
        }).forEachOrdered((currency) -> {
            currencyTwoComboBox.addItem(currency.getName());
        });
        
    }
 

    
}
