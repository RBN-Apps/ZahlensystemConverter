import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    static String[] Zahl;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Gib die " + "\u001B[96m" + "Basis" + "\u001B[0m" + " deiner Zahl ein: ");
        int basis1 = scanner.nextInt();
        System.out.print("Gib die " + "\u001B[95m" + "Zahl" + "\u001B[0m" + " ein: ");
        String zahl1 = scanner.next();

        boolean isLegitNum = checkBase(zahl1, basis1);
        if (isLegitNum) {
            System.out.print("Gib die " + "\u001B[31m" + "Basis" + "\u001B[0m" + " der Zahl ein, die Errechnet werden soll: ");
            int basis2 = scanner.nextInt();
            int decimalZahl = calcToDec(zahl1, basis1);
//        System.out.println("Zahl im Zehnersystem:  " + decimalZahl);
            int runs = calcRuns(decimalZahl, basis2);
            Zahl = new String[runs];
//        System.out.println("Runs: "+runs);
            if (basis2 > 36 && basis2 < 2) {
                System.out.println("Die Basis darf nicht größer als 36 und kleiner als 2 sein!");
            } else {
                Calc(decimalZahl, basis2, 0);
/*            //gibt Gelb aus
            System.out.print("\u001B[33m" + "Gelb" + "\u001B[0m");
            //gibt Grün aus
            System.out.print("\u001B[32m" + "Grün" + "\u001B[0m");
            //gibt Rot aus
            System.out.print("\u001B[31m" + "Rot" + "\u001B[0m");
            //gibt Blau aus
            System.out.print("\u001B[34m" + "Blau" + "\u001B[0m");
            //gibt Lila aus
            System.out.print("\u001B[35m" + "Lila" + "\u001B[0m");
            //gibt Cyan aus
            System.out.print("\u001B[36m" + "Cyan" + "\u001B[0m");
            //gibt Weiß aus
            System.out.print("\u001B[37m" + "Weiß" + "\u001B[0m");
            //gibt Schwarz aus
            System.out.print("\u001B[30m" + "Schwarz" + "\u001B[0m");
            //gibt Hellgrün aus
            System.out.print("\u001B[92m" + "Hellgrün" + "\u001B[0m");
            //gibt Hellblau aus
            System.out.print("\u001B[94m" + "Hellblau" + "\u001B[0m");
            //gibt Hellrot aus
            System.out.print("\u001B[91m" + "Hellrot" + "\u001B[0m");
            //gibt Hellgelb aus
            System.out.print("\u001B[93m" + "Hellgelb" + "\u001B[0m");
            //gibt Helllila aus
            System.out.print("\u001B[95m" + "Helllila" + "\u001B[0m");
            //gibt Hellcyan aus
            System.out.print("\u001B[96m" + "Hellcyan" + "\u001B[0m");
            //gibt Hellgrau aus
            System.out.print("\u001B[37m" + "Hellgrau" + "\u001B[0m");
            //gibt Dunkelgrau aus
            System.out.print("\u001B[90m" + "Dunkelgrau" + "\u001B[0m");*/

                System.out.println("Die " + "\u001B[95m" + "Zahl " + zahl1 + "\u001B[0m" + " zur " + "\u001B[96m" + "Basis " + basis1 + "\u001B[0m" + " ist zur" + "\u001B[31m" + " Basis " + basis2 + "\u001B[0m" + ": \u001B[93m" + printZahl() + "\u001B[0m");
            }
        } else {
            System.out.println("Die Zahl ist nicht in der Basis!");
            if (basis1 - 1 > 9) {
                System.out.println("Die Zahl darf nur Zahlen von 0 bis " + (basis1 - 1) + " also " + (char) (basis1 + 54) + " enthalten!");
                System.out.println("Erlaubte Zeichen: ");
                for (int i = 0; i < basis1; i++) {
                    if (i > 9) {
                        System.out.print((char) (i + 55) + " ");
                    } else {
                        System.out.print(i + " ");
                    }
                }
            } else {
                System.out.println("Zahlen mit der Basis " + basis1 + " dürfen nur die Zahlen von 0 bis " + (basis1 - 1) + " enthalten!");
                for (int i = 0; i < basis1; i++) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    private static boolean checkBase(String zahl1, int basis1) {
        for (int i = 0; i < zahl1.length(); i++) {
            char c = zahl1.charAt(i);
            int digit = 0;
            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } else if (c >= 'A' && c <= 'Z') {
                digit = 10 + c - 'A';
            }
            if (digit >= basis1) {
                return false;
            }
        }
        return true;
    }

    public static int calcToDec(String Zahl, int basisEingabeZahl) {
        int decimal = 0;
        System.out.print("Dezimalzahl: ");
        for (int i = 0; i < Zahl.length(); i++) {
            char c = Zahl.charAt(i);
            int digit = 0;
            if (c >= '0' && c <= '9') {
                digit = c - '0';
            } else if (c >= 'A' && c <= 'Z') {
                digit = 10 + c - 'A';
            }

            decimal = decimal + digit * (int) Math.pow(basisEingabeZahl, Zahl.length() - 1 - i);

            if (i == 0) {
                System.out.print("(" + "\u001B[95m" + digit + "\u001B[0m" + " * " + "\u001B[96m" + basisEingabeZahl + "\u001B[0m" + " ^ " + (Zahl.length() - 1 - i) + ")");
            } else {
                System.out.print(" + (" + "\u001B[95m" + digit + "\u001B[0m" + " * " + "\u001B[96m" + basisEingabeZahl + "\u001B[0m" + " ^ " + (Zahl.length() - 1 - i) + ")");
            }
            if (i == Zahl.length() - 1) {
                System.out.println(" = \u001B[92m" + decimal + "\u001B[0m");
            }
//            decimal = decimal * basisEingabeZahl + digit;
        }
        return decimal;
    }

    public static int calcRuns(int decimalZahl, int basis) {
        int runs = 0;
        while (decimalZahl > 0) {
            decimalZahl /= basis;
            runs++;
        }
        return runs;
    }


    public static void Calc(int decimalZahl, int basis, int currentRun) {
        int Rest = decimalZahl % basis;
        int Quotient = decimalZahl / basis;
        if (Rest < 10) {
            System.out.println(decimalZahl + " / " + "\u001B[31m" + basis + "\u001B[0m" + " = " + Quotient + " Rest " + "\u001B[93m" + Rest + "\u001B[0m");
        } else {
            System.out.println(decimalZahl + " / " + "\u001B[31m" + basis + "\u001B[0m" + " = " + Quotient + " Rest " + Rest + " --> " + "\u001B[93m" + (char) (Rest + 55) + "\u001B[0m");
        }
        char[] hex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        if (basis >= 10) {
            if (Rest >= 10) {
                Zahl[currentRun] = String.valueOf(hex[Rest - 10]);
            } else {
                Zahl[currentRun] = String.valueOf(Rest);
            }
        } else {
            Zahl[currentRun] = String.valueOf(Rest);
        }

        if (Quotient > 0) {
            Calc(Quotient, basis, currentRun + 1);
        }
    }

    public static String printZahl() {
        String convertedNum = "";
        for (int i = Zahl.length - 1; i >= 0; i--) {
            convertedNum += Zahl[i];
            if ((i % 4 == 0) && i != 0) //basis == 2 &&
                convertedNum += " ";
        }
        return convertedNum;
    }

    /* public static int CalcRuns(int decimalZahl, int basis, int runs) {
        int Quotient = decimalZahl/basis;
        if (Quotient > 0) {
            CalcRuns(Quotient, basis, runs + 1);
        }else {
            finalRuns = runs;
            return runs;
        }
        return finalRuns;
    }*/
}