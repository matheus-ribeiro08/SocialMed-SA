package org.example.enums;

public enum TipoUsuario {

    PACIENTE(0, "Usuario final que marca consultas"),
    SECRETARIO(1, "Usuario que é o responsável pela confirmação de consultas"),
    MEDICO(2, "Usuario que faz as consultas"),
    ADM(3, "Usuario responsável por mudar, arrumar e atualizar o sistema");

    private final int codigo;
    private final String descricao;

    TipoUsuario(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoUsuario fromCodigo(int codigo){
        for(TipoUsuario tipo : TipoUsuario.values()){
            if (tipo.getCodigo() == codigo){
                return tipo;
            }
        }
        throw new IllegalArgumentException("Codigo de TipoUsuario invalido: "+ codigo);
    }
}
