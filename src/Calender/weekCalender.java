package Calender;

import java.util.EnumMap;
import java.util.Scanner;

/**
 *Weekcalender makes a calender containing events for each day.<br>
 * Has attributes: <br>
 * {@link weekCalender#activities}<br>
 * {@link weekCalender#scanner}<br>
 * Has methods:<br>
 *{@link #setActivities()} sets activities for weekdays<br>
 * {@link #showWeek()} displyes weekdays and their activities <br>
 */

public class weekCalender {
    /**
     * activites is an EnumMap referencing {@link weekdays}
     */
    EnumMap<weekdays, String> activities = new EnumMap<>(weekdays.class);
    /**
     * scanner is a scanner using java.util.Scanner
     */
    Scanner scanner = new Scanner(System.in);


    /**
     * setActivities validates an input, if input is "Y" it calls {@link #setActivity()}
     */
    public void setActivities(){
        boolean setting = true;

        while (setting){
            System.out.println("Do you wish to set an activity? (Y/N)");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("Y")){
                setActivity();
                continue;
            }if(input.equalsIgnoreCase("N")){
                setting = false;
            }else{
                System.out.println("invalid");
                input = scanner.nextLine();
            }


        }
    }

    /**
     * contains is a method that tests if a string exists in {@link weekdays}
     * @param test is a String
     * @return returns true if test exists is {@link weekdays} other returns false
     */
    public static boolean contains(String test){
        for (weekdays day : weekdays.values()){
            if (day.name().equalsIgnoreCase(test)){
                return true;
            }
        }
        return false;
    }

    /**
     * setActivity takes a user input, validates it with {@link #contains(String)} and sets a key in {@link weekCalender#activities} if input exists in {@link weekdays}
     */
    public void setActivity(){
        System.out.println("What day do you wish to assign an activity?");
        String input = scanner.nextLine().toUpperCase();
        boolean isDone = false;

        while(!isDone){
            if(contains(input)){
                System.out.println("What activity do you wish to assign?");
                activities.put(weekdays.valueOf(input), scanner.nextLine());
                isDone = true;
            }else{
                System.out.println("that is not a weekday, please try again.");
                input = scanner.nextLine().toUpperCase();
            }
        }
    }

    /**
     * filler fills empty keys in {@link weekCalender#activities} with " " for better printing.
     */
    public void filler(){
        for(weekdays day : weekdays.values()){
            if(!this.activities.containsKey(weekdays.valueOf(day.toString()))){
                activities.put(weekdays.valueOf(day.toString()), " ");

            }
        }
    }

    /**
     * showWeek prints {@link weekCalender#activities} both values and keys.
     */
    public void showWeek() {
        this.filler();
        for (weekdays day : this.activities.keySet()) {
            System.out.println(day + ": " + this.activities.get(day));
        }
    }
}