package ch.zhaw.iwi.devops.tictactoe;
import java.util.Arrays;
import java.util.Random;

public class TicTacToe {

    private String[] players;
    private String currentPlayer = "";
    private String[] spielfeld;
    
    public TicTacToe(){
        spielfeld = new String[9];
        for (int a = 0; a < 9; a++) {
            spielfeld[a]="";
        }
        players = new String[2];
        players[0] = "x";
        players[1] = "o";
        Random rand = new Random();
        setCurrentPlayer(players[rand.nextInt(1)]);
    }

    public String play(int feld, String player){
        if (currentPlayer == player){

            if (feld >=0 && feld <= 8){

                if (spielfeld[feld] == ""){
                        spielfeld[feld] = player;
                        if (player == "x"){
                            setCurrentPlayer("o");
                        } else {
                            setCurrentPlayer("x");
                        }
                        switch(spielStandPruefen()){
                            case "": return player+"-"+Integer.toString(feld);
                            case "x": return "x gewinnt";
                            case "y": return "y gewinnt";
                            case "u": return "unentschieden!";
                        }

                } else {
                    return "#error-"+Integer.toString(feld)+"-belegt";
                }

            } else {
                return "#error-0to8";
            }

        } else {
            return currentPlayer+"'s turn";
        }
        return "";
    }

    public String getCurrentPlayer(){
        return currentPlayer;
    }

    private void setCurrentPlayer(String player){
        currentPlayer = player;
    }

    private String spielStandPruefen(){
        for (int a = 0; a < 8; a++) {
            String linie = null;
  
            switch (a) {
            case 0:
                linie = spielfeld[0] + spielfeld[1] + spielfeld[2];
                break;
            case 1:
                linie = spielfeld[3] + spielfeld[4] + spielfeld[5];
                break;
            case 2:
                linie = spielfeld[6] + spielfeld[7] + spielfeld[8];
                break;
            case 3:
                linie = spielfeld[0] + spielfeld[3] + spielfeld[6];
                break;
            case 4:
                linie = spielfeld[1] + spielfeld[4] + spielfeld[7];
                break;
            case 5:
                linie = spielfeld[2] + spielfeld[5] + spielfeld[8];
                break;
            case 6:
                linie = spielfeld[0] + spielfeld[4] + spielfeld[8];
                break;
            case 7:
                linie = spielfeld[2] + spielfeld[4] + spielfeld[6];
                break;
            }
            //x gewinnt
            if (linie.equals("xxx")) {
                return "x";
            }
              
            // o gewinnt
            else if (linie.equals("ooo")) {
                return "o";
            }
        }
        for (int a = 0; a < 9; a++) {
            if (spielfeld[a]=="") {
                //leere Felder
                return "";
            } 
        }
        
        return "u";
    }
}
