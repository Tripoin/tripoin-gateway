package id.co.tripoin.core.dto.raw;

import java.io.Serializable;

/**
 *
* @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class LOVDTO implements Serializable{
    /**
     * 
     * 
     */
    private static final long serialVersionUID = -1117195724949104462L;
    
    private Object key;
    private Object value;

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
    
    
    
}
