package HW01;

public class Task01 {
//    תרגיל 1:
//ישנו אלגוריתם פשוט המסייע לבדוק האם מספר כלשהו
//                                         הוא תעודת זהות ישראלית תקינה.
//                                      בקישור זה ניתן למצוא את ההוראות:
//       https://www.upnext.co.il/articles/israeli-id-numer-validation/
//כתבו תוכנית המבקשת מהמשתמש שוב ושוב להכניס תעודות זהות,
//               ובכל פעם מדפיסה הודעה האם מדובר במספר תעודת זהות תקין.


// Since I cant use Integer.Parse im calculating it by ascii table :)

    private int calculateID(String id){
        int sum = 0;
        for (int i = 0; i < id.length(); i++) {
            int digit = id.charAt(i) - '0';
            int temp = ((i % 2) + 1) * digit;

            if(temp > 9) {
                sum += temp/10 + temp % 10;
            } else {
                sum += temp;
            }
        }
        return sum;
    }

    public boolean checkID(String id){
        id = id.trim();
        if (id.length() > 9 || id.isEmpty()) return false;

        // checking if contains only numbers
        for (int i = 0; i < id.length(); i++) {
            if(id.charAt(i) > '9' || id.charAt(i) < '0') return false;
        }

        // fill 0 if needed
        while (id.length() < 9){
            id = "0" + id;
        }

        return calculateID(id) % 10 == 0;
    }
}
