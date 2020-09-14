package backend.data;

import java.io.File;

public class Transparencia {

    private int id;
    private String tituloTransparencia;
    private File arquivoTransparencia;

    @Override
    public String toString() {
        return "Transparencia{" +
                "id=" + id +
                ", tituloTransparencia='" + tituloTransparencia + '\'' +
                ", arquivoTransparencia=" + arquivoTransparencia +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloTransparencia() {
        return tituloTransparencia;
    }

    public void setTituloTransparencia(String tituloTransparencia) {
        this.tituloTransparencia = tituloTransparencia;
    }

    public File getArquivoTransparencia() {
        return arquivoTransparencia;
    }

    public void setArquivoTransparencia(File arquivoTransparencia) {
        this.arquivoTransparencia = arquivoTransparencia;
    }
}
