import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Press Alt+Eingabe with your caret at the highlighted text to see how

        System.out.println("Wie viele Spieler? Bitte die Anzahl angeben!");

        Scanner scanner= new Scanner(System.in);
        int anzSpieler = scanner.nextInt();
        System.out.println("Anzahl Spieler: " + anzSpieler);
        Deque<Spieler> spielerStack = new ArrayDeque<>();

        for(int i = 1; i <= anzSpieler; i++)
        {
            System.out.println("Spielernamen Eingeben und mit Enter Taste bestätigen");
            Spieler sp = new Spieler();
            sp.setSpielerName(scanner.next());
            spielerStack.push(sp);
        }
        Spiel spiel = new Spiel();

        Deque<Spieler> spielerStack2 = new ArrayDeque<>();

        while (!spielerStack.isEmpty() || !spielerStack2.isEmpty()) {

            if(spielerStack.isEmpty())
            {
                while (!spielerStack2.isEmpty())
                {
                    spielerStack.push(spielerStack2.pop());
                }

            }

            Spieler sp = spielerStack.pop();
            System.out.println("Jetzt würfelt " + sp.getSpielerName());

            System.out.println(sp.getSpielerName() + " drücke Enter um zu würfeln");
            System.in.read();
            Wuerfel wuerfel = new Wuerfel();
            int zahl = wuerfel.werfen();
            sp.setAktuellerStand(sp.getAktuellerStand() + zahl);
            System.out.println("Gewürfelte Zahl ist: " + zahl);
            Thread.sleep(1000);
            //System.out.println("Gesamtpunkt von " + sp.getSpielerName() + " ist: " + sp.getAktuellerStand());

            for(int i = 1; i <= 10; i++)
            {
                if(sp.getAktuellerStand() == i)
                {
                    System.out.print(i+"-");
                }else if(sp.getAktuellerStand()>10 && i==10) {
                    System.out.print(i);
                }else {
                    if(i < 10)
                    {
                        System.out.print( "0-");
                    }else {
                        System.out.print( "0");
                    }

                }
            }
            System.out.println();

            if(sp.getAktuellerStand() >= spiel.getMaxStepsToGoal())
            {
                System.out.println("Herzlichen Glückwunsch " + sp.getSpielerName() + ", du hast gewonnen!");
                break;
            }

            spielerStack2.push(sp);
        }

        scanner.close();
    }
}