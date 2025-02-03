import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
public class test {
    public static void main(String[] args) throws IOException {
        String[] imageInputFilenames = {"veg1.jpg", "veg2.jpg", "veg3.jpg", "veg4.jpg", "veg5.jpg", "veg6.jpg", "veg7.jpg", "veg8.jpg"};
        //String[] imageInputFilenames = {"Tespng"};
        MedianFilter medianFilter = new MedianFilter(imageInputFilenames);
        BufferedImage resultImage = medianFilter.removeNoise();
        medianFilter.writeImage("output1.jpg");
    }
}
