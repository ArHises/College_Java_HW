package HW01;

import java.util.Random;
import java.util.Scanner;

public class Task02 {
    /*
    תרגיל 2:
משחק Wordle ב-Java
רקע על המשחק:
Wordle הוא משחק מילים פופולרי שבו השחקן מנסה לנחש מילה סודית בת מספר מסוים של אותיות.
 בכל ניסיון, השחקן מקבל משוב על כמה מהאותיות שהוא ניחש נכונות, והאם הן נמצאות במיקום הנכון.
 המטרה היא לנחש את המילה בתוך מספר מוגבל של ניסיונות.

מטרת התרגיל:
לכתוב תוכנית ב-Java שמדמה את משחק Wordle, תוך שימוש בכלים שהכרנו בלבד.

חוקי המשחק:
המילה הסודית:
בתחילת המשחק, התוכנית תבחר מילה סודית קבועה מתוך רשימת מילים מוגדרת מראש (מלאו את הרשימה ב-10 מילים לפחות, כולן באורך של 5 אותיות).

ניחושי השחקן:
לשחקן יש 6 ניסיונות לנחש את המילה הסודית.
כל ניחוש חייב להיות מילה תקנית מתוך רשימת המילים המוגדרת מראש, ובאורך זהה למילה הסודית.
אם הניחוש אינו עומד בתנאים הללו, התוכנית תבקש מהשחקן לנסות שוב מבלי לספור את הניחוש כניסיון.

משוב על כל ניחוש:
לאחר כל ניחוש, התוכנית תציג משוב שיסביר:
אילו אותיות נכונות ונמצאות במיקום הנכון (יוצגו כ-G - Green).
אילו אותיות נכונות אך נמצאות במיקום שגוי (יוצגו כ-Y - Yellow).
אילו אותיות אינן מופיעות כלל במילה הסודית (יוצגו כ-_).
יש להתעלם מהבדלים בין אותיות גדולות וקטנות באנגלית.

דוגמה:
המילה הסודית: apple
ניחוש השחקן: angle
משוב: G_Y__

סיום המשחק:
השחקן מנצח אם הוא מצליח לנחש את המילה הסודית בתוך 6 ניסיונות.
אם השחקן לא מצליח לנחש את המילה הסודית לאחר 6 ניסיונות, המשחק מסתיים והתוכנית חושפת את המילה הסודית.
     */

    private String[] wards = {
            "apple",
            "grape",
            "chair",
            "table",
            "flame",
            "stone",
            "bread",
            "world",
            "plant",
            "space"
    };

    private String getWard(){
        Random random = new Random();
        return this.wards[random.nextInt(this.wards.length)];
    }

    private void printWards(){
        System.out.println("Possible wards are: ");
        System.out.print("{ ");
        for (int i = 0; i < this.wards.length; i++) {
            if (i == this.wards.length - 1){
                System.out.print(this.wards[i] + " }");
            } else {
                System.out.print(this.wards[i] + ", ");
            }
        }
        System.out.println();
    }


    public void runWordle(){
        System.out.println("========== Welcome to Wordle! ==========");
        Scanner scanner = new Scanner(System.in);
        String ward = getWard().toLowerCase();
        int tries = 0;

//        System.out.println("The ward is: " + ward);

        while (tries < 6){
            printWards();
            System.out.println();
            System.out.print("Enter your ward(tries left " + (6-tries) +"): ");

            String guess = scanner.nextLine().toLowerCase();
//            String guess = tries == 1 ? "table" : "stone"; // for tests

            System.out.println("guess:  " + guess);
            String result = "";
            boolean find = false;

            if (guess.length() != ward.length()){
                continue;
            }

            if (guess.equals(ward)){
                System.out.println("You won! the ward is: " + ward + "!");
                break;
            }

            for (int i = 0; i < ward.length(); i++) {
                if (ward.charAt(i) == guess.charAt(i)){
                    result += 'G';
                    find = true;
                } else {
                    for (int j = 0; j < ward.length(); j++) {
                        if (ward.charAt(j) == guess.charAt(i) && !find) {
                            result += 'Y';
                            find = true;
                            break;
                        }
                    }
                }
                 if (!find){
                    result += '_';
                }
                 find = false;
            }
            System.out.println("Result: " + result);
            tries++;
        }
        System.out.println(".\n.\n.\n.\n.");
        System.out.println("The world was: " + ward);
        System.out.println("You lost! \ngood luck next time!");
    }

}
