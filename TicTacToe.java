package Tic_Tac_Toe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author tph
 */

public class TicTacToe extends JPanel{
    
    char player = 'X';
    int cells = 9;
    int rows = 3;
    int columns = 3;
    JButton[] buttons = new JButton[cells];
    
    TicTacToe()
    {
       setLayout(new GridLayout(rows,columns));
       createButtons();
        
    }
    
    //To add buttons
    public void createButtons() 
    {
        for (int i = 0; i <= 8; i++) 
        {

            buttons[i] =new JButton();

            buttons[i].setText("");

            buttons[i].addActionListener(e -> {

                JButton clickedBtn = (JButton) e.getSource();
                clickedBtn.setText(String.valueOf(player));
                clickedBtn.setEnabled(false);


                if (player == 'X')
                    player = 'O';
                else
                    player = 'X';

                showWinner();
            });
            
            add(buttons[i]);
        }
    }
    
    //To popup winner
    public void showWinner() 
    {
        //X or O wins
        if (isWinner()) 
        {
            if (player == 'X') 
            {
                player = 'O';
            }
            else 
            {
                player = 'X';
            }
            //Result box
            JOptionPane jOptionPane = new JOptionPane();
            int dialog = JOptionPane.showConfirmDialog(jOptionPane, "Game Over. " + "The winner is " + player + ". Restart? ", "Result.",JOptionPane.YES_NO_OPTION);
            if (dialog == JOptionPane.YES_OPTION)
            {
                JFrame frame = new JFrame("Tic Tac Toe");
                frame.getContentPane().add(new TicTacToe());
                frame.setBounds(200, 200, 300, 250);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
            else
            {
                System.exit(0);
            }
        } 
        //For conditions that no one wins
        else if (isDraw()) 
        {
            JOptionPane jOptionPane = new JOptionPane();
            int dialog = JOptionPane.showConfirmDialog(jOptionPane, "Game Draw. Restart?", "Result", JOptionPane.YES_NO_OPTION);
            if (dialog == JOptionPane.YES_OPTION)
            {
                JFrame frame = new JFrame("Tic Tac Toe");
                frame.getContentPane().add(new TicTacToe());//adding only method isn't enough
                frame.setBounds(200, 200, 300, 250);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
            }
            else
            {
                System.exit(0);
            }
        }
    }
    
    //Check every winning combination
    public boolean isWinner() {
        return checkRows() || checkColumns() || checkDiagonals();
    }
    
    public boolean checkRows() 
    {
        int i = 0;
        for (int j = 0; j < 3; j++) {
            if (buttons[i].getText().equals(buttons[i + 1].getText()) && buttons[i].getText().equals(buttons[i + 2].getText()) && !buttons[i].getText().equals("")) 
            {
                return true;
            }
            i = i + 3;
        }
        return false;
    }
    
    public boolean checkColumns() 
    {
        int i = 0;
        for (int j = 0; j < 3; j++) 
        {
            if (buttons[i].getText().equals(buttons[i + 3].getText()) && buttons[i].getText().equals(buttons[i + 6].getText()) && !buttons[i].getText().equals("")) 
            {
                return true;
            }
            i++;
        }
        return false;
    }
    
    public boolean checkDiagonals() 
    {
        if (buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].getText().equals(""))
        {
            return true;
        }
        else
        {
            return buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].getText().equals("");
        }
    }
    
    //When no one wins
    public boolean isDraw() {
        boolean gridsFull = true;
        for (int i = 0; i < cells; i++) {
            if (buttons[i].getText().equals("")) {
                gridsFull = false;
            }
        }
        return gridsFull;
    }
     
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.getContentPane().add(new TicTacToe());
        frame.setBounds(200, 200, 300, 250);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }    
}
