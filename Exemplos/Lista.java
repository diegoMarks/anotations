
public class Lista {
    int id;
    String nome;
    double preco;

    public Lista() {
    }

    public Lista(int id) {
        this.id = id;
    }

    public Lista(int id, String nome, double preço) {
        this.id = id;
        this.nome = nome;
        this.preco = preço;
    }

    public double getPreço() {
        return preco;
    }

    public void setPreço(double preço) {
        this.preco = preço;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\n"
             + " Nome: " + nome + "\n" + 
             " Preço: " + String.format("%.2f", preco) + "\n" +
            "------------------------------------------------------- \n";
    }
}
