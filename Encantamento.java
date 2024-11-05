public class Encantamento extends Carta {
    private String efeitoContinuo;

    public Encantamento(String nome, int custoDeMana, String efeitoContinuo) {
        super(nome, custoDeMana);
        setEfeitoContinuo(efeitoContinuo);
    }

    public String getEfeitoContinuo() {
        return efeitoContinuo;
    }

    public void setEfeitoContinuo(String efeitoContinuo) {
        this.efeitoContinuo = efeitoContinuo;
    }

}