import java.util.Objects;
import java.util.Scanner;

public class Generator {
    Alphabet alphabet;
    public static Scanner keyboard;

    public Generator(Scanner scanner) {
        keyboard = scanner;
    }

    public Generator(boolean IncludeUpper, boolean IncludeLower, boolean IncludeNum, boolean IncludeSym) {
        alphabet = new Alphabet(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
    }

    public void mainLoop() {
        System.out.println("Bienvenue aux services de mot de passe Friend-Ly :)");
        printMenu();

        String userOption = "-1";

        while (!userOption.equals("4")) {

            userOption = keyboard.next();

            switch (userOption) {
                case "1":
                    requestPassword();
                    printMenu();
                    break;
                case "2":
                    checkPassword();
                    printMenu();
                    break;
                case "3":
                    printUsefulInfo();
                    printMenu();
                    break;
                case "4":
                    printQuitMessage();
                    break;
                default:
                    System.out.println();
                    System.out.println("Veuillez sélectionner l'une des commandes disponibles");
                    printMenu();
                    break;
            }
        }
    }

    private Password GeneratePassword(int length) {
        final StringBuilder pass = new StringBuilder("");

        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * range) + min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(pass.toString());
    }

    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Utilisez une longueur de mot de passe minimale de 8 caractères ou plus si possible");
        System.out.println("Incluez des caractères alphabétiques minuscules et majuscules, des chiffres et des symboles si possible");
        System.out.println("Générez des mots de passe aléatoirement lorsque cela est possible");
        System.out.println("Évitez d'utiliser le même mot de passe deux fois (par exemple, sur plusieurs comptes utilisateur et/ou systèmes logiciels)");
        System.out.println("Évitez la répétition de caractères, les modèles de clavier, les mots du dictionnaire, les séquences de lettres ou de chiffres," +
                "\nles noms d'utilisateur, les noms de proches ou d'animaux de compagnie, les liens romantiques (actuels ou passés) " +
                "et les informations biographiques (par exemple, numéros d'identification, noms d'ancêtres ou dates).");
        System.out.println("Évitez d'utiliser des informations que les collègues et/ou connaissances de l'utilisateur pourraient associer à l'utilisateur");
        System.out.println("N'utilisez pas de mots de passe constitués entièrement de n'importe quelle combinaison simple des composants faibles mentionnés ci-dessus");
    }

    private void requestPassword() {
        boolean IncludeUpper = false;
        boolean IncludeLower = false;
        boolean IncludeNum = false;
        boolean IncludeSym = false;

        boolean correctParams;

        System.out.println();
        System.out.println("Bonjour, bienvenue dans le générateur de mot de passe :) répondez"
                + " aux questions suivantes par Oui ou Non \n");

        do {
            String input;
            correctParams = false;

            do {
                System.out.println("Voulez-vous que les lettres minuscules \"abcd...\" soient utilisées ? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("oui") && !input.equalsIgnoreCase("non"));

            if (isInclude(input)) IncludeLower = true;

            do {
                System.out.println("Voulez-vous que les lettres majuscules \"ABCD...\" soient utilisées ? ");
                input = keyboard.next();
                PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("oui") && !input.equalsIgnoreCase("non"));

            if (isInclude(input)) IncludeUpper = true;

            do {
            System.out.println("Voulez-vous que les chiffres \"1234...\" soient utilisés ? ");
            input = keyboard.next();
            PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("oui") && !input.equalsIgnoreCase("non"));

            if (isInclude(input)) IncludeNum = true;

            do {
            System.out.println("Voulez-vous que les symboles \"!@#$...\" soient utilisés ? ");
            input = keyboard.next();
            PasswordRequestError(input);
            } while (!input.equalsIgnoreCase("oui") && !input.equalsIgnoreCase("non"));

            if (isInclude(input)) IncludeSym = true;

            //Aucun ensemble sélectionné
            if (!IncludeUpper && !IncludeLower && !IncludeNum && !IncludeSym) {
                System.out.println("Vous n'avez sélectionné aucun caractère pour générer votre " +
                        "mot de passe, au moins une de vos réponses doit être Oui\n");
                correctParams = true;
            }

        } while (correctParams);

        System.out.println("Parfait ! Entrez maintenant la longueur du mot de passe");
        int length = keyboard.nextInt();

        final Generator generator = new Generator(IncludeUpper, IncludeLower, IncludeNum, IncludeSym);
        final Password password = generator.GeneratePassword(length);

        System.err.println("Votre mot de passe généré -> " + password);
    }

    private boolean isInclude(String Input) {
        if (Input.equalsIgnoreCase("oui")) {
            return true;
        } else {
            return false;
        }
    }

    private void PasswordRequestError(String i) {
        if (!i.equalsIgnoreCase("oui") && !i.equalsIgnoreCase("non")) {
            System.out.println("Vous avez entré quelque chose d'incorrect, revenons-y \n");
        }
    }

    private void checkPassword() {
        String input;

        System.out.print("\nEntrez votre mot de passe :");
        input = keyboard.next();

        final Password p = new Password(input);

        System.out.println(p.calculateScore());
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Entrez 1 - Générateur de mot de passe");
        System.out.println("Entrez 2 - Vérification de la force du mot de passe");
        System.out.println("Entrez 3 - Informations utiles");
        System.out.println("Entrez 4 - Quitter");
        System.out.print("Choix :");
    }

    private void printQuitMessage() {
        System.out.println("Fermeture du programme au revoir !");
    }
}