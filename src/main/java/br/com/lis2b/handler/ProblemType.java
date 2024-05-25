package br.com.lis2b.handler;

import lombok.Getter;

@Getter
public enum ProblemType {
    REGISTRO_DUPLICADO("/dados-duplicado", "Dados duplicados"),
    TRANSFERENCIA_NAO_AUTORIZADA("/transferência-nao-autorizada", "Transferência não autorizada"),
    ERRO_DE_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    SERVICO_INDISPONIVEL("/servico-indisponivel", "Serviço indisponível"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso não encontrado"),
    ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio");

    private final String title;
    private final String uri;

    ProblemType(String path, String title) {
        this.uri = "https://lis2b.com.br" + path;
        this.title = title;
    }

}
