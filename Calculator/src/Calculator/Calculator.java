package Calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class Calculator implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextArea textArea = new JTextArea(2,10);
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();
	JButton button6 = new JButton();
	JButton button7 = new JButton();
	JButton button8 = new JButton();
	JButton button9 = new JButton();
	JButton button0 = new JButton();
	JButton buttonAdd = new JButton();
	JButton buttonSub = new JButton();
	JButton buttonMul = new JButton();
	JButton buttonDiv = new JButton();
	JButton buttonClear = new JButton();
	JButton buttonDot = new JButton();
	JButton buttonEqual = new JButton();
	
	double number1, number2, result;
	int addC = 0, mulC = 0, divC = 0, subC = 0;
	
	public Calculator() {
		frame.setSize(340, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setTitle("Calculator");
		
		frame.add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		Border border = BorderFactory.createLineBorder(Color.GREEN, 4);
		panel.setBorder(border);
		
		panel.add(textArea);
		
		textArea.setBackground(Color.BLACK);
		Border tBorder = BorderFactory.createLineBorder(Color.BLUE, 3);
		
		textArea.setBorder(tBorder);
		Font font = new Font("arial", Font.BOLD, 33);
		textArea.setFont(font);
		textArea.setForeground(Color.WHITE);
		textArea.setPreferredSize(new Dimension(2,10));
		textArea.setLineWrap(true);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		panel.add(button0);
		
		panel.add(buttonDot);
		panel.add(buttonSub);
		panel.add(buttonMul);
		panel.add(buttonDiv);
		panel.add(buttonAdd);
		panel.add(buttonEqual);
		
		panel.add(buttonClear);
		
		button1.setPreferredSize(new Dimension(100,43));
		button1.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButton1.png")));
		
		button2.setPreferredSize(new Dimension(100,43));
		button2.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButton2.png")));

		button3.setPreferredSize(new Dimension(100,43));
		button3.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButton3.png")));

		button4.setPreferredSize(new Dimension(100,43));
		button4.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButton4.png")));

		button5.setPreferredSize(new Dimension(100,43));
		button5.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButton5.png")));

		button6.setPreferredSize(new Dimension(100,43));
		button6.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButton6.png")));

		button7.setPreferredSize(new Dimension(100,43));
		button7.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButton7.png")));

		button8.setPreferredSize(new Dimension(100,43));
		button8.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButton8.png")));

		button9.setPreferredSize(new Dimension(100,43));
		button9.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButton9.png")));

		button0.setPreferredSize(new Dimension(100,43));
		button0.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButton0.png")));

		buttonDiv.setPreferredSize(new Dimension(100,43));
		buttonDiv.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButtonDivide.png")));
		
		buttonMul.setPreferredSize(new Dimension(100,43));
		buttonMul.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButtonTimesX.png")));
		
		buttonSub.setPreferredSize(new Dimension(100,43));
		buttonSub.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButtonMinus-.png")));
		
		buttonAdd.setPreferredSize(new Dimension(100,43));
		buttonAdd.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButtonPlus+.png")));
		
		buttonDot.setPreferredSize(new Dimension(100,43));
		buttonDot.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButtonDot•.png")));
		
		buttonClear.setPreferredSize(new Dimension(100,43));
		buttonClear.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButtonClearC.png")));

		buttonEqual.setPreferredSize(new Dimension(200,43));
		buttonEqual.setIcon(new ImageIcon(getClass().getResource("/CalculatorButtons/CalculatorButtonEquals=.png")));
		
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		button0.addActionListener(this);
		buttonDiv.addActionListener(this);
		buttonMul.addActionListener(this);
		buttonSub.addActionListener(this);
		buttonAdd.addActionListener(this);
		buttonDot.addActionListener(this);
		buttonClear.addActionListener(this);
		buttonEqual.addActionListener(this);
		
		textArea.setEditable(false);
	}

	public void actionPerformed(ActionEvent e) {
	
		Object source = e.getSource();
		
		if (source == buttonClear) {
			number1 = 0.0;
			number2 = 0.0;
			textArea.setText("");
		}
		
		if (source == button1) {	
			textArea.append("1");			
		}
		if (source == button2) {	
			textArea.append("2");			
		}
		if (source == button3) {	
			textArea.append("3");			
		}
		if (source == button4) {	
			textArea.append("4");			
		}
		if (source == button5) {	
			textArea.append("5");			
		}
		if (source == button6) {	
			textArea.append("6");			
		}
		if (source == button7) {	
			textArea.append("7");			
		}
		if (source == button8) {	
			textArea.append("8");			
		}
		if (source == button9) {	
			textArea.append("9");			
		}
		if (source == button0) {	
			textArea.append("0");			
		}
		if (source == buttonDot) {	
			textArea.append(".");			
		}
		if (source == buttonAdd) {
			number1 = Number_Reader();
			textArea.setText("");
			addC = 1;
			divC = 0;
			mulC = 0;
			subC = 0;
		}
		if (source == buttonDiv) {
			number1 = Number_Reader();
			textArea.setText("");
			addC = 0;
			divC = 1;
			mulC = 0;
			subC = 0;
		}
		if (source == buttonMul) {
			number1 = Number_Reader();
			textArea.setText("");
			addC = 0;
			divC = 0;
			mulC = 1;
			subC = 0;
		}
		if (source == buttonSub) {
			number1 = Number_Reader();
			textArea.setText("");
			addC = 0;
			divC = 0;
			mulC = 0;
			subC = 1;
		}
		if (source == buttonEqual) {
			number2 = Number_Reader();
			
			if (addC > 0) {
				result = number1 + number2;
				textArea.setText(Double.toString(result));
			}
			if (divC > 0) {
				result = number1 / number2;
				textArea.setText(Double.toString(result));
			}
			if (mulC > 0) {
				result = number1 * number2;
				textArea.setText(Double.toString(result));
			}
			if (subC > 0) {
				result = number1 - number2;
				textArea.setText(Double.toString(result));
			}
			
		}
	}
	
	public double Number_Reader() {
		double num1;
		String s;
		
		s = textArea.getText();
		num1 = Double.valueOf(s);
		
		return num1;
	}
	
}
