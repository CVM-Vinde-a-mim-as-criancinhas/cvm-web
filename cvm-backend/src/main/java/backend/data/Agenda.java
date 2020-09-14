package backend.data;

public class Agenda {

    private int id;
    private String descricaoEvento;
    private String dataEvento;

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", descricao='" + descricaoEvento + '\'' +
                ", data='" + dataEvento + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }
}
