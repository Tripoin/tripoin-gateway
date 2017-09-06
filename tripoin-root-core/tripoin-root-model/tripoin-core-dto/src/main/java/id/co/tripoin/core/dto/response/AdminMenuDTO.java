package id.co.tripoin.core.dto.response;

import java.io.Serializable;
import java.util.List;

/**
 * created on 1/3/2017
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class AdminMenuDTO implements Serializable {
    private static final long serialVersionUID = -4356457072464226872L;

    private String code;
    private String name;
    private String link;
    private String style;
    private int order;
    private int level;
    private Long parent;
    private List<AdminMenuDTO> subMenu;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public List<AdminMenuDTO> getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(List<AdminMenuDTO> subMenu) {
        this.subMenu = subMenu;
    }

    @Override
    public String toString() {
        return "AdminMenuDTO{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", style='" + style + '\'' +
                ", order=" + order +
                ", level=" + level +
                ", parent=" + parent +
                ", subMenu=" + subMenu +
                '}';
    }
}
