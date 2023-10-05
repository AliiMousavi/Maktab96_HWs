package q1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import q1.entity.Person;
import q1.ui.Menu;
import q1.util.ApplicationContext;

import java.sql.Date;
import java.util.Set;

import static java.awt.SystemColor.menu;

public class Main {

    public static final Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        logger.info("logger simple" , Main.class.getSimpleName());
        Menu.run();

    }
}
