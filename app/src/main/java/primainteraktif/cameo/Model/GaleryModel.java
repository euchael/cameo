package primainteraktif.cameo.Model;

import java.io.Serializable;

/**
 * Created by wenby on 4/5/2017.
 */

public class GaleryModel implements Serializable {
    public String galeryTitle, galeryDate, GaleryImg;

    public String getGaleryTitle() {
        return galeryTitle;
    }

    public void setGaleryTitle(String galeryTitle) {
        this.galeryTitle = galeryTitle;
    }

    public String getGaleryDate() {
        return galeryDate;
    }

    public void setGaleryDate(String galeryDate) {
        this.galeryDate = galeryDate;
    }

    public String getGaleryImg() {
        return GaleryImg;
    }

    public void setGaleryImg(String galeryImg) {
        GaleryImg = galeryImg;
    }
}
