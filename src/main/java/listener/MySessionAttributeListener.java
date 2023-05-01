package listener;

import model.User;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.Date;

@WebListener
public class MySessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        String attrName = event.getName();
        User attrValue = (User)event.getValue();
        if(attrName.equals("user")){
            System.out.println("user "+attrValue.getEmail()+" login at:"+new Date()+event.getSession().getId());
        }
    }
}
