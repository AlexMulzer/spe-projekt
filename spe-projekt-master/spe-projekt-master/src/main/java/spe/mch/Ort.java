package spe.mch;

/**
 *
 * @author Alex
 */
public class Ort {

    private int ortsId;
    private String ortsName;
    
    public Ort(){}
    public Ort(int ortsId, String ortsName){
        this.ortsId = ortsId;
        this.ortsName = ortsName;
    }

    public void setOrtsId(int ortsId){
        this.ortsId = ortsId;
    }
    public int getOrtsId(){
        return ortsId;
    }

    public void setOrtsName(String ortsName){
        this.ortsName = ortsName;
    }
    public String getOrtsName(){
        return ortsName;
    }
}
