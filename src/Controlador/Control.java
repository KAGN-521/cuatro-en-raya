
package Controlador;

import Modelo.Modelo;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public final class Control implements ActionListener{
    Ventana ven;
    Modelo mod;
    
    public Control(Ventana vis, Modelo mod){
        this.ven = vis;
        this.mod = mod; 
            
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                ven.getBotones()[i][j].addActionListener(this);
            }
        }
    }  
    
    public void Iniciar(){
        ven.setTitle("Conecta 4 (Edicion JAVA)");
        ven.setLocationRelativeTo(null);
        ven.setVisible(true); 
    }
    
    public String[][] Conversion_1(JButton[][] aux){
        String[][] aux_2 = new String[8][8];
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if("X".equals(aux[i][j].getText())){
                   aux_2[i][j] = "X"; 
                }
                else if("O".equals(aux[i][j].getText())){
                    aux_2[i][j] = "O";
                }
                else{
                    aux_2[i][j] = "";
                }
            }
        }
        return aux_2;
    }

    public JButton[][] Conversion_2(String[][] aux){
        JButton[][] aux_2;
        aux_2 = new JButton[8][8];
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if("X".equals(aux[i][j])){
                   aux_2[i][j] = new JButton("X"); 
                }
                else if("O".equals(aux[i][j])){
                    aux_2[i][j] = new JButton("O");
                }
                else{
                    aux_2[i][j] = new JButton("");
                }
            }
        }
        
        return aux_2;
    }
    
    public void Reset(){
        JButton[][] aux = new JButton[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                aux[i][j] = new JButton("");
            }  
        }
        ven.setBotones(aux);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        mod.setMatriz(Conversion_1(ven.getBotones()));
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(e.getSource() == ven.getBotones()[i][j]){
                    mod.Movimiento_Humano(j);
                }
            }
        }
        
        mod.Movimiento_Computadora();
        ven.setBotones(Conversion_2(mod.getMatriz()));
        
        if(mod.Ganador() == 1){
            JOptionPane.showMessageDialog(null,"Haz Ganado");
            Reset();
        }
        else if(mod.Ganador() == 0){
            JOptionPane.showMessageDialog(null,"Te Han Ganado");
            Reset();
        }
        else if(mod.Ganador() == 2){
            JOptionPane.showMessageDialog(null,"El Juego Quedo Empatado");
            Reset();
        }
    }
}
