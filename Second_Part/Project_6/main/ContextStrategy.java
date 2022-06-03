class ContextStrategy {
    Strategy strategy;

    public void ActivateAction(Double x, Double y, Double height, Double width) throws Exception {
        strategy.Action(x, y, height, width);
    }
}
