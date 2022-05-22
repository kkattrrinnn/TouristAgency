public class Tour {
    private String name;
    private String starting_point;
    private String final_point;
    private String date;
    private int duration;
    private int price;

    public Tour() {}

    public Tour(String name, String starting_point, String final_point, String date, int duration, int price) {
        this.name = name;
        this.starting_point = starting_point;
        this.final_point = final_point;
        this.date = date;
        this.duration = duration;
        this.price = price;
    }
}
