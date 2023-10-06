import java.util.Comparator;
public class SortByRate implements Comparator<Member> {

    public int compare(Member a, Member b) {
        return a.getRate() - b.getRate();
    }
}
