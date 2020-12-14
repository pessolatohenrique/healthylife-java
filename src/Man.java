public class Man extends Client{
    public Man(String name, Double weight, Double height) {
        super(name, weight, height);
    }

    public void calculateEer() throws HighHeightException, HighWeightException {
        super.calculateEer();

        Double eer = 662 - 9.53 * this.getAge() + this.getCaf() * (15.91 * this.getWeight() + 539.6 * this.getHeight());
        this.setEer(eer);
    }

    @Override
    public void calculateCaf() throws CafException {
        super.calculateCaf();

        if (this.getActivityLevel() >= 5) {
            throw new CafException("O nível de atividade deve ser entre 1 e 4");
        }

        switch (this.getActivityLevel()) {
            case 2: this.setCaf(1.11); break;
            case 3: this.setCaf(1.25); break;
            case 4: this.setCaf(1.48); break;
            default: this.setCaf(1.0); break;
        }
    }
}
