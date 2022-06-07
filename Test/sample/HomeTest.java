package sample;
import javafx.scene.Node;
import javafx.scene.control.DialogPane;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.api.FxRobotInterface;
import java.lang.String.*;
import java.util.concurrent.TimeoutException;
import java.util.function.Function.*;//javafx.scene.Node,java.util.Set<javafx.scene.Node;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;
import static io.netty.util.ReferenceCountUtil.release;
import static org.junit.jupiter.api.Assertions.*;
class HomeTest{
    FxRobot r;
    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() throws TimeoutException {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }
    @Test
    public void testClickDATA1()
    {
        pushloginHome();
        r.clickOn( "#txtUsername").write( "robbytan");
        r.clickOn( "#txtPassword").write("12345");
        r.clickOn( "#btnLogin");
        //Node alert= lookup(".dialog-pane").query();
        //Node dialogPane = lookup(".dialog-pane").query();
       // DialogPane pane=(DialogPane) alert;
    }
    @Test
    void pushsignUpHome() {
    }

    @Test
    void pushloginHome() {
    }
}