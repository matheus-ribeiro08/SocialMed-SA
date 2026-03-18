package org.example.enums;

public enum Destinos {

    MENU_INICIAL("menuInicial", "Menu_principal"),
    CADASTRO("cadastro", "Tela de cadastro"),
    LOGIN("login", "Tela de login"),

    MENU_PACIENTE("menuPaciente", "Menu Do Paciente"),
    MENU_SECRETARIO("menuSecretario", "Menu Do Secretario"),
    MENU_MEDICO("menuMedico", "Menu Do Medico"),
    MENU_ADMIN("menuAdmin", "Menu DO Admin"),

    AGENDAR_CONSULTA("agendarConsulta", "Agendar Consulta"),
    CANCELAR_CONSULTA("cancelarConsulta", "Cancelar consulta"),
    RELATORIOS("relatorios", "Relatorios"),
    CONFIGURACOES("configuracoes", "Configuracoes"),

    ERRO("Eroo", "Tela de Erro"),
    SAIR("sair", "Sair do Sistema");

    private String codigo;
    private String descricao;

    Destinos(String codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Destinos fromCodigo(String codigo){
        if(codigo == null || codigo.isEmpty()){
            return MENU_INICIAL;
        }

        for(Destinos destinos : values()){
            if(destinos.equals(codigo)){
                return destinos;
            }
        }

        return MENU_INICIAL;
    }

    public boolean isMenuUsuario(){
        return  this == MENU_PACIENTE ||
                this == MENU_SECRETARIO ||
                this == MENU_MEDICO ||
                this == MENU_ADMIN;
    }

    public boolean requerAutorizacao(){
        return this != MENU_INICIAL &&
                this != CADASTRO &&
                this == LOGIN &&
                this == SAIR;
    }

    @Override
    public String toString(){
        return descricao;
    }
}
