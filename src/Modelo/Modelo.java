
package Modelo;

import java.util.Random;

public class Modelo {
    String[][] matriz;
    Random rand;
    
    public Modelo(){
        matriz = new String[8][8];
        rand = new Random();
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(String[][] aux) {
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                this.matriz[i][j] = aux[i][j];
            }
        }
    }
    
    public void Movimiento_Humano(int j){
        
        for(int i=0; i<8; i++){
            if("X".equals(matriz[i][j]) || "O".equals(matriz[i][j])){
                matriz[i-1][j] = "X";
                return;
            }      
            if(i == 7){
                if("".equals(matriz[i][j])){
                    matriz[i][j] = "X";
                }
            } 
        }
    }
    
    public int Aleatorio(){
        return rand.nextInt(8);
    }
    
    public void Movimiento_Computadora(){
        
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if("X".equals(matriz[i][j])){
                    if(i < 7 && i != 0) {
                        if("X".equals(matriz[i+1][j])){
                            if("".equals(matriz[i-1][j])){
                                matriz[i-1][j] = "O";
                                return;                               
                            }
                        }
                    }
                    if(j != 7 && j != 0 && i != 7 && i != 0){
                        if("X".equals(matriz[i][j+1])){
                            if("".equals(matriz[i][j-1])){
                                if("X".equals(matriz[i+1][j-1]) || "O".equals(matriz[i+1][j-1])){
                                    matriz[i][j-1] = "O";
                                    return;
                                }
                            }
                        }
                        if("X".equals(matriz[i][j-1])){
                            if("".equals(matriz[i][j+1])){
                                if("X".equals(matriz[i+1][j+1]) || "O".equals(matriz[i+1][j+1])){
                                    matriz[i][j+1] = "O";
                                    return;
                                }
                            }
                        }
                    }    
                }  
                else if("O".equals(matriz[i][j])){
                    if(i < 7 && i != 0) {
                        if("O".equals(matriz[i+1][j])){
                            if("".equals(matriz[i-1][j])){
                            matriz[i-1][j] = "O";
                            return;                               
                            }
                        }
                    } 
                    if(j < 7 && j != 0 && i != 0 && i != 7){
                        if("O".equals(matriz[i][j+1])){
                            if("".equals(matriz[i][j-1])){
                                if("O".equals(matriz[i+1][j-1]) || "X".equals(matriz[i+1][j-1])){
                                    matriz[i][j-1] = "O";
                                    return;
                                }
                            }
                        }
                        if("O".equals(matriz[i][j-1])){
                            if("".equals(matriz[i][j+1])){
                                if("O".equals(matriz[i+1][j+1]) || "X".equals(matriz[i+1][j+1])){
                                    matriz[i][j+1] = "O";
                                    return;
                                }
                            }
                        }
                    } 
                }
            }
        }
        
        while(!Movimiento_Aleatorio()){
            Movimiento_Aleatorio();
        }
    } 
    
    public int Ganador(){
        
        int cont_1 = 0;
        int cont_2 = 0;
        
        // Validacion de las Filas
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if("X".equals(matriz[i][j])){
                    cont_1++;
                    if(cont_1 >= 4){
                        return 1;
                    }
                }
                else{
                    cont_1 = 0;
                }
                if("O".equals(matriz[i][j])){
                    cont_2++;
                    if(cont_2 >= 4){
                        return 0;
                    }
                }
                else{
                    cont_2 = 0;
                }
                
            }
            cont_1 = 0;
            cont_2 = 0;
        }
        
        cont_1 = 0;
        cont_2 = 0;
       
        // Validacion de las Columnas
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if("X".equals(matriz[j][i])){
                    cont_1++;
                    if(cont_1 >= 4){
                        return 1;
                    }
                }
                else{
                    cont_1 = 0;
                }
                if("O".equals(matriz[j][i])){
                    cont_2++;
                    if(cont_2 >= 4){
                        return 0;
                    }
                }
                else{
                    cont_2 = 0;
                }
            }
            cont_1 = 0;
            cont_2 = 0;
        }
        
        cont_1 = 0;
        cont_2 = 0;
        
        // Validacion Diagonal Principal Inferior
        
        if(matriz[0][0] == "X" && matriz[1][1] == "X" && matriz[2][2] == "X" && matriz[3][3] == "X"){ return 1; }
        if(matriz[0][1] == "X" && matriz[1][2] == "X" && matriz[2][3] == "X" && matriz[3][4] == "X"){ return 1; }
        if(matriz[0][2] == "X" && matriz[1][3] == "X" && matriz[2][4] == "X" && matriz[3][5] == "X"){ return 1; }
        if(matriz[0][3] == "X" && matriz[1][4] == "X" && matriz[2][5] == "X" && matriz[3][6] == "X"){ return 1; }
        if(matriz[0][4] == "X" && matriz[1][5] == "X" && matriz[2][6] == "X" && matriz[3][7] == "X"){ return 1; }
        
        if(matriz[1][0] == "X" && matriz[2][1] == "X" && matriz[3][2] == "X" && matriz[4][3] == "X"){ return 1; }
        if(matriz[1][1] == "X" && matriz[2][2] == "X" && matriz[3][3] == "X" && matriz[4][4] == "X"){ return 1; }
        if(matriz[1][2] == "X" && matriz[2][3] == "X" && matriz[3][4] == "X" && matriz[4][5] == "X"){ return 1; }
        if(matriz[1][3] == "X" && matriz[2][4] == "X" && matriz[3][5] == "X" && matriz[4][6] == "X"){ return 1; }
        if(matriz[1][4] == "X" && matriz[2][5] == "X" && matriz[3][6] == "X" && matriz[4][7] == "X"){ return 1; }
        
        if(matriz[2][0] == "X" && matriz[2][1] == "X" && matriz[3][2] == "X" && matriz[4][3] == "X"){ return 1; }
        if(matriz[2][1] == "X" && matriz[2][2] == "X" && matriz[3][3] == "X" && matriz[4][4] == "X"){ return 1; }
        if(matriz[2][2] == "X" && matriz[2][3] == "X" && matriz[3][4] == "X" && matriz[4][5] == "X"){ return 1; }
        if(matriz[2][3] == "X" && matriz[2][4] == "X" && matriz[3][5] == "X" && matriz[4][6] == "X"){ return 1; }
        if(matriz[2][4] == "X" && matriz[2][5] == "X" && matriz[3][6] == "X" && matriz[4][7] == "X"){ return 1; }
        
        if(matriz[3][0] == "X" && matriz[4][1] == "X" && matriz[5][2] == "X" && matriz[6][3] == "X"){ return 1; }
        if(matriz[3][1] == "X" && matriz[4][2] == "X" && matriz[5][3] == "X" && matriz[6][4] == "X"){ return 1; }
        if(matriz[3][2] == "X" && matriz[4][3] == "X" && matriz[5][4] == "X" && matriz[6][5] == "X"){ return 1; }
        if(matriz[3][3] == "X" && matriz[4][4] == "X" && matriz[5][5] == "X" && matriz[6][6] == "X"){ return 1; }
        if(matriz[3][4] == "X" && matriz[4][5] == "X" && matriz[5][6] == "X" && matriz[6][7] == "X"){ return 1; }
        
        if(matriz[4][0] == "X" && matriz[5][1] == "X" && matriz[6][2] == "X" && matriz[7][3] == "X"){ return 1; }
        if(matriz[4][1] == "X" && matriz[5][2] == "X" && matriz[6][3] == "X" && matriz[7][4] == "X"){ return 1; }
        if(matriz[4][2] == "X" && matriz[5][3] == "X" && matriz[6][4] == "X" && matriz[7][5] == "X"){ return 1; }
        if(matriz[4][3] == "X" && matriz[5][4] == "X" && matriz[6][5] == "X" && matriz[7][6] == "X"){ return 1; }
        if(matriz[4][4] == "X" && matriz[5][5] == "X" && matriz[6][6] == "X" && matriz[7][7] == "X"){ return 1; }
        
        // Validacion del Empate
        int aux = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if("".equals(matriz[i][j])){
                    aux++;
                }
            }
        }
        if(aux == 0){
            return 2;
        }
        
        return -1;
    }
    
    public boolean Movimiento_Aleatorio(){
        int a = Aleatorio();
        
        for(int i=0; i<8; i++){
            if("X".equals(matriz[i][a]) || "O".equals(matriz[i][a])){
                if(i != 0) {
                    matriz[i-1][a] = "O";
                    return true;
                }
            } 
            
            if(i == 7){
                if("".equals(matriz[i][a])){
                    matriz[i][a] = "O";
                    return true;
                }
            } 
        }
        return false; 
    }
    
}
