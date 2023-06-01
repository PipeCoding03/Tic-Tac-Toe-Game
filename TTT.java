package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TTT extends JFrame {
    String TITLE = "Tic Tac Toe Game v0.2.1";
    int WIDTH = 8+80+90+30+90+30+90+80+8;
    int HEIGHT = 32+80+90+30+90+30+90+80+8;
    
    JPanel panel = new JPanel();
    JLabel tags[] = new JLabel[9];
    JLabel xWon = new JLabel("", SwingConstants.CENTER);
    JLabel oWon = new JLabel("", SwingConstants.CENTER);
    JLabel scoreboard = new JLabel("", SwingConstants.CENTER);
    JButton restart = new JButton("Limpiar Tablero");
    
    Font board = new Font("Arial Black", 1, 70);
    Color myRed = new Color(200, 10, 0);
    Color myGreen = new Color(0, 200, 40);
    Color myBlue = new Color(0, 40, 200);
    
    String nameX, nameO;
    String turnoActual = "X";
    boolean winsX = false;
    boolean winsO = false;
    int xScore = 0, oScore = 0;
    
    public TTT(){
        nameX = JOptionPane.showInputDialog(null,
                                            "Nombre del Jugador 1 (X)",
                                            "Players Names",
                                            1);
        nameO = JOptionPane.showInputDialog(null, 
                                            "Nombre del Jugador 2 (O)",
                                            "Players Names",
                                            1);
        
        scoreboard.setText(nameX + " (X) 0 - 0 (O) " + nameO);
        
        this.setTitle(TITLE);
             setSize(WIDTH, HEIGHT);
             setDefaultCloseOperation(EXIT_ON_CLOSE);
             setLocationRelativeTo(null);
             setResizable(false);
             
        this.add(panel);
        panel.setBackground(myBlue);
        panel.setLayout(null);
    }
    
    @Override
    public void paint (Graphics g){
        super.paint(g);
        
        int xLeftBorder = 8,
            xRightBorder = WIDTH - 8,
            yTopBorder = 32,
            yBottomBorder = HEIGHT - 8;
        g.fillRect(xLeftBorder + 80, yTopBorder + 80, 330, 330);
        
        panel.add(xWon);
        xWon.setFont(new Font("Comic Sans MS", 0, 18));
        xWon.setForeground(Color.BLACK);
        xWon.setOpaque(true);
        xWon.setBackground(myBlue);
        xWon.setBounds(20, 20 + 5, 80, 30);
        
        panel.add(oWon);
        oWon.setFont(new Font("Comic Sans MS", 0, 18));
        oWon.setForeground(Color.BLACK);
        oWon.setOpaque(true);
        oWon.setBackground(myBlue);
        oWon.setBounds(WIDTH - 16 - 80 - 20, yTopBorder - 32 + 20 + 5, 80, 30);
        
        panel.add(scoreboard);
        //winnerShower.setVisible(false);
        scoreboard.setFont(new Font("Comic Sans MS", 0, 17));
        scoreboard.setForeground(Color.BLACK);
        scoreboard.setOpaque(true);
        scoreboard.setBackground(myRed);
        scoreboard.setBounds(WIDTH/2 - 120 - 4, yTopBorder - 32 + 20, 240, 40);
        
        panel.add(restart);
        restart.setFont(new Font("Comic Sans MS", 0, 14));
        restart.setBounds(WIDTH/2 - 140/2 - 8, HEIGHT - 100, 140, 40);
        restart.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                for (int i = 0; i < 9; i++){
                    tags[i].setText("");
                    tags[i].setBackground(myBlue);
                }

                xWon.setBackground(myBlue);
                xWon.setText("");
                oWon.setBackground(myBlue);
                oWon.setText("");

                winsX = false;
                winsO = false;
            }
            @Override public void mousePressed(MouseEvent e){}
            @Override public void mouseReleased(MouseEvent e){}
            @Override public void mouseEntered(MouseEvent e){}
            @Override public void mouseExited(MouseEvent e) {}
        });
        
        JLabel label1 = new JLabel(); tags[0] = label1;
        JLabel label2 = new JLabel(); tags[1] = label2;
        JLabel label3 = new JLabel(); tags[2] = label3;
        JLabel label4 = new JLabel(); tags[3] = label4;
        JLabel label5 = new JLabel(); tags[4] = label5;
        JLabel label6 = new JLabel(); tags[5] = label6;
        JLabel label7 = new JLabel(); tags[6] = label7;
        JLabel label8 = new JLabel(); tags[7] = label8;
        JLabel label9 = new JLabel(); tags[8] = label9;
        
        for (int i = 0; i < 9; i++){
            tags[i].setOpaque(true);
            panel.add(tags[i]);
            tags[i].setHorizontalAlignment(SwingConstants.CENTER);
            tags[i].setFont(board);
            tags[i].setBackground(myBlue);
            tags[i].setForeground(Color.BLACK);
        }
        
        tags[0].setBounds(80, 80, 90, 90);
        tags[1].setBounds(200, 80, 90, 90);
        tags[2].setBounds(320, 80, 90, 90);
        tags[3].setBounds(80, 200, 90, 90);
        tags[4].setBounds(200, 200, 90, 90);
        tags[5].setBounds(320, 200, 90, 90);
        tags[6].setBounds(80, 320, 90, 90);
        tags[7].setBounds(200, 320, 90, 90);
        tags[8].setBounds(320, 320, 90, 90);
        
        tags[0].addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                press(1);
            }

            @Override public void mousePressed(MouseEvent e){}
            @Override public void mouseReleased(MouseEvent e){}
            @Override public void mouseEntered(MouseEvent e){}
            @Override public void mouseExited(MouseEvent e) {}
        });
        
        tags[1].addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                press(2);
            }

            @Override public void mousePressed(MouseEvent e){}
            @Override public void mouseReleased(MouseEvent e){}
            @Override public void mouseEntered(MouseEvent e){}
            @Override public void mouseExited(MouseEvent e) {}
        });
        
        tags[2].addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                press(3);
            }

            @Override public void mousePressed(MouseEvent e){}
            @Override public void mouseReleased(MouseEvent e){}
            @Override public void mouseEntered(MouseEvent e){}
            @Override public void mouseExited(MouseEvent e) {}
        });
        
        tags[3].addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                press(4);
            }

            @Override public void mousePressed(MouseEvent e){}
            @Override public void mouseReleased(MouseEvent e){}
            @Override public void mouseEntered(MouseEvent e){}
            @Override public void mouseExited(MouseEvent e) {}
        });
        
        tags[4].addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                press(5);
            }

            @Override public void mousePressed(MouseEvent e){}
            @Override public void mouseReleased(MouseEvent e){}
            @Override public void mouseEntered(MouseEvent e){}
            @Override public void mouseExited(MouseEvent e) {}
        });
        
        tags[5].addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                press(6);
            }

            @Override public void mousePressed(MouseEvent e){}
            @Override public void mouseReleased(MouseEvent e){}
            @Override public void mouseEntered(MouseEvent e){}
            @Override public void mouseExited(MouseEvent e) {}
        });
        
        tags[6].addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                press(7);
            }

            @Override public void mousePressed(MouseEvent e){}
            @Override public void mouseReleased(MouseEvent e){}
            @Override public void mouseEntered(MouseEvent e){}
            @Override public void mouseExited(MouseEvent e) {}
        });
        
        tags[7].addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                press(8);
            }

            @Override public void mousePressed(MouseEvent e){}
            @Override public void mouseReleased(MouseEvent e){}
            @Override public void mouseEntered(MouseEvent e){}
            @Override public void mouseExited(MouseEvent e) {}
        });
        
        tags[8].addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e){
                press(9);
            }

            @Override public void mousePressed(MouseEvent e){}
            @Override public void mouseReleased(MouseEvent e){}
            @Override public void mouseEntered(MouseEvent e){}
            @Override public void mouseExited(MouseEvent e){}
        });
    }
    
    public void press(int pos){
        if (winsX == false && winsO == false){
            if (tags[pos-1].getText().equals("")){
                tags[pos-1].setText(turnoActual);
                cambiarTurno();
            }

            checkWinner();
        }else{
            //NADA
        }
    }
    
    public void cambiarTurno(){
        if (turnoActual == "X"){
            turnoActual = "O";
        }else{
            turnoActual = "X";
        }
    }
    
    public void checkWinner(){
        String checking;
        
        for (int j = 0; j < 2; j++){
            if (j == 0){
                checking = "X";
            }else{
                checking = "O";
            }
            
            //Horizontal
            for (int head = 0; head < 8; head += 3){
                if(tags[head].getText().equals(checking)
                && tags[head + 1].getText().equals(tags[head].getText())
                && tags[head + 2].getText().equals(tags[head].getText())){                    
                    for (int i = head; i < head + 3; i++){
                        if (checking == "X"){
                            tags[i].setBackground(myGreen);
                            winsX = true;
                        }else{
                            tags[i].setBackground(myRed);
                            winsO = true;
                        }
                    }
                    
                    if (winsX){
                        xScore++;
                    }else if (winsO){
                        oScore++;
                    }
                }
            }
            
            //Vertical
            for (int head = 0; head < 3; head++){
                if(tags[head].getText().equals(checking) 
                && tags[head + 3].getText().equals(tags[head].getText())
                && tags[head + 6].getText().equals(tags[head].getText())){
                    if(tags[0].getText().equals(checking)
                    && tags[1].getText().equals(checking)
                    && tags[2].getText().equals(checking)){
                        //NOTHING
                    }else if(tags[3].getText().equals(checking)
                    && tags[4].getText().equals(checking)
                    && tags[5].getText().equals(checking)){
                        //NOTHING
                    }else if(tags[6].getText().equals(checking)
                    && tags[7].getText().equals(checking)
                    && tags[8].getText().equals(checking)){
                        //NOTHING
                    }else{
                        for (int i = head; i < head + 7; i += 3){
                            if (checking == "X"){
                                tags[i].setBackground(myGreen);
                                winsX = true;
                            }else{
                                tags[i].setBackground(myRed);
                                winsO = true;
                            }
                        }

                        if (winsX){
                            xScore++;
                        }else if (winsO){
                            oScore++;
                        } 
                    }                 
                }
            }
            
            //Diagonal "\"
            int head = 0;
            if(tags[head].getText().equals(checking)
            && tags[head + 4].getText().equals(tags[head].getText())
            && tags[head + 8].getText().equals(tags[head].getText())){
                if(tags[0].getText().equals(checking)
                && tags[1].getText().equals(checking)
                && tags[2].getText().equals(checking)){
                    //NOTHING
                }else if(tags[3].getText().equals(checking)
                && tags[4].getText().equals(checking)
                && tags[5].getText().equals(checking)){
                    //NOTHING
                }else if(tags[6].getText().equals(checking)
                && tags[7].getText().equals(checking)
                && tags[8].getText().equals(checking)){
                    //NOTHING
                }else if(tags[0].getText().equals(checking)
                && tags[3].getText().equals(checking)
                && tags[6].getText().equals(checking)){
                    //NOTHING
                }else if(tags[1].getText().equals(checking)
                && tags[4].getText().equals(checking)
                && tags[7].getText().equals(checking)){
                    //NOTHING
                }else if(tags[2].getText().equals(checking)
                && tags[5].getText().equals(checking)
                && tags[8].getText().equals(checking)){
                    //NOTHING
                }else{
                    for (int i = head; i < head + 9; i += 4){
                        if (checking == "X"){
                            tags[i].setBackground(myGreen);
                            winsX = true;
                        }else{
                            tags[i].setBackground(myRed);
                            winsO = true;
                        }
                    }

                    if (winsX){
                        xScore++;
                    }else if (winsO){
                        oScore++;
                    }
                }
            }
            
            //Diagonal "/"
            head = 2;
            if(tags[head].getText().equals(checking)
            && tags[head + 2].getText().equals(tags[head].getText())
            && tags[head + 4].getText().equals(tags[head].getText())){
                if(tags[0].getText().equals(checking)
                && tags[1].getText().equals(checking)
                && tags[2].getText().equals(checking)){
                    //NOTHING
                }else if(tags[3].getText().equals(checking)
                && tags[4].getText().equals(checking)
                && tags[5].getText().equals(checking)){
                    //NOTHING
                }else if(tags[6].getText().equals(checking)
                && tags[7].getText().equals(checking)
                && tags[8].getText().equals(checking)){
                    //NOTHING
                }else if(tags[0].getText().equals(checking)
                && tags[3].getText().equals(checking)
                && tags[6].getText().equals(checking)){
                    //NOTHING
                }else if(tags[1].getText().equals(checking)
                && tags[4].getText().equals(checking)
                && tags[7].getText().equals(checking)){
                    //NOTHING
                }else if(tags[2].getText().equals(checking)
                && tags[5].getText().equals(checking)
                && tags[8].getText().equals(checking)){
                    //NOTHING
                }else{
                    for (int i = head; i < head + 6; i += 2){
                        if (checking == "X"){
                            tags[i].setBackground(myGreen);
                            winsX = true;
                        }else{
                            tags[i].setBackground(myRed);
                            winsO = true;
                        }
                    }

                    if (winsX){
                        xScore++;
                    }else if (winsO){
                        oScore++;
                    }
                }
            }
            
            colorWinner();
            scoreboard.setText(nameX + " (X) " + xScore + " - " + oScore + " (O) " + nameO);
        }
    }
    
    public void colorWinner(){
        if (winsX){
            xWon.setBackground(myGreen);
            xWon.setText("Ganó: X");
        }else if (winsO){
            oWon.setBackground(myRed);
            oWon.setText("Ganó: O");
        }
    }
}