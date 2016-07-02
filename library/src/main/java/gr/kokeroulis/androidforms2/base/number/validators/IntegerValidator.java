package gr.kokeroulis.androidforms2.base.number.validators;

public class IntegerValidator implements Validator<Integer> {
    private int mix;
    private int max;

    public IntegerValidator(int mix, int max) {
        this.mix = mix;
        this.max = max;
    }

    @Override
    public Integer validate(String value) throws Exception {
        int currentValue = Integer.parseInt(value);
        if (value.length() > 1 && (currentValue <= mix || currentValue >= max)) {
            throw new RuntimeException("Your value is out of the expected limits");
        }
        return currentValue;
    }
}
