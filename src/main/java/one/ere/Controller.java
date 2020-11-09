package one.ere;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("controller")
@ViewScoped
public class Controller implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean showPanel1 = true;

    private boolean showPanel2;

    public void clickOnButton1() {

        setShowPanel1(true);
        setShowPanel2(false);
    }

    public void clickOnButton2() {

        setShowPanel1(false);
        setShowPanel2(true);
    }

    public boolean isShowPanel1() {

        return this.showPanel1;
    }

    public void setShowPanel1(final boolean showPanel1) {

        this.showPanel1 = showPanel1;
    }

    public boolean isShowPanel2() {

        return this.showPanel2;
    }

    public void setShowPanel2(final boolean showPanel2) {

        this.showPanel2 = showPanel2;
    }

}
