import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calcGUI {
    public static void main(String[] args)
    {

        calculator obj = new calculator();

    }
}


class calculator extends JFrame implements ActionListener
{
    JFrame frame;
    JPanel panel;
//    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,ba,bs,bm,bd,be,beq,bc,bdec,bdel;
//    JButton bsq;
    JButton[] numbers =new JButton[10];
    JButton[] functions = new JButton[9];
    JButton badd,sub,mul,div,clr,eql,dec,delete;
    JButton negative;
    JTextField txtfield;
    Font my = new Font("Courier New",Font.BOLD,35);
    char operator;
    double num1=0,num2=0,results=0;



    public calculator(){

        frame=new JFrame("Calculator");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420,550);

        txtfield=new JTextField();
        txtfield.setFont(my);
        txtfield.setBounds(50,25,300,50);
        txtfield.setEditable(true);

        badd=new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        delete=new JButton("DEL");
        eql=new JButton("=");
        clr=new JButton("C");
        dec=new JButton(".");
        negative=new JButton(("-"));

        functions[0]=badd;
        functions[1]=sub;
        functions[2]=mul;
        functions[3]=div;
        functions[4]=dec;
        functions[5]=delete;
        functions[6]=clr;
        functions[7]=eql;
        functions[8]=negative;

        for(int i=0;i<9;i++)
        {
            functions[i].addActionListener(this);
            functions[i].setFont(my);
            functions[i].setForeground(Color.white);
            if (i==7)
            {
                functions[i].setForeground(Color.green);
            }
            functions[i].setBackground(Color.darkGray);
            functions[i].setBorder(BorderFactory.createLoweredSoftBevelBorder());
        }
        for (int i=0;i<10;i++)
        {
            numbers[i]=new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(my);
            numbers[i].setBorder(BorderFactory.createLoweredSoftBevelBorder());
        }

        delete.setBounds(150,430,100,50);
        clr.setBounds(250,430,100,50);
        negative.setBounds(50,430,100,50);

        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,5,5));
        panel.setBackground(Color.lightGray);

        panel.add(numbers[9]);
        panel.add(numbers[8]);
        panel.add(numbers[7]);
        panel.add(mul);
        panel.add(numbers[6]);
        panel.add(numbers[5]);
        panel.add(numbers[4]);
        panel.add(sub);
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(badd);
        panel.add(div);
        panel.add(numbers[0]);
        panel.add(dec);
        panel.add(eql);
        add(panel);
        add(delete);
        add(clr);
        add(negative);
        add(txtfield);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        int cnt=0;
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numbers[i])
            {
                txtfield.setText(txtfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==dec)
        {
            txtfield.setText(txtfield.getText().concat("."));
        }
        if(e.getSource()==badd)
            {
                num1=Double.parseDouble(txtfield.getText());
                operator='+';
                txtfield.setText(" ");
            }
        if(e.getSource()==sub)
        {
            num1=Double.parseDouble(txtfield.getText());
            operator='-';
            txtfield.setText(" ");
        }
        if(e.getSource()==mul)
        {
            num1=Double.parseDouble(txtfield.getText());
            operator='*';
            txtfield.setText(" ");
        }
        if(e.getSource()==div)
        {
            num1=Double.parseDouble(txtfield.getText());
            operator='/';
            txtfield.setText(" ");
        }
        if (e.getSource()==eql)
        {
            num2=Double.parseDouble(txtfield.getText());

            switch (operator)
            {
                case '+': {
                    results = num1 + num2;
                    break;
                }
                case '-':
                {
                    results=num1-num2;
                    break;
                }
                case '*':
                {
                    results=num1*num2;
                    break;
                }
                case '/':
                {
                    results=num1/num2;
                    break;
                }
                default:
                    results=num1;
            }txtfield.setText(String.valueOf(results));
            num1=results;
        }

        if (e.getSource()==clr)
        {
            txtfield.setText("");
        }
        if(e.getSource()==delete)
        {
            String str = txtfield.getText();
            txtfield.setText(" ");
            for(int i=0;i<str.length()-1;i++)
            {
                txtfield.setText(txtfield.getText()+str.charAt(i));
            }
        }
        if(e.getSource()==negative)
        {
            double temp = Double.parseDouble((txtfield.getText()));
            temp *= -1;
            txtfield.setText(String.valueOf(temp));
        }



    }
}


