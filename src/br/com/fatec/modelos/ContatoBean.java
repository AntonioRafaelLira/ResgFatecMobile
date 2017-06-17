/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.modelos;

import java.io.Serializable;

/**
 *
 * @author MARCIO
 */
public class ContatoBean implements Serializable {
    String id;
    String nome;
    String rg;
    String cpf;
    String end;

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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
    
    @Override
    public String toString() {
        return "ContatoBean{" + "id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", end=" + end + '}';
    }
}
