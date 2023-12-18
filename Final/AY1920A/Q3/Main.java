package Final.AY1920A.Q3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cook c1 = new Cook("Candy");  
        Cook c2 = new Cook("Cara");
        Recipe r1 = new Recipe("Grilled Fish");
        Recipe r2 = new Recipe("Baked beancurd");
        Recipe r3 = new Recipe("Minced cabbage");
        Dish d1 = c1.cookDish(r1);
        Dish d2 = c1.cookDish(r2);
        Dish d3 = c2.cookDish(r2);
        d1.obtainScore(5);
        d2.obtainScore(4);
        d3.obtainScore(6);
        c1.report(); //Output: I got 2 scores: 5 4  
        c2.report(); //Output: I got 1 scores: 6
        r1.report(); //Output: Grilled Fish: The best cook is Candy
        r2.report(); //Output: Baked beancurd: The best cook is Cara
        r3.report(); //Output: Minced cabbage: [No data]
    } 
}

/*
 * Complete the program. The fields in Cook, Recipe and Dish classes are given below. Do not add any other fields.
 */

class Cook {
    private String name;
    private ArrayList<Integer> scores = new ArrayList<>();

    public Cook(String name) { this.name = name; }
    public Dish cookDish(Recipe r) { return new Dish(this, r); }
    public void addToScore(int score) { scores.add(score); }
    public void report() {
        if (scores.size() == 0) {
            System.out.println("I got 0 scores");
        } else {
            System.out.printf("I got %d scores:", scores.size());
            for (Integer score : scores) {
                System.out.printf(" %d", score);
            }
            System.out.println();
        }
    }
    public String getName() { return name; }
}

class Recipe {
    private String name;
    private Cook bestCook;
    private int bestScore;
    public Recipe(String name) {
        this.name = name;
        bestCook = null;
        bestScore = 0;
    }
    public void updateScore(Cook c, int score) {
        if (score > bestScore) {
            bestCook = c;
            bestScore = score;
        }
    }
    public void report() {
        if (bestCook == null) {
            System.out.printf("%s: [No data]\n", name);
        } else {
            System.out.printf("%s: The best cook is %s\n", name, bestCook.getName());
        }
    }
}

class Dish {
    private Cook cook;
    private Recipe recipe;
    public Dish(Cook cook, Recipe recipe) {
        this.cook = cook;
        this.recipe = recipe;
    }
    public void obtainScore(int score) {
        cook.addToScore(score);
        recipe.updateScore(cook, score);
    }
}