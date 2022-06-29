package Utils;

public class TypeOperation {

    public static String emptyStringTransform(String val){

        if (val != null) {
            if (val.equals("[empty]"))
                return "";
        }

        return val;

    }

}
