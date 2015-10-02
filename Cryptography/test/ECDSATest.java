/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigInteger;
import java.util.ArrayList;
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
public class ECDSATest {
    
    public ECDSATest() {
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
     * Test of ScalarMult method, of class ECDSA.
     */
    @Test
    public void testScalarMult() {
        System.out.println("ScalarMult");
        Point A = new Point(new BigInteger("188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF1012",16),new BigInteger("07192B95FFC8DA78631011ED6B24CDD573F977A11E794811",16));
        ArrayList<BigInteger> testk = new ArrayList<BigInteger>();
        for(int i=1;i<=20;i++){
            testk.add(new BigInteger(Integer.toString(i)));
        }
        
        testk.add(new BigInteger("112233445566778899",16));
        testk.add(new BigInteger("112233445566778899112233445566778899",16));
        testk.add(new BigInteger("1618292094200346491064154703205151664562462359653015613567",16));
        testk.add(new BigInteger("1484605055214526729816930749766694384906446681761906688",16));
        testk.add(new BigInteger("1569275434166462877105627261392580354519833538813866540831",16));
        testk.add(new BigInteger("3138550867681922400546388175470823984762234518836963313664",16));
        testk.add(new BigInteger("3138550119404545973088374812479323842475901485681169401600",16));
        testk.add(new BigInteger("24519928471166604179655321383971467003990211439919824896",16));
        testk.add(new BigInteger("46756768218837031708063422466358611246556475572231",16));
        testk.add(new BigInteger("3138502977207688322901699644928655553044791844086883549215",16));
        testk.add(new BigInteger("47890485652059026491391979477371914515865621847605503",16));
        testk.add(new BigInteger("3138549376958826959341570842566593375326996431013993775615",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284061",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284062",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284063",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284064",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284065",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284066",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284067",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284068",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284069",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284070",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284071",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284072",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284073",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284074",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284075",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284076",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284077",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284078",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284079",16));
        testk.add(new BigInteger("6277101735386680763835789423176059013767194773182842284080",16));
        
        ECDSA instance = new ECDSA( "-3",
                                    "64210519e59c80e70fa7e9ab72243049feb8deecc146b9b1",
                                    "6277101735386680763835789423207666416083908700390324961279",
                                    "188da80eb03090f67cbf20eb43a18800f4ff0afd82ff1012",
                                    "07192b95ffc8da78631011ed6b24cdd573f977a11e794811",
                                    "6277101735386680763835789423176059013767194773182842284081"
        );
        Point expResult[] = {
            new Point(new BigInteger("188DA80EB03090F67CBF20EB43A18800F4FF0AFD82FF1012",16),new BigInteger("07192B95FFC8DA78631011ED6B24CDD573F977A11E794811",16)),
            new Point(new BigInteger("DAFEBF5828783F2AD35534631588A3F629A70FB16982A888",16),new BigInteger("DD6BDA0D993DA0FA46B27BBC141B868F59331AFA5C7E93AB",16)),
            new Point(new BigInteger("76E32A2557599E6EDCD283201FB2B9AADFD0D359CBB263DA",16),new BigInteger("782C37E372BA4520AA62E0FED121D49EF3B543660CFD05FD",16)),
            new Point(new BigInteger("35433907297CC378B0015703374729D7A4FE46647084E4BA",16),new BigInteger("A2649984F2135C301EA3ACB0776CD4F125389B311DB3BE32",16)),
            new Point(new BigInteger("10BB8E9840049B183E078D9C300E1605590118EBDD7FF590",16),new BigInteger("31361008476F917BADC9F836E62762BE312B72543CCEAEA1",16))
        
        };
        for(int i=0;i<5;i++){
            Point result = instance.ScalarMult(A, testk.get(i));
            assertEquals(expResult[i].x, result.x);
            assertEquals(expResult[i].y,result.y);
        }
    }

    /**
     * Test of ECDSASign method, of class ECDSA.
     */
    @Test
    public void testECDSASign() {
        System.out.println("ECDSASign");
        /*BigInteger e = null;
        ECDSA instance = null;
        BigInteger[] expResult = null;
        BigInteger[] result = instance.ECDSASign(e);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }

    /**
     * Test of ECDSAVerify method, of class ECDSA.
     */
    @Test
    public void testECDSAVerify() {
        System.out.println("ECDSAVerify");
        /*BigInteger r = null;
        BigInteger s = null;
        BigInteger e = null;
        ECDSA instance = null;
        boolean expResult = false;
        boolean result = instance.ECDSAVerify(r, s, e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");*/
    }
    
}
