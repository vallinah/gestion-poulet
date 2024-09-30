import dao.ChargeDAO;
import util.AnalytiqueDesCouts;
import util.Charge;
import util.ChargeAnalytique;
import util.TypeCharge;

public class Main {
    public static void main(String[] args) {
        TypeCharge typeCharge = new TypeCharge(1, "Type A");
        ChargeAnalytique chargeAnalytique = new ChargeAnalytique(1, "Charge A");
        AnalytiqueDesCouts analytiqueDesCouts = new AnalytiqueDesCouts(1, "Analyse des Coûts A");

        // Création d'un objet Charge
        Charge charge = new Charge(0, "jkjk", 42022222.0, "jkj", typeCharge, chargeAnalytique, analytiqueDesCouts, 45.1, 40.2, 40.2);

        // Affichage de l'objet Charge

        System.out.println(charge.toString());
        ChargeDAO dao = new ChargeDAO();
        dao.insert(charge);
    }
}
