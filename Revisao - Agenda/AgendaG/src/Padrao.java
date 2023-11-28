import java.time.LocalDate;
import java.time.LocalTime;

public class Padrao {
    String titulo;
    LocalDate data;
    LocalTime hora;
    boolean repetir;

    public Padrao() {
    }

    public Padrao(String titulo, LocalDate data, LocalTime hora, boolean repetir) {
        this.titulo = titulo;
        this.data = data;
        this.hora = hora;
        this.repetir = repetir;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public boolean isRepetir() {
        return repetir;
    }

    public void setRepetir(boolean repetir) {
        this.repetir = repetir;
    }
}
