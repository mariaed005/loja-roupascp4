package models;

import enums.TipoRoupaEnum;
import java.util.UUID;

public class Roupa {
    private UUID codigo;
    private String marca;
    private int tamanho;
    private String material;
    private TipoRoupaEnum tipoRoupa ;

    public Roupa(UUID codigo, String marca, int tamanho, String material, TipoRoupaEnum tipoRoupa) {
        this.codigo = codigo;
        this.marca = marca;
        this.tamanho = tamanho;
        this.material = material;
        this.tipoRoupa = tipoRoupa;
    }

    public UUID getCodigo() {
        return codigo;
    }
    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getTamanho() {
        return tamanho;
    }
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public TipoRoupaEnum getTipoRoupa() {
        return tipoRoupa;
    }
    public void setTipoRoupa(TipoRoupaEnum tipoRoupa) {
        this.tipoRoupa = tipoRoupa;
    }
}

