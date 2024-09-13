package ct07.adminmanagerforttn.app.view.menu;

import ct07.adminmanagerforttn.app.event.EventMenuSelected;
import ct07.adminmanagerforttn.app.model.MenuModel;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 *
* @author CT07N0161 VoThiBichTuyen CT07N0162 LeThanhYen
 */
public class ListMenu<E extends Object> extends JList<E> {
    
    private final DefaultListModel model;
    private int selectedIndex = -1;
    private int overIndex = -1;
    
    private EventMenuSelected event;
    
    public void addEventMenuSelected(EventMenuSelected event){
        this.event = event;
    }
    
    public ListMenu(){    
        model = new DefaultListModel();
        setModel(model);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof MenuModel) {
                        MenuModel menu = (MenuModel) o;
                        if (menu.getType() == MenuModel.MenuType.MENU) {
                            selectedIndex = index;
                            if (event != null){
                                event.selected(index);
                            }
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                overIndex = -1;
                repaint();
            }
        });
        
        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseMoved(MouseEvent me) {
                int index = locationToIndex(me.getPoint());
                if (index != overIndex){
                    Object o = model.getElementAt(index);
                    if (o instanceof MenuModel) {
                        MenuModel menu = (MenuModel) o;
                        if (menu.getType() == MenuModel.MenuType.MENU){
                            overIndex = index;
                        }
                        repaint();
                    }
                }
            }
        });
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer(){
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object o, int index, boolean selected, boolean focus) {
                MenuModel data;
                if (o instanceof MenuModel) {
                    data = (MenuModel) o;
                } else {
                    data = new MenuModel("", o + "", MenuModel.MenuType.EMPTY);
                }
                
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                item.setOver(overIndex == index);
                return item;
            }
        };
    }
    
    public void addItem(MenuModel data){
        model.addElement(data);
    }
}
