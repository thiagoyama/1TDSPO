package br.com.fiap.porto.main.concessionaria;

import br.com.fiap.porto.dao.ConcessionariaDao;
import br.com.fiap.porto.factory.ConnectionFactory;
import br.com.fiap.porto.model.Concessionaria;

import java.sql.Connection;

public class CadastroTest {

    public static void main(String[] args) {
        try {
            Connection conexao = ConnectionFactory.getConnection();
            //Criar o DAO
            ConcessionariaDao dao = new ConcessionariaDao(conexao);
            //Criar a Concessionaria
            Concessionaria c = new Concessionaria("Agulhas Negras",
                                             "1233/0001-12", 50);
            //Cadastrar a Concessionaria
            dao.cadastrar(c);
            System.out.println("Sucesso!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
