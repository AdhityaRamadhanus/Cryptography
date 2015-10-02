
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import org.bouncycastle.pqc.math.linearalgebra.IntegerFunctions;

class Point{
    public BigInteger x;
    public BigInteger y;
    Point(BigInteger _x,BigInteger _y){
        x=_x;
        y=_y;
    }
}

public class ECDSA {
    public byte[] PlainBytes;
    public byte[] CipherBytes;
    
    BigInteger a,b,p,n; //Elliptic curve parameters
    Point G; //Generator
    BigInteger Two,Three;
    public BigInteger PrivKey;
    public Point PubKey;
    
    public ECDSA(String _a,String _b, String _p,String _Gx,String _Gy,String _n){
        Two = new BigInteger("2");
        Three = new BigInteger("3");
        
        a = new BigInteger(_a);
        b = new BigInteger(_b,16);
        p = new BigInteger(_p);
        G = new Point(new BigInteger(_Gx,16),
                      new BigInteger(_Gy,16));
        n = new BigInteger(_n);
     
        /*
        //NIST Elliptic Curves Parameters (192 bit)
        a = new BigInteger("-3");
        b = new BigInteger("64210519e59c80e70fa7e9ab72243049feb8deecc146b9b1",16);
        p = new BigInteger("6277101735386680763835789423207666416083908700390324961279");
        G = new Point(new BigInteger("188da80eb03090f67cbf20eb43a18800f4ff0afd82ff1012",16),
                      new BigInteger("07192b95ffc8da78631011ed6b24cdd573f977a11e794811",16));
        n = new BigInteger("6277101735386680763835789423176059013767194773182842284081");*/
        PrivKey = new BigInteger("0");
        PubKey = new Point(BigInteger.ZERO,BigInteger.ZERO);
    }
    public String[] getPubKeyString(){
        return new String[]{PubKey.x.toString(16),PubKey.y.toString(16)};
    }
    public BigInteger[] getPubKeyBig(){
        return new BigInteger[]{PubKey.x,PubKey.y};
    }
    public void setPubKey(BigInteger x,BigInteger y){
        PubKey.x=x;
        PubKey.y=y;
    }
    public void setPrivKey(BigInteger p){
        PrivKey = p;
    }
    public Point NegatePoint(Point A){
        return new Point(A.x,A.y.negate().mod(p));
    }
    public Point DoublingPoint(Point A){
        BigInteger s = ((((A.x.pow(2)).multiply(Three)).add(a)).multiply(A.y.multiply(Two).modInverse(p))).mod(p);
        BigInteger rx = (s.pow(2).subtract(A.x.multiply(Two))).mod(p) ;
        BigInteger ry = (((A.x.subtract(rx)).multiply(s)).subtract(A.y)).mod(p);
        return new Point(rx,ry);
    }
    public Point AddPoint(Point A,Point B){
        BigInteger dx = B.x.subtract(A.x);
        BigInteger dy = B.y.subtract(A.y);
        
        BigInteger s = (dy.multiply(dx.modInverse(p))).mod(p);
        BigInteger rx = (((s.pow(2)).subtract(A.x)).subtract(B.x)).mod(p) ;
        BigInteger ry = ((s.multiply(A.x.subtract(rx))).subtract(A.y)).mod(p);
        return new Point(rx,ry);
    }
    public Point ScalarMult(Point A, BigInteger k){
        Point Q = A;
        Point R = A;
        for(int i=0;i<k.bitLength();i++){
            if (k.testBit(i)){
                if (i==k.getLowestSetBit())
                    Q = R;
                else
                    Q = AddPoint(Q,R);
            }
            R = DoublingPoint(R);
        }
        return Q;
    }
    private BigInteger GenerateBig(int nbits){
        Random rand = new Random();
        BigInteger Numb = BigInteger.ZERO;
        while(true){
            Numb = new BigInteger(nbits,rand);
            if (Numb.compareTo(n)==-1){
                break;
            }
        }
        return Numb;
    }
    public void GenerateKey() {                                                  
        // TODO add your handling code here:
        PrivKey = GenerateBig(192);
        PubKey = ScalarMult(G,PrivKey);
    }      
    public BigInteger[] ECDSASign(BigInteger e){
        BigInteger[] rs = new BigInteger[2];
        while(true){
            BigInteger k = GenerateBig(192);
            Point X = ScalarMult(G,k);
            rs[0] = X.x.mod(n);
            if (rs[0].compareTo(BigInteger.ZERO)>0){
                rs[1] = ((e.add(PrivKey.multiply(rs[0]))).multiply((k.modInverse(n)))).mod(n);
                if (rs[1].compareTo(BigInteger.ZERO)>0) break;
            }
        }
        System.out.println("Signature : ");
        System.out.println(rs[0].toString(16)+" , "+rs[1].toString(16));
        return rs;
    }
    public boolean ECDSAVerify(BigInteger r,BigInteger s,BigInteger e){
        if (r.compareTo(n)>=0 || s.compareTo(n)>=0){
            return false;
        }
        else{
            BigInteger w = s.modInverse(n);
            BigInteger u1 = (e.multiply(w)).mod(n);
            BigInteger u2 = (r.multiply(w)).mod(n);
            Point X = AddPoint(ScalarMult(G,u1),ScalarMult(PubKey,u2));
            if (X.x.compareTo(r)==0) return true;
            else return false;
        }
    }
    
}
