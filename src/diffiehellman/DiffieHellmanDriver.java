
package diffiehellman;

import java.math.BigInteger;
import oracle.security.crypto.core.DiffieHellman;
import oracle.security.crypto.core.RandomBitsSource;

public class DiffieHellmanDriver{

    public static void main(String[] args) {
    BigInteger bit_size=new BigInteger(args[0]);
    DiffieHellman DH1=new DiffieHellman(RandomBitsSource.getDefault(),bit_size.intValue()-1);
    BigInteger p,g,A,B,s1,s2;
    p=DH1.getPrime();
    g=DH1.getGen();
    A=DH1.myValue();
    DiffieHellman DH2=new DiffieHellman(p,g,RandomBitsSource.getDefault());
    B=DH2.myValue();
    s1=DH1.getKey(DH2.myValue());
    s2=DH2.getKey(DH1.myValue());
    System.out.println("The value of p selected : "+p);
    System.out.println("The value of g selected : "+g);
    System.out.println("The value of A sent to Bob by Alice : "+A);
    System.out.println("The value of B sent to Alice by Bob : "+B);
    System.out.println("The value of shared key computed by Alice : "+s1);
    System.out.println("The value of shared key computed by Bob : "+s2);
    }
    
}
