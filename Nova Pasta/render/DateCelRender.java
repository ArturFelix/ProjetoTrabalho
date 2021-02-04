package render;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class DateCelRender extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                          boolean isSelected, boolean hasFocus, int row, int column){
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        if(value instanceof Date){
           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
           setValue(sdf.format(value)); 
        }
        return this;
    }
}
    