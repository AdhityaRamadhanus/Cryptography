/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nao
 */
public class SHA1Test {
    
    public SHA1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of SHA1Digest method, of class SHA1.
     */
    @Test
    public void testSHA1Digest() {
        System.out.println("SHA1Digest");
        SHA1 instance = new SHA1();
        String[] X = {"abc",
                      "",
                      "abcdbcdecdefdefgefghfghighijhijkijkljklmklmnlmnomnopnopq",
                     };
        int[][] expResult = {{0xa9993e36,0x4706816a,0xba3e2571,0x7850c26c,0x9cd0d89d},
            {0xda39a3ee,0x5e6b4b0d,0x3255bfef,0x95601890,0xafd80709},
            {0x84983e44,0x1c3bd26e,0xbaae4aa1,0xf95129e5,0xe54670f1}};
        for(int i=0;i<X.length;i++){
            int[] M = instance.ParsingMessage(instance.PaddingMessage(X[i].getBytes(),X[i].length()*8));
            int[] result=instance.SHA1Digest(M);
            assertArrayEquals(expResult[i],result);
        }
        
    }
    
}
