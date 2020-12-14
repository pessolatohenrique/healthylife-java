public class Women extends Client{
    public Women(String name, Double weight, Double height) {
        super(name, weight, height);
    }

    public void calculateEer() throws HighHeightException, HighWeightException {
        super.calculateEer();

        Double eer = 354 - (6.91 * this.getAge()) + this.getCaf() * (9.36 * this.getWeight() + 726 * this.getHeight());
        this.setEer(eer);
    }

    @Override
    public void calculateCaf() throws CafException {
        super.calculateCaf();

        if (this.getActivityLevel() >= 5) {
            throw new CafException("O nível de atividade deve ser entre 1 e 4");
        }

        switch (this.getActivityLevel()) {
            case 2: this.setCaf(1.12); break;
            case 3: this.setCaf(1.27); break;
            case 4: this.setCaf(1.45); break;
            default: this.setCaf(1.0); break;
        }
    }
}
