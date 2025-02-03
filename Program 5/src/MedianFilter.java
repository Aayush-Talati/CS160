/**
 *  Program 5
 *  Removes a llama by averaging out the pixels in a set of photos
 *  CS160-1
 *  03/18/2024
 *  @author  Aayush Talati
 */


import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.Collections;
import java.io.IOException;
import java.io.File;

public class MedianFilter {
    private BufferedImage filteredImage;
    private BufferedImage[] images;

    //constructor that initializes the MedianFilter with an array of image filenames.
    public MedianFilter(String[] imageInputFilenames) throws IOException {
        this.images = new BufferedImage[imageInputFilenames.length];
        for (int i = 0; i < imageInputFilenames.length; i++) {
            this.images[i] = readImage(new File(imageInputFilenames[i]));
        }
        this.filteredImage = new BufferedImage(images[0].getWidth(), images[0].getHeight(), BufferedImage.TYPE_INT_RGB);
    }

    //Opens and reads an image file
    //@param imageFile The image file to be read.
    //@return The BufferedImage read from the file.
    // @throws IOException If an error occurs during reading.
    public BufferedImage readImage(File imageFile) throws IOException {
        try {
            if (imageFile.exists() == false) {
                throw new IOException("File does not exist");
            }
            BufferedImage image = ImageIO.read(imageFile);
            if (image == null) {
                throw new IOException("File can not be read");
            }
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }
    }
    //Removes noise from the images using median filtering.
    //@return The filtered, noise-reduced image.
    public BufferedImage removeNoise() {
        for (int y = 0; y < filteredImage.getHeight(); y++) {
            for (int x = 0; x < filteredImage.getWidth(); x++) {
                ArrayList<Integer> imageP = new ArrayList<>();
                for (BufferedImage image : images) {
                    int pixel = image.getRGB(x, y);
                    imageP.add(pixel);
                }
                int finalP = getMedianValue(imageP);
                filteredImage.setRGB(x, y, finalP);
            }
        }
        return filteredImage;
    }
    //Returns the median value from an ArrayList of integers.
    //@param values The ArrayList of integers.
    //@return The median value.
    public int getMedianValue(ArrayList<Integer> pixels) {
        Collections.sort(pixels);
        return pixels.get(pixels.size() / 2);
    }
    //Writes the filtered image to a specified output filename.
    //@param outputFilename The name of the output file.
    //@return 0 if successful, or -1 if an exception was thrown.
    public int writeImage(String outputFilename) {
        try {
            File outputFile = new File(outputFilename);
            ImageIO.write(filteredImage, "jpg", outputFile);
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
    //Gets the height of the filtered image.
    //@return The height of the filtered image.
    public int getHeight() {
        return filteredImage.getHeight();
    }
    //Gets the width of the filtered image.
    //@return The width of the filtered image.
    public int getWidth() {
        return filteredImage.getWidth();
    }
    public String getInfo() {
        return "Program 5, Aayush Talati";
    }

}
