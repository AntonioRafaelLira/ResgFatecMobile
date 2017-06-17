package br.com.fatec.modelos;

import java.io.Serializable;

public class ColaboradorBean implements Serializable {
    String id;
    String nome;
    String tipo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    @Override
    public String toString() {
        return "ColaboradorBean{" + "id=" + id + ", nome=" + nome + ", tipo=" + tipo + '}';
    }
}
