import junit.framework.TestCase;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by user on 14.03.2016.
 */
public class TestPen extends TestCase {

    @Test
    public void testWrite_inkContainerValueLargerThenSizeOfWord_correctWordWritten(){
        int initialInkContainerValue = 100;
        Pen pen = new Pen(initialInkContainerValue);
        String wordToWrite = "Hello";
        String output = pen.write(wordToWrite);
        assertTrue("Wrong output! Expected: " + wordToWrite + "; Actual: " +output,
                output.equals(wordToWrite));
    }

    @Test
    public void testWrite_inkContainerValueLargerThenSizeOfWord_penCanContinueWriting(){
        int initialInkContainerValue = 100;
        Pen pen = new Pen(initialInkContainerValue);
        String wordToWrite = "Hello";
        String output = pen.write(wordToWrite);
        assertTrue("Wrong output! Expected: inkContainer is not empty, so pen.isWork == true, Actual: pen.isWork == "
                + pen.isWork(), pen.isWork());
    }


    @Test
    public void testWrite_inkContainerValueIsEqualToSizeOfWord_correctWordWritten(){
        int initialInkContainerValue = 50;
        double letterSize = 10.0d;
        Pen pen = new Pen(initialInkContainerValue, letterSize);
        String wordToWrite = "Hello";
        String output = pen.write(wordToWrite);
        assertTrue("Wrong output! Expected: " + wordToWrite + "; Actual: " +output,
                output.equals(wordToWrite));
    }

    @Test
    public void testWrite_inkContainerValueIsEqualToSizeOfWord_penCanNotContinueWriting(){
        int initialInkContainerValue = 50;
        double letterSize = 10.0d;
        Pen pen = new Pen(initialInkContainerValue, letterSize);
        String wordToWrite = "Hello";
        String output = pen.write(wordToWrite);
        assertTrue("Wrong output! Expected: inkContainer is empty, so pen.isWork == false, Actual: pen.isWork == "
                + pen.isWork(), !pen.isWork());
    }

    @Test
    public void testWrite_inkContainerValueLessThenSizeOfWord_onlyPartOfWordWritten(){
        int initialInkContainerValue = 40;
        double letterSize = 10.0d;
        Pen pen = new Pen(initialInkContainerValue, letterSize);
        String wordToWrite = "Hello";
        String output = pen.write(wordToWrite);
        assertTrue(!output.equals(wordToWrite));

    }

    @Test
    public void testWrite_inkContainerValueLessThenSizeOfWord_penCanNotContinueWriting(){
        int initialInkContainerValue = 40;
        double letterSize = 10.0d;
        Pen pen = new Pen(initialInkContainerValue, letterSize);
        String wordToWrite = "Hello";
        String output = pen.write(wordToWrite);
        assertTrue("Wrong output! Expected: inkContainer is empty, so pen.isWork == false, Actual: pen.isWork == "
                + pen.isWork(), !pen.isWork());

    }

    @Test
    public void testWrite_inkContainerIsEmpty_noWordWritten(){
        int initialInkContainerValue = 0;
        double letterSize = 10.0d;
        Pen pen = new Pen(initialInkContainerValue, letterSize);
        String wordToWrite = "Hello";
        String output = pen.write(wordToWrite);
        assertTrue("Wrong output! Expected: '' (empty String); Actual: " +output, output.equals(""));
    }

    @Test
    public void testWrite_inkContainerIsEmpty_penCanNotContinueWriting(){
        int initialInkContainerValue = 0;
        double letterSize = 10.0d;
        Pen pen = new Pen(initialInkContainerValue, letterSize);
        String wordToWrite = "Hello";
        String output = pen.write(wordToWrite);
        assertTrue("Wrong output! Expected: inkContainer is empty, so pen.isWork == false, Actual: pen.isWork == "
                + pen.isWork(), !pen.isWork());
    }

    @Test
    public void testGetColor_returnsCorrectColor(){
        int initialInkContainerValue = 50;
        double letterSize = 10.0d;
        String penColor = "Green";
        Pen pen = new Pen(initialInkContainerValue, letterSize, penColor);
        assertTrue("Wrong output! Expected color: " + penColor + "; Actual color: " +pen.getColor(),
                pen.getColor().equals(penColor));
    }

    @Test
    public void testIsWorkContainerNotEmpty(){
        int initialInkContainerValue = 50;
        Pen pen = new Pen(initialInkContainerValue);
        assertTrue("Wrong output! Expected: inkContainer is not empty, so pen.isWork == true, Actual: pen.isWork == "
                + pen.isWork(), pen.isWork() == true);
    }

    @Test
    public void testIsWorkinkContainerEmpty(){
        int initialInkContainerValue = 0;
        Pen pen = new Pen(initialInkContainerValue);
        assertTrue("Wrong output! Expected: inkContainer is empty, so pen.isWork == false, Actual: pen.isWork == "
                + pen.isWork(), pen.isWork() == false);
    }

    @Test
    public void testDoSomethingElse(){
        int initialInkContainerValue = 50;
        double letterSize = 10.0d;
        String penColor = "Green";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Pen pen = new Pen(initialInkContainerValue, letterSize, penColor);
        pen.doSomethingElse();

        assertTrue("Wrong text is printed in console!", outContent.toString().equals(penColor + "\r\n"));
    }
}
