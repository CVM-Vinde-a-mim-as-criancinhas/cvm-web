package backend.data;


import javax.persistence.*;

@Entity
@Table(name="tab_agenda")
public class Agenda {

    @Id
    @GeneratedValue
    @Column(name="id_agenda")
    private int id;
    @Column(name="ds_evento")
    private String descricaoEvento;
    @Column(name="dt_evento")
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
