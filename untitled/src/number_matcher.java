import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class number_matcher {

    public static void main(String[] args) {
        Pattern normalizedPattern = Pattern.compile("^[\\+][0-9].*");
        Matcher matcher = normalizedPattern.matcher("6047830249");
        Matcher matcher2 = normalizedPattern.matcher("joseph");
        System.out.println(matcher.matches());
    }
}
