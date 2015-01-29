package es.art83.ticTacToe.models.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ListStringWrapper {
    List<String> listString;

    public ListStringWrapper(List<String> listString) {
        this.listString = listString;
    }

    public ListStringWrapper() {
    }

    public List<String> getListString() {
        return listString;
    }

    public void setListString(List<String> listString) {
        this.listString = listString;
    }
}
