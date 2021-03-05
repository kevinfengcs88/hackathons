import java.util.Scanner;

public class Translate
{
    public static char morseToAlphabet(String m)
    {
        String[] morseArr = {".-", "-...", "-.-.", "-..", ".",
        "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
        "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--.."};

        for (int i = 0; i<morseArr.length; i++)
        {
            if (m.equals(morseArr[i]))
                return (char)(i+97);
            if (m.equals(" "))
                return '  ';
        }
        return '0';
    }

    public static String alphabetToMorse(String a)
    {
        String[] morseArr = {".-", "-...", "-.-.", "-..", ".",
        "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
        "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-",
        "...-", ".--", "-..-", "-.--", "--.."};

        return morseArr[a.toLowerCase().charAt(0)-97];
    }

    public static String decipher(String m)
    {
        String result = "";
        String[] letters = m.split(" ");
        for (int i = 0; i<letters.length; i++)
        {
            result+=morseToAlphabet(letters[i]);
        }

        return result;
    }

    public static String cipher(String a)
    {
        String result = "";
        for (int i = 0; i<a.length(); i++)
        {
            result+=alphabetToMorse(a.substring(i, i+1)) + " ";
        }
        
        return result;
    }

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);

        System.out.println("1) Decode\n2) Encode");
        int choice = Integer.parseInt(s.nextLine());

        if (choice == 1)
        {
            System.out.println("Enter Morse: ");
            String input = s.nextLine();
            System.out.println(decipher(input));
        }
        else if (choice == 2)
        {
            System.out.println("Enter Word: ");
            String input = s.nextLine();
            System.out.println(cipher(input));
        }
    }
}
