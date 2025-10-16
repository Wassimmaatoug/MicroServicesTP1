package metier;

import dao.IDao;

public class MetierIMP implements IMetier {
    private IDao dao;

    @Override
    public double calcul() {
        double data = dao.getData();
        double res = data * Math.random(); // Calcul simulé
        return res;
    }

    @Override
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}