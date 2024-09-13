package ct07.adminmanagerforttn.app.view.company;

import ct07.adminmanagerforttn.app.model.StatusType;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

/**
 *
* @author CT07N0161 VoThiBichTuyen CT07N0162 LeThanhYen
 */
public class ComboBoxStatus extends DefaultListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (value instanceof StatusType) {
            StatusType status = (StatusType) value;
            switch (status) {
                case PENDING:
                    label.setForeground(Color.RED);
                    break;
                case APPROVED:
                    label.setForeground(Color.GREEN);
                    break;
                case REJECT:
                    label.setForeground(Color.BLUE);
                    break;
            }
        }
        return label;
    }
    
}
