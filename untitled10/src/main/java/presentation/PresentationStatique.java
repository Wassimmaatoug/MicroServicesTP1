package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;


import dao.DaoIMP;
import dao.IDao;
import metier.IMetier;
import metier.MetierIMP;

public class PresentationStatique {
    public static void main(String[] args) {
        IDao dao = new DaoIMP();
        IMetier metier = new MetierIMP();

        metier.setDao(dao);

        System.out.println("Résultat du calcul : " + metier.calcul());
    }
}

// 9: Explication du couplage faible : Le couplage est faible car MetierIMP dépend de l'interface IDao (abstraction) et non de l'implémentation concrète DaoIMP. L'injection via setDao permet de changer l'implémentation sans modifier MetierIMP, favorisant la flexibilité et la maintenabilité.

 /*
public class PresentationDynamique {
    public static void main(String[] args) throws Exception {

        InputStream inputStream = PresentationDynamique.class.getClassLoader().getResourceAsStream("config.txt");

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String daoClassName = reader.readLine().trim();
        String metierClassName = reader.readLine().trim();
        reader.close();

        Class<?> daoClass = Class.forName(daoClassName);
        IDao dao = (IDao) daoClass.getDeclaredConstructor().newInstance();

        Class<?> metierClass = Class.forName(metierClassName);
        IMetier metier = (IMetier) metierClass.getDeclaredConstructor().newInstance();

        Method setDaoMethod = metier.getClass().getMethod("setDao", IDao.class);
        setDaoMethod.invoke(metier, dao);

        System.out.println("Résultat du calcul dynamique : " + metier.calcul());
    }
}

/*
Explication de la DI dynamique : Les classes sont chargées à l'exécution via Class.forName et instanciées par réflexion, en se basant sur le fichier config.txt.
Cela découple encore plus le code : changer une implémentation ne nécessite qu'une modification du fichier,
sans recompilation. Cela illustre l'IoC où le contrôle de l'instanciation est externalisé.
*/