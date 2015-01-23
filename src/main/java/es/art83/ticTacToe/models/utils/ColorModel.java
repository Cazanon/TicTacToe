package es.art83.ticTacToe.models.utils;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public enum ColorModel {
    X, O;
    
    public ColorModel next(){
        ColorModel result = null;
        switch (this) {
        case X:
            result = O;
            break;
        case O:
            result = X;
            break;
        }
        return result;
    }

}
