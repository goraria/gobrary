package Gobrary.GIcon;

import javax.swing.*;
import java.awt.*;

public class GIcon {
    public static ImageIcon iconCorp = resizeImage(new ImageIcon("./img/logo_modified.png"), 34, 34);
    public static ImageIcon iconJaptor = resizeImage(new ImageIcon("./img/japtor.png"), 34, 34);
    public static ImageIcon iconPayHD = resizeImage(new ImageIcon("./img/payhd.png"), 34, 34);
    public static ImageIcon iconHoi = resizeImage(new ImageIcon("./img/hoi.png"), 34, 34);
    public static ImageIcon iconHome = resizeImage(new ImageIcon("./img/home.png"), 40, 40);
    public static ImageIcon iconBook = resizeImage(new ImageIcon("./img/book.png"), 40, 40);
    public static ImageIcon iconAccount = resizeImage(new ImageIcon("./img/user.png"), 40, 40);
    public static ImageIcon iconLogo = resizeImage(new ImageIcon("./img/app.png"), 60, 60);
    public static ImageIcon iconList = resizeImage(new ImageIcon("./img/list.png"), 40, 40);
    public static ImageIcon iconAdd = resizeImage(new ImageIcon("./img/book.png"), 40, 40);
    public static ImageIcon iconDel = resizeImage(new ImageIcon("./img/recbin.png"), 40, 40);
    public static ImageIcon iconBor = resizeImage(new ImageIcon("./img/bor.png"), 40, 40);
    public static ImageIcon iconRtn = resizeImage(new ImageIcon("./img/rtn.png"), 40, 40);
    public static ImageIcon iconGive = resizeImage(new ImageIcon("./img/launch.png"), 40, 40);
    public static ImageIcon iconDub = resizeImage(new ImageIcon("./img/dub.png"), 40, 40);
    public static ImageIcon iconForm = resizeImage(new ImageIcon("./img/form.png"), 40, 40);
    public static ImageIcon iconInfo = resizeImage(new ImageIcon("./img/info.png"), 40, 40);
    public static ImageIcon iconMember = resizeImage(new ImageIcon("./img/member.png"), 40, 40);
    public static ImageIcon iconBlock = resizeImage(new ImageIcon("./img/magnet.png"), 40, 40);
    public static ImageIcon iconSnip = resizeImage(new ImageIcon("./img/snip.png"), 40, 40);

    public static ImageIcon application = resizeImage(new ImageIcon("./img/app.png"), 40, 40);
    public static ImageIcon background = resizeImage(new ImageIcon("./img/theme.png"), 40, 40);

    public GIcon() {
        
        // ImageIcon iconCorp = resizeImage(new ImageIcon("./img/logo_modified.png"), 34, 34);
        // ImageIcon iconJaptor = resizeImage(new ImageIcon("./img/japtor.png"), 34, 34);
        // ImageIcon iconPayHD = resizeImage(new ImageIcon("./img/payhd.png"), 34, 34);
        // ImageIcon iconHoi = resizeImage(new ImageIcon("./img/hoi.png"), 34, 34);
        // ImageIcon iconHome = resizeImage(new ImageIcon("./img/home.png"), 40, 40);
        // ImageIcon iconBook = resizeImage(new ImageIcon("./img/book.png"), 40, 40);
        // ImageIcon iconAccount = resizeImage(new ImageIcon("./img/user.png"), 40, 40);
        // ImageIcon iconLogo = resizeImage(new ImageIcon("./img/app.png"), 60, 60);

        // ImageIcon iconList = resizeImage(new ImageIcon("./img/list.png"), 40, 40);
        // ImageIcon iconAdd = resizeImage(new ImageIcon("./img/book.png"), 40, 40);
        // ImageIcon iconDel = resizeImage(new ImageIcon("./img/recbin.png"), 40, 40);
        // ImageIcon iconBor = resizeImage(new ImageIcon("./img/bor.png"), 40, 40);
        // ImageIcon iconRtn = resizeImage(new ImageIcon("./img/rtn.png"), 40, 40);
        // ImageIcon iconGive = resizeImage(new ImageIcon("./img/launch.png"), 40, 40);

        // ImageIcon logo = new ImageIcon(getClass().getResource("/img/app.png")); // no (.) //
        // logo = resizeImage(logo, 40, 40);

        ImageIcon application = new ImageIcon("./img/app.png");
        // this.setIconImage(application.getImage());

        ImageIcon background = new ImageIcon("./img/theme.png");

        // ////////
        // ImageIcon iconCorp = new ImageIcon("./img/logo_modified.png");
        // iconCorp = resizeImage(iconCorp, 34, 34);
        // ImageIcon iconJaptor = new ImageIcon("./img/japtor.png");
        // iconJaptor = resizeImage(iconJaptor, 34, 34);
        // ImageIcon iconPayHD = new ImageIcon("./img/payhd.png");
        // iconPayHD = resizeImage(iconPayHD, 34, 34);
        // ImageIcon iconHoi = new ImageIcon("./img/hoi.png");
        // iconHoi = resizeImage(iconHoi, 34, 34);
        // ImageIcon iconHome = new ImageIcon("./img/home.png");
        // iconHome = resizeImage(iconHome, 40, 40);
        // ImageIcon iconBook = new ImageIcon("./img/book.png");
        // iconBook = resizeImage(iconBook, 40, 40);
        // ImageIcon iconAccount = new ImageIcon("./img/user.png");
        // iconAccount = resizeImage(iconAccount, 40, 40);
        // ImageIcon iconLogo = new ImageIcon("./img/app.png");
        // iconLogo = resizeImage(iconLogo, 60, 60);

        // ImageIcon iconList = new ImageIcon("./img/list.png");
        // iconList = resizeImage(iconList, 40, 40);
        // ImageIcon iconAdd = new ImageIcon("./img/book.png");
        // iconAdd = resizeImage(iconAdd, 40, 40);
        // ImageIcon iconDel = new ImageIcon("./img/recbin.png");
        // iconDel = resizeImage(iconDel, 40, 40);
        // ImageIcon iconBor = new ImageIcon("./img/bor.png");
        // iconBor = resizeImage(iconBor, 40, 40);
        // ImageIcon iconRtn = new ImageIcon("./img/rtn.png");
        // iconRtn = resizeImage(iconRtn, 40, 40);
        // ImageIcon iconGive = new ImageIcon("./img/launch.png");
        // iconGive = resizeImage(iconGive, 40, 40);
        // // ImageIcon logo = new ImageIcon(getClass().getResource("/img/app.png")); // no (.) //
        // // logo = resizeImage(logo, 40, 40);


        // ImageIcon application = new ImageIcon("./img/app.png");
        // this.setIconImage(application.getImage());

        // ImageIcon background = new ImageIcon("./img/theme.png");

        // ////////
    }

    public static ImageIcon resizeImage(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image modify = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(modify);
    }
}
