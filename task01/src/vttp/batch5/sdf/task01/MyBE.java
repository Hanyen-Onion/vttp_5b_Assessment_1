package vttp.batch5.sdf.task01;

public class MyBE {

	private String season;
	private String month;
	private String holiday;
	private String weekday;
	private String weather;
	private String temperature;
	private String humidity;
	private String windspeed;
	private int casual;
	private int registered;
    
    private String[] position = {"highest", "second highest", "third highest", "fourth highest", "fifth highest"} ;


    public int getTotal() {
        return this.casual+this.registered;
    }


    @Override
    public String toString() {
        return "The " + position + "recorded number of cyclists was in "+ season +", on a " + weekday + "in the month of " + month +".\n" 
        + "There were a total of " + getTotal() + "cyclists. The weather was "+ weather + ".\n" + weekday + "was " + holiday ;
    }

    


	

}
