/**
 * Created by wyzhangdongsheng1 on 2014/9/4.
 */
public class BuilderPatternForConstructorsWithMultipleParameters {
    public static void main(String[] args) {
        NutritutionFacts nf = new NutritutionFacts.Builder(100,200).calories(23).carbohydrate(2).build();
        System.out.println(nf);
    }
}

//Builder pattern
class NutritutionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;


    private NutritutionFacts(Builder builder){
        this.servings = builder.servings;
        this.servingSize = builder.servingSize;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public static class Builder {
        private final int servingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int calories) {
            this.calories = calories;
            return this;
        }

        public Builder fat(int fat) {
            this.fat = fat;
            return this;
        }

        public Builder sodium(int sodium) {
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate(int carbohydrate) {
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritutionFacts build(){
            return new NutritutionFacts(this);
        }
    }

    @Override
    public String toString() {
        return "NutritutionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}