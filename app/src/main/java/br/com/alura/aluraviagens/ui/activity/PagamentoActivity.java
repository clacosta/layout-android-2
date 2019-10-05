package br.com.alura.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import br.com.alura.aluraviagens.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagemanto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote(
                "São Paulo",
                "sao_paulo_sp",
                2,
                new BigDecimal("243.99"));

        mostraPreco(pacoteSaoPaulo);

        Button botaoFinalizaPagamento = findViewById(R.id.pagamento_botao_finaliza_compra);
        botaoFinalizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        PagamentoActivity.this,
                        ResumoCompraActivity.class);
                startActivity(intent);
            }
        });

    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBrasileira(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
