package br.com.murilomoro.muriloapp.model;

/**
 * Created by Murilo on 08/01/2016.
 */
public class Sobre {

    private String nome;
    private int idade;
    private String endereco;
    private String cidade;
    private String estado;
    private String nascionalidade;
    private String estadoCivil;
    private String[] telefones;
    private String email;


    public Sobre() {
        this.nome = "Murilo Henrique Moro Sanches";
        this.idade = 22;
        this.endereco = "Avenida 7 de Setembro";
        this.cidade = "Nova Granada";
        this.estado = "SP";
        this.nascionalidade = "Brasileiro";
        this.estadoCivil = "Solteiro";
        this.telefones = new String[]{"(17)3262-1974", "(17)99283-0945"};
        this.email = "murilo104@gmail.com";
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTextSobre() {
        return this.nascionalidade + ", " + this.estadoCivil + ", " + this.idade + " anos\n"
                + this.endereco + "\n" + this.cidade + " - " + this.estado + "\nTelefone: "
                + this.telefones[0] + " / " + this.telefones[1] + "\nE-mail: " + this.email;
    }
}
