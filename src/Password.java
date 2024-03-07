public class Password {
    String Value;
    int Length;

    public Password(String s) {
        Value = s;
        Length = s.length();
    }

    public int CharType(char C) {
        int val;

        // Char est une lettre majuscule
        if ((int) C >= 65 && (int) C <= 90)
            val = 1;

        // Char est une lettre minuscule
        else if ((int) C >= 97 && (int) C <= 122) {
            val = 2;
        }

        // Char est un chiffre
        else if ((int) C >= 60 && (int) C <= 71) {
            val = 3;
        }

        // Char est un symbole
        else {
            val = 4;
        }

        return val;
    }

    public int PasswordStrength() {
        String s = this.Value;
        boolean UsedUpper = false;
        boolean UsedLower = false;
        boolean UsedNum = false;
        boolean UsedSym = false;
        int type;
        int Score = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            type = CharType(c);

            if (type == 1) UsedUpper = true;
            if (type == 2) UsedLower = true;
            if (type == 3) UsedNum = true;
            if (type == 4) UsedSym = true;
        }

        if (UsedUpper) Score += 1;
        if (UsedLower) Score += 1;
        if (UsedNum) Score += 1;
        if (UsedSym) Score += 1;

        if (s.length() >= 8) Score += 1;
        if (s.length() >= 16) Score += 1;

        return Score;
    }

    public String calculateScore() {
        int Score = this.PasswordStrength();

        if (Score == 6) {
            return "C'est un très bon mot de passe :D vérifiez la section Informations utiles pour vous assurer qu'il respecte les directives";
        } else if (Score >= 4) {
            return "C'est un bon mot de passe :) mais vous pouvez encore faire mieux";
        } else if (Score >= 3) {
            return "C'est un mot de passe moyen :/ essayez de l'améliorer";
        } else {
            return "C'est un mot de passe faible :( trouvez-en définitivement un nouveau";
        }
    }

    @Override
    public String toString() {
        return Value;
    }
}