package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author Enric
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssistenciaM {

    private ClientM client;

    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ")
    private Date dataRegistre;

    private int esdeveniment;

    public AssistenciaM() {
        // Constructor buit necessari per a la deserialització
    }

    public int getId() {
        return id;
    }

    public Date getDataRegistre() {
        return dataRegistre;
    }

    public int getEsdeveniment() {
        return esdeveniment;
    }

    @JsonProperty("client")
    public ClientM getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(ClientM client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "AssistenciaM{"
                + "id=" + id
                + ", dataRegistre=" + dataRegistre
                + ", client=" + client
                + ", esdeveniment=" + esdeveniment
                + '}';
    }
}
