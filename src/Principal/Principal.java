package Principal;

import Splash.SplashScreen;

/**
 *
 * @author Gustavo Gonçalves
 * 10/05/2018
 */

public class Principal 
{
    public static void main(String[] args) 
    {
        SplashScreen splash = new SplashScreen(); //Instanciando a splashscreen
        splash.setLocationRelativeTo(null); //Centralizar form.
        splash.setVisible(true); //Fazer o form ficar visível
    }
}
