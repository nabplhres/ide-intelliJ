package br.com.alura.bytebank.registrador;

import br.com.alura.bytebank.model.Pagamento;
import br.com.alura.bytebank.model.Tipo;

import java.util.ArrayList;
import java.util.List;

public class RegistroDePagamento {

    private final static List<Pagamento> PAGAMENTOS = new ArrayList<>();

    public void registra(List<Pagamento> ps) {
        for (int i = 0; i < ps.size(); i++) {
            Pagamento p = ps.get(i);
            verificaTipo(p);
            salvaPagamentos(p);
        }
        pagEfetuados();
    }

    private void pagEfetuados() {
        if (!PAGAMENTOS.isEmpty()) {
            System.out.println("Todos os pagamentos");
            for (int i = 0; i < PAGAMENTOS.size(); i++) {
                System.out.println(PAGAMENTOS.get(i));
            }
        } else {
            System.out.println("Não temos pagamentos");
        }
    }

    private void verificaTipo(Pagamento p) {
        if (p.getTipo().equals(Tipo.CREDITO)) {
            p.setValor(p.getValor() * 1.02);

        }
        if (p.getTipo().equals(Tipo.DEBITO)) {
            p.setValor(p.getValor() * 1.001);
        }



    }

    private void salvaPagamentos(Pagamento p) {
        PAGAMENTOS.add(p);
        System.out.println("Pagamento realizado " + p);
    }

}
