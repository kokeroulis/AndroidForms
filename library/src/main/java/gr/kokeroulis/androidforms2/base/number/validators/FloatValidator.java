package gr.kokeroulis.androidforms2.base.number.validators;

public class FloatValidator implements Validator<Float> {
    private float mix;
    private float max;

    public FloatValidator(float mix, float max) {
        this.mix = mix;
        this.max = max;
    }

    @Override
    public Float validate(String value) throws Exception {
        float currentValue = Float.parseFloat(value);
        final String minValue = String.valueOf((int) mix);
        final String curValue = String.valueOf((int) currentValue);
        if (curValue.length() > minValue.length() && !value.endsWith(".") && (currentValue < mix || currentValue > max)) {
            throw new RuntimeException("Your value is out of the expected limits");
        }
        return currentValue;
    }
}
