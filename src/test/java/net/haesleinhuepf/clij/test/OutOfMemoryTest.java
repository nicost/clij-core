package net.haesleinhuepf.clij.test;

import net.haesleinhuepf.clij.clearcl.ClearCLImage;
import net.haesleinhuepf.clij.clearcl.enums.ImageChannelDataType;
import net.haesleinhuepf.clij.CLIJ;
import net.haesleinhuepf.clij.kernels.Kernels;
import org.junit.Ignore;
import org.junit.Test;

/**
 * OutOfMemoryTest
 * <p>
 * <p>
 * <p>
 * Author: @haesleinhuepf
 * 09 2018
 */
public class OutOfMemoryTest {
    @Ignore
    @Test
    public void runOutOfMemory() {
        CLIJ clij = CLIJ.getInstance();
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            ClearCLImage image1 = clij.createCLImage(new long[]{1024, 1024, 300}, ImageChannelDataType.Float);
            ClearCLImage image2 = clij.createCLImage(new long[]{1024, 1024, 300}, ImageChannelDataType.Float);
            ClearCLImage image3 = clij.createCLImage(new long[]{1024, 1024, 300}, ImageChannelDataType.Float);

            for (int j = 0; j < 1000; j++) {
                System.out.println(">" + j);
                Kernels.tenengradFusion(clij, image1, new float[]{15, 15, 5}, image2, image3);
            }

            image1.close();
            image2.close();
            image3.close();
        }


    }
}
