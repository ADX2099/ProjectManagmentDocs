package recyclercard.adx2099.com.recyclercardview;

public class Movie {
    public String name;
    public int poster;

    public Movie(){


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public Movie(String name, int poster){
        this.name = name;
        this.poster = poster;

    }

}
