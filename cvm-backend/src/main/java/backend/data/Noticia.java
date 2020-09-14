package backend.data;

public class Noticia {

    private int id;
    private String tituloNoticia;
    private String descricaoNoticia;
    private String dataData;

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", titulo='" + tituloNoticia + '\'' +
                ", descricao='" + descricaoNoticia + '\'' +
                ", data='" + dataData + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloNoticia() {
        return tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia) {
        this.tituloNoticia = tituloNoticia;
    }

    public String getDescricaoNoticia() {
        return descricaoNoticia;
    }

    public void setDescricaoNoticia(String descricaoNoticia) {
        this.descricaoNoticia = descricaoNoticia;
    }

    public String getDataData() {
        return dataData;
    }

    public void setDataData(String dataData) {
        this.dataData = dataData;
    }
}
