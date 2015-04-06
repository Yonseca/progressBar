/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progressBar;

import java.util.Scanner;

/**
 *
 * @author yonseca
 */
public class ProgressBar {

    long timeMillis;
    boolean atras = false;
    char symbol;
    ProgressBar progressBar = null;

    public ProgressBar() {
    }

    public void clavaProgressBar() {
        timeMillis = System.currentTimeMillis();
        symbol = '.';
        System.out.print(". Cargando...\r");
    }

    public void updateProgressBar() {
        //Scanner leeLinea = new Scanner(System.in);
        try {
            //String symbol = leeLinea.nextLine();
            long diff = System.currentTimeMillis() - timeMillis;
            if (diff > 250) {
                change();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void change() {
        switch (symbol) {
            case '.':
                atras = !atras;
                this.symbol = 'o';
                System.out.print("o Cargando...\r");
                break;
            case 'o':
                if (atras) {
                    System.out.print(". Cargando...\r");
                    this.symbol = '.';
                } else {
                    System.out.print("0 Cargando...\r");
                    this.symbol = '0';
                }
                break;
            case '0':
                atras = !atras;
                System.out.print("o Cargando...\r");
                this.symbol = 'o';
                break;
        }
        timeMillis = System.currentTimeMillis();
    }
}
