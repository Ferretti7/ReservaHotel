
public class Reserva {

    private String nomeHospede;
    private String tipoQuarto;
    private int numeroDias;
    private double valorDiaria;

    // Construtor
    public Reserva(String nomeHospede, String tipoQuarto, int numeroDias, double valorDiaria) {
        this.nomeHospede = nomeHospede;
        this.tipoQuarto = tipoQuarto;
        this.numeroDias = numeroDias;
        this.valorDiaria = valorDiaria;
    }

    // Getters e Setters
    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public int getNumeroDias() {
        return numeroDias;
    }

    public void setNumeroDias(int numeroDias) {
        this.numeroDias = numeroDias;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    // Calcula o valor total da reserva
    public double calcularValorTotal() {
        return numeroDias * valorDiaria;
    }

    // Exibe os dados da reserva
    @Override
    public String toString() {
        return "Nome do hóspede: " + nomeHospede +
                "\nTipo de quarto: " + tipoQuarto +
                "\nNúmero de dias: " + numeroDias +
                "\nValor da diária: R$ " + valorDiaria +
                "\nValor total: R$ " + calcularValorTotal();
    }
}
