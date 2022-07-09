package middlewareManager;

public class    MiddlewareLocation {
    String before;
    String after;
    Boolean atStart = false;
    Boolean atEnd = false;
    Integer atIndex = -1;
    
    public MiddlewareLocation() {
        atEnd = true;
    }

    public MiddlewareLocation(String before, String after) {
        this.before = before;
        this.after = after;
    }

    public String getBefore() {
        return before;
    }

    public String getAfter() {
        return after;
    }
}
